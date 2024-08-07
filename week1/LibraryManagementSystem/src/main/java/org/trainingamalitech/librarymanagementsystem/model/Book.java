package org.trainingamalitech.librarymanagementsystem.model;

import org.trainingamalitech.librarymanagementsystem.enums.ResourceType;

public class Book extends LibraryResource{

    public Book(String id, String title, String author, String publisher, int year){
        super(id,title,author,publisher,year);

    }
    public Book(String id, String title, String author, String publisher, int year, String dateAdded,boolean availability) {
        super(id, title, author, publisher, year, dateAdded,availability);
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.BOOK;
    }

    @Override
    public String toString() {
        return "Book [ISBN=" + this.getId() + ", Title=" + this.getTitle() + ", Author=" + this.getAuthor() + ", Publisher=" + this.getPublisher() + ", Year=" + this.getYear() + ", Available=" + this.getAvailability() + "]";
    }

    public boolean isAvailability() {
        return this.isAvailable;
    }
}
