package org.trainingamalitech.librarymanagementsystem.util;

import java.sql.Connection;
import java.sql.SQLException;
public class TestDatabaseConnection {
        public static void main(String[] args) {
            try {
                Connection connection = DatabaseUtil.getConnection();
                if (connection != null) {
                    System.out.println("Connection established successfully.");
                    DatabaseUtil.closeConnection(connection);
                } else {
                    System.out.println("Failed to establish connection.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
