package com.testgioco.core.tile;

import com.testgioco.core.Cell;
import com.testgioco.core.Vector2DInt;
import com.testgioco.entities.Player;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    private static int[][] mapTileNum;

    private int mapRows;
    private int mapCols;

    public TileManager(Player player) {
        this.player = player;
        reset();
    }

    private void loadTileImages() {
        try {
            String name;

            name = TilesName.grass_01.name();
            tiles.put(name, new Tile(name, ImageIO.read(new File("assets/tiles/" + name + ".png")), false));

            name = TilesName.wall_01.name();
            tiles.put(name, new Tile(name, ImageIO.read(new File("assets/tiles/" + name + ".png")), true));

            name = TilesName.water_01.name();
            tiles.put(name, new Tile(name, ImageIO.read(new File("assets/tiles/" + name + ".png")), false));

            name = TilesName.not_loaded.name();
            tiles.put(name, new Tile(name, ImageIO.read(new File("assets/tiles/" + name + ".png")), true));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tile getTileByIndex(int index){
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

    public Tile getTileByCoordinates(int x, int y){
        // If entity gets out of map. Return a "not loaded" tile.
        if (x < 0 || y < 0 || x >= mapRows || y >= mapCols){
            return getTileByName(TilesName.not_loaded.name());
        }

        int tileNum = mapTileNum[x][y];
        return getTileByIndex(tileNum);
    }

    public void draw (Graphics g2) {
        for (int r = 0; r < mapRows; r++) {
            for (int c = 0; c < mapCols; c++) {
                int tileIndex = mapTileNum[r][c];

                // Tile position, to draw.
                Vector2DInt tilePosition = new Vector2DInt(c * cell.width, r * cell.height);

                // Tile position, to draw, taking into consideration player position.
                int screenX = tilePosition.getX() - player.positionOnTheMap.getX() + player.positionOnScreen.getX();
                int screenY = tilePosition.getY() - player.positionOnTheMap.getY() + player.positionOnScreen.getY();

                if (tilePosition.getX() + cell.width > player.positionOnTheMap.getX() - player.positionOnScreen.getX() &&
                    tilePosition.getX() - cell.width < player.positionOnTheMap.getX() + player.positionOnScreen.getX() &&
                    tilePosition.getY() + cell.height > player.positionOnTheMap.getY() - player.positionOnScreen.getY() &&
                    tilePosition.getY() - cell.height < player.positionOnTheMap.getY() + player.positionOnScreen.getY()){
                    g2.drawImage(getTileByIndex(tileIndex).getImage(),screenX, screenY, cell.width, cell.height, null);
                }
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
        System.out.println("TileManager - Loading map: " + mapPath);
        reset();
        try (InputStream stream = getClass().getResourceAsStream(mapPath);
             InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             BufferedReader bufferReader = new BufferedReader(streamReader)) {

            // Example path "/maps/maps01.txt"
            getMapDimension("assets/" + mapPath);
            mapTileNum = new int[mapRows][mapCols];

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

    public void reset(){
        loadTileImages();
        mapTileNum = null;
    }
}