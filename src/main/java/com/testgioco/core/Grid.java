package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

import java.awt.*;

public class Grid {
    // Here you can modify grid resolution.
    private final GameSettings settings = new GameSettings();
    public final int columnNumber = 10;
    public final int rowNumber = 10;


    public void drawDebugGrid(Graphics2D g2){
        int k;
        int width = settings.screenWidth;
        int height = settings.screenHeight;

        int rowHeight = height / (rowNumber);
        for (k = 0; k < rowNumber; k++) {
            g2.drawLine(0, k * rowHeight, width, k * rowHeight);
        }

        int rowWidth = width / (columnNumber);
        for (k = 0; k < columnNumber; k++) {
            g2.drawLine(k * rowWidth, 0, k * rowWidth, height);
        }
    }
}
