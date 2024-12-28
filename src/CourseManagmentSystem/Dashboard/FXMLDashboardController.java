package CourseManagmentSystem.Dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class FXMLDashboardController {

    @FXML
    protected Button viewCoursesButton;

    @FXML
    protected Button viewProfileButton;

    @FXML
    protected void handleViewCourses() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/CourseList/FXMLCourseList.fxml"));
            GridPane courseListRoot = loader.load(); // Cast to GridPane

            Stage primaryStage = (Stage) viewCoursesButton.getScene().getWindow();
            Scene courseListScene = new Scene(courseListRoot, 400, 300);
            primaryStage.setScene(courseListScene);
            primaryStage.setTitle("Course List");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Failed to load the Course List screen.");
        }
    }

    @FXML
    protected void handleProfile() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/Profile/FXMLProfile.fxml"));
            AnchorPane profileRoot = loader.load();

            Stage primaryStage = (Stage) viewProfileButton.getScene().getWindow();
            Scene profileScene = new Scene(profileRoot, 641, 449);
            primaryStage.setScene(profileScene);
            primaryStage.setTitle("Profile");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Failed to load the Profile screen.");
        }
    }

    protected void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
