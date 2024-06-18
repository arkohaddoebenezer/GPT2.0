import java.util.Arrays;
import java.util.Scanner;

//Author: Ebenezer Arkoh-Addo
public class MatrixMultiplication {
    public static void main(String[] args) {

        System.out.println("Lets get your first matrix...");
        int[] userInput = getValuesForMatrix();

        int[][] firstMatrix = buildMatrix(userInput, userInput[userInput.length - 2], userInput[userInput.length - 1]);

        System.out.println("Lets get your second matrix...");
        userInput = getValuesForMatrix();

        int[][] secondMatrix = buildMatrix(userInput, userInput[userInput.length - 2], userInput[userInput.length - 1]);

        int[][] outPut = matrixMultiplication(firstMatrix, secondMatrix);

        for (int i = 0; i < firstMatrix.length; i++) {
            System.out.print(" Matrix A  \n");
            printMatrix(firstMatrix);
            System.out.println("\n  multiplied by  ");
            System.out.println("\n Matrix B ");
            printMatrix(secondMatrix);
            System.out.println("\n  the product is  ");
            if (outPut!=null)
                printMatrix(outPut);
            else
                System.out.println("A matrix can be multiplied by any other matrix if it has the same number of rows as the  columns of the first");
        }
    }

    /**
     * Prints the elements of a matrix.
     *
     * @param matrix The matrix to be printed.
     */
    public static void printMatrix(int[][] matrix){
        for (int[] rows : matrix) {
            System.out.print("| ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(rows[j] + " ");
            }
            System.out.println("|");
        }
    }

    /**
     * Performs matrix multiplication on two matrices.
     *
     * @param matrixA the first matrix
     * @param matrixB the second matrix
     * @return the result of matrix multiplication as a new matrix
     */
    public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB) {

        if (matrixA[0].length != matrixB.length) {
            System.out.println("The matrices you provided are not compatible for multiplication");
            return null;
        }

        int[][] result = new int[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrixB.length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Builds a matrix from a given array of integers.
     *
     * @param arr The array of integers to build the matrix from.
     * @param row The number of rows in the matrix.
     * @param col The number of columns in the matrix.
     * @return The matrix built from the given array.
     */
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
     * @return an array of integers representing the matrix values, The last 2 values of the array represent the dimensions
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
                    if(!(matrixInputs.split(",").length==row)){
                        throw  new Exception("The dimensions of your matrix requires "+row+" numbers per row");
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