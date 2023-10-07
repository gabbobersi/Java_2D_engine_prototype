package com.testgioco.ui_elements;

import com.testgioco.Debug;
import com.testgioco.core.Fps;
import com.testgioco.core.InputHandler;
import com.testgioco.entities.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    private Fps fps = new Fps(30);
    private InputHandler keyH = new InputHandler();
    private Thread gameThread;
    private Player player = new Player(keyH, 100, 100);
    private TileManager tileManager = new TileManager();
    public Panel() {
        Debug debug = new Debug();
        debug.debug();
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    @Override
    public void run() {
        // Main game loop
        while (gameThread != null) {
            // Note: we only updates and draw when fps allow us.
            if (fps.canDraw(true)){
                update();
                repaint();  // Calls "paintComponent" method.
            }
        }
    }

    public void start(){
        gameThread = new Thread(this);
        gameThread.start(); // Calls "run" method, in a new thread.
    }

    public void update(){
        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        // Questo metodo DISEGNA
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileManager.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
