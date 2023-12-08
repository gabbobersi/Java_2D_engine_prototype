package com.testgioco.core;

import com.testgioco.utilities.GameSettings;

public class GameState {
    private static State previousState =  State.QUIT;
    private static State activeState = GameSettings.defaultScene;
    private static State nextState = State.EMPTY;
    
    public enum State {
        EMPTY,              // Means that no next state has been set.
        MAIN_MENU,
        PLAY,
        TILE_MAP_GENERATOR,
        QUIT,
        TEST,
        LOADING_SCREEN
    }

    public static void setActiveState(State newState) {
        previousState = activeState;
        activeState = newState;
        nextState = State.EMPTY;
    }

    public static void setNextState(State newState) {
        nextState = newState;
    }

    public static State getNextState() {
        return nextState;
    }

    public static State getActiveState() {
        return activeState;
    }

    public static State getPreviousState(){
        return previousState;
    }
}
