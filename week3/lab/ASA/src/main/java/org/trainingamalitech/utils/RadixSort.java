package org.trainingamalitech.utils;

public class RadixSort {
    public static int[] sort(int[] array) {

        int[][] buckets = new int[10][array.length];
        int[] bucketCounts = new int[10];

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                int digit = array[j] / n % 10;
                buckets[digit][bucketCounts[digit]] = array[j];
                bucketCounts[digit]++;
            }

            int index = 0;
            for (int j = 0; j < buckets.length; j++) {
                if (bucketCounts[j] != 0) {
                    for (int k = 0; k < bucketCounts[j]; k++) {
                        array[index++] = buckets[j][k];
                    }
                }
                bucketCounts[j] = 0;
            }
        }
        return array;
    }
}
