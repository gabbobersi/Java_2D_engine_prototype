package com.testgioco.core.interfaces.base;

import java.awt.*;

public interface Collidable {
    /**
     * Action to perform when colliding.
     * */
    void onCollision();

    /**
     * Returns the collision state of the entity.
     * */
    boolean isColliding();

    /**
     * Returns the collision area occupied by the entity.
     * */
    Rectangle getSolidArea();

    /**
     * Sets the vertical collision state of the entity.
     * */
    void setVerticalCollision(boolean isColliding);

    /**
     * Sets the horizontal collision state of the entity.
     * */
    void setHorizontalCollision(boolean isColliding);
}
