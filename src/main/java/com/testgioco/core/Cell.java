package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

public class Cell {
    private final GameSettings settings = new GameSettings();
    public int height = settings.screenHeight / settings.cameraHeight;
    public int width = settings.screenWidth / settings.cameraWidth;
}
