package org.trainingamalitech.librarymanagementsystem.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatronTest {

    @Test
    public void testPatronDefaultConstructor() {
        Patron patron = new Patron();
        assertNull(patron.getId());
        assertNull(patron.getName());
        assertNull(patron.getAddress());
        assertNull(patron.getPhoneNumber());
    }

    @Test
    public void testPatronParameterizedConstructor() {
        Patron patron = new Patron("1", "John Doe", "123 Main St", "555-1234");
        assertEquals("1", patron.getId());
        assertEquals("John Doe", patron.getName());
        assertEquals("123 Main St", patron.getAddress());
        assertEquals("555-1234", patron.getPhoneNumber());
    }

    @Test
    public void testSettersAndGetters() {
        Patron patron = new Patron();
        patron.setId("2");
        patron.setName("Jane Smith");
        patron.setAddress("456 Elm St");
        patron.setPhoneNumber("555-5678");

        assertEquals("2", patron.getId());
        assertEquals("Jane Smith", patron.getName());
        assertEquals("456 Elm St", patron.getAddress());
        assertEquals("555-5678", patron.getPhoneNumber());
    }

    @Test
    public void testToString() {
        Patron patron = new Patron("3", "Alice Brown", "789 Oak St", "555-9876");
        String expectedString = "Patron [ID=3, Name=Alice Brown, Address=789 Oak St, PhoneNumber=555-9876]";
        assertEquals(expectedString, patron.toString());
    }
}
