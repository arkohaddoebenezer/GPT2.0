package org.trainingamalitech.librarymanagementsystem.services;

import org.trainingamalitech.librarymanagementsystem.contracts.LibraryResourceOperations;
import org.trainingamalitech.librarymanagementsystem.model.Book;
import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements LibraryResourceOperations {

    @Override
    public LibraryResource saveResource(LibraryResource book) {

        String sql = "INSERT INTO Book (isbn, title, author,date_added,isAvailable) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setDate(4,(java.sql.Date)book.getDateAdded());
            statement.setBoolean(5, book.getAvailability());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public LibraryResource updateResource(LibraryResource book) {
        return null;
    }

    @Override
    public LibraryResource editResource(LibraryResource book) {
        return null;
    }

    @Override
    public void deleteResource(LibraryResource book) {
        String sql = "DELETE FROM Book WHERE isbn = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAvailability(LibraryResource book,boolean availability) {
        String sql = "UPDATE Book SET isAvailable = ? WHERE isbn = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, availability);
            statement.setString(2, book.getId());

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
                Date dateAdded = resultSet.getDate("date_added");
                boolean availability = resultSet.getBoolean("isAvailable");
                Book book = new Book(isbn,title,author,dateAdded,availability);
                System.out.println("Title: "+resultSet.getString("title"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }


}
