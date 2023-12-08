package com.tilemapgenerator;

import com.testgioco.core.GameState;
import com.testgioco.core.tile.TileManager;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TileMapGenerator extends JPanel implements Scene {
    private final int btnWidth = 300;
    private final int btnHorizontalAlignment = GameSettings.screenWidth / 2 - btnWidth / 2;

    private final int btnHeight = 50;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);

    private final Button btnGenerateAlgo1 = new Button(new Vector2DInt(btnHorizontalAlignment, 100), btnWidth,
            btnHeight, "Algorithm 1 - Room", bordThickness, btnColor, btnFont);

    private final Button btnGenerateAlgo2 = new Button( new Vector2DInt(btnHorizontalAlignment, 160), btnWidth,
            btnHeight, "Algorithm 2 - Random", bordThickness, btnColor, btnFont);

    private final Button btnGenerateAlgo3 = new Button( new Vector2DInt(btnHorizontalAlignment, 220), btnWidth,
            btnHeight, "Algorithm 3 - Zebra", bordThickness, btnColor, btnFont);

    private final Button btnMainMenu = new Button(new Vector2DInt(btnHorizontalAlignment,
            GameSettings.screenHeight - 100), btnWidth,
            btnHeight, "Main menu", bordThickness, btnColor, btnFont);

    private Writer writer = new Writer();
    private Algorithm1 algo1 = new Algorithm1();
    private Algorithm2 algo2 = new Algorithm2();
    private Algorithm3 algo3 = new Algorithm3();

    private int rowsNumber = GameSettings.mapRowsNumber;
    private int columnsNumber = GameSettings.mapColumnsNumber;

    private String defaultFile = "assets/maps/tmapgen_1.txt";

    private enum Algorithms {
        ALGO1,
        ALGO2,
        ALGO3
    }

    public TileMapGenerator(){
        super();
    }

    @Override
    public void awake(){
    }

    @Override
    public void update() {
        String filePath = defaultFile;

        if (btnGenerateAlgo1.isClicked()) {
            deleteFile();
            checkFile(filePath);
            generateAndDebug(filePath, Algorithms.ALGO1);
        } else if (btnGenerateAlgo2.isClicked()){
            deleteFile();
            checkFile(filePath);
            generateAndDebug(filePath, Algorithms.ALGO2);
        } else if (btnGenerateAlgo3.isClicked()) {
            deleteFile();
            checkFile(filePath);
            generateAndDebug(filePath, Algorithms.ALGO3);
        }

        if (btnMainMenu.isClicked()){
            GameState.setActiveState(GameState.State.MAIN_MENU);
        }
    }

    @Override
    public void fixedUpdate(){}

    private void checkFile(String path){
        File file = new File(path);
        if (file.exists()){
            System.out.println("I'm overwriting the following map: " + path);
        } else {
            System.out.println("I'm creating the following map: " + path);
        }
    }

    private void generateAndDebug(String path, Algorithms algo) {
        int [][] tileMap;
        switch (algo){
            case ALGO1 -> tileMap = algo1.generateRandomArray(rowsNumber, columnsNumber);
            case ALGO2 -> tileMap = algo2.generateRandomArray(rowsNumber, columnsNumber);
            case ALGO3 -> tileMap = algo3.generateRandomArray(rowsNumber, columnsNumber);
            default -> tileMap = new int[0][0];
        }

        writer.generateTileMap(path, tileMap);
        TileManager.printTileMap(tileMap, rowsNumber);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        btnGenerateAlgo1.draw(g2);
        btnGenerateAlgo2.draw(g2);
        btnGenerateAlgo3.draw(g2);
        btnMainMenu.draw(g2);
        g2.dispose();
    }

    private void deleteFile(){
        File f = new File(defaultFile);
        try {
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("File eliminato.");
    }

    @Override
    public void unload(int delay){}
}
