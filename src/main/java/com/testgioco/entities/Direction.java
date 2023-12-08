package com.testgioco.entities;

import com.testgioco.core.Vector2D;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    UP_LEFT,
    UP_RIGHT,
    DOWN_LEFT,
    DOWN_RIGHT;

    static Direction getDirection(Vector2D vector){
        if (vector.getX() == 0 && vector.getY() == 0){
            return null;
        }

        if (vector.getX() == 0){
            return vector.getY() > 0 ? DOWN : UP;
        }

        if (vector.getY() == 0){
            return vector.getX() > 0 ? RIGHT : LEFT;
        }

        if (vector.getX() > 0){
            return vector.getY() > 0 ? DOWN_RIGHT : UP_RIGHT;
        }

        return vector.getY() > 0 ? DOWN_LEFT : UP_LEFT;
    }

}
