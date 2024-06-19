package org.trainingamalitech.librarymanagementsystem.model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private boolean isAvailable;

    public Book() {
    }

    public Book(String isbn, String title, String author, String publisher, int year, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book [ISBN=" + isbn + ", Title=" + title + ", Author=" + author + ", Publisher=" + publisher + ", Year=" + year + ", Available=" + isAvailable + "]";
    }
}
