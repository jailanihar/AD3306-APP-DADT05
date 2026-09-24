package controllers;

import java.util.LinkedList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class FlightPaneController {
    
    private static final double GRAVITY = 900;
    private static final double WALL_SPEED = 200;
    private static final int WALL_GAP = 150;

    private double velocityY;

    @FXML BirdPaneController birdPaneController;
    @FXML Pane birdPane, flightPane;

    ScorePaneController currentScorePaneController,
        previousScorePaneController;

    AnimationTimer animation;
    Random random = new Random();

    int score;
    int previousScore;
    double scoreTime;
    boolean gameStarted = false;

    LinkedList<Rectangle> topWalls = new LinkedList<Rectangle>();
    LinkedList<Rectangle> bottomWalls = new LinkedList<Rectangle>();

    public void initialize() {
        birdPane.setLayoutX(10.0);
        birdPane.setLayoutY(300);
        generateWall(250);
        generateWall(500);
        generateWall(750);
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
                scoreTime += deltaSeconds;
                score = (int) scoreTime;
                if(currentScorePaneController != null) {
                    currentScorePaneController.setScore(score);
                }

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

    public void generateWall(double x) {
        int height = 600;
        int topHeight = random.nextInt(250) + 100;
        int bottomHeight = height - topHeight - WALL_GAP;
        Rectangle topWall = new Rectangle(x, 0, 50, topHeight);
        Rectangle bottomWall =
            new Rectangle(x, height - bottomHeight, 50, bottomHeight);
        flightPane.getChildren().addAll(topWall, bottomWall);
        topWalls.add(topWall);
        bottomWalls.add(bottomWall);
    }

    public void resetGame() {
        gameStarted = false;
        velocityY = 0;
        birdPane.setLayoutX(10);
        birdPane.setLayoutY(300);
        previousScore = score;
        score = 0;
        scoreTime = 0;
        if(currentScorePaneController != null) {
            currentScorePaneController.setScore(score);
        }
        if(previousScorePaneController != null) {
            previousScorePaneController.setScore(previousScore);
        }
    }

}
