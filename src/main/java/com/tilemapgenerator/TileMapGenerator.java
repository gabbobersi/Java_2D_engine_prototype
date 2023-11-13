package com.tilemapgenerator;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class TileMapGenerator extends JPanel implements Scene {
    private final GameSettings settings = new GameSettings();

    private final int btnHorizontalAlignment = settings.screenWidth/2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);
    private Button btnGenerate = new Button(this, new Vector2DInt(btnHorizontalAlignment, 100), btnWidth, btnHeight, "Generate",
            bordThickness, btnColor, btnFont);

    public TileMapGenerator(){
        setBackground(Color.WHITE);
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    public void run(){
        System.out.println("Non ancora implementato.");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        btnGenerate.draw(g2);
        g2.dispose();
    }
}
