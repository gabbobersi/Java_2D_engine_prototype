package com.testgioco.core;

import com.testgioco.core.scenes.Play;
import com.testgioco.entities.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TileManager {
    Cell cell = new Cell();
    Player player;
    World world = new World();
    Tile[] tiles;
    int[][] mapTileNum;

    String mapPath;

    public TileManager(Player player, String mapPath) {
        this.player = player;
        tiles = new Tile[10];
        mapTileNum = new int[world.maxRow][world.maxColumn];
        getTileImage();
        this.mapPath = mapPath;
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

        for (int r = 0; r < world.maxRow; r++) {
            for (int c = 0; c < world.maxColumn; c++) {
                int tileIndex = mapTileNum[r][c];

                int worldX = c * cell.width;
                int worldY = r * cell.height;

                int screenX = worldX - player.positionOnTheMap.getX() + player.positionOnScreen.getX();
                int screenY = worldY - player.positionOnTheMap.getY() - player.positionOnScreen.getY();

                g2.drawImage(tiles[tileIndex].image,screenX, screenY, cell.width, cell.height, null);
            }
        }
    }
    public void loadMap (){
        try{
            // Example path "/maps/maps01.txt"
            InputStream is = getClass().getResourceAsStream(mapPath);
            System.out.println("Sto usando la mappa: " + mapPath);
            assert is != null;
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            for (int r = 0; r < world.maxRow; r++) {
                String line = br.readLine();
                String[] numbers = new String[world.maxColumn];

                // If the line has been correctly read, I just take those values.
                // Else, I take a default tile
                if (line != null) {
                    numbers = line.split(" ");
                } else {
                    for (int i = 0; i < world.maxColumn; i++){
                        numbers[i] = "9";
                    }
                }

                for ( int c = 0; c < world.maxColumn; c++) {
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