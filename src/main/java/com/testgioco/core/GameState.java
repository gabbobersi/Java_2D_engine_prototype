package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

public class GameState {
    private static State previousState =  State.QUIT;
    private static State activeState = GameSettings.defaultScene;
    public enum State {
        MAIN_MENU,
        PLAY,
        TILE_MAP_GENERATOR,
        QUIT,
        TEST,
        LOADING_SCREEN
    }

    public static void setActiveState(State newState) {
        previousState = activeState;
        switch (newState) {
            case PLAY -> activeState = State.PLAY;
            case TILE_MAP_GENERATOR -> activeState = State.TILE_MAP_GENERATOR;
            case QUIT -> activeState = State.QUIT;
            case TEST -> activeState = State.TEST;
            case LOADING_SCREEN -> activeState = State.LOADING_SCREEN;
            default -> activeState = State.MAIN_MENU;
        }
    }

    public static State getActiveState() {
        return activeState;
    }

    public static String getActiveStateName(){
        return getActiveState().toString();
    }

    public static State getPreviousState(){
        return previousState;
    }
}
