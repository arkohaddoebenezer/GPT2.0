package org.trainingamalitech.librarymanagementsystem.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.services.TransactionService;
import org.trainingamalitech.librarymanagementsystem.model.Transaction;

import java.sql.Date;

public class TransactionViewController {

    @FXML private TextField transactionIdField;
    @FXML private TextField resourceIdField;
    @FXML private TextField resourceTypeField;
    @FXML private TextField patronIdField;
    @FXML private TextField borrowDateField;
    @FXML private TextField returnDateField;

    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> transactionIdColumn;
    @FXML private TableColumn<Transaction, String> resourceIdColumn;
    @FXML private TableColumn<Transaction, String> resourceTypeColumn;
    @FXML private TableColumn<Transaction, String> patronIdColumn;
    @FXML private TableColumn<Transaction, Date> borrowDateColumn;
    @FXML private TableColumn<Transaction, Date> returnDateColumn;

    private TransactionService transactionService;

    @FXML
    public void initialize() {
        transactionService = new TransactionService();
        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        resourceIdColumn.setCellValueFactory(new PropertyValueFactory<>("resourceId"));
        resourceTypeColumn.setCellValueFactory(new PropertyValueFactory<>("resourceType"));
        patronIdColumn.setCellValueFactory(new PropertyValueFactory<>("patronId"));
        borrowDateColumn.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        loadTransactions();
    }

    @FXML
    private void handleAddTransaction() {
        String resourceId = resourceIdField.getText();
        String resourceType = resourceTypeField.getText();
        String patronId = patronIdField.getText();
        String borrowDate = borrowDateField.getText();
        String returnDate = returnDateField.getText();
        Transaction transaction = new Transaction(resourceId,resourceType, patronId, borrowDate, returnDate);
        transactionService.addTransaction(transaction);
        loadTransactions();
    }

    private void loadTransactions() {
        transactionTable.getItems().setAll(transactionService.getAllTransactions());
    }
}
