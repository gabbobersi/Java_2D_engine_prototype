package com.testgioco.core.ui_elements.button;

import com.testgioco.core.components.MouseInteractivityManager;
import com.testgioco.utilities.Vector2DInt;

import java.awt.*;

public class BaseButton {

    protected Vector2DInt positionOnTheScreen;
    protected int width, height;
    protected int bordThickness;
    protected Color buttonColor;
    protected Font font;
    protected boolean isVisible = true;

    protected MouseInteractivityManager mouseInteractivityManager;


    public BaseButton(Vector2DInt positionOnTheScreen, int width, int height, int bordThickness,
                      Color buttonColor, Font font){
        this.positionOnTheScreen = positionOnTheScreen;
        this.width = width;
        this.height = height;
        this.bordThickness = bordThickness;
        this.buttonColor = buttonColor;
        this.font = font;
        this.mouseInteractivityManager = new MouseInteractivityManager(positionOnTheScreen, width, height);
    }
}
