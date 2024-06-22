package org.trainingamalitech.librarymanagementsystem.controller.views;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.model.Book;
import org.trainingamalitech.librarymanagementsystem.services.BookService;

import java.util.Date;

public class BookViewController {

    @FXML private TextField isbnField;
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField publisherField;
    @FXML private TextField yearField;

    @FXML private TableView<Book> bookTable;
    @FXML private TableColumn<Book, String> isbnColumn;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> publisherColumn;
    @FXML private TableColumn<Book, Integer> yearColumn;
    @FXML private TableColumn<Book, Boolean> availableColumn;

    private BookService bookService;

    @FXML
    public void initialize() {
        bookService = new BookService();

        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));

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
            Date dateAdded = new Date();

            Book book = new Book(isbn, title, author,dateAdded,publisher, year);
            bookService.saveResource(book);

            loadBooks();
        } catch (NumberFormatException e) {
            System.out.println("Error: Year must be a number");
        }
    }

    private void loadBooks() {
        bookTable.getItems().setAll(bookController.fetchAllBooks());
    }
}
