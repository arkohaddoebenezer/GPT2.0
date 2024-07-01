public class Main {
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6 };
        InsertionSort.insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
