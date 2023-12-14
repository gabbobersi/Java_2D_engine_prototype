package com.testgioco.core.components;

import com.testgioco.utilities.Handlers;
import com.testgioco.utilities.Vector2DInt;

public class MouseInteractivityManager {
    private Vector2DInt positionOnTheScreen;
    private int width, height;
    private boolean isClicked = false;

    public MouseInteractivityManager(Vector2DInt positionOnTheScreen, int width, int height){
        this.positionOnTheScreen = positionOnTheScreen;
        this.width = width;
        this.height = height;
    }

    /**
     * Check if mouse is over the box's boundaries.
     * */
    public boolean hasMouseOver(){
        return (Handlers.mouseMotionH.x >= positionOnTheScreen.getX() && Handlers.mouseMotionH.x <= positionOnTheScreen.getX() + width)
                && (Handlers.mouseMotionH.y > positionOnTheScreen.getY() && Handlers.mouseMotionH.y < positionOnTheScreen.getY() + height);
    }

    /**
     * Check if mouse has been pressed inside box's boundaries.
     * */
    public boolean hasBeenPressed(){
        return hasMouseOver() && !Handlers.mouseH.released;
    }

    /**
     * Check if mouse has been clicked inside box's boundaries.
     * */
    public boolean hasBeenClicked(){
        boolean condition = hasMouseOver() && !Handlers.mouseH.released;

        // If the ButtonLabel doesn't results already clicked, and I've clicked on it, will be clicked.
        // Prevents the ButtonLabel to remain triggered, after the first click!
        isClicked = !isClicked && condition;
        return isClicked;
    }
}
