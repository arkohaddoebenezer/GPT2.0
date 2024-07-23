package org.trainingamalitech.librarymanagementsystem.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.trainingamalitech.librarymanagementsystem.contracts.LibraryResourceOperations;
import org.trainingamalitech.librarymanagementsystem.model.DVD;
import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

public class DVDService implements LibraryResourceOperations {

    private final Connection connection;

    public DVDService(Connection connection) {
        this.connection = connection;
    }

    public DVDService() throws SQLException {
        this.connection = DatabaseUtil.getConnection();
    }

    @Override
    public LibraryResource saveResource(LibraryResource DVD) {

        String sql = "INSERT INTO DVD (isbn, title, author,publisher,\"year\") VALUES (?, ?, ?, ?,?)";
        try {
            if (DVD.getId().isEmpty()) {
                throw new Exception("ID is empty");
            } else if (DVD.getTitle().isEmpty()) {
                throw new Exception("Title is empty");
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, DVD.getId());
            statement.setString(2, DVD.getTitle());
            statement.setString(3, DVD.getAuthor());
            statement.setString(4, DVD.getPublisher());
            statement.setInt(5, DVD.getYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            DVD.pushErrors(e.getMessage());
            System.out.println(e.getMessage());
            SQLException nextException = e.getNextException();
            while (nextException != null) {
                DVD.pushErrors(nextException.getMessage());
                nextException = nextException.getNextException();
            }
            return DVD;
        } catch (Exception e) {
            DVD.pushErrors(e.getMessage());
            return DVD;
        }

        return DVD;
    }
    public List<DVD> fetchAllDVDs (){
        List<DVD> dvds = new ArrayList<>();
        String sql = "SELECT * FROM DVD";
        try {
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Retrieving DVDs");
            while (resultSet.next()) {
                String issn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String producer = resultSet.getString("publisher");
                int year = resultSet.getInt("year");
                String dateAdded = resultSet.getString("created_at");
                boolean availability = resultSet.getBoolean("isAvailable");

                DVD dvd = new DVD(issn, title, author, producer, year, dateAdded, availability);
                System.out.println("Title: " + resultSet.getString("title"));
                dvds.add(dvd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dvds;
    }



    @Override
    public LibraryResource updateResource(LibraryResource libraryResource) {
        return null;
    }

    @Override
    public LibraryResource editResource(LibraryResource libraryResource) {
        return null;
    }

    @Override
    public void deleteResource(String resourceIdentifier) {

    }

    @Override
    public void updateAvailability(LibraryResource libraryResource, boolean availability) {

    }
}
