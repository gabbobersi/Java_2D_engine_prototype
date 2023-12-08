package com.testgioco.entities;

import com.testgioco.utilities.Handlers;

public class AxisController {
    private Direction previousHorizontalDirection = null;
    private Direction previousVerticalDirection = null;

    private Direction horizontalDirection = null;
    private Direction verticalDirection = null;

    /**
     * Returns true if the direction has changed.
     * */
    public boolean directionHasChanged(){
        return previousHorizontalDirection != horizontalDirection || previousVerticalDirection != verticalDirection;
    }

    /**
     * Returns the vertical direction of the entity.
     * */
    public Direction getVerticalDirection() {
        previousVerticalDirection = verticalDirection;
        verticalDirection = null;

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
        previousHorizontalDirection = horizontalDirection;
        horizontalDirection = null;

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
