package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Api {
    private static final String db = "jdbc:mysql://localhost:3306/coursemanagementsystem";
    private static final String username11 = "user123"; 
    private static final String password11 = "user123"; 

    public static void main(String[] args) {
        try {
            insertUserData("mooooood", "moooood@gg.com", "ububduw4343");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
            try {
            System.out.println(searchUser("example_user", "user123"));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertUserData(String username, String email, String password) throws SQLException {
        try (Connection conn = DriverManager.getConnection(db, username11, password11)) {
            System.out.println("Connected to the database.");

            String sql = "INSERT INTO newUsers (username, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new record was inserted successfully!");
                } else {
                    System.out.println("Failed to insert record.");
                }
            } catch (SQLException ex) {
                System.out.println("Error executing SQL statement: " + ex.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
    
      public static String searchUser(String username, String password) throws SQLException {
    try (Connection conn = DriverManager.getConnection(db, username11, password11)) {
        System.out.println("Connected to the database.");

        String sql = "SELECT * FROM newUsers WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return "Yes"; // User exists
                } else {
                    return "No"; // User does not exist
                }
            } catch (SQLException ex) {
                System.out.println("Error executing query: " + ex.getMessage());
                return "No"; // Return "No" in case of error
            }
        } catch (SQLException ex) {
            System.out.println("Error preparing statement: " + ex.getMessage());
            return "No"; // Return "No" in case of error
        }
    } catch (SQLException e) {
        System.out.println("Connection failed: " + e.getMessage());
        return "No"; // Return "No" in case of connection failure
    }
}

}
