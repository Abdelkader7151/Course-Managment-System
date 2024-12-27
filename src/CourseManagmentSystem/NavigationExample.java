package CourseManagmentSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NavigationExample extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Course Management System");
        showLoginScreen();
    }

    private void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CourseManagmentSystem.Login/FXMLLogin.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDashboardScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CourseManagmentSystem.Dashboard/FXMLDashboard.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCourseListScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CourseManagmentSystem.CourseList/FXMLCourseList.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCourseDetailsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CourseManagmentSystem.CourseDetails/FXMLCourseDetails.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showProfileScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CourseManagmentSystem.Profile/FXMLProfile.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }  
}
