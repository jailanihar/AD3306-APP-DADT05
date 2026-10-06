package controllers;

import java.io.IOException;

import data.TodoListAppRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Todo;
import models.User;

public class TodoListController {
    private User user;
    @FXML TextField todoTextField;
    @FXML Label errorLabel;
    @FXML VBox todoListVBox;

    public void addTodo() throws Exception {
        FXMLLoader fxmlLoader = 
            new FXMLLoader(getClass().getResource("../views/SingleTodo.fxml"));
        HBox newTodo = fxmlLoader.load();
        SingleTodoController singleTodoController =
            fxmlLoader.getController();
        singleTodoController.addTodo(todoTextField.getText(), todoListVBox);
        int generatedKey = TodoListAppRepository.addTodo(
            todoTextField.getText(), user
        );
        if(generatedKey == -1) {
            errorLabel.setText("Unable to add todo");
        } else {
            Todo todo = new Todo(generatedKey, todoTextField.getText());
            user.addTodo(todo);
            singleTodoController.setTodo(todo);
            todoListVBox.getChildren().add(newTodo);
            todoTextField.clear();
        }
    }

    public void setUser(User user) throws Exception {
        this.user = user;
        for(Todo todo : user.getTodoList()) {
            FXMLLoader fxmlLoader = 
                new FXMLLoader(getClass().getResource("../views/SingleTodo.fxml"));
            HBox newTodo = fxmlLoader.load();
            SingleTodoController singleTodoController =
                fxmlLoader.getController();
            singleTodoController.addTodo(todo.getValue(), todoListVBox);
            todoListVBox.getChildren().add(newTodo);
            singleTodoController.setTodo(todo);
        }
    }
}
