import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Author: Ebenezer Arkoh-Addo
public class PeakColumns {

    public static void main(String[] args) {
        int[] getValuesForMatrix = getValuesForMatrix();
        int[][] matrix = buildMatrix(getValuesForMatrix, getValuesForMatrix[getValuesForMatrix.length - 2],
                getValuesForMatrix.length - 1);
        findPeakColumns(matrix);
    }

    /**
     * Finds the peak columns in a given matrix.
     * A peak column is defined as a column where the element in that column is the
     * maximum in its row
     * and the minimum in its column.
     *
     * @param matrix the matrix to search for peak columns
     */
    public static void findPeakColumns(int[][] matrix) {
        List<String> peakColumns = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int element = matrix[i][j];
                if (isMaxInRow(matrix, i, element) && isMinInColumn(matrix, j, element)) {
                    peakColumns.add(String.format("Position: (%d, %d), Value: %d", i, j, element));
                }
            }
        }

        if (peakColumns.isEmpty()) {
            System.out.println("No peak-columns found.");
        } else {
            peakColumns.forEach(System.out::println);
        }
    }

    /**
     * Checks if the given element is the maximum value in the specified row of the
     * matrix.
     *
     * @param matrix  the matrix to check
     * @param row     the row index
     * @param element the element to compare
     * @return true if the element is the maximum value in the row, false otherwise
     */
    public static boolean isMaxInRow(int[][] matrix, int row, int element) {
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] > element) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the given element is the minimum value in the specified column of
     * the matrix.
     *
     * @param matrix  the matrix to check
     * @param column  the column index to check
     * @param element the element to compare with
     * @return true if the element is the minimum value in the column, false
     *         otherwise
     */
    public static boolean isMinInColumn(int[][] matrix, int column, int element) {
        for (int[] row : matrix) {
            if (row[column] < element) {
                return false;
            }
        }
        return true;
    }

    public static int[][] buildMatrix(int[] arr, int row, int col) {

        int[][] matrix = new int[row][col];

        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = arr[index];
                index++;
            }
        }
        return matrix;
    }

    /**
     * Reads user input to get the dimensions and values for a matrix.
     * 
     * @return an array of integers representing the matrix values, The last 2
     *         values of the array represent the dimensions
     */
    public static int[] getValuesForMatrix() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the dimensions of your matrix separated by a (,): ");
                String[] dimensions = sc.nextLine().split(",");
                if (dimensions.length != 2) {
                    throw new Exception("This application handles only two dimensional matrix");
                }
                System.out.println(Arrays.toString(dimensions));
                int row = Integer.parseInt(dimensions[0]);
                int column = Integer.parseInt(dimensions[1]);

                StringBuilder userInput = new StringBuilder();
                for (int i = 0; i < row; i++) {
                    System.out.println("Enter values for row " + (i + 1) + " separated by a (,):");
                    String matrixInputs = sc.nextLine();
                    if (!(matrixInputs.split(",").length == row)) {
                        throw new Exception("The dimensions of your matrix requires " + row + " numbers per row");
                    }
                    userInput.append(matrixInputs).append(",");
                }
                userInput.append(row).append(",").append(column);
                String[] stringArray = userInput.toString().split(",");
                int[] intArray = new int[stringArray.length];

                for (int i = 0; i < stringArray.length; i++) {
                    intArray[i] = Integer.parseInt(stringArray[i]);
                }
                return intArray;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}