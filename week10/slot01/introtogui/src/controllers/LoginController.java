package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    @FXML TextField usernameTextField, passwordTextField;

    @FXML CheckBox showPasswordCheckBox;

    @FXML Label errorLabel;

    public void login() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if(username.toLowerCase().equals("test") &&
            password.equals("test")    
        ) {
            errorLabel.setText("Able to login");
        } else {
            errorLabel.setText("Wrong credentials");
        }
    }

    public void register() {
        System.out.println("Register Button");
    }

    public void showPassword() {
        System.out.println("Show Password Clicked");
    }

}
