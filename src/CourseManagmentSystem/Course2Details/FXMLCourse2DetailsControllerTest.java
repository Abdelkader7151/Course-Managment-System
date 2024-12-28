package CourseManagmentSystem.Course2Details;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.util.WaitForAsyncUtils;

class FXMLCourse2DetailsControllerTest {
    private FXMLCourse2DetailsController controller;
    private Label courseNameLabel;
    private Label courseDescriptionLabel;
    private Button viewBackButton;

    @BeforeEach
    void setUp() {
        // Initialize JavaFX toolkit
        new JFXPanel(); // Ensures JavaFX environment is initialized

        // Initialize JavaFX components and controller
        Platform.runLater(() -> {
            controller = new FXMLCourse2DetailsController();
            courseNameLabel = new Label();
            courseDescriptionLabel = new Label();
            viewBackButton = new Button();
            injectFields();
        });

        // Wait for JavaFX thread to finish setup
        WaitForAsyncUtils.waitForFxEvents();
    }

    private void injectFields() {
        try {
            // Inject courseNameLabel
            java.lang.reflect.Field courseNameField =
                    FXMLCourse2DetailsController.class.getDeclaredField("courseNameLabel");
            courseNameField.setAccessible(true);
            courseNameField.set(controller, courseNameLabel);

            // Inject courseDescriptionLabel
            java.lang.reflect.Field courseDescField =
                    FXMLCourse2DetailsController.class.getDeclaredField("courseDescriptionLabel");
            courseDescField.setAccessible(true);
            courseDescField.set(controller, courseDescriptionLabel);

            // Inject viewBackButton
            java.lang.reflect.Field backButtonField =
                    FXMLCourse2DetailsController.class.getDeclaredField("viewBackButton");
            backButtonField.setAccessible(true);
            backButtonField.set(controller, viewBackButton);
        } catch (Exception e) {
            fail("Failed to inject fields: " + e.getMessage());
        }
    }

    @Test
    void testInitialize() throws Exception {
        Platform.runLater(() -> {
            try {
                // Call the initialize method using reflection
                java.lang.reflect.Method initializeMethod =
                        FXMLCourse2DetailsController.class.getDeclaredMethod("initialize");
                initializeMethod.setAccessible(true);
                initializeMethod.invoke(controller);

                // Assert the expected values using the actual components
                assertEquals("English Course", courseNameLabel.getText());
                assertEquals(
                        "English language, a West Germanic language of the Indo-European language family that is closely related to the Frisian, German, and Dutch languages. It originated in England and is the dominant language of the U.S., the U.K., Canada, Australia, Ireland, and New Zealand.",
                        courseDescriptionLabel.getText()
                );
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
                root.getChildren().add(viewBackButton);

                // Create a Scene and set the root node
                Scene realScene = new Scene(root);

                // Create a Stage and set the Scene
                Stage realStage = new Stage();
                realStage.setScene(realScene);

                // Use reflection to call the private handleBack method
                java.lang.reflect.Method handleBackMethod =
                        FXMLCourse2DetailsController.class.getDeclaredMethod("handleBack");
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
