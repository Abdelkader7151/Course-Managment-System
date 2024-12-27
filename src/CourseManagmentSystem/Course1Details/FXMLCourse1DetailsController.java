package CourseManagmentSystem.Course1Details;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class FXMLCourse1DetailsController {

    @FXML
    private Label courseNameLabel;

    @FXML
    private Label courseDescriptionLabel;
    
    @FXML
    private Button viewBackButton;    

    @FXML
    private void initialize() {
        // Simulating setting the course details
        courseNameLabel.setText("Sample Course");
        courseDescriptionLabel.setText("This is a sample course description.");
    }

    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/CourseList/FXMLCourseList.fxml"));
            GridPane courseListRoot = loader.load(); // Cast to GridPane

            Stage primaryStage = (Stage) viewBackButton.getScene().getWindow();
            Scene courseListScene = new Scene(courseListRoot, 400, 300);
            primaryStage.setScene(courseListScene);
            primaryStage.setTitle("Course List");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Failed to load the Course List screen.");
        }
    }
    
        private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}