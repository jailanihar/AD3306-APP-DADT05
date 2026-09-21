package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ScorePaneController {
    
    @FXML
    Label scoreTitleLabel, scoreLabel;

    public void setScoreTitle(String title) {
        scoreTitleLabel.setText(title);
    }

    public void setScore(int score) {
        scoreLabel.setText(Integer.toString(score));
    }

}
