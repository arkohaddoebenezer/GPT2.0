package org.trainingamalitech.utils;

import org.springframework.stereotype.Component;
import org.trainingamalitech.contracts.SortingAlgorithm;

@Component
public class MergeSort extends SortingAlgorithm {
    public MergeSort() {
        this.timeComplexity = "O(n log n)";
        this.spaceComplexity = "O(n)";
    }

    @Override
    public int[] sort(int[] arr) {
        long startTime = System.nanoTime();

        if (arr == null || arr.length == 0) {
            return arr;
        }
        mergeSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        this.timeElapsed = endTime - startTime;
        return arr;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}