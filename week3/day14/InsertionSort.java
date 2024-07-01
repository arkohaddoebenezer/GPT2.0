public class InsertionSort {

//     ALGORITHM insertionSort(array)
// BEGIN
//     FOR i = 1 to length(array) - 1 DO
//         key = array[i]
//         j = i - 1
//         WHILE j >= 0 AND array[j] > key DO
//             array[j + 1] = array[j]
//             j = j - 1
//         END WHILE
//         array[j + 1] = key
//     END FOR
// END

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    
}