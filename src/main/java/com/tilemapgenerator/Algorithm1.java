/*
* Questo algoritmo cerca di creare una stanza, lasciando libero il centro della mappa.
* */

package com.tilemapgenerator;

import com.testgioco.utilities.GameSettings;
import com.tilemapgenerator.interfaces.Algorithm;

import java.util.Arrays;
import java.util.Random;

public class Algorithm1 implements Algorithm {
    //Probabilità per la generazione di erba, muri e acqua
    private final int PROBABILITY_GRASS = 60;
    private final int PROBABILITY_WALL = 20;
    private final int PROBABILITY_WATER = 10;
    private final int[] probabilities = {PROBABILITY_GRASS, PROBABILITY_WALL, PROBABILITY_WATER};

    //Probabilità di generare muri ai bordi
    private static final int PROBABILITY_BORDER_WALL = 90;

    //Costanti per lo stato della mappa
    private final int GRASS = 0;
    private final int WALL = 1;
    private final int WATER = 2;

    @Override
    public int[][] generateRandomArray (int rowNumber, int colNumber) {
        Random rnd = new Random();
        int [][] result = new int[rowNumber][colNumber];

        for (int row=0; row < rowNumber; row++){
            for (int col=0; col < colNumber; col++){
                // probabilities[0] += Math.abs(row - GameSettings.mapRowsNumber / 2) * 2;

                int tile = getRandomValueBasedOnProbabilities(rnd, probabilities);
//                if (isInCenter(row, col)) {
//                    probabilities[1] = 5;
//                }

                if (isAtBorder(row, col) && rnd.nextInt(100) < PROBABILITY_BORDER_WALL && tile != WATER) {
                    tile = WALL;
                }

                if (isInCenter(row, col) && tile != WATER) {
                    tile = GRASS;
                }
                result[row][col] = tile;
            }
        }
        return result;
    }

    private int getRandomValueBasedOnProbabilities(Random rnd, int[] probabilities) {
        int total = Arrays.stream(probabilities).sum();
        int randomValue = rnd.nextInt(total);

        if (randomValue < PROBABILITY_GRASS) {
            return 0;
        } else if (randomValue < (PROBABILITY_GRASS + PROBABILITY_WALL)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isInCenter(int row, int col) {
        return row >= GameSettings.mapRowsNumber / 4 && row <= 3 * GameSettings.mapRowsNumber / 4 && col >= GameSettings.mapColumnsNumber / 4 && col <= 3 * GameSettings.mapColumnsNumber / 4;
    }

    private boolean isAtBorder(int row, int col) {
        return col == 0 || col == GameSettings.mapColumnsNumber - 1 || row == 0 || row == GameSettings.mapRowsNumber - 1;
    }

}
