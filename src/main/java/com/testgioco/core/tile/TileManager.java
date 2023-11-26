package com.testgioco.core.tile;

import com.testgioco.core.Cell;
import com.testgioco.core.tile.Tile;
import com.testgioco.entities.Player;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TileManager {
    private final Cell cell = new Cell();
    private final Player player;
    private final Map<String, Tile> tiles = new HashMap<>();
    private int[][] mapTileNum;

    private int mapRows;
    private int mapCols;



    public TileManager(Player player) {
        this.player = player;
        loadTileImages();
    }


    private void loadTileImages() {
        String[] tileNames = {
                TilesName.grass_01.name(),
                TilesName.wall_01.name(),
                TilesName.water_01.name(),
                TilesName.not_loaded.name()
        };

        for (String name : tileNames) {
            try {
                tiles.put(name, new Tile(ImageIO.read(new File("assets/tiles/" + name + ".png")), false));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Tile getTileByIndex(int index){
        return switch (index) {
            case 0 -> tiles.get(TilesName.grass_01.name());
            case 1 -> tiles.get(TilesName.wall_01.name());
            case 2 -> tiles.get(TilesName.water_01.name());
            default -> tiles.get(TilesName.not_loaded.name());
        };
    }

    public Tile getTileByName(String name){
        Tile tile = tiles.get(name);

        if (tile == null){
            return tiles.get(TilesName.not_loaded.name());
        }
        return tile;
    }

    public int[][] getTileMap(){
        return mapTileNum;
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

                g2.drawImage(getTileByIndex(tileIndex).getImage(),screenX, screenY, cell.width, cell.height, null);
            }
        }
    }

    /**
     * Get map rows and columns number by reading the tilemap (.txt file).
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
        reader.close();
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
            streamReader.close();
            stream.close();

            System.out.println("TileManager - I'm using the map: " + mapPath + " that has " + mapRows + " rows and " + mapCols + " columns.");
            printTileMap(mapTileNum, mapRows);
            updateSettings();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Adjust global map's informations
     * */
    private void updateSettings() {
        GameSettings.mapRowsNumber = mapRows;
        GameSettings.mapColumnsNumber = mapCols;
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