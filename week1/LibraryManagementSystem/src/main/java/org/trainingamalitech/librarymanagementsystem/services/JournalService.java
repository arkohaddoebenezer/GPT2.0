package org.trainingamalitech.librarymanagementsystem.services;

import org.trainingamalitech.librarymanagementsystem.contracts.LibraryResourceOperations;
import org.trainingamalitech.librarymanagementsystem.model.Book;
import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JournalService implements LibraryResourceOperations {

    @Override
    public LibraryResource saveResource(LibraryResource journal) {

        String sql = "INSERT INTO Book (isbn, title, author,created_at,isAvailable) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, journal.getId());
            statement.setString(2, journal.getTitle());
            statement.setString(3, journal.getAuthor());
            statement.setString(4,journal.getDateAdded());
            statement.setBoolean(5, journal.getAvailability());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journal;
    }

    @Override
    public LibraryResource updateResource(LibraryResource journal) {
        return null;
    }

    @Override
    public LibraryResource editResource(LibraryResource journal) {
        return null;
    }

    @Override
    public void deleteResource(String resourceIdentifier) {
        String sql = "DELETE FROM Book WHERE isbn = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resourceIdentifier);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAvailability(LibraryResource journal,boolean availability) {
        String sql = "UPDATE Book SET isAvailable = ? WHERE isbn = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, availability);
            statement.setString(2, journal.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> fetchAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Retrieving "+ books.getClass());
            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("");
                int year = resultSet.getInt("year");
                String dateAdded = resultSet.getString("created_at");
                boolean availability = resultSet.getBoolean("isAvailable");
                Book journal = new Book(isbn,title,author,publisher,year,dateAdded,availability);
                System.out.println("Title: "+resultSet.getString("title"));
                books.add(journal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }


}
