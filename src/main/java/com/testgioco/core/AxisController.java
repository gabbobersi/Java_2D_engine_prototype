package com.testgioco.core;

import com.testgioco.utilities.Handlers;

public class AxisController {
    /**
     * Returns the vertical direction of the entity.
     * */
    public Direction getVerticalDirection() {
        Direction verticalDirection = null;

        if (Handlers.keyH.w_pressed){
            verticalDirection = Direction.UP;
        }
        else if ( Handlers.keyH.s_pressed){
            verticalDirection = Direction.DOWN;
        }
        return verticalDirection;
    }

    /**
     * Returns the horizontal direction of the entity.
     * */
    public Direction getHorizontalDirection() {
        Direction horizontalDirection = null;

        if ( Handlers.keyH.a_pressed){
            horizontalDirection = Direction.LEFT;
        }
        else if ( Handlers.keyH.d_pressed){
            horizontalDirection = Direction.RIGHT;
        }
        return horizontalDirection;
    }

    /**
     * Returns true if any axis is active.
     * */
    public boolean anyAxisIsActive(){
        return getHorizontalDirection() != null || getVerticalDirection() != null;
    }
}
