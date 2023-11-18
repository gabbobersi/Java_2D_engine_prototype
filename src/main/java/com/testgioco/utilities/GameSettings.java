package com.testgioco.utilities;

import com.testgioco.core.GameState;

public class GameSettings {
    // For now are final.
    // In the future, with options menu, these options will be normal (so you will be able to change them).

    // Note: these are game settings, NOT CONSTANTS!

    public final int fps = 15;
    public final int screenWidth = 600;
    public final int screenHeight = 600;
    public final String gameTitle = "Gioco di esempio";
    public final GameState.State defaultScene = GameState.State.TEST;
}
