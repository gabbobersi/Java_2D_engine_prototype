package com.tilemapgenerator;

import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class TileMapGenerator extends JPanel {
    private final GameSettings settings = new GameSettings();

    public TileMapGenerator(){
        setBackground(Color.WHITE);
        addKeyListener(Singletons.keyH);
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);
        setDoubleBuffered(true);
        setFocusable(true);
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    public void run(){
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
