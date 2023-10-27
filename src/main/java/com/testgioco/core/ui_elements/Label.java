package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2D;
import com.testgioco.core.exceptions.UnexpectedStringValueException;

import javax.swing.*;
import java.awt.*;

/**
 * This class allows to draw and update text on the screen.
 * */
public class Label {
    private final JLabel label = new JLabel();
    public enum Alignment {
        LEFT, CENTER, RIGHT
    }

    /**
     * Custom label with coordinates (x, y) for position.
     * */
    public Label(int x, int y, String text, Alignment horizontalAlign, Alignment verticalAlign, Font font,
                 Color fontColor){
        Vector2D vector = new Vector2D(x, y);
        setLabel(vector, text, horizontalAlign, verticalAlign, font, fontColor);
    }

    /**
     * Custom label with vector for position.
     * */
    public Label(Vector2D vector, String text, Alignment horizontalAlign, Alignment verticalAlign, Font font, Color fontColor){
        setLabel(vector, text, horizontalAlign, verticalAlign, font, fontColor);
    }

    /**
     * Default label with vector for position.
     * */
    public Label(Vector2D vector, String text){
        Font font = new Font("Comic Sans", 1, 30);
        setLabel(vector, text, Alignment.CENTER, Alignment.CENTER, font, Color.BLACK);
    }

    /**
     * Set all label's attributes
     * @param pos Label's position on the screen.
     * @param text Text of the label
     * @param x Horizontal alignment.
     * @param y Vertical alignment.
     * @param font Font object. Its size will determine label's font size.
     * @param color Font's color.
     * */
    private void setLabel(Vector2D pos, String text, Alignment x, Alignment y, Font font, Color color){
        label.setText(text);
        label.setLocation((int)pos.getX(), (int)pos.getY());
        label.setForeground(color);
        label.setSize(font.getSize(), font.getSize());
        label.setFont(font);

        try{
            setAlignment(label, "horizontal", x);
            setAlignment(label, "vertical", y);
        } catch (UnexpectedStringValueException e){
            e.printStackTrace();
        }
        label.setVisible(true);
        // label.setBounds(200, 200, label.getPreferredSize().width, label.getPreferredSize().height);
        reDrawLabel(label);
    }

    private void reDrawLabel(JLabel lbl){
        lbl.revalidate();
        lbl.repaint();
    }

    private void setAlignment(JLabel lbl, String alignmentType, Alignment alignment) throws UnexpectedStringValueException {
        if (alignmentType == null || !alignmentType.equals("horizontal") && !alignmentType.equals("vertical")){
            throw new UnexpectedStringValueException("alignmentType value is not equal 'horizontal' or 'vertical'");
        }

        switch (alignment) {
            case LEFT -> lbl.setHorizontalAlignment(SwingConstants.LEFT);
            case CENTER -> lbl.setHorizontalAlignment(SwingConstants.CENTER);
            case RIGHT -> lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        }
    }

    /**
     * Returns the JLabel internal implementation.
     * It should be used just to add the component to a container.
     * */
    public JLabel getComponent(){
        return label;
    }

    public void draw(Graphics2D g2){
        label.paint(g2);
    }
}
