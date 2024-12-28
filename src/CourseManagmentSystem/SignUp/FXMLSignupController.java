package CourseManagmentSystem.SignUp;

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

public class FXMLSignupController {

    @FXML
    protected TextField usernameField;

    @FXML
    protected TextField emailField;

    @FXML
    protected PasswordField passwordField;

    @FXML
    protected PasswordField confirmPasswordField;

    @FXML
    protected void handleSignup() throws SQLException {
        String username = usernameField.getText();
        String email = emailField.getText(); // Get email
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            showAlert("Error", "Password mismatch", "Password and confirm password do not match. Please try again.");
            return; // Exit the method
        }

        Api.insertUserData(username, email, password);
        openLoginScreen();
    }

    @FXML
    protected void handleCancel() {
        usernameField.clear();
        emailField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
    }

    protected void openLoginScreen() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CourseManagmentSystem/Login/FXMLLogin.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            Stage signupStage = (Stage) usernameField.getScene().getWindow();
            signupStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
