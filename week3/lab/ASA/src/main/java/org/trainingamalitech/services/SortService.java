package org.trainingamalitech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trainingamalitech.utils.BucketSort;
import org.trainingamalitech.utils.HeapSort;
import org.trainingamalitech.utils.MergeSort;
import org.trainingamalitech.utils.QuickSort;
import org.trainingamalitech.utils.RadixSort;

@Service
public class SortService {

    private final QuickSort quickSort;
    private final HeapSort heapSort;
    private final MergeSort mergeSort;
    private final RadixSort radixSort;
    private final BucketSort bucketSort;

    @Autowired
    public SortService(QuickSort quickSort, HeapSort heapSort, MergeSort mergeSort, RadixSort radixSort, BucketSort bucketSort) {
        this.quickSort = quickSort;
        this.heapSort = heapSort;
        this.mergeSort = mergeSort;
        this.radixSort = radixSort;
        this.bucketSort = bucketSort;
    }

    public int[] sort(int[] arr) {
        return quickSort.sort(arr);
    }

    public int[] sort(int[] unsortedArray, String sortType) {
        switch (sortType.toLowerCase()) {
            case "heap":
                return heapSort.sort(unsortedArray);
            case "merge":
                return mergeSort.sort(unsortedArray);
            case "radix":
                return radixSort.sort(unsortedArray);
            case "bucket":
                return bucketSort.sort(unsortedArray);
            default:
                return quickSort.sort(unsortedArray);
        }
    }
}