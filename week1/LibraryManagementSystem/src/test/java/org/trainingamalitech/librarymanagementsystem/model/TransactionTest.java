package org.trainingamalitech.librarymanagementsystem.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testDefaultConstructor() {
        Transaction transaction = new Transaction();
        assertEquals(0, transaction.getTransactionId());
        assertNull(transaction.getResourceID());
        assertNull(transaction.getResourceType());
        assertNull(transaction.getPatronId());
        assertNull(transaction.getBorrowDate());
        assertNull(transaction.getReturnDate());
    }

    @Test
    public void testParameterizedConstructorWithId() {
        Transaction transaction = new Transaction(1, "123", "BOOK", "456", "2024-07-23", "2024-08-23");
        assertEquals(1, transaction.getTransactionId());
        assertEquals("123", transaction.getResourceID());
        assertEquals("BOOK", transaction.getResourceType());
        assertEquals("456", transaction.getPatronId());
        assertEquals("2024-07-23", transaction.getBorrowDate());
        assertEquals("2024-08-23", transaction.getReturnDate());
    }

    @Test
    public void testParameterizedConstructorWithoutId() {
        Transaction transaction = new Transaction("124", "DVD", "457", "2024-07-24", "2024-08-24");
        assertEquals("124", transaction.getResourceID());
        assertEquals("DVD", transaction.getResourceType());
        assertEquals("457", transaction.getPatronId());
        assertEquals("2024-07-24", transaction.getBorrowDate());
        assertEquals("2024-08-24", transaction.getReturnDate());
    }

    @Test
    public void testSettersAndGetters() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(2);
        transaction.setResourceID("789");
        transaction.setPatronId("321");
        transaction.setBorrowDate("2024-07-25");
        transaction.setReturnDate("2024-08-25");

        assertEquals(2, transaction.getTransactionId());
        assertEquals("789", transaction.getResourceID());
        assertEquals("321", transaction.getPatronId());
        assertEquals("2024-07-25", transaction.getBorrowDate());
        assertEquals("2024-08-25", transaction.getReturnDate());
    }

    @Test
    public void testToString() {
        Transaction transaction = new Transaction(3, "456", "BOOK", "654", "2024-07-26", "2024-08-26");
        String expectedString = "Transaction [TransactionID=3, resourceId=456, PatronID=654, BorrowDate=2024-07-26, ReturnDate=2024-08-26]";
        assertEquals(expectedString, transaction.toString());
    }
}
