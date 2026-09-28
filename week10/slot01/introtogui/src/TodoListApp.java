import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TodoListApp extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        FXMLLoader loader = 
            new FXMLLoader(getClass().getResource("/views/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 500);
        arg0.setScene(scene);
        arg0.setTitle("Todo List App");
        arg0.setResizable(false);
        arg0.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
