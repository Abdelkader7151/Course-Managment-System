package CourseManagmentSystem.Course3Details;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLCourse3DetailsController {

    @FXML
    private Label courseNameLabel;

    @FXML
    private Label courseDescriptionLabel;

    @FXML
    private void initialize() {
        // Simulating setting the course details
        courseNameLabel.setText("Sample Course");
        courseDescriptionLabel.setText("This is a sample course description.");
    }

    @FXML
    private void handleBack() {
        // Code to navigate back to the Course List screen
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Navigation");
        alert.setHeaderText(null);
        alert.setContentText("Navigating back to Course List screen...");
        alert.showAndWait();

        // Retrieve the stage and close it
        Stage stage = (Stage) courseNameLabel.getScene().getWindow();
        stage.close();
    }
}