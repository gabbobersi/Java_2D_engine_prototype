package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

public class GameState {
    private static State previousState =  State.MAIN_MENU;
    private static State activeState = State.MAIN_MENU;
    public enum State {
        MAIN_MENU,
        PLAY,
        TILE_MAP_GENERATOR,
        QUIT
    }

    private GameState(){
    }

    public static void setActiveState(State newState) {
        previousState = activeState;
        activeState = newState;
        switch (newState) {
            case PLAY -> activeState = State.PLAY;
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
