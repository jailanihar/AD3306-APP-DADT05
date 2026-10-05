package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

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

}
