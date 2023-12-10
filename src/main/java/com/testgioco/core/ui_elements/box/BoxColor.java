package com.testgioco.core.ui_elements.box;

import com.testgioco.core.interfaces.base.Drawable;
import com.testgioco.utilities.Vector2DInt;
import java.awt.*;

public class BoxColor extends BaseBox implements Drawable {
    private Color boxColor;

    public BoxColor(Vector2DInt positionOnTheScreen, int width, int height, int bordThickness, Color boxColor){
        super(positionOnTheScreen, width, height, bordThickness);
        this.boxColor = boxColor;

    }

    /**
     * Check if mouse has been pressed inside box's boundaries.
     * */
    @Override
    public void draw(Graphics2D g2) {
        switch (renderingAlign){
            case DEFAULT -> renderTopLeft();
            case CENTER -> renderCenter();
        }

        g2.setColor(Color.BLACK);
        g2.fill(boxBorders);
        g2.setColor(boxColor);
        g2.fill(box);
    }
    public void setColor(Color boxColor) {
        this.boxColor = boxColor;
    }
}
