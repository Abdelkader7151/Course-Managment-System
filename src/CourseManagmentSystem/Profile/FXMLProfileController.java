package CourseManagmentSystem.Profile;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class FXMLProfileController implements Initializable {

    @FXML
    protected Label usernameLabel;

    @FXML
    protected void handleLogout() {
        navigateToDashboard();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Simulating setting the profile details
        usernameLabel.setText("Profile");
    }

    private void navigateToDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/Dashboard/FXMLDashboard.fxml"));
            Parent dashboardRoot = loader.load();

            Scene dashboardScene = new Scene(dashboardRoot);

            Stage primaryStage = (Stage) usernameLabel.getScene().getWindow();
            primaryStage.setScene(dashboardScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Navigation Error");
            alert.setContentText("Unable to load the dashboard screen.");
            alert.showAndWait();
        }
    }
}
