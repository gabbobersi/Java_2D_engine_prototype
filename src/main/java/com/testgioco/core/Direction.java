package com.testgioco.core;

import com.testgioco.utilities.Vector2D;

public enum Direction {
    IDLE,
    UP,
    DOWN,
    LEFT,
    RIGHT,
    // Below are the diagonal directions (so a combination of keys).
    UP_LEFT,
    UP_RIGHT,
    DOWN_LEFT,
    DOWN_RIGHT;

    public static Direction getDirection(Vector2D vector){
        Direction direction = IDLE;

        // I'm not moving
        if (vector.getX() == 0 && vector.getY() == 0){
            return direction;
        }

        if (vector.getX() == 0){
            // Moving vertically
            direction = vector.getY() > 0 ? DOWN : UP;
        } else if (vector.getY() == 0){
            // Moving horizontally
            direction = vector.getX() > 0 ? RIGHT : LEFT;
        } else if (vector.getX() > 0){
            // Moving diagonally
            direction = vector.getY() > 0 ? DOWN_RIGHT : UP_RIGHT;
        } else if (vector.getX() < 0){
            // Moving diagonally
            direction = vector.getY() > 0 ? DOWN_LEFT : UP_LEFT;
        }
        return direction;
    }

}
