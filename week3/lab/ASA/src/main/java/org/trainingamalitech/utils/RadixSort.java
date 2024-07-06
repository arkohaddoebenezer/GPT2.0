package org.trainingamalitech.utils;

import org.springframework.stereotype.Component;
import org.trainingamalitech.contracts.SortingAlgorithm;

@Component
public class RadixSort extends SortingAlgorithm {

    public RadixSort() {
        this.timeComplexity = "O(nk)";
        this.spaceComplexity = "O(n + k)";
    }

    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

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
            for (int value : array) {
                int digit = value / n % 10;
                buckets[digit][bucketCounts[digit]] = value;
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