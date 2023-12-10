package com.testgioco.core.ui_elements;

import com.testgioco.utilities.Vector2DInt;
import com.testgioco.core.interfaces.ui.VisibleUI;

import java.awt.*;

/**
 * This class allows to draw and update text on the screen.
 * */
public class Label implements VisibleUI {
    private Font font;
    private Vector2DInt positionOnTheScreen;
    private String text;
    private Color color;
    private boolean isVisible = true;

    /**
     * Custom label with positionOnTheScreen for position.
     * @param positionOnTheScreen positionOnTheScreen 2D containing x, y position.
     * @param text Text of the label.
     * @param font Font object represent text's font and text's size.
     * @param color Color of the text.
     * */
    public Label(Vector2DInt positionOnTheScreen, String text, Font font, Color color){
        this.positionOnTheScreen = positionOnTheScreen;
        this.text = text;
        this.font = font;
        this.color = color;
    }

    public void draw(Graphics2D g2){
        // Note: font and color are set ONLY during first draw.
        g2.setFont(font);
        g2.setColor(color);
        g2.drawString(text, positionOnTheScreen.getX(), positionOnTheScreen.getY());
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Vector2DInt getVector() {
        return positionOnTheScreen;
    }

    public void setVector(Vector2DInt positionOnTheScreen) {
        this.positionOnTheScreen = positionOnTheScreen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public Vector2DInt getPositionOnTheScreen() {
        return positionOnTheScreen;
    }
}
