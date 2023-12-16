package com.testgioco.core.tile;

import com.testgioco.utilities.Image;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.entities.Player;
import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TileManager {
    private final Player player;
    private final Map<String, Tile> tiles = new HashMap<>();
    private static int[][] mapTileNum;
    private ArrayList<Vector2DInt> highlightTileNum = new ArrayList<>();

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
        System.out.println("x: " + x + " y: " + y);
        if (x < 0 || y < 0 || x >= mapRows || y >= mapCols){
            System.out.println("Sono fuori");
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
                Vector2DInt tilePositionOnTheMap = new Vector2DInt(c * Constants.cellWidth, r * Constants.cellHeight);

                // Tile position, to draw, taking into consideration player position.
                int screenX =
                        tilePositionOnTheMap.getX() - player.positionOnTheMap.getX() + (int)Math.round(player.positionOnTheScreen.getX());
                int screenY =
                        tilePositionOnTheMap.getY() - player.positionOnTheMap.getY() + (int)Math.round(player.positionOnTheScreen.getY());

                // Draw only tiles that are visible on the screen.
                if (tilePositionOnTheMap.getX() + Constants.cellWidth > player.positionOnTheMap.getX() - player.positionOnTheScreen.getX() &&
                    tilePositionOnTheMap.getX() - Constants.cellWidth < player.positionOnTheMap.getX() + player.positionOnTheScreen.getX() &&
                    tilePositionOnTheMap.getY() + Constants.cellHeight > player.positionOnTheMap.getY() - player.positionOnTheScreen.getY() &&
                    tilePositionOnTheMap.getY() - Constants.cellHeight < player.positionOnTheMap.getY() + player.positionOnTheScreen.getY()){

                    // Highlights or draw
                    boolean highlight = false;
                    for (Vector2DInt tile : highlightTileNum) {
                        if (r == tile.getX() && c == tile.getY()) {
                            highlight = true;
                            break;
                        }
                    }
                    if (highlight) {
                        Image image = new Image(getTileByIndex(tileIndex).getImage());
                        image.brightImage(100);
                        g2.drawImage(image.getImage(), screenX, screenY, Constants.cellWidth, Constants.cellHeight, null);
                    } else {
                        g2.drawImage(getTileByIndex(tileIndex).getImage(), screenX, screenY, Constants.cellWidth, Constants.cellHeight, null);
                    }
                }
            }
        }
    }

    public void highlightTiles(ArrayList<Vector2DInt> tiles){
        highlightTileNum = tiles;
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
        Scanner reader;

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
        try (InputStream stream = getClass().getResourceAsStream(mapPath)) {
            assert stream != null;

            try (InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
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

            }
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