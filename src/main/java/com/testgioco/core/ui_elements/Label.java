package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2D;

import javax.swing.*;
import java.awt.*;

/**
 * This class allows to draw and update text on the screen.
 * */
public class Label extends JLabel {
    private Vector2D vector;

    public enum Alignment {
        LEFT, CENTER, RIGHT
    }

    /**
     * Constructor with coordinates (x, y) for position.
     * */
    public Label(int x, int y, String text, Alignment alignment, Font font, Color fontColor){
        super(text);
        this.vector = new Vector2D(x, y);
        setLocation(x, y);
        setAlignment(alignment);

        modifyFont(font, fontColor);

        updateVisuals();
    }

    /**
     * Constructor with vector for position.
     * */
    public Label(Vector2D vector, String text, Alignment alignment, Font font, Color fontColor){
        super(text);
        this.vector = vector;
        setLocation((int)vector.getX(), (int)vector.getY());
        setAlignment(alignment);

        modifyFont(font, fontColor);

        updateVisuals();
    }

    private void setAlignment(Alignment alignment){
        switch (alignment) {
            case LEFT -> setHorizontalAlignment(SwingConstants.LEFT);
            case CENTER -> setHorizontalAlignment(SwingConstants.CENTER);
            case RIGHT -> setHorizontalAlignment(SwingConstants.RIGHT);
            default ->
                // Allineamento predefinito in caso di parametro non valido
                setHorizontalAlignment(SwingConstants.LEFT);
        }
    }

    private void modifyFont(Font font, Color color){
        setFont(font);
        setSize(font.getSize(), font.getSize());
        setForeground(color);
    }

    public void updateText(String text) {
        this.setText(text);
        updateVisuals();
    }

    public void updateCoordinates(int x, int y) {
        vector.setX(x);
        vector.setY(y);
        setLocation((int)vector.getX(), (int)vector.getY());
        updateVisuals();
    }

    /**
     * Allows to update font and size.
     * */
    public void updateFont(Font font){
        setFont(font);
        updateVisuals();
    }

    public void updateColor(Color color){
        setForeground(color);
        updateVisuals();
    }

    private void updateVisuals(){
        revalidate();
        repaint();
    }
}
