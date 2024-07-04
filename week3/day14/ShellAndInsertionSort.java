public class ShellAndInsertionSort {

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

    public static void shellSort(int[] array) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }
        }
    }

    
}