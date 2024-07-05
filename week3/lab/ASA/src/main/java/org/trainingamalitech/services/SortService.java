package org.trainingamalitech.services;

import org.trainingamalitech.utils.BucketSort;
import org.trainingamalitech.utils.HeapSort;
import org.trainingamalitech.utils.MergeSort;
import org.trainingamalitech.utils.QuickSort;
import org.trainingamalitech.utils.RadixSort;

public class SortService {

    public int[] heapSort(int[] arr){
        return HeapSort.sort(arr);
    }

    public int[] mergeSort(int[] arr){
        return MergeSort.sort(arr, 0, 0);
    }

    public int[] quickSort(int[] arr){
       return QuickSort.sort(arr, 0, 0);
    }

    public int[] radixSort(int[] arr){
        return RadixSort.sort(arr);

    }

    public int[] bucketSort(int[] arr){
        return BucketSort.sort(arr, 0);
    }
}
