package org.trainingamalitech.librarymanagementsystem.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.trainingamalitech.librarymanagementsystem.model.DVD;

class DVDServiceTest {

    private DVDService dvdService;

    private Connection connection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS DVD");
        statement.execute("CREATE TABLE DVD (isbn VARCHAR(255) PRIMARY KEY, title VARCHAR(255), author VARCHAR(255), publisher VARCHAR(255), \"year\" INT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, isAvailable BOOLEAN DEFAULT TRUE)");

        dvdService = new DVDService(connection);
    }

    @Test
    void saveResource() throws Exception {
        DVD dvd = new DVD("54321", "Test Title", "Test Director", "Test Producer", 2022);

        dvdService.saveResource(dvd);

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM DVD WHERE isbn = ?");
        statement.setString(1, "54321");
        ResultSet resultSet = statement.executeQuery();
        assertTrue(resultSet.next());
        assertEquals("54321", resultSet.getString("isbn"));
        assertEquals("Test Title", resultSet.getString("title"));
        assertEquals("Test Director", resultSet.getString("author"));
        assertEquals("Test Producer", resultSet.getString("publisher"));
        assertEquals(2022, resultSet.getInt("year"));
    }

    @Test
    void fetchAllDVDs() throws Exception {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO DVD (isbn, title, author, publisher, \"year\") VALUES ('54321', 'Test Title', 'Test Director', 'Test Producer', 2022)");

        List<DVD> actualDVDs = dvdService.fetchAllDVDs();

        assertEquals(1, actualDVDs.size());
        DVD dvd = actualDVDs.get(0);
        assertEquals("54321", dvd.getId());
        assertEquals("Test Title", dvd.getTitle());
        assertEquals("Test Director", dvd.getAuthor());
        assertEquals("Test Producer", dvd.getPublisher());
        assertEquals(2022, dvd.getYear());
    }
}
