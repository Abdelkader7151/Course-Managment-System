package CourseManagmentSystem.Login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Api; 
import java.io.IOException;
import java.sql.SQLException;

public class FXMLLoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            String result = Api.searchUser(username, password);
            if (result.equals("Yes")) {
                navigateToDashboard();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while accessing the database.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancel() {
        usernameField.clear();
        passwordField.clear();
    }

    private void navigateToDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/Dashboard/FXMLDashboard.fxml"));
            Parent dashboardRoot = loader.load();

            Scene dashboardScene = new Scene(dashboardRoot);

            Stage primaryStage = (Stage) usernameField.getScene().getWindow();
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
