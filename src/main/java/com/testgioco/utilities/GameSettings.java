package com.testgioco.utilities;

import com.testgioco.core.GameState;

public class GameSettings {
    // For now are final.
    // In the future, with options menu, these options will be normal (so you will be able to change them).

    // Note: these are game settings, NOT CONSTANTS!

    public final double fps = 60.0;
    public final int screenWidth = 600;
    public final int screenHeight = 600;
    public final String gameTitle = "Gioco di esempio";
    public final GameState.State defaultScene = GameState.State.MAIN_MENU;

    // Camera
    public final int cameraHeight = 10;
    public final int cameraWidth = 10;

    // Active map informations.
    public static int mapRowsNumber = 15;
    public static int mapColumnsNumber = 15;
}
