package com.testgioco.core.ui_elements;

import com.testgioco.utilities.GameSettings;

public class Cell {
    private final Grid grid = new Grid();
    private final GameSettings settings = new GameSettings();

    public int height = settings.screenHeight / grid.rowNumber;
    public int width = settings.screenWidth / grid.columnNumber;

}
