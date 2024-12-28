package CourseManagmentSystem.Course3Details;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.util.WaitForAsyncUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class FXMLCourse3DetailsControllerTest {
    private FXMLCourse3DetailsController controller;
    private Label courseNameLabel;
    private Label courseDescriptionLabel;

    @BeforeEach
    void setUp() {
        // Initialize JavaFX toolkit
        new JFXPanel(); // Ensures JavaFX environment is initialized

        // Initialize JavaFX components and controller
        Platform.runLater(() -> {
            controller = new FXMLCourse3DetailsController();
            courseNameLabel = new Label();
            courseDescriptionLabel = new Label();
            injectFields();
        });

        // Wait for JavaFX thread to finish setup
        WaitForAsyncUtils.waitForFxEvents();
    }

    private void injectFields() {
        try {
            // Inject courseNameLabel
            Field courseNameField = FXMLCourse3DetailsController.class.getDeclaredField("courseNameLabel");
            courseNameField.setAccessible(true);
            courseNameField.set(controller, courseNameLabel);

            // Inject courseDescriptionLabel
            Field courseDescField = FXMLCourse3DetailsController.class.getDeclaredField("courseDescriptionLabel");
            courseDescField.setAccessible(true);
            courseDescField.set(controller, courseDescriptionLabel);
        } catch (Exception e) {
            fail("Failed to inject fields: " + e.getMessage());
        }
    }

    @Test
    void testInitialize() throws Exception {
        Platform.runLater(() -> {
            try {
                // Call the initialize method using reflection
                Method initializeMethod = FXMLCourse3DetailsController.class.getDeclaredMethod("initialize");
                initializeMethod.setAccessible(true);
                initializeMethod.invoke(controller);

                // Assert the expected values using the actual components
                assertEquals("Sample Course", courseNameLabel.getText());
                assertEquals("This is a sample course description.", courseDescriptionLabel.getText());
            } catch (Exception e) {
                fail("Initialization failed: " + e.getMessage());
            }
        });

        // Wait for JavaFX thread to finish
        WaitForAsyncUtils.waitForFxEvents();
    }

    @Test
    void testHandleBack() throws Exception {
        Platform.runLater(() -> {
            try {
                // Create a root node (e.g., AnchorPane) and add the button to it
                AnchorPane root = new AnchorPane();

                // Create a Scene and set the root node
                Scene realScene = new Scene(root);

                // Create a Stage and set the Scene
                Stage realStage = new Stage();
                realStage.setScene(realScene);

                // Use reflection to call the private handleBack method
                Method handleBackMethod = FXMLCourse3DetailsController.class.getDeclaredMethod("handleBack");
                handleBackMethod.setAccessible(true);

                // Verify that the method executes without throwing an exception
                assertDoesNotThrow(() -> handleBackMethod.invoke(controller));
            } catch (Exception e) {
                fail("Failed to test handleBack: " + e.getMessage());
            }
        });

        // Wait for JavaFX thread to finish
        WaitForAsyncUtils.waitForFxEvents();
    }
}
