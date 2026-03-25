/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginexample;

/**
 *
 * @author andrey
 */
import java.sql.*;
import java.util.Scanner;

public class LoginExample {

    // JDBC URL, username and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase"; // replace with your DB
    private static final String USER = "root"; // your DB username
    private static final String PASSWORD = "password"; // your DB password

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask user for login and password
        System.out.print("Enter login: ");
        String login = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Check if user exists
            String checkUserQuery = "SELECT * FROM users WHERE login = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkUserQuery);
            checkStmt.setString(1, login);

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // User exists
                System.out.println("User exists. Logging in...");
            } else {
                // User does not exist, create new one
                String insertUserQuery = "INSERT INTO users (login, password) VALUES (?, ?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertUserQuery);
                insertStmt.setString(1, login);
                insertStmt.setString(2, pass); // in real apps, hash the password!
                insertStmt.executeUpdate();

                System.out.println("New user created: " + login);
            }

            // Close resources
            rs.close();
            checkStmt.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }

        scanner.close();
    }
}