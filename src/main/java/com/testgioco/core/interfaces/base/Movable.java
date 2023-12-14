package com.testgioco.core.interfaces.base;

import com.testgioco.core.Direction;
import com.testgioco.utilities.Vector2DInt;

public interface Movable {
    int getSpeed();
    void setSpeed(int speed);

    Direction getVerticalDirection();
    Direction getHorizontalDirection();

    boolean isMoving();

    /**
     * Returns the position of the entity on the map.
     * */
    Vector2DInt getPositionOnTheMap();
}
