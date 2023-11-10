package com.testgioco.core.scenes;

import com.testgioco.core.Grid;
import com.testgioco.core.TileManager;
import com.testgioco.entities.Player;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;

public class Test1 extends JPanel{
    private final GameSettings settings = new GameSettings();
    private final TileManager tileManager = new TileManager();
    private final Grid grid = new Grid();
    private final Player player = new Player();
    private final ScreenLogger debug = new ScreenLogger();

    public Test1(){
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileManager.draw(g2);
        grid.drawDebugGrid(g2);
        debug.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
