package org.trainingamalitech.librarymanagementsystem.model;

import java.sql.Date;

import javax.xml.catalog.Catalog;

import org.trainingamalitech.librarymanagementsystem.enums.ResourceType;

public class DVD extends LibraryResource{


    public DVD(String id, String title, String author, String publisher, int year) {
        super(id, title, author, publisher, year);
    }

    public DVD(String id, String title, String author, String publisher, int year, String dateAdded, boolean availability) {
        super(id, title, author, publisher, year, dateAdded, availability);
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.DVD;
    }


    @Override
    public String toString() {
        return "DVD [dvdID=" + this.getId() + ", Title=" + this.getTitle() + ", Author=" + this.getAuthor() + ", Producer=" + this.getPublisher() + ", Release Date=" + this.getYear() + ", Available=" + this.getAvailability() + "]";
    }

}
