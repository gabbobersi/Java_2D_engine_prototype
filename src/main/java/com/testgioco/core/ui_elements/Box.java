package com.testgioco.core.ui_elements;

import javax.swing.*;
import java.awt.*;

public class Box {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Tile Map Generator");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 500);
        jFrame.add(new JLabel("Scegli la dimensione della mappa"));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
