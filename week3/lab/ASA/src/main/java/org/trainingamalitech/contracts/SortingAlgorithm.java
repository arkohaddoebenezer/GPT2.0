package org.trainingamalitech.contracts;

public interface SortingAlgorithm {
    int[] sort(int[] arr);
    int[] heapSort(int[] arr);  
    int[] mergeSort(int[] arr);  
    int[] quickSort(int[] arr);
    int[] radixSort(int[] arr);
    int[] bucketSort(int[] arr);
} 
