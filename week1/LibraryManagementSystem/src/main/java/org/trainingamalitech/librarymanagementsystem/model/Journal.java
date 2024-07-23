package org.trainingamalitech.librarymanagementsystem.model;

import org.trainingamalitech.librarymanagementsystem.enums.ResourceType;

import java.util.Date;

public class Journal extends LibraryResource {


    protected Journal(String id, String title, String author, String publisher, int year) {
        super(id, title, author, publisher, year);
    }

    public Journal(String id, String title, String author, String publisher, int year, String dateAdded, boolean availability) {
        super(id, title, author, publisher, year, dateAdded, availability);
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.JOURNAL;
    }

}
