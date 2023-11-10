package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

public class GameState {
    private static State previousState =  State.MAIN_MENU;
    private static State activeState = State.MAIN_MENU;
    public enum State {
        MAIN_MENU,
        TEST_1,
        TILE_MAP_GENERATOR,
        QUIT
    }

    private GameState(){
    }

    public static void setActiveState(State newState) {
        previousState = activeState;
        activeState = newState;
        switch (newState) {
            case TEST_1 -> activeState = State.TEST_1;
            case TILE_MAP_GENERATOR -> activeState = State.TILE_MAP_GENERATOR;
            case QUIT -> activeState = State.QUIT;
            default -> activeState = State.MAIN_MENU;
        }
    }

    public static State getActiveState() {
        return activeState;
    }

    public static State getPreviousState(){
        return previousState;
    }
}
