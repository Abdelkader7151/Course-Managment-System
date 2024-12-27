package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    private static final String db = "jdbc:mysql://localhost:3306/coursemanagementsystem"; // Note the port number for MAMP
    private static final String namer = "user123";
    private static final String password = "user123";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(db, namer, password)) {
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
