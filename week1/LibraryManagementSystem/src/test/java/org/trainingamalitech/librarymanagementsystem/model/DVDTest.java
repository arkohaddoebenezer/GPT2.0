package org.trainingamalitech.librarymanagementsystem.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.trainingamalitech.librarymanagementsystem.enums.ResourceType;

public class DVDTest {

    @Test
    public void testDVDConstructorWithoutDateAdded() {
        DVD dvd = new DVD("1", "Title", "Author", "Producer", 2024);
        assertEquals("1", dvd.getId());
        assertEquals("Title", dvd.getTitle());
        assertEquals("Author", dvd.getAuthor());
        assertEquals("Producer", dvd.getPublisher());
        assertEquals(2024, dvd.getYear());
    }

    @Test
    public void testDVDConstructorWithDateAdded() {
        DVD dvd = new DVD("2", "Another Title", "Another Author", "Another Producer", 2023, "2024-07-23", true);
        assertEquals("2", dvd.getId());
        assertEquals("Another Title", dvd.getTitle());
        assertEquals("Another Author", dvd.getAuthor());
        assertEquals("Another Producer", dvd.getPublisher());
        assertEquals(2023, dvd.getYear());
        assertEquals("2024-07-23", dvd.getDateAdded());
    }

    @Test
    public void testGetResourceType() {
        DVD dvd = new DVD("3", "Some Title", "Some Author", "Some Producer", 2022);
        assertEquals(ResourceType.DVD, dvd.getResourceType());
    }

    @Test
    public void testToString() {
        DVD dvd = new DVD("4", "Title", "Author", "Producer", 2021, "2024-07-23", false);
        String expectedString = "DVD [dvdID=4, Title=Title, Author=Author, Producer=Producer, Release Date=2021, Available=false]";
        assertEquals(expectedString, dvd.toString());
    }
}
