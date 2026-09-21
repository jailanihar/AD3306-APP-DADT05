package controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class FlightPaneController {
    
    private static final double GRAVITY = 900;

    private double velocityY;

    @FXML BirdPaneController birdPaneController;
    @FXML Pane birdPane, flightPane;

    AnimationTimer animation;

    boolean gameStarted = false;

    public void initialize() {
        birdPane.setLayoutX(10.0);
        birdPane.setLayoutY(300);
        animation = new AnimationTimer() {
            private long previousTime;

            @Override
            public void handle(long arg0) {
                if(gameStarted == false) {
                    return;
                }
                if(previousTime == 0) {
                    previousTime = arg0; //arg0 is time now
                    return;
                }
                double deltaSeconds = (arg0 - previousTime) / 1000000000.0;
                previousTime = arg0;

                velocityY += GRAVITY * deltaSeconds;
                double nextY = birdPane.getLayoutY() + velocityY * deltaSeconds;

                double maxY = flightPane.getHeight() - 
                    birdPane.getBoundsInParent().getHeight();
                if(nextY < 0) {
                    nextY = 0;
                    velocityY = 0;
                    gameStarted = false;
                } else if(nextY > maxY) {
                    nextY = maxY;
                    velocityY = 0;
                    gameStarted = false;
                }

                birdPane.setLayoutY(nextY);

                if(gameStarted == false) {
                    previousTime = 0;
                    resetGame();
                }
            }
        };
        animation.start();
    }

    public void moveBirdUp() {
        velocityY = -350;
    }

    public void resetGame() {
        gameStarted = false;
        velocityY = 0;
        birdPane.setLayoutX(10);
        birdPane.setLayoutY(300);
    }

}
