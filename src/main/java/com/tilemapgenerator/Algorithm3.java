/*
 * Questo algoritmo crea una mappa a righe di acqua e terra.
 * */

package com.tilemapgenerator;

import com.testgioco.core.interfaces.Algorithm;

public class Algorithm3 implements Algorithm {
    @Override
    public int[][] generateRandomArray(int rowNumber, int colNumber) {
        int[][] randomArray = new int[rowNumber][colNumber];
        for (int r = 0; r < rowNumber; r++) {
            for (int c = 0; c < colNumber; c++) {
                int tile = 0;
                if (c % 2 == 0) tile = 2;
                randomArray[r][c] = tile;
            }
        } return randomArray;
    }
}
