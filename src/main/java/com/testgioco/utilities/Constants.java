package com.testgioco.utilities;

import com.testgioco.core.Game;

/**
 * Below all the constants available in the game.
 * This class does not contain game settings!
 * */
public class Constants {

    // One second in nanoseconds
    public static final long ONE_SECOND_IN_NANOSECONDS = 1_000_000_000L;

    // Nanoseconds to update the game
    // 1 sec / number of fps == Update frequency in seconds * NS == Update frequency in NS
    public static final double NANOSECONDS_PER_UPDATE = (1.0 / GameSettings.fps) * ONE_SECOND_IN_NANOSECONDS;

    public static final double NANOSECONDS_PER_FIXED_UPDATE = 0.2 * ONE_SECOND_IN_NANOSECONDS;

    // Cell dimension
    // public static int cellHeight = GameSettings.screenHeight / GameSettings.cameraHeight;
    // public static int cellWidth = GameSettings.screenWidth / GameSettings.cameraWidth;
    public static int cellHeight = 50;
    public static int cellWidth = 50;


    // World dimension
    public static int maxWorldColumn = 100;
    public static int maxWorldRow = 100;
    public static int WorldWidth = Constants.cellWidth * maxWorldColumn;
    public static int WorldHeight = Constants.cellHeight * maxWorldRow;
}

//10^-3	ms	millisecondo
//10^-6	µs	microsecondo
//10^-9	ns	nanosecondo

// Da secondi a ns = secondi * 1_000_000_000
// Da ns a secondi = ns / 1_000_000_000