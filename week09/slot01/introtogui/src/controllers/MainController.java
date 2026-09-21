package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class MainController {
    
    @FXML VBox rootPane;
    @FXML
    ScorePaneController currentScorePaneController,
        previousScorePaneController, spacePressedScorePaneController;
    @FXML FlightPaneController flightPaneController;

    int countSpacePressed = 0;

    public void initialize() {
        currentScorePaneController.setScoreTitle("Current Score");
        previousScorePaneController.setScoreTitle("Previous Score");
        spacePressedScorePaneController.setScoreTitle("Space Pressed");
        Platform.runLater(rootPane::requestFocus);
    }

    public void handleKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            flightPaneController.gameStarted = true;

            flightPaneController.birdPaneController.wingUp();

            countSpacePressed++;
            spacePressedScorePaneController.setScore(countSpacePressed);
        }
    }

    public void handleKeyReleased(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            flightPaneController.birdPaneController.wingDown();
        }
    }

}
