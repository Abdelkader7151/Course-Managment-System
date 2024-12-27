package CourseManagmentSystem.Course2Details;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import java.io.IOException;

public class FXMLCourse2DetailsController {

    @FXML
    private Label courseNameLabel;

    @FXML
    private Label courseDescriptionLabel;

    @FXML
    private Button viewBackButton;

    @FXML
    private void initialize() {
        // Simulating setting the course details
        courseNameLabel.setText("English Course");
        courseDescriptionLabel.setText("English language, a West Germanic language of the Indo-European language family that is closely related to the Frisian, German, and Dutch languages. It originated in England and is the dominant language of the U.S., the U.K., Canada, Australia, Ireland, and New Zealand.");
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
