package com.testgioco.core.ui_elements;

import com.testgioco.core.Grid;
import com.testgioco.utilities.ScreenLogger;
import com.testgioco.core.InputHandler;
import com.testgioco.entities.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private InputHandler keyH;

    // Here put classes to draw
    public final TileManager tileManager = new TileManager();
    public final Grid grid = new Grid();
    public final Player player = new Player();
    public final ScreenLogger debug = new ScreenLogger();
    private final Box box = new Box();

    public Panel(InputHandler keyH, Color backGround){
        this.keyH = keyH;
        this.player.keyH = keyH;
        this.setBackground(Color.white);
        this.addKeyListener(this.keyH);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.add(box);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        // Objects to draw, in order.
//        tileManager.draw(g2);
//        grid.drawDebugGrid(g2);
//        debug.draw(g2);
//        player.draw(g2);
        box.setX(200);
        box.setY(100);
        box.setWidth(200);
        box.setHeight(100);
        box.setThickness(5);
        box.setBoxColor(Color.BLUE);
        box.draw(g2);
        g2.dispose();
    }
}
