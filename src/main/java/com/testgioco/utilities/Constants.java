package com.testgioco.utilities;

public class Constants {
    private final GameSettings settings = new GameSettings();
    // Below all the constants available in the game.
    // This class does not contain game settings!

    public final long ONE_SECOND_IN_NANOSECONDS = 1000000000L;   // One second in nanoseconds
    public final double NS_PER_UPDATE = ((double)1 / settings.fps) * 1_000_000_000.0; // Nanoseconds to update game

}
