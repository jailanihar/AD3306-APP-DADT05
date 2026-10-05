package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TodoListController {
    
    @FXML TextField todoTextField;
    @FXML Label errorLabel;
    @FXML VBox todoListVBox;

    public void addTodo() throws IOException {
        FXMLLoader fxmlLoader = 
            new FXMLLoader(getClass().getResource("../views/SingleTodo.fxml"));
        HBox newTodo = fxmlLoader.load();
        SingleTodoController singleTodoController =
            fxmlLoader.getController();
        singleTodoController.addTodo(todoTextField.getText(), todoListVBox);
        todoListVBox.getChildren().add(newTodo);
    }
}
