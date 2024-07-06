package org.trainingamalitech.utils;

import java.util.Arrays;

public class BucketSort {
    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        // Determine minimum and maximum values
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // Determine bucket size
        int bucketSize = Math.max((maxValue - minValue) / array.length + 1, 1);

        // Initialize buckets
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        // Distribute input array values into buckets
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = (array[i] - minValue) / bucketSize;
            buckets[bucketIndex] = arrayAppend(buckets[bucketIndex], array[i]);
        }

        // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            InsertionSort.insertionSort(buckets[i]);
            for (int j = 0; j < buckets[i].length; j++) {
                array[currentIndex++] = buckets[i][j];
            }
        }
        return array;
    }

    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
