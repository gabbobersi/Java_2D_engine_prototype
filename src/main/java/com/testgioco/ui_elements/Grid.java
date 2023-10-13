package com.testgioco.ui_elements;

import com.testgioco.utilities.GameSettings;

public class Grid {
    private final Cell cell = new Cell();
    private final GameSettings settings = new GameSettings();

    public int columnNumber = settings.screenWidth / cell.size;
    public int rowNumber = settings.screenHeight / cell.size;
}
