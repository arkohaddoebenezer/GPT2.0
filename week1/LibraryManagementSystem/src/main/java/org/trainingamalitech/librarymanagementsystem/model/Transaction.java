package org.trainingamalitech.librarymanagementsystem.model;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private String bookIsbn;
    private String patronId;
    private Date borrowDate;
    private Date returnDate;

    public Transaction() {
    }

    public Transaction(String transactionId, String bookIsbn, String patronId, Date borrowDate, Date returnDate) {
        this.transactionId = transactionId;
        this.bookIsbn = bookIsbn;
        this.patronId = patronId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Transaction [TransactionID=" + transactionId + ", BookISBN=" + bookIsbn + ", PatronID=" + patronId + ", BorrowDate=" + borrowDate + ", ReturnDate=" + returnDate + "]";
    }
}

