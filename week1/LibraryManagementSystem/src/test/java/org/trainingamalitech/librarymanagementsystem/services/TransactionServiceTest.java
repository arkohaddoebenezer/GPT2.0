package org.trainingamalitech.librarymanagementsystem.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.trainingamalitech.librarymanagementsystem.model.Transaction;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

class TransactionServiceTest {

    private TransactionService transactionService;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private Statement mockStatement;

    @Mock
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Mock the DatabaseUtil.getConnection method
        when(DatabaseUtil.getConnection()).thenReturn(mockConnection);

        transactionService = new TransactionService();
    }

    @Test
    void addTransaction() throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setResourceID("123");
        transaction.setPatronId("456");
        transaction.setBorrowDate("2024-07-22");
        transaction.setReturnDate("2024-08-22");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        transactionService.addTransaction(transaction);

        verify(mockPreparedStatement).setInt(1, 1);
        verify(mockPreparedStatement).setString(2, "123");
        verify(mockPreparedStatement).setString(3, "Book");
        verify(mockPreparedStatement).setString(4, "456");
        verify(mockPreparedStatement).setString(5, "2024-07-22");
        verify(mockPreparedStatement).setString(6, "2024-08-22");
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void getAllTransactions() throws Exception {
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("transactionId")).thenReturn(1);
        when(mockResultSet.getString("resourceId")).thenReturn("123");
        when(mockResultSet.getString("resourceType")).thenReturn("Book");
        when(mockResultSet.getString("patronId")).thenReturn("456");
        when(mockResultSet.getString("borrowDate")).thenReturn("2024-07-22");
        when(mockResultSet.getString("returnDate")).thenReturn("2024-08-22");

        List<Transaction> transactions = transactionService.getAllTransactions();

        assertEquals(1, transactions.size());
        Transaction transaction = transactions.get(0);
        assertEquals(1, transaction.getTransactionId());
        assertEquals("123", transaction.getResourceID());
        assertEquals("Book", transaction.getResourceType());
        assertEquals("456", transaction.getPatronId());
        assertEquals("2024-07-22", transaction.getBorrowDate());
        assertEquals("2024-08-22", transaction.getReturnDate());
    }

    @Test
    void updateTransactionReturnDate() throws Exception {
        String transactionId = "1";
        java.util.Date returnDate = new java.util.Date();

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        transactionService.updateTransactionReturnDate(transactionId, (Date) returnDate);

        verify(mockPreparedStatement).setDate(1, new java.sql.Date(returnDate.getTime()));
        verify(mockPreparedStatement).setString(2, transactionId);
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void deleteTransaction() throws Exception {
        String transactionId = "1";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        transactionService.deleteTransaction(transactionId);

        verify(mockPreparedStatement).setString(1, transactionId);
        verify(mockPreparedStatement).executeUpdate();
    }
}