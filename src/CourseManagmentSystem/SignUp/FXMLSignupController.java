package CourseManagmentSystem.SignUp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Api;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Api;

import java.io.IOException;

public class FXMLSignupController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField; 

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private void handleSignup() throws SQLException {
        String username = usernameField.getText();
        String email = emailField.getText(); // Get email
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        
        if (!password.equals(confirmPassword)) {
            // Passwords don't match, show alert
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Password mismatch");
            alert.setContentText("Password and confirm password do not match. Please try again.");
            alert.showAndWait();
            return; // Exit the method
        }
        
        // Call the insertUserData method from Api class
        Api.insertUserData(username, email, password);
        
        // After successful signup, open the login screen
        openLoginScreen();
    }

    private void openLoginScreen() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CourseManagmentSystem/Login/FXMLLogin.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            // Close the signup screen
            Stage signupStage = (Stage) usernameField.getScene().getWindow();
            signupStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancel() {
        usernameField.clear();
        emailField.clear(); // Clear email field
        passwordField.clear();
        confirmPasswordField.clear();
    }
}
