package com.foodApp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fooddelivery";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection initializeDatabase() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Database Driver not found.");
        }

        // Return a connection instance
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
