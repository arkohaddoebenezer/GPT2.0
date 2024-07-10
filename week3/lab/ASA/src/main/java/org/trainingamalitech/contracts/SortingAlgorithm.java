package org.trainingamalitech.contracts;

public abstract class SortingAlgorithm {
    protected long timeElapsed;
    protected String timeComplexity;
    protected String spaceComplexity;

    public abstract int[] sort(int[] arr);

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
