// package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserService {
    // FIXED: Read credentials from environment variables
    private String password = System.getenv("DB_PASSWORD");
    private String username = System.getenv("DB_USERNAME");
    private String dbUrl = System.getenv("DB_URL");

    // FIXED: SQL Injection prevented with PreparedStatement
    public void findUser(String username) throws java.sql.SQLException {

        try (Connection conn = DriverManager.getConnection(dbUrl, this.username, password);
                PreparedStatement pst = conn.prepareStatement("SELECT id, name, email FROM users WHERE name = ?")) {

            pst.setString(1, username);
            pst.executeQuery();
        }
    }

    // FIXED: SQL Injection prevented with PreparedStatement
    public void deleteUser(String username) throws java.sql.SQLException {
        try (Connection conn = DriverManager.getConnection(dbUrl, this.username, password);
                PreparedStatement pst = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {

            pst.setString(1, username);
            pst.execute();
        }
    }
}
