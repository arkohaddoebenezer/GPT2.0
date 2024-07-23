package org.trainingamalitech.librarymanagementsystem.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.model.Book;
import org.trainingamalitech.librarymanagementsystem.model.LibraryResource;
import org.trainingamalitech.librarymanagementsystem.model.Transaction;
import org.trainingamalitech.librarymanagementsystem.services.BookService;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.SQLException;
import java.util.List;

public class BookViewController {
    @FXML
    private TextField isbnField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField publisherField;
    @FXML
    private TextField yearField;

    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> isbnColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, Integer> yearColumn;
    @FXML
    private TableColumn<Book, String> dateAddedColumn;
    @FXML
    private TableColumn<Book, Boolean> isAvailableColumn;

    private BookService bookService;

    @FXML
    public void initialize() throws SQLException {
        bookService = new BookService();
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        dateAddedColumn.setCellValueFactory(new PropertyValueFactory<>("created_at"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));

        loadBooks();
    }

    @FXML
    private void handleAddBook() {
        try {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String publisher = publisherField.getText();
            int year = Integer.parseInt(yearField.getText());
            LibraryResource book = bookService.saveResource(new Book(isbn, title, author, publisher, year));
            if (book.hasOperationErrors()) {
                for (String errorMessage : book.operationErrors) {
                    if (errorMessage.contains("isbn")||errorMessage.contains("book.PRIMARY"))
                        isbnField.setText("ISBN Already exist or cannot be blank");
                    else if (errorMessage.contains("Title"))
                        titleField.setText(errorMessage);
                    else if (errorMessage.contains("author"))
                        authorField.setText(errorMessage);
                    else if (errorMessage.contains("publisher"))
                        publisherField.setText(errorMessage);
                    else
                        yearField.setText(errorMessage);
                }
            } else {
                loadBooks();
            }
        } catch (Exception e) {
            if (e.getClass() == NumberFormatException.class) {
                yearField.setText("Wrong input for the year");
            }
        }
    }

    @FXML
    private void handleUpdateBook() {
        try {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String publisher = publisherField.getText();
            int year = Integer.parseInt(yearField.getText());
            LibraryResource book = bookService.updateResource(new Book(isbn, title, author, publisher, year));
            if (book.hasOperationErrors()) {
                for (String errorMessage : book.operationErrors) {
                    if (errorMessage.contains("isbn")||errorMessage.contains("book.PRIMARY"))
                        isbnField.setText("ISBN Already exist in library or cannot be blank");
                    else if (errorMessage.contains("title"))
                        titleField.setText(errorMessage);
                    else if (errorMessage.contains("author"))
                        authorField.setText(errorMessage);
                    else if (errorMessage.contains("publisher"))
                        publisherField.setText(errorMessage);
                    else
                        yearField.setText(errorMessage);
                }
                List<Transaction> transactionHistory = book.transactionHistory();
                for ( Transaction transaction: transactionHistory){
                    System.out.println(transaction.toString());
                }
                List<Transaction> reservationHistory = book.transactionHistory();
                for ( Transaction reservation: reservationHistory){
                    System.out.println(reservation.toString());
                }
            } else {
                loadBooks();
            }
        } catch (Exception e) {
            if (e.getClass() == NumberFormatException.class) {
                yearField.setText("Wrong input for the year");
            }
        }
    }

    @FXML
    private void handleRemoveBook() {
        try {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            if (!isbn.isEmpty())
                bookService.deleteResource(isbn);
            else if (!title.isEmpty())
                bookService.deleteResource(title);
            loadBooks();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadBooks() {
        bookTable.getItems().setAll(bookService.fetchAllBooks());
    }
}
