package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class MainController {
    
    @FXML VBox rootPane;

    public void initialize() {
        Platform.runLater(rootPane::requestFocus);
    }

    public void handleKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            System.out.println("Key Pressed");
        }
    }

    public void handleKeyReleased(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            System.out.println("Key Released");
        }
    }

}
