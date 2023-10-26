package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2D;

import javax.swing.*;

public class Label extends JLabel {
    private Vector2D vector;
    private String text;

    public Label(String text, int x, int y){
        super(text);
        this.text = text;
        vector.setX(x);
        vector.setY(y);
    }

    public Label(String text, Vector2D vector){
        super(text);
        this.text = text;
        this.vector = vector;
    }


}
