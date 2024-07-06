package org.trainingamalitech.utils;

import org.springframework.stereotype.Component;
import org.trainingamalitech.contracts.SortingAlgorithm;

@Component
public class QuickSort extends SortingAlgorithm {

    public QuickSort() {
        this.timeComplexity = "O(n log n)";
        this.spaceComplexity = "O(log n)";
    }

    @Override
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}