package CourseManagmentSystem.Dashboard;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.util.WaitForAsyncUtils;

class DashboardScreenTest {

    private FXMLDashboardController controller;
    private Button viewCoursesButton;
    private Button viewProfileButton;
    private Stage stage;

    @BeforeEach
    void setUp() {
        // Initialize JavaFX toolkit
        new JFXPanel(); // Ensures JavaFX environment is initialized

        // Initialize JavaFX components and controller
        Platform.runLater(() -> {
            controller = new FXMLDashboardController();
            viewCoursesButton = new Button();
            viewProfileButton = new Button();
            stage = new Stage(); // Create a new Stage
            Scene scene = new Scene(viewCoursesButton); // Create a simple Scene with the button
            stage.setScene(scene); // Set the scene to the stage
            injectFields(); // Inject the buttons into the controller
        });

        // Wait for JavaFX thread to finish setup
        WaitForAsyncUtils.waitForFxEvents();
    }

    private void injectFields() {
        try {
            // Inject viewCoursesButton
            java.lang.reflect.Field viewCoursesField = FXMLDashboardController.class.getDeclaredField("viewCoursesButton");
            viewCoursesField.setAccessible(true);
            viewCoursesField.set(controller, viewCoursesButton);

            // Inject viewProfileButton
            java.lang.reflect.Field viewProfileField = FXMLDashboardController.class.getDeclaredField("viewProfileButton");
            viewProfileField.setAccessible(true);
            viewProfileField.set(controller, viewProfileButton);

        } catch (Exception e) {
            fail("Failed to inject fields: " + e.getMessage());
        }
    }

    @Test
    void testHandleViewCourses() {
        Platform.runLater(() -> {
            try {
                // Call the handleViewCourses method to simulate button click
                controller.handleViewCourses();
            } catch (Exception e) {
                fail("Failed to test handleViewCourses: " + e.getMessage());
            }
        });
        WaitForAsyncUtils.waitForFxEvents();
    }

    @Test
    void testHandleProfile() {
        Platform.runLater(() -> {
            try {
                // Set up the scene and stage
                AnchorPane root = new AnchorPane();
                root.getChildren().add(viewProfileButton); // Add the button to the scene

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene); // Attach the scene to the stage
                stage.show(); // Show the stage to make the scene active

                // Call the handleProfile method to simulate button click
                controller.handleProfile();

                // Verify the profile screen is displayed by checking the stage title
                assertNotNull(stage);
                assertEquals("Profile", stage.getTitle()); // Assert the title to confirm the screen has changed
            } catch (Exception e) {
                fail("Failed to test handleProfile: " + e.getMessage());
            }
        });

        WaitForAsyncUtils.waitForFxEvents();
    }


}