package CourseManagmentSystem.SignUp;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FXMLSignUpControllerTest {

    private FXMLSignupController controller;
    private TextField usernameField;
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;

    @BeforeAll
    public static void initJFX() {
        // Initialize JavaFX environment
        new JFXPanel();
    }

    @BeforeEach
    public void setUp() {
        // Create actual JavaFX components
        controller = new FXMLSignupController();
        usernameField = new TextField();
        passwordField = new PasswordField();
        confirmPasswordField = new PasswordField();

        // Set the fields using reflection
        try {
            java.lang.reflect.Field userField = FXMLSignupController.class.getDeclaredField("usernameField");
            java.lang.reflect.Field passField = FXMLSignupController.class.getDeclaredField("passwordField");
            java.lang.reflect.Field confirmPassField = FXMLSignupController.class.getDeclaredField("confirmPasswordField");

            userField.setAccessible(true);
            passField.setAccessible(true);
            confirmPassField.setAccessible(true);

            userField.set(controller, usernameField);
            passField.set(controller, passwordField);
            confirmPassField.set(controller, confirmPasswordField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHandleCancel() {
        // Setup
        usernameField.setText("testuser");
        passwordField.setText("testpass");
        confirmPasswordField.setText("testpass");

        // Execute
        controller.handleCancel();

        // Verify
        assertEquals("", usernameField.getText(), "Username field should be empty");
        assertEquals("", passwordField.getText(), "Password field should be empty");
        assertEquals("", confirmPasswordField.getText(), "Confirm Password field should be empty");
    }

    @Test
    void testFieldsNotNull() {
        assertNotNull(usernameField, "Username field should not be null");
        assertNotNull(passwordField, "Password field should not be null");
        assertNotNull(confirmPasswordField, "Confirm Password field should not be null");
    }

    @Test
    void testInitialFieldsEmpty() {
        assertEquals("", usernameField.getText(), "Username field should be empty initially");
        assertEquals("", passwordField.getText(), "Password field should be empty initially");
        assertEquals("", confirmPasswordField.getText(), "Confirm Password field should be empty initially");
    }
}
