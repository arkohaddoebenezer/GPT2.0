package org.trainingamalitech.librarymanagementsystem.model;

public class Transaction {
    private int transactionId;
    private String resourceID;
    private String resourceType;
    private String patronId;
    private String borrowDate;
    private String returnDate;

    public Transaction(int transactionId, String resourceID, String resourceType, String patronId, String borrowDate, String returnDate) {
        this.transactionId = transactionId;
        this.resourceID = resourceID;
        this.resourceType = resourceType;
        this.patronId = patronId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Transaction(){

    }
    public Transaction(String resourceID, String resourceType, String patronId, String borrowDate, String returnDate) {
        this.resourceID = resourceID;
        this.resourceType = resourceType;
        this.patronId = patronId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getResourceID() {
        return resourceID;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Transaction [TransactionID=" + transactionId + ", resourceId=" + resourceID + ", PatronID=" + patronId
                + ", BorrowDate=" + borrowDate + ", ReturnDate=" + returnDate + "]";
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
