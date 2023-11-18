package com.tilemapgenerator;

import com.testgioco.core.Grid;

import java.io.File;
import java.io.FileWriter;

public class Writer {
    private final Grid grid = new Grid();
    private boolean available = true;

    public boolean isAvailable(){
        return available;
    }

    public void generateTileMap(String filePath, int[][] tiles) {
        available = false;
        File file = new File(filePath);

        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int row = 0; row < grid.rowNumber; row++) {
                for (int col = 0; col < grid.columnNumber; col++) {
                    String value = Integer.toString(tiles[row][col]);
                    fileWriter.write(value + " ");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
            available = true;
            System.out.println("Generated and written tile map!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
