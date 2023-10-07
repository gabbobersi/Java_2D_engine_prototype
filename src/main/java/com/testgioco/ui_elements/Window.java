package com.testgioco.ui_elements;

import javax.swing.*;

public class Window extends JFrame {
    private int width = 620;
    private int height = 480;
    public Window(){
    }

    public Window(int width, int height, Panel gamePanel){
        this.width = width;
        this.height = height;

        this.setTitle("Gioco di esempio");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(gamePanel);
        this.pack();

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.start();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
