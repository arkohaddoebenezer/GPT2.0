package org.trainingamalitech.librarymanagementsystem.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {

    @Test
    public void testDefaultConstructor() {
        Reservation reservation = new Reservation();
        assertEquals(0, reservation.getReservationId());
        assertNull(reservation.getResourceId());
        assertNull(reservation.getResourceType());
        assertNull(reservation.getPatronId());
        assertNull(reservation.getReservationDate());
    }

    @Test
    public void testParameterizedConstructorWithId() {
        Reservation reservation = new Reservation(1, "123", "BOOK", "456", "2024-07-23");
        assertEquals(1, reservation.getReservationId());
        assertEquals("123", reservation.getResourceId());
        assertEquals("BOOK", reservation.getResourceType());
        assertEquals("456", reservation.getPatronId());
        assertEquals("2024-07-23", reservation.getReservationDate());
    }

    @Test
    public void testParameterizedConstructorWithoutId() {
        Reservation reservation = new Reservation("123", "BOOK", "456", "2024-07-23");
        assertEquals("123", reservation.getResourceId());
        assertEquals("BOOK", reservation.getResourceType());
        assertEquals("456", reservation.getPatronId());
        assertEquals("2024-07-23", reservation.getReservationDate());
    }

    @Test
    public void testSettersAndGetters() {
        Reservation reservation = new Reservation();
        reservation.setReservationId(2);
        reservation.setResourceId("789");
        reservation.setPatronId("321");
        reservation.setReservationDate("2024-07-24");

        assertEquals(2, reservation.getReservationId());
        assertEquals("789", reservation.getResourceId());
        assertEquals("321", reservation.getPatronId());
        assertEquals("2024-07-24", reservation.getReservationDate());
    }

    @Test
    public void testToString() {
        Reservation reservation = new Reservation(3, "456", "MAGAZINE", "654", "2024-07-25");
        String expectedString = "Reservation [ReservationID=3, resourceId=456, PatronID=654, ReservationDate=2024-07-25]";
        assertEquals(expectedString, reservation.toString());
    }
}