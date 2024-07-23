package org.trainingamalitech.librarymanagementsystem.services;

import org.trainingamalitech.librarymanagementsystem.contracts.LibraryResourceOperations;
import org.trainingamalitech.librarymanagementsystem.model.Book;
import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements LibraryResourceOperations {

    private final Connection connection;

    public BookService() throws SQLException {
        this.connection = DatabaseUtil.getConnection();
    }

    public BookService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public LibraryResource saveResource(LibraryResource book) {

        String sql = "INSERT INTO Book (isbn, title, author, publisher, \"year\") VALUES (?,?, ?,?, ?)";

        try {
            if (book.getId().isEmpty())
                throw new Exception("ISBN is empty");
            else if (book.getTitle().isEmpty())
                throw new Exception("Title is empty");

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getPublisher());
            statement.setInt(5, book.getYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            book.pushErrors(e.getMessage());
            SQLException nextException = e.getNextException();
            while (nextException != null) {
                book.pushErrors(nextException.getMessage());
                nextException = nextException.getNextException();
            }
            return book;
        } catch (Exception e) {
            book.pushErrors(e.getMessage());
        }
        return book;
    }

    @Override
    public LibraryResource updateResource(LibraryResource book) {
        String sql = "UPDATE Book SET title = ?, author = ?, publisher = ?, year = ? WHERE isbn = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setInt(4, book.getYear());
            statement.setString(5, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            book.pushErrors(e.getMessage());
            SQLException nextException = e.getNextException();
            while (nextException != null) {
                book.pushErrors(nextException.getMessage());
                nextException = nextException.getNextException();
            }
        }
        return book;
    }

    @Override
    public LibraryResource editResource(LibraryResource book) {
        String sql = "UPDATE Book SET title = COALESCE(?, title), author = COALESCE(?, author), " +
                "publisher = COALESCE(?, publisher), year = COALESCE(?, year) WHERE isbn = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle() != null ? book.getTitle() : null);
            statement.setString(2, book.getAuthor() != null ? book.getAuthor() : null);
            statement.setString(3, book.getPublisher() != null ? book.getPublisher() : null);
            statement.setInt(4, book.getYear() != 0 ? book.getYear() : null);
            statement.setString(5, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            book.pushErrors(e.getMessage());
            SQLException nextException = e.getNextException();
            while (nextException != null) {
                book.pushErrors(nextException.getMessage());
                nextException = nextException.getNextException();
            }
        }
        return book;
    }

    @Override
    public void deleteResource(String resourceIdentifier) {
        String sql = "DELETE FROM Book WHERE isbn = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resourceIdentifier);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAvailability(LibraryResource book, boolean availability) {
        String sql = "UPDATE Book SET isAvailable = ? WHERE isbn = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, availability);
            statement.setString(2, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> fetchAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book ORDER BY created_at DESC";
        try (Statement statement = connection.createStatement();
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
                Book book = new Book(isbn, title, author, publisher, year, dateAdded, availability);
                System.out.println("Title: " + resultSet.getString("title"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
