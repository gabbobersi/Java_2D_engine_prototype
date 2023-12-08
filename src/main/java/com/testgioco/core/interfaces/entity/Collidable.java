package com.testgioco.core.interfaces.entity;

import java.awt.*;

public interface Collidable {
    /**
     * Action to perform when colliding.
     * */
    void onCollision();

    /**
     * Returns the collision area occupied by the entity.
     * */
    Rectangle getSolidArea();

    /**
     * Sets the collision state of the entity.
     * */
    void setCollision(boolean isColliding);
}
