package com.testgioco.core.ui_elements;

import com.testgioco.core.Cell;
import com.testgioco.core.Grid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TileManager {
    Cell cell = new Cell();
    Grid grid = new Grid();
    Tile[] tiles;
    int[][] mapTileNum;
    public TileManager() {
        tiles = new Tile[10];
        mapTileNum = new int[grid.rowNumber][grid.columnNumber];
        loadMap();
        getTileImage();
    }
    public void getTileImage() {
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
        int y = 0;

        for (int r = 0; r < grid.rowNumber; r++) {
            int x = 0;
            for (int c = 0; c < grid.columnNumber; c++) {
                int tileIndex = mapTileNum[r][c];
                g2.drawImage(tiles[tileIndex].image,x, y, cell.width, cell.height, null);
                x += cell.width;
            }
            y += cell.height;
        }
    }
    public void loadMap (){
        try{
            InputStream is = getClass().getResourceAsStream("/maps/maps01.txt");
            assert is != null;
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            for (int r = 0; r < grid.rowNumber; r++) {
                String line = br.readLine();
                String[] numbers = new String[grid.columnNumber];

                // If the line has been correctly read, I just take those values.
                // Else, I take a default tile
                if (line != null) {
                    numbers = line.split(" ");
                } else {
                    for (int i = 0; i < grid.columnNumber; i++){
                        numbers[i] = "9";
                    }
                }

                for ( int c = 0; c < grid.columnNumber; c++) {
                    int num = Integer.parseInt(numbers[c]);
                    mapTileNum[r][c] = num;

                }
            }
            br.close();

        } catch(Exception e){
            e.printStackTrace();
        }


    }
}




