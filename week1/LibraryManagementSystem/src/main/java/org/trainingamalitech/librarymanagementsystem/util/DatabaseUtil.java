package org.trainingamalitech.librarymanagementsystem.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseUtil {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/LibraryManagement";
        private static final String DB_USER = "your_username";
        private static final String DB_PASSWORD = "your_password";

        static {
            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Failed to load MySQL JDBC driver", e);
            }
        }

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

        public static void closeConnection(Connection connection) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

}
