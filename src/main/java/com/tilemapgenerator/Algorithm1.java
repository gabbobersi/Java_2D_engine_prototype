package com.tilemapgenerator;

import com.testgioco.core.Grid;
import com.tilemapgenerator.interfaces.Algorithm;

import java.util.Arrays;
import java.util.Random;

public class Algorithm1 implements Algorithm {
    //Probabilità per la generazione di erba, muri e acqua
    private final int PROBABILITY_GRASS = 60;
    private final int PROBABILITY_WALL = 20;
    private final int PROBABILITY_WATER = 5;
    private final int[] probabilities = {PROBABILITY_GRASS, PROBABILITY_WALL, PROBABILITY_WATER};

    //Probabilità di generare muri ai bordi
    private static final int PROBABILITY_BORDER_WALL = 90;

    //Costanti per lo stato della mappa
    private final int GRASS = 0;
    private final int WALL = 1;
    private final int WATER = 2;

    private final Grid grid = new Grid();

    @Override
    public int[][] generateRandomArray (int rowNumber, int colNumber) {
        Random rnd = new Random();
        int [][] result = new int[rowNumber][colNumber];

        for (int row=0; row < rowNumber; row++){
            for (int col=0; col < rowNumber; col++){
                probabilities[0] += Math.abs(row - grid.rowNumber / 2) * 2;

                int tile = getRandomValueBasedOnProbabilities(rnd, probabilities);;

                if (isInCenter(row, col)) {
                    probabilities[1] = 5;
                }

                if (isAtBorder(row, col) && rnd.nextInt(100) < PROBABILITY_BORDER_WALL) {
                    tile = WATER;
                }

                if (isInCenter(row, col)) {
                    tile = GRASS;
                }
                result[row][col] = tile;
            }
        }
        return result;
    }

    //Genera un numero casuale basato sulle probabilità specificate
    private int getRandomValueBasedOnProbabilities(Random rnd, int[] probabilities) {
        int total = Arrays.stream(probabilities).sum();
        int randomValue = rnd.nextInt(total);

        //Assegna il valore in base alle probabilità
        if (randomValue < probabilities[0]) {
            return 0;
        } else if (randomValue < probabilities[0] + probabilities[1]) {
            return 1;
        } else {
            return 2;
        }
    }

    //Verifica se la posizione è nel centro della mappa
    private boolean isInCenter(int row, int col) {
        return row >= grid.rowNumber / 4 && row <= 3 * grid.rowNumber / 4 && col >= grid.columnNumber / 4 && col <= 3 * grid.columnNumber / 4;
    }

    //Verifica se la posizione è ai bordi della mappa
    private boolean isAtBorder(int row, int col) {
        return col == 0 || col == grid.columnNumber - 1 || row == 0 || row == grid.rowNumber - 1;
    }

}
