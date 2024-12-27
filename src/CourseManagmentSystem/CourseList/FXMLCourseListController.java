package CourseManagmentSystem.CourseList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLCourseListController {

    @FXML
    private ListView<String> courseListView;

    @FXML
    private void initialize() {
        courseListView.setItems(FXCollections.observableArrayList(
            "Arabic Course", "Engilsh Course", "French Course"
        ));
        courseListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void handleViewDetails() {
        String selectedCourse = courseListView.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            if (selectedCourse.equals("Arabic Course")) {
                navigateToCourse1Details();
            }
            else if(selectedCourse.equals("Engilsh Course")){
                navigateToCourse2Details();
            }
            else if(selectedCourse.equals("French Course")){
                navigateToCourse3Details();
            }
                else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Course Details");
                alert.setHeaderText(null);
                alert.setContentText("Navigating to details of " + selectedCourse);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a course in the list.");
            alert.showAndWait();
        }
    }

    private void navigateToCourse1Details() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/Course1Details/FXMLCourse1Details.fxml"));
            Parent course1DetailsRoot = loader.load();

            Scene course1DetailsScene = new Scene(course1DetailsRoot);

            Stage primaryStage = (Stage) courseListView.getScene().getWindow();
            primaryStage.setScene(course1DetailsScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Navigation Error");
            alert.setContentText("Unable to load the Course 1 details screen.");
            alert.showAndWait();
        }
    }
    
        private void navigateToCourse2Details() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/Course2Details/FXMLCourse2Details.fxml"));
            Parent course2DetailsRoot = loader.load();

            Scene course2DetailsScene = new Scene(course2DetailsRoot);

            Stage primaryStage = (Stage) courseListView.getScene().getWindow();
            primaryStage.setScene(course2DetailsScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Navigation Error");
            alert.setContentText("Unable to load the Course 1 details screen.");
            alert.showAndWait();
        }
    }
        
        private void navigateToCourse3Details() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CourseManagmentSystem/Course3Details/FXMLCourse3Details.fxml"));
            Parent course3DetailsRoot = loader.load();

            Scene course3DetailsScene = new Scene(course3DetailsRoot);

            Stage primaryStage = (Stage) courseListView.getScene().getWindow();
            primaryStage.setScene(course3DetailsScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Navigation Error");
            alert.setContentText("Unable to load the Course 1 details screen.");
            alert.showAndWait();
        }
    }
}
