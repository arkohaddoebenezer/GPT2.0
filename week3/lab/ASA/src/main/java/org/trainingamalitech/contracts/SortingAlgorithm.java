package org.trainingamalitech.contracts;

public abstract class SortingAlgorithm {
    long timeElapsed;
    protected String timeComplexity;
    protected String spaceComplexity;

    public abstract int[] sort(int[] arr);

    public int[] timedSort(int[] arr) {
        long startTime = System.nanoTime();
        int[] sortedArray = sort(arr);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        return sortedArray;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public String getTimeComplexity() {
        return timeComplexity;
    }

    public String getSpaceComplexity() {
        return spaceComplexity;
    }
}
