package CourseManagmentSystem.Profile;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FXMLProfileControllerTest {

    private FXMLProfileController controller;
    private Label usernameLabel;

    @BeforeAll
    public static void initJFX() {
        // Initialize JavaFX environment
        new JFXPanel();
    }

    @BeforeEach
    public void setUp() {
        // Create actual JavaFX components
        controller = new FXMLProfileController();
        usernameLabel = new Label();

        // Set the field using reflection
        try {
            java.lang.reflect.Field usernameField = FXMLProfileController.class.getDeclaredField("usernameLabel");
            usernameField.setAccessible(true);
            usernameField.set(controller, usernameLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testHandleLogout() {
        // Simulate navigation
        assertDoesNotThrow(() -> controller.handleLogout(), "Logout should not throw exceptions");
    }

    @Test
    void testInitialize() {
        controller.initialize(null, null);
        assertEquals("Profile", usernameLabel.getText(), "Username label text should be 'Profile'");
    }

    @Test
    void testFieldsNotNull() {
        assertNotNull(usernameLabel, "Username label should not be null");
    }
}
