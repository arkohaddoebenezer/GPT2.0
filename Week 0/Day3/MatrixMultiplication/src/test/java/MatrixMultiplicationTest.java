import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplicationTest {

    @Test
    void testMatrixMultiplication() {
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixB = {{7, 8}, {9, 10}, {11, 12}};
        int[][] expected = {{58, 64}, {139, 154}};

        int[][] result = MatrixMultiplication.matrixMultiplication(matrixA, matrixB);

        assertArrayEquals(expected, result);
    }

    @Test
    void testMatrixMultiplication_IncompatibleMatrices() {
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixB = {{7, 8, 9}, {10, 11, 12}};

        assertNull(MatrixMultiplication.matrixMultiplication(matrixA, matrixB));
    }

    @Test
    void testBuildMatrix() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[][] expected = {{1, 2, 3}, {4, 5, 6}};

        int[][] result = MatrixMultiplication.buildMatrix(arr, 2, 3);

        assertArrayEquals(expected, result);
    }

}