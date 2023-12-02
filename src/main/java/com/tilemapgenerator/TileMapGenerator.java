package com.tilemapgenerator;

import com.testgioco.core.GameState;
import com.testgioco.core.TileManager;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;
import com.tilemapgenerator.interfaces.Algorithm;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TileMapGenerator extends JPanel implements Scene {
    private final GameSettings settings = new GameSettings();

    private final int btnWidth = 300;
    private final int btnHorizontalAlignment = settings.screenWidth / 2 - btnWidth / 2;

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
            settings.screenHeight - 100), btnWidth,
            btnHeight, "Main menu", bordThickness, btnColor, btnFont);

    private Writer writer = new Writer();
    private Algorithm1 algo1 = new Algorithm1();
    private Algorithm2 algo2 = new Algorithm2();
    private Algorithm3 algo3 = new Algorithm3();

    private int rowsNumber = GameSettings.mapRowsNumber;
    private int columnsNumber = GameSettings.mapColumnsNumber;

    private enum Algorithms {
        ALGO1,
        ALGO2,
        ALGO3
    }

    public TileMapGenerator() {
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);

        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    public void awake(){
        File f = new File("assets/maps/tmapgen_1.txt");
        f.delete();
    }

    @Override
    public void fixedUpdate() {
        String filePath = "assets/maps/tmapgen_1.txt";

        if (btnGenerateAlgo1.isClicked()) {
            checkFile(filePath);
            generateAndDebug(filePath, Algorithms.ALGO1);
        } else if (btnGenerateAlgo2.isClicked()){
            checkFile(filePath);
            generateAndDebug(filePath, Algorithms.ALGO2);
        } else if (btnGenerateAlgo3.isClicked()) {
            checkFile(filePath);
            generateAndDebug(filePath, Algorithms.ALGO3);
        }

        if (btnMainMenu.isClicked()){
            GameState.setActiveState(GameState.State.MAIN_MENU);
        }
    }

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
}
