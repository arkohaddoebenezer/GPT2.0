package org.trainingamalitech.librarymanagementsystem.services;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.sql.*;
import java.util.List;
import org.trainingamalitech.librarymanagementsystem.model.Book;

public class BookServiceTest {

    private BookService bookService;

    private Connection connection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS Book");

        statement.execute("CREATE TABLE Book (isbn VARCHAR(255) PRIMARY KEY, title VARCHAR(255), author VARCHAR(255), publisher VARCHAR(255), \"year\" INT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, isAvailable BOOLEAN DEFAULT TRUE)");

        bookService = new BookService(connection);
    }

    @Test
    public void testSaveBook() throws Exception {
        Book book = new Book("12345", "Test Title", "Test Author", "Test Publisher", 2022);

        bookService.saveResource(book);

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Book WHERE isbn = ?");
        statement.setString(1, "12345");
        ResultSet resultSet = statement.executeQuery();
        assertTrue(resultSet.next());
        assertEquals("12345", resultSet.getString("isbn"));
        assertEquals("Test Title", resultSet.getString("title"));
        assertEquals("Test Author", resultSet.getString("author"));
        assertEquals("Test Publisher", resultSet.getString("publisher"));
        assertEquals(2022, resultSet.getInt("year"));
    }

    @Test
    public void testFetchAllBooks() throws Exception {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO Book (isbn, title, author, publisher, \"year\") VALUES ('12345', 'Test Title', 'Test Author', 'Test Publisher', 2022)");
        List<Book> actualBooks = bookService.fetchAllBooks();

        assertEquals(1, actualBooks.size());
        Book book = actualBooks.get(0);
        assertEquals("12345", book.getId());
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("Test Publisher", book.getPublisher());
        assertEquals(2022, book.getYear());
    }
}
