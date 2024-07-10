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
    public long timeElapsed;
    public String timeComplexity;
    public  String spaceComplexity;

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
        int[] sortedArray;
        switch (sortType.toLowerCase()) {

            case "heap":
                sortedArray = heapSort.sort(unsortedArray);
                this.timeElapsed = heapSort.getTimeElapsed();
                this.timeComplexity = heapSort.getTimeComplexity();
                this.spaceComplexity = heapSort.getSpaceComplexity();
                return sortedArray;
            case "merge":
                sortedArray = mergeSort.sort(unsortedArray);
                this.timeElapsed = mergeSort.getTimeElapsed();
                return sortedArray;
            case "radix":
                sortedArray = radixSort.sort(unsortedArray);
                this.timeElapsed = radixSort.getTimeElapsed();
                return sortedArray;
            case "bucket":
                sortedArray = bucketSort.sort(unsortedArray);
                this.timeElapsed = bucketSort.getTimeElapsed();
                return sortedArray;
            default:
                sortedArray = quickSort.sort(unsortedArray);
                this.timeElapsed = quickSort.getTimeElapsed();
                return sortedArray;
        }
    }
}