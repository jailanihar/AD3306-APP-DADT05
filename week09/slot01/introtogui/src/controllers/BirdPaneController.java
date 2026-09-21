package controllers;

import javafx.fxml.FXML;
import javafx.scene.shape.Polygon;

public class BirdPaneController {
    
    @FXML private Polygon wing;

    public void wingUp() {
        wing.getPoints().set(4, 25.0);
        wing.getPoints().set(5, 10.0);
    }

    public void wingDown() {
        wing.getPoints().set(4, 15.0);
        wing.getPoints().set(5, 35.0);
    }

}
