module CourseManagmentSystem {
        requires javafx.controls;
        requires javafx.fxml;
        requires org.testfx.junit5;
        requires org.junit.jupiter.api;
        requires org.testfx;
        requires javafx.swing;
        requires java.sql;

        opens CourseManagmentSystem.Login to javafx.fxml;
        opens CourseManagmentSystem to javafx.fxml, javafx.graphics;

        exports CourseManagmentSystem.Login;
        exports CourseManagmentSystem;
        }