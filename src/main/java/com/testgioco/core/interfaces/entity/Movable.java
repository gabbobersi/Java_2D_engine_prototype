package com.testgioco.core.interfaces.entity;

import com.testgioco.entities.Direction;
import com.testgioco.core.Vector2DInt;

public interface Movable {
    int getSpeed();
    void setSpeed(int speed);

    Direction getVerticalDirection();
    Direction getHorizontalDirection();

    /**
     * Returns the position of the entity on the map.
     * */
    Vector2DInt getPositionOnTheMap();
}
