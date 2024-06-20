package org.trainingamalitech.librarymanagementsystem.controller.views;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.controller.TransactionController;
import org.trainingamalitech.librarymanagementsystem.model.Transaction;

import java.sql.Date;

public class TransactionViewController {

    @FXML private TextField transactionIdField;
    @FXML private TextField bookIsbnField;
    @FXML private TextField patronIdField;
    @FXML private TextField borrowDateField;
    @FXML private TextField returnDateField;

    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> transactionIdColumn;
    @FXML private TableColumn<Transaction, String> bookIsbnColumn;
    @FXML private TableColumn<Transaction, String> patronIdColumn;
    @FXML private TableColumn<Transaction, Date> borrowDateColumn;
    @FXML private TableColumn<Transaction, Date> returnDateColumn;

    private TransactionController transactionController;

    @FXML
    public void initialize() {
        transactionController = new TransactionController();

        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        bookIsbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookIsbn"));
        patronIdColumn.setCellValueFactory(new PropertyValueFactory<>("patronId"));
        borrowDateColumn.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        loadTransactions();
    }

    @FXML
    private void handleAddTransaction() {
        String transactionId = transactionIdField.getText();
        String bookIsbn = bookIsbnField.getText();
        String patronId = patronIdField.getText();
        Date borrowDate = Date.valueOf(borrowDateField.getText());
        Date returnDate = returnDateField.getText().isEmpty() ? null : Date.valueOf(returnDateField.getText());

        Transaction transaction = new Transaction(transactionId, bookIsbn, patronId, borrowDate, returnDate);
        transactionController.addTransaction(transaction);

        loadTransactions();
    }

    private void loadTransactions() {
        transactionTable.getItems().setAll(transactionController.getAllTransactions());
    }
}
