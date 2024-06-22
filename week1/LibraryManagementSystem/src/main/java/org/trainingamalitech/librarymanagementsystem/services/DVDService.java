package org.trainingamalitech.librarymanagementsystem.services;

import org.trainingamalitech.librarymanagementsystem.contracts.LibraryResourceOperations;
import org.trainingamalitech.librarymanagementsystem.model.DVD;
import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DVDService implements LibraryResourceOperations {
   
    @Override
    public LibraryResource saveResource(LibraryResource DVD) {
        
        String sql = "INSERT INTO DVD (isbn, title, author,date_added,isAvailable) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, DVD.getId());
            statement.setString(2, DVD.getTitle());
            statement.setString(3, DVD.getAuthor());
            statement.setString(4,DVD.getDateAdded());
            statement.setBoolean(5, DVD.getAvailability());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DVD;
    }

    @Override
    public LibraryResource updateResource(LibraryResource DVD) {
        return null;
    }

    @Override
    public LibraryResource editResource(LibraryResource DVD) {
        return null;
    }

    @Override
    public void deleteResource(String resourceIdentifier) {
        String sql = "DELETE FROM DVD WHERE isbn = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resourceIdentifier);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAvailability(LibraryResource DVD,boolean availability) {
        String sql = "UPDATE DVD SET isAvailable = ? WHERE isbn = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, availability);
            statement.setString(2, DVD.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DVD> fetchAllBooks() {
        List<DVD> books = new ArrayList<>();
        String sql = "SELECT * FROM DVD";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Retrieving DVDs");
            while (resultSet.next()) {
                String issn = resultSet.getString("issn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String producer = resultSet.getString("producer");
                int year = resultSet.getInt("year");
                String dateAdded = resultSet.getString("date_added");
                boolean availability = resultSet.getBoolean("isAvailable");
                
                DVD DVD = new DVD(issn,title,author,producer,year,dateAdded,availability);
                System.out.println("Title: "+resultSet.getString("title"));
                books.add(DVD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
    
   
}
