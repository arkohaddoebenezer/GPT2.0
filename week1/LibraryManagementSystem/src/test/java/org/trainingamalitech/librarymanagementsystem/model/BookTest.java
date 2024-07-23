package org.trainingamalitech.librarymanagementsystem.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.trainingamalitech.librarymanagementsystem.enums.ResourceType;

public class BookTest {

    @Test
    public void testBookConstructorWithoutDateAdded() {
        Book book = new Book("1", "Title", "Author", "Publisher", 2024);
        assertEquals("1", book.getId());
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Publisher", book.getPublisher());
        assertEquals(2024, book.getYear());
        assertFalse(book.isAvailability());
        assertNull(book.getDateAdded());
    }

    @Test
    public void testBookConstructorWithDateAdded() {
        Book book = new Book("2", "Another Title", "Another Author", "Another Publisher", 2023, "2024-07-23", true);
        assertEquals("2", book.getId());
        assertEquals("Another Title", book.getTitle());
        assertEquals("Another Author", book.getAuthor());
        assertEquals("Another Publisher", book.getPublisher());
        assertEquals(2023, book.getYear());
        assertEquals("2024-07-23", book.getDateAdded());
        assertTrue(book.isAvailability());
    }

    @Test
    public void testGetResourceType() {
        Book book = new Book("3", "Some Title", "Some Author", "Some Publisher", 2022);
        assertEquals(ResourceType.BOOK, book.getResourceType());
    }

    @Test
    public void testToString() {
        Book book = new Book("4", "Title", "Author", "Publisher", 2021, "2024-07-23", false);
        String expectedString = "Book [ISBN=4, Title=Title, Author=Author, Publisher=Publisher, Year=2021, Available=false]";
        assertEquals(expectedString, book.toString());
    }
}
