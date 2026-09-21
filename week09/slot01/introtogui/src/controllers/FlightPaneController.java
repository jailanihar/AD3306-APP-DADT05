package controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class FlightPaneController {
    
    @FXML BirdPaneController birdPaneController;
    @FXML Pane birdPane;

    AnimationTimer animation;

    boolean gameStarted = false;

    public void initialize() {
        birdPane.setLayoutX(10.0);
        birdPane.setLayoutY(300);
        animation = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                if(gameStarted == false) {
                    return;
                }

                birdPane.setLayoutY(birdPane.getLayoutY() + 1);
            }
        };
        animation.start();
    }

}
