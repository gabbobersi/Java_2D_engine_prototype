package com.testgioco.core.interfaces;

public interface Algorithm {
    /**
     * Generates a random array of integers.
     * @param rowNumber number of rows of the array.
     * @param colNumber number of columns of the array.
     * @return the generated array.
     * */
    int[][] generateRandomArray(int rowNumber, int colNumber);
}
