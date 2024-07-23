package org.trainingamalitech.librarymanagementsystem.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.trainingamalitech.librarymanagementsystem.model.Reservation;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.List;

class ReservationServiceTest {

    private ReservationService reservationService;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private Statement mockStatement;

    @Mock
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Mock the DatabaseUtil.getConnection method
        when(DatabaseUtil.getConnection()).thenReturn(mockConnection);

        reservationService = new ReservationService();
    }

    @Test
    void addReservation() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setResourceId("123");
        reservation.setPatronId("456");
        reservation.setReservationDate("2024-07-22");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        reservationService.addReservation(reservation);

        verify(mockPreparedStatement).setString(1, "123");
        verify(mockPreparedStatement).setString(2, "Book");
        verify(mockPreparedStatement).setString(3, "456");
        verify(mockPreparedStatement).setString(4, "2024-07-22");
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void getAllReservations() throws Exception {
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("reservationId")).thenReturn(1);
        when(mockResultSet.getString("resourceId")).thenReturn("123");
        when(mockResultSet.getString("resourceType")).thenReturn("Book");
        when(mockResultSet.getString("patronId")).thenReturn("456");
        when(mockResultSet.getString("reservationDate")).thenReturn("2024-07-22");

        List<Reservation> reservations = reservationService.getAllReservations();

        assertEquals(1, reservations.size());
        Reservation reservation = reservations.get(0);
        assertEquals(1, reservation.getReservationId());
        assertEquals("123", reservation.getResourceId());
        assertEquals("Book", reservation.getResourceType());
        assertEquals("456", reservation.getPatronId());
        assertEquals("2024-07-22", reservation.getReservationDate());
    }

    @Test
    void deleteReservation() throws Exception {
        String reservationId = "1";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        reservationService.deleteReservation(reservationId);

        verify(mockPreparedStatement).setString(1, reservationId);
        verify(mockPreparedStatement).executeUpdate();
    }
}