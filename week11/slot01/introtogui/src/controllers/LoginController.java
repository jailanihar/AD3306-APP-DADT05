package controllers;

import java.io.IOException;

import app.TodoListApp;
import data.TodoListAppRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;

public class LoginController {
    
    @FXML TextField usernameTextField, passwordTextField;

    @FXML CheckBox showPasswordCheckBox;

    @FXML Label errorLabel;

    public void login() throws Exception {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if(TodoListAppRepository.login(username.toLowerCase(), password)    
        ) {
            FXMLLoader loader = 
                new FXMLLoader(getClass().getResource("../views/TodoList.fxml"));
            Parent root = loader.load();
            TodoListController controller = loader.getController();
            User user = new User(username.toLowerCase());
            user.setTodoList(TodoListAppRepository.getTodoList(username.toLowerCase()));
            controller.setUser(user);
            Scene scene = new Scene(root, 500, 500);
            TodoListApp.primaryStage.setScene(scene);
        } else {
            errorLabel.setText("Wrong credentials");
        }
    }

    public void register() throws Exception{
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if(TodoListAppRepository.register(username.toLowerCase(), password)) {
            FXMLLoader loader = 
                new FXMLLoader(getClass().getResource("../views/TodoList.fxml"));
            Parent root = loader.load();
            TodoListController controller = loader.getController();
            User user = new User(username.toLowerCase());
            controller.setUser(user);
            Scene scene = new Scene(root, 500, 500);
            TodoListApp.primaryStage.setScene(scene);
        } else {
            errorLabel.setText("Unable to register.");
        }
    }

    public void showPassword() {
        System.out.println("Show Password Clicked");
    }

}
