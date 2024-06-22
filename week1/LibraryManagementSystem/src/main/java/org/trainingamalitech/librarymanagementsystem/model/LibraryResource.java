package org.trainingamalitech.librarymanagementsystem.model;

import org.trainingamalitech.librarymanagementsystem.enums.ResourceType;

import java.util.Date;
import java.util.LinkedList;

public abstract class LibraryResource {
    private final String id;
    private final String title;
    private final String author;
    private final String publisher;
    private final int year;
    private final String dateAdded;
    boolean isAvailable;
    public LinkedList<String> operationErrors = new LinkedList<>();

    protected  LibraryResource(String id, String title, String author, String publisher, int year){
        this.id =id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isAvailable = true;
        this.dateAdded = new Date().toString();

    }
    protected LibraryResource(String id, String title, String author, String publisher, int year, String dateAdded, boolean availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.dateAdded = dateAdded;
        this.isAvailable=availability;
    }

    public String getTitle() {
        if (title == null) {
            this.pushErrors("Title not set.");
            return null;
        }
        return title;
    }

    public String getAuthor() {
        if (title == null) {
            this.pushErrors("Author not set.");
            return null;
        }
        return author;
    }

    public String getId() {
        if (title == null) {
            this.pushErrors("ID not set.");
            return null;
        }
        return id;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public String getDateAdded() {
        return dateAdded;
    }
    public String getPublisher(){
        if (title == null) {
            this.pushErrors("Publisher not set.");
            return null;
        }
        return  publisher;
    }
    public  int getYear(){
        return year;
    }

    public void pushErrors(String errorMessage){
        operationErrors.add(errorMessage);
    }
    public boolean hasOperationErrors(){
        return !operationErrors.isEmpty();
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public abstract ResourceType getResourceType();
}
