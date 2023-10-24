package com.tilemapgenerator;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.dispose();
    }
}
