package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2D;
import com.testgioco.core.interfaces.UiElement;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel implements UiElement {
    private Vector2D vector;
    private String text;

    public enum Alignment {
        LEFT, CENTER, RIGHT
    }

    // With coordinates
    public Label(int x, int y, String text, Alignment alignment, Font font, Color FontColor, int fontSize){
        super(text);
        this.text = text;
        vector.setX(x);
        vector.setY(y);
        setAlignment(alignment);
    }

    // With Vector
    public Label(Vector2D vector, String text, Alignment alignment){
        super(text);
        this.text = text;
        this.vector = vector;
        setAlignment(alignment);

    }

    private void setAlignment(Alignment alignment){
        switch (alignment) {
            case LEFT -> setHorizontalAlignment(SwingConstants.LEFT);
            case CENTER -> setHorizontalAlignment(SwingConstants.CENTER);
            case RIGHT -> setHorizontalAlignment(SwingConstants.RIGHT);
            default ->
                // Allineamento predefinito in caso di allineamento non valido
                setHorizontalAlignment(SwingConstants.LEFT);
        }
    }

    @Override
    public void Draw() {
    }

    @Override
    public void Update() {
    }
}
