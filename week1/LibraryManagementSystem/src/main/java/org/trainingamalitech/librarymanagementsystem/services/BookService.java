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

        String sql = "INSERT INTO Book (isbn, title, author,publisher,year) VALUES (?, ?, ?, ?,?,?)";

        try {
            Connection connection = DatabaseUtil.getConnection();
             if (book.getId().isEmpty())
                 throw new Exception("isbn is empty");
             else if(book.getTitle().isEmpty())
                 throw new Exception("Title is empty");

             PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getPublisher());
            statement.setInt(5,book.getYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            book.pushErrors(e.getMessage());
            SQLException nextException = e.getNextException();
            while (nextException != null) {
                book.pushErrors(nextException.getMessage());
                nextException = nextException.getNextException();
            }
            return  book;
        }catch (Exception e) {
            book.pushErrors(e.getMessage());
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
    public void deleteResource(String resourceIdentifier) {
        String sql = "DELETE FROM Book WHERE isbn = ? OR title = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resourceIdentifier);
            statement.setString(2, resourceIdentifier);
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
            System.out.println("Retrieving Books");
            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String dateAdded = resultSet.getString("created_at");
                String publisher = resultSet.getString("publisher");
                int year = resultSet.getInt("year");
                boolean availability = resultSet.getBoolean("isAvailable");
                Book book = new Book(isbn,title,author,publisher,year,dateAdded,availability);
                System.out.println("Title: "+resultSet.getString("title"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }


}
