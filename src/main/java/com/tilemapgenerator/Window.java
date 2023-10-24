package com.tilemapgenerator;

import javax.swing.*;

public class Window extends JFrame {
        public Window(Panel gamePanel){
            this.setTitle("Tilemap Generator");
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.add(gamePanel);
            this.pack();
            this.setSize(600, 600);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
    }
