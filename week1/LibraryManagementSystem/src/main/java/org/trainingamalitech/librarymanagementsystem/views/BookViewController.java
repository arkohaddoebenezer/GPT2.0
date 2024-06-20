package org.trainingamalitech.librarymanagementsystem.views;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.controller.BookController;
import org.trainingamalitech.librarymanagementsystem.controller.MainController;
import org.trainingamalitech.librarymanagementsystem.model.Book;


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

        private BookController BookController;

        @FXML
        public void initialize() {
            BookController = new BookController();

            isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
            publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
            yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
            availableColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));

            loadBooks();
        }

        @FXML
        private void handleAddBook() {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String publisher = publisherField.getText();
            int year = Integer.parseInt(yearField.getText());

            Book book = new Book(isbn, title, author, publisher, year, true);
            BookController.addBook(book);

            loadBooks();
        }

        private void loadBooks() {
            bookTable.getItems().setAll(BookController.getAllBooks());
        }


}
