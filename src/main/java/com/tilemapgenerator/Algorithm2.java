/*
 * Questo algoritmo crea una mappa completamente random.
 * */

package com.tilemapgenerator;

import com.tilemapgenerator.interfaces.Algorithm;

import java.util.Random;

public class Algorithm2 implements Algorithm {
    @Override
    public int[][] generateRandomArray(int rowNumber, int colNumber) {
        int [][]randomArray = new int[rowNumber][colNumber];
        for (int r = 0; r < rowNumber; r++){
            for (int c = 0; c < colNumber; c++){
                Random rand = new Random();
                randomArray[r][c] = rand.nextInt(0, 3);
            }
        }
        return randomArray;
    }
}
