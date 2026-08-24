import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GuessMyColour extends Application {

    private Rectangle guessRectangle = new Rectangle();
    private Rectangle answerRectangle = new Rectangle();

    private int guessRed = 0;
    private int guessGreen = 0;
    private int guessBlue = 0;
    private int answerRed = 0;
    private int answerGreen = 0;
    private int answerBlue = 0;


    public void initGUI(Stage arg0) {
        BorderPane rootPane = new BorderPane();
        
        Label titleLabel = new Label("Guess My Colour");
        Font titleFont = Font.font("Serif", FontWeight.EXTRA_BOLD, 32);
        titleLabel.setFont(titleFont);
        titleLabel.setBackground(new Background(
            new BackgroundFill(Color.BLACK, null, null)
        ));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.prefWidthProperty().bind(rootPane.widthProperty());
        titleLabel.setAlignment(Pos.CENTER);
        
        rootPane.setTop(titleLabel);

        guessRectangle.setWidth(50);
        guessRectangle.setHeight(50);
        guessRectangle.setFill(Color.BLUEVIOLET);
        
        answerRectangle.setWidth(50);
        answerRectangle.setHeight(50);
        answerRectangle.setFill(Color.CRIMSON);

        FlowPane centerPane = new FlowPane();
        centerPane.getChildren().addAll(guessRectangle, answerRectangle);
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setHgap(10);
        centerPane.setVgap(10);

        rootPane.setCenter(centerPane);

        generateGuessColour();

        Scene root = new Scene(rootPane);
        arg0.setScene(root);
    }

    public void generateGuessColour() {
        Random rand = new Random();
        guessRed = rand.nextInt(18) * 15;
        guessGreen = rand.nextInt(18) * 15;
        guessBlue = rand.nextInt(18) * 15;
        Color guessColour = Color.rgb(guessRed, guessGreen, guessBlue);
        guessRectangle.setFill(guessColour);

        answerRed = rand.nextInt(18) * 15;
        answerGreen = rand.nextInt(18) * 15;
        answerBlue = rand.nextInt(18) * 15;
        Color answerColour = Color.rgb(answerRed, answerGreen, answerBlue);
        answerRectangle.setFill(answerColour);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        initGUI(arg0);

        arg0.setTitle("Guess My Colour");
        // arg0.setResizable(false);
        arg0.sizeToScene();
        arg0.show();
    }

}