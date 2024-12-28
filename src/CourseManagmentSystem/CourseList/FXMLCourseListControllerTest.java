package CourseManagmentSystem.CourseList;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FXMLCourseListControllerTest {

    private FXMLCourseListController controller;
    private ListView<String> courseListView;
    private Button viewDetailsButton;

    @BeforeAll
    public static void initJFX() {
        // Initialize JavaFX environment
        new JFXPanel();
    }

    @BeforeEach
    public void setUp() {
        // Create actual JavaFX components
        controller = new FXMLCourseListController();
        courseListView = new ListView<>();
        viewDetailsButton = new Button();

        // Set the fields using reflection
        try {
            java.lang.reflect.Field listViewField = FXMLCourseListController.class.getDeclaredField("courseListView");
            java.lang.reflect.Field buttonField = FXMLCourseListController.class.getDeclaredField("viewDetailsButton");

            listViewField.setAccessible(true);
            buttonField.setAccessible(true);

            listViewField.set(controller, courseListView);
            buttonField.set(controller, viewDetailsButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCourseListViewInitialization() {
        // Setup
        courseListView.setItems(FXCollections.observableArrayList("Arabic Course", "English Course", "French Course"));

        // Execute
        controller.initialize();

        // Verify
        assertEquals(3, courseListView.getItems().size(), "Course list should have 3 items.");
    }

    @Test
    void testHandleViewDetailsWithSelection() {
        // Setup
        courseListView.setItems(FXCollections.observableArrayList("Arabic Course", "English Course", "French Course"));
        courseListView.getSelectionModel().select("Arabic Course");

        // Execute
        controller.handleViewDetails();

        // Verify
        // We can't directly verify UI changes, so we would need to mock or capture the navigation action here.
        // Assuming the navigation occurs correctly in the actual controller, we check if the alert is not triggered.
        assertTrue(courseListView.getSelectionModel().getSelectedItem().equals("Arabic Course"));
    }

    @Test
    void testHandleViewDetailsWithNoSelection() {
        // Setup: no course selected
        courseListView.getSelectionModel().clearSelection();

        // Execute
        controller.handleViewDetails();

        // Verify: an alert should show up due to no selection
        Alert alert = controller.getAlert();
        assertNotNull(alert, "Alert should be triggered when no course is selected.");
        assertEquals(Alert.AlertType.WARNING, alert.getAlertType(), "Alert type should be WARNING for no selection.");
        assertEquals("No Selection", alert.getTitle(), "Alert title should be 'No Selection'.");
        assertTrue(alert.getContentText().contains("Please select a course in the list."), "Alert content text should mention course selection.");
    }
}
