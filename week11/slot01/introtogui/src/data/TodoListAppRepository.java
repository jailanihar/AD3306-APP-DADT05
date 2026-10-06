package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import models.Todo;
import models.User;

public class TodoListAppRepository {
    
    private static String driver, url, username, password;

    public static void initialise() throws Exception {
        Properties properties = new Properties();
        InputStream file =
            new FileInputStream("src/data/application.properties");
        properties.load(file);
        driver = properties.getProperty("db.driver");
        url = properties.getProperty("db.url");
        username = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
        file.close();
    }

    public static Connection connect() throws Exception {
        Class.forName(driver);
        Connection connection = 
            DriverManager.getConnection(
                url, username, password
            );
        return connection;
    }

    public static boolean login(String username, String password) 
        throws Exception {
        Connection connection = connect();
        String sql = 
        "SELECT username FROM todos_users WHERE username=? AND upassword=SHA2(?,256)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        boolean valid = false;
        if(result.next()) {
            valid = true;
        }
        connection.close();
        return valid;
    }

    public static boolean register(String username, String password) 
        throws Exception {
        Connection connection = connect();
        String sql = 
        "INSERT INTO todos_users (username, upassword, created_at, updated_at) VALUES (?, SHA2(?,256), NOW(), NOW())";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        int rowsAffected = statement.executeUpdate();
        connection.close();
        return rowsAffected > 0;
    }

    public static ArrayList<Todo> getTodoList(String username) throws Exception {
        Connection connection = connect();
        String sql = 
        "SELECT * FROM todos WHERE username=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();
        ArrayList<Todo> todoList = new ArrayList<>();
        while(result.next()) {
            Todo todo = new Todo(result.getInt(1), result.getString(2));
            todoList.add(todo);
        }
        connection.close();
        return todoList;
    }

    public static int addTodo(String value, User user) throws Exception {
        Connection connection = connect();
        String sql = 
        "INSERT INTO todos (todo_value, username) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, value);
        statement.setString(2, user.getUsername());
        int rowsAffected = statement.executeUpdate();
        int generatedKey = -1;
        if(rowsAffected > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                generatedKey = generatedKeys.getInt(1);
            }
        }
        connection.close();
        return generatedKey;
    }

    public static boolean deleteTodo(int id) throws Exception {
        Connection connection = connect();
        String sql = 
        "DELETE FROM todos WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int rowsAffected = statement.executeUpdate();
        boolean success;
        if(rowsAffected > 0) {
            success = true;
        } else {
            success = false;
        }
        connection.close();
        return success;
    }

}
