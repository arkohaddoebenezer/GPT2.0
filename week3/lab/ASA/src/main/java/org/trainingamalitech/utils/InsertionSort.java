package org.trainingamalitech.utils;

import org.springframework.stereotype.Component;
import org.trainingamalitech.contracts.SortingAlgorithm;

@Component
public class InsertionSort extends SortingAlgorithm {

    public InsertionSort() {
        this.timeComplexity = "O(n^2)";
        this.spaceComplexity = "O(1)";
    }

    @Override
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
        return arr;
    }

}