import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PeakColumnsTest {

    @Test
    void testFindPeakColumns() {
        int[][] matrix = {
            {12, 2, 4},
            {17, 10, 1},
            {92, 80, 79}
        };
        String[] expected = {
            "Position: (0, 0), Value: 12"
        };

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        PeakColumns.findPeakColumns(matrix);

        String[] output = outputStream.toString().trim().split("\\r?\\n");
        assertArrayEquals(expected, output);
    }

    @Test
    void testFindPeakColumns_NoPeakColumns() {
        int[][] matrix = {
            {4, 2, 3},
            {1, 5, 6},
            {7, 8, 9}
        };

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        PeakColumns.findPeakColumns(matrix);

        String output = outputStream.toString().trim();
        assertEquals("No peak-columns found.", output);
    }

    @Test
    void testIsMaxInRow() {
        int[][] matrix = {
            {12, 2, 4},
            {17, 10, 1},
            {92, 80, 79}
        };

        assertTrue(PeakColumns.isMaxInRow(matrix, 0, 12));
        assertFalse(PeakColumns.isMaxInRow(matrix, 1, 10));
        assertTrue(PeakColumns.isMaxInRow(matrix, 2, 92));
    }

    @Test
    void testIsMinInColumn() {
        int[][] matrix = {
            {12, 2, 4},
            {17, 10, 1},
            {92, 80, 79}
        };

        assertTrue(PeakColumns.isMinInColumn(matrix, 1, 2));
        assertFalse(PeakColumns.isMinInColumn(matrix, 2, 4));
    }


}