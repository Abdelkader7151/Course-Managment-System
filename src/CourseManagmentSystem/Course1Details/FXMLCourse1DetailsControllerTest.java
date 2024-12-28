package CourseManagmentSystem.Course1Details;

import static org.junit.jupiter.api.Assertions.*;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FXMLCourse1DetailsControllerTest {
    private FXMLCourse1DetailsController controller;
    private Label courseNameLabel;
    private Label courseDescriptionLabel;
    private Button viewBackButton;

    @BeforeEach
    void setUp() {
        // Initialize JavaFX toolkit
        new JFXPanel(); // This initializes the JavaFX platform

        // Create actual JavaFX components instead of mocks
        controller = new FXMLCourse1DetailsController();
        courseNameLabel = new Label();
        courseDescriptionLabel = new Label();
        viewBackButton = new Button();

        // Inject the real components
        injectFields();
    }

    private void injectFields() {
        try {
            // Inject courseNameLabel
            java.lang.reflect.Field courseNameField =
                    FXMLCourse1DetailsController.class.getDeclaredField("courseNameLabel");
            courseNameField.setAccessible(true);
            courseNameField.set(controller, courseNameLabel);

            // Inject courseDescriptionLabel
            java.lang.reflect.Field courseDescField =
                    FXMLCourse1DetailsController.class.getDeclaredField("courseDescriptionLabel");
            courseDescField.setAccessible(true);
            courseDescField.set(controller, courseDescriptionLabel);

            // Inject viewBackButton
            java.lang.reflect.Field backButtonField =
                    FXMLCourse1DetailsController.class.getDeclaredField("viewBackButton");
            backButtonField.setAccessible(true);
            backButtonField.set(controller, viewBackButton);
        } catch (Exception e) {
            fail("Failed to inject fields: " + e.getMessage());
        }
    }

    @Test
    void testInitialize() throws Exception {
        // Call the initialize method using reflection
        java.lang.reflect.Method initializeMethod =
                FXMLCourse1DetailsController.class.getDeclaredMethod("initialize");
        initializeMethod.setAccessible(true);
        initializeMethod.invoke(controller);

        // Assert the expected values using the actual components
        assertEquals("Sample Course", courseNameLabel.getText());
        assertEquals("This is a sample course description.", courseDescriptionLabel.getText());
    }
}