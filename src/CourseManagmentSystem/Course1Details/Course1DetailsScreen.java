package CourseManagmentSystem.Course1Details;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Course1DetailsScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCourse1Details.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root, 584, 498); // Adjusted scene size to match FXML
            primaryStage.setTitle("Course 1 Details");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}