package org.trainingamalitech.librarymanagementsystem.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.trainingamalitech.librarymanagementsystem.model.Patron;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.List;

class PatronServiceTest {

    private PatronService patronService;

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

        patronService = new PatronService();
    }

    @Test
    void addPatron() throws Exception {
        Patron patron = new Patron();
        patron.setName("John Doe");
        patron.setAddress("123 Main St");
        patron.setPhoneNumber("1234567890");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        patronService.addPatron(patron);

        verify(mockPreparedStatement).setString(1, "John Doe");
        verify(mockPreparedStatement).setString(2, "123 Main St");
        verify(mockPreparedStatement).setString(3, "1234567890");
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void getAllPatrons() throws Exception {
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("id")).thenReturn("1");
        when(mockResultSet.getString("name")).thenReturn("John Doe");
        when(mockResultSet.getString("address")).thenReturn("123 Main St");
        when(mockResultSet.getString("phoneNumber")).thenReturn("1234567890");

        List<Patron> patrons = patronService.getAllPatrons();

        assertEquals(1, patrons.size());
        Patron patron = patrons.get(0);
        assertEquals("1", patron.getId());
        assertEquals("John Doe", patron.getName());
        assertEquals("123 Main St", patron.getAddress());
        assertEquals("1234567890", patron.getPhoneNumber());
    }

    @Test
    void updatePatron() throws Exception {
        Patron patron = new Patron();
        patron.setId("1");
        patron.setName("John Doe");
        patron.setAddress("123 Main St");
        patron.setPhoneNumber("1234567890");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        patronService.updatePatron(patron);

        verify(mockPreparedStatement).setString(1, "John Doe");
        verify(mockPreparedStatement).setString(2, "123 Main St");
        verify(mockPreparedStatement).setString(3, "1234567890");
        verify(mockPreparedStatement).setString(4, "1");
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void deletePatron() throws Exception {
        String patronId = "1";

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        patronService.deletePatron(patronId);

        verify(mockPreparedStatement).setString(1, patronId);
        verify(mockPreparedStatement).executeUpdate();
    }
}
