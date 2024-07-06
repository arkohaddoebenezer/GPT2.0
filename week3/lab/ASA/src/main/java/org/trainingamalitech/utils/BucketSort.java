package org.trainingamalitech.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trainingamalitech.contracts.SortingAlgorithm;

import java.util.Arrays;

@Component
public class BucketSort extends SortingAlgorithm {
    private final InsertionSort insertionSort;

    @Autowired
    public BucketSort(InsertionSort insertionSort) {
        this.insertionSort = insertionSort;
        this.timeComplexity = "O(n + k)";
        this.spaceComplexity = "O(n + k)";
    }

    @Override
    public int[] sort(int[] array) {
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
        for (int k : array) {
            int bucketIndex = (k - minValue) / bucketSize;
            buckets[bucketIndex] = arrayAppend(buckets[bucketIndex], k);
        }

        int currentIndex = 0;
        for (int[] bucket : buckets) {
            insertionSort.sort(bucket);
            for (int i : bucket) {
                array[currentIndex++] = i;
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