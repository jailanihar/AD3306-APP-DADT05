package controllers;

import data.TodoListAppRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Todo;

public class SingleTodoController {

    VBox parentNode;
    private Todo todoObj;
    @FXML Label todoLabel;

    public void addTodo(String todo, VBox parentNode) {
        this.parentNode = parentNode;
        todoLabel.setText(todo);
    }
    
    public void delete(ActionEvent e) throws Exception {
        Button deleteButton = (Button) e.getSource();
        HBox singleTodo = (HBox) deleteButton.getParent();
        if(TodoListAppRepository.deleteTodo(todoObj.getId())) {
            parentNode.getChildren().remove(singleTodo);
        }
    }

    public void setTodo(Todo todoObj) {
        this.todoObj = todoObj;
    }

}
