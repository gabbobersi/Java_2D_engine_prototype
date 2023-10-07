package com.testgioco.ui_elements;

import com.testgioco.*;
import com.testgioco.entities.Player;

import javax.swing.*;
import java.awt.*;
//berse sei un fregno
public class Panel extends JPanel implements Runnable {
    Grid grid = new Grid();
    Fps fps = new Fps(60);

    /* 1. Creiamo una variabile keyH, di tipo InputHandler (che è una classe)
    *  2. Assegniamo alla variabile keyH, una istanza della classe InputHandler.
    * (abbiamo creato una istanza - aka oggetto - della classe InputHandler. L'istanza è keyH.)
    * */
    InputHandler keyH = new InputHandler();
    Thread gameThread;
    Player player = new Player(keyH, 100, 100);
    TileManager tileManager = new TileManager();
    public Panel() {
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
