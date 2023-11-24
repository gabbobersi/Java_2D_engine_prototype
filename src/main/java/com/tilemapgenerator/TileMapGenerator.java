package com.tilemapgenerator;

import com.testgioco.core.GameState;
import com.testgioco.core.Grid;
import com.testgioco.core.TileManager;
import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;

public class TileMapGenerator extends JPanel implements Scene {
    private final GameSettings settings = new GameSettings();

    private final int btnHorizontalAlignment = settings.screenWidth / 2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);

    private final Button btnGenerate = new Button(this, new Vector2DInt(btnHorizontalAlignment, 100), btnWidth, btnHeight, "Generate",
            bordThickness, btnColor, btnFont);
    private final Button btnMainMenu = new Button(this, new Vector2DInt(btnHorizontalAlignment, 200), btnWidth,
            btnHeight, "Main menu", bordThickness, btnColor, btnFont);

    private Writer writer = new Writer();
    private Algorithm1 algo1 = new Algorithm1();

    private int rowsNumber = 15;
    private int columnsNumber = 15;

    public TileMapGenerator() {
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);

        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    @Override
    public void run() {
        String filePath = "assets/maps/tmapgen_1.txt";

        if (btnGenerate.isClicked()) {
            File file = new File(filePath);
            if (file.exists()){
                System.out.println("I'm overwriting the following map: " + filePath);
            } else {
                System.out.println("I'm creating the following map: " + filePath);
            }
            int [][] tileMap = algo1.generateRandomArray(rowsNumber, columnsNumber);
            writer.generateTileMap(filePath, tileMap);
            TileManager.printTileMap(tileMap, rowsNumber);
        }

        if (btnMainMenu.isClicked()){
            GameState.setActiveState(GameState.State.MAIN_MENU);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        btnGenerate.draw(g2);
        btnMainMenu.draw(g2);
        g2.dispose();
    }
}
