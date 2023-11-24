package com.testgioco.core;

import com.testgioco.entities.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class TileManager {
    private final Cell cell = new Cell();
    private final Player player;
    private final Tile[] tiles = new Tile[10];
    private int[][] mapTileNum;

    private int mapRows;
    private int mapCols;

    public TileManager(Player player) {
        this.player = player;
        loadTileImages();
    }


    private void loadTileImages() {
        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("assets/tiles/grass_01.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("assets/tiles/wall_01.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new File("assets/tiles/water_01.png"));

            tiles[9] = new Tile();
            tiles[9].image = ImageIO.read(new File("assets/tiles/not_loaded.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    public void draw (Graphics g2) {
        for (int r = 0; r < mapRows; r++) {
            for (int c = 0; c < mapCols; c++) {
                int tileIndex = mapTileNum[r][c];

                // Tile position, to draw.
                int worldX = c * cell.width;
                int worldY = r * cell.height;

                // Tile position, to draw, taking into consideration player position.
                int screenX = worldX - player.positionOnTheMap.getX() + player.positionOnScreen.getX();
                int screenY = worldY - player.positionOnTheMap.getY() + player.positionOnScreen.getY();

                g2.drawImage(tiles[tileIndex].image,screenX, screenY, cell.width, cell.height, null);
            }
        }
    }

    /**
     * Get map rows and columns number.
     * */
    private void getMapDimension(String filePath) throws FileNotFoundException {
        mapRows = 0;
        mapCols = 0;

        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        Scanner reader = null;

        try {
            reader = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(reader.hasNext()){
            String line = reader.nextLine();
            if (mapCols == 0){
                mapCols = line.length() / 2;
            }
            mapRows++;
        }
    }

    public void loadMap (String mapPath){
        try{
            // Example path "/maps/maps01.txt"
            getMapDimension("assets/" + mapPath);
            mapTileNum = new int[mapRows][mapCols];

            InputStream stream = getClass().getResourceAsStream(mapPath);
            assert stream != null;

            InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            BufferedReader bufferReader = new BufferedReader(streamReader);

            for (int r = 0; r < mapRows; r++) {
                String line = bufferReader.readLine();
                String[] numbers = new String[mapCols];

                // If line has not been correctly read, just take a default line.
                if (line != null) {
                    numbers = line.split(" ");
                } else {
                    for (int i = 0; i < mapCols; i++){
                        numbers[i] = "9";
                    }
                }

                // Populate final array containing all the tiles in "array of int" format.
                for (int c = 0; c < mapCols; c++) {
                    int num = Integer.parseInt(numbers[c]);
                    mapTileNum[r][c] = num;
                }
            }
            bufferReader.close();
            System.out.println("TileManager - I'm using the map: " + mapPath + " that has " + mapRows + " rows and " + mapCols + " columns.");
            printTileMap(mapTileNum, mapRows);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Print a tile map
     * */
    public static void printTileMap(int [][]map, int rowsNumber){
        System.out.println("---------- Tile map dimension ----------");
        for (int r = 0; r < rowsNumber; r++){
            System.out.println(Arrays.toString(map[r]));
        }
    }

}