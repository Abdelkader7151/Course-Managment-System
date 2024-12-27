package CourseManagmentSystem.Course2Details;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Course2DetailsScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCourse2Details.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root, 578, 507); // Set scene size according to FXML
            primaryStage.setTitle("Course 2 Details");
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