package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SingleTodoController {

    VBox parentNode;
    @FXML Label todoLabel;

    public void addTodo(String todo, VBox parentNode) {
        this.parentNode = parentNode;
        todoLabel.setText(todo);
    }
    
    public void delete(ActionEvent e) {
        Button deleteButton = (Button) e.getSource();
        HBox singleTodo = (HBox) deleteButton.getParent();
        parentNode.getChildren().remove(singleTodo);
    }

}
