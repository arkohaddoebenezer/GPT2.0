package org.trainingamalitech.librarymanagementsystem.model;

import org.trainingamalitech.librarymanagementsystem.enums.ResourceType;
import org.trainingamalitech.librarymanagementsystem.model.Reservation;
import org.trainingamalitech.librarymanagementsystem.model.Transaction;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class LibraryResource {
    private final String id;
    private final String title;
    private final String author;
    private final String publisher;
    private final int year;
    private final String dateAdded;
    boolean isAvailable;
    public LinkedList<String> operationErrors = new LinkedList<>();

    protected LibraryResource(String id, String title, String author, String publisher, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isAvailable = true;
        this.dateAdded = new Date().toString();

    }

    protected LibraryResource(String id, String title, String author, String publisher, int year, String dateAdded,
            boolean availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.dateAdded = dateAdded;
        this.isAvailable = availability;
    }

    public String getTitle() {
        if (title == null) {
            this.pushErrors("Title not set.");
            return null;
        }
        return title;
    }

    public String getAuthor() {
        if (title == null) {
            this.pushErrors("Author not set.");
            return null;
        }
        return author;
    }

    public String getId() {
        if (title == null) {
            this.pushErrors("ID not set.");
            return null;
        }
        return id;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getPublisher() {
        if (title == null) {
            this.pushErrors("Publisher not set.");
            return null;
        }
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public void pushErrors(String errorMessage) {
        operationErrors.add(errorMessage);
    }

    public boolean hasOperationErrors() {
        return !operationErrors.isEmpty();
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public List<Transaction> transactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transaction WHERE resourceType = ? AND resourceId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sql)) {

            prepareStatement.setString(1, this.getResourceType().toString());
            prepareStatement.setString(2, this.getId());

            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                System.out.println("Retrieving Transactions for " + this.getTitle());

                while (resultSet.next()) {
                    int transactionId = resultSet.getInt("transactionId");
                    String resourceId = resultSet.getString("resourceId");
                    String resourceType = resultSet.getString("resourceType");
                    String patronId = resultSet.getString("patronId");
                    String borrowDate = resultSet.getString("borrowDate");
                    String returnDate = resultSet.getString("returnDate");

                    Transaction transaction = new Transaction(transactionId, resourceId, resourceType, patronId,
                            borrowDate, returnDate);
                    transactions.add(transaction);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving transactions", e);
        }

        return transactions;
    }

    public List<Reservation> reservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation WHERE resourceType = ? AND resourceId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sql)) {

            prepareStatement.setString(1, this.getResourceType().toString());
            prepareStatement.setString(2, this.getId());

            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                System.out.println("Retrieving Transactions for " + this.getTitle());

                while (resultSet.next()) {
                    int reservationId = resultSet.getInt("reservationId");
                    String resourceId = resultSet.getString("resourceId");
                    String resourceType = resultSet.getString("resourceType");
                    String patronId = resultSet.getString("patronId");
                    String reservationDate = resultSet.getString("reservationDate");
                    Reservation transaction = new Reservation(reservationId, resourceId,resourceType, patronId,
                    reservationDate);
                     
                            reservations.add(transaction);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving transactions", e);
        }

        return reservations;
    }


    public abstract ResourceType getResourceType();
}
