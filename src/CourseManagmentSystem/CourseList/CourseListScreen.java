package CourseManagmentSystem.CourseList;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class CourseListScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCourseList.fxml"));
            GridPane root = loader.load();
            Scene scene = new Scene(root, 400, 300);
            primaryStage.setTitle("Course List");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showNoSelectionAlert() {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Course Selected");
            alert.setContentText("Please select a course to view details.");
            alert.showAndWait();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
