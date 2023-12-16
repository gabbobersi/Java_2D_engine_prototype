package com.testgioco.core.interfaces.entity;

import com.testgioco.core.interfaces.base.Drawable;
import com.testgioco.utilities.Vector2D;
import com.testgioco.core.interfaces.base.Visible;
import com.testgioco.utilities.Vector2DInt;

public interface VisibleEntity extends Drawable, Visible {
    /**
     * Returns the position of the entity on the screen.
     * */
    Vector2DInt getPositionOnTheScreen();
}
