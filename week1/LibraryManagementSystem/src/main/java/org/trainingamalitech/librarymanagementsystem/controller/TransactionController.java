package org.trainingamalitech.librarymanagementsystem.controller;

import org.trainingamalitech.librarymanagementsystem.model.Transaction;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionController {

        // Method to add a new transaction
        public void addTransaction(Transaction transaction) {
            String sql = "INSERT INTO Transaction (transactionId, bookIsbn, patronId, borrowDate, returnDate) VALUES (?, ?, ?, ?, ?)";

            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, transaction.getTransactionId());
                statement.setString(2, transaction.getBookIsbn());
                statement.setString(3, transaction.getPatronId());
                statement.setDate(4, new java.sql.Date(transaction.getBorrowDate().getTime()));
                statement.setDate(5, transaction.getReturnDate() != null ? new java.sql.Date(transaction.getReturnDate().getTime()) : null);

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to get a list of all transactions
        public List<Transaction> getAllTransactions() {
            List<Transaction> transactions = new ArrayList<>();
            String sql = "SELECT * FROM Transaction";

            try (Connection connection = DatabaseUtil.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionId(resultSet.getString("transactionId"));
                    transaction.setBookIsbn(resultSet.getString("bookIsbn"));
                    transaction.setPatronId(resultSet.getString("patronId"));
                    transaction.setBorrowDate(resultSet.getDate("borrowDate"));
                    transaction.setReturnDate(resultSet.getDate("returnDate"));

                    transactions.add(transaction);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return transactions;
        }

        // Method to update a transaction's return date
        public void updateTransactionReturnDate(String transactionId, Date returnDate) {
            String sql = "UPDATE Transaction SET returnDate = ? WHERE transactionId = ?";

            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setDate(1, new java.sql.Date(returnDate.getTime()));
                statement.setString(2, transactionId);

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to delete a transaction
        public void deleteTransaction(String transactionId) {
            String sql = "DELETE FROM Transaction WHERE transactionId = ?";

            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, transactionId);

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
