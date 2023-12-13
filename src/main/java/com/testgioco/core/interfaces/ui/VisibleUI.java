package com.testgioco.core.interfaces.ui;

import com.testgioco.core.interfaces.base.Drawable;
import com.testgioco.utilities.Vector2DInt;
import com.testgioco.core.interfaces.base.Visible;

public interface VisibleUI extends Drawable, Visible {
    /**
     * Returns the position of the element on the screen.
     * */
    Vector2DInt getPositionOnTheScreen();
}
