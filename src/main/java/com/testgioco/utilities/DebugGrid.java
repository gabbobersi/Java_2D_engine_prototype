package com.testgioco.utilities;

import java.awt.*;

public class DebugGrid {

    public void draw(Graphics2D g2){
        int width = GameSettings.screenWidth;
        int height = GameSettings.screenHeight;

        int rowHeight = height / (GameSettings.mapRowsNumber);
        for (int k = 0; k < GameSettings.mapRowsNumber; k++) {
            g2.drawLine(0, k * rowHeight, width, k * rowHeight);
        }

        int rowWidth = width / (GameSettings.mapColumnsNumber);
        for (int k = 0; k < GameSettings.mapColumnsNumber; k++) {
            g2.drawLine(k * rowWidth, 0, k * rowWidth, height);
        }
    }
}
