package com.tilemapgenerator;

import java.io.File;
import java.io.FileWriter;

public class Writer {
    public void generateTileMap(String filePath, int[][] tiles) {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int[] tile : tiles) {
                for (int col = 0; col < tiles[0].length; col++) {
                    String value = Integer.toString(tile[col]);
                    fileWriter.write(value + " ");
                }
                fileWriter.write("\n");
            }
            System.out.println("Generated and written tile map!");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
}
