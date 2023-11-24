package com.testgioco.core;

import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.DebugGrid;

public class Cell {
    private final GameSettings settings = new GameSettings();
    public int height = settings.screenHeight / GameSettings.mapRowsNumber;
    public int width = settings.screenWidth / GameSettings.mapColumnsNumber;
}
