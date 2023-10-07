package com.testgioco.ui_elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TileManager {
    Cell cella = new Cell();
    Grid grid = new Grid();
    Tile[] tiles;
    int mapTileNum[][];
    public TileManager() {
        tiles = new Tile[3];
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
                g2.drawImage(tiles[tileIndex].image,x, y, cella.size, cella.size, null);
                x += cella.size;
            }
            y += cella.size;
        }
    }
    public void loadMap (){
        try{
            InputStream is = getClass().getResourceAsStream("/maps/maps01.txt");
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            for (int r = 0; r < grid.rowNumber; r++) {
                String line = br.readLine();

                for ( int c = 0; c < grid.columnNumber; c++) {
                    String numbers[] = line.split(" ");
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




