package com.testgioco.core.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public int xPressed;
    public int yPressed;
    public int xClick;
    public int yClick;

    public boolean released;

    public MouseHandler(){
        xPressed = 0;
        yPressed = 0;
        xClick = 0;
        yClick = 0;
        released = true;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // Fired with a "complete" click (pressed, and then released)
        // Mouse clicked never call mouseReleased!!!
        xClick = e.getX();
        yClick = e.getY();
        released = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xPressed = e.getX();
        yPressed = e.getY();
        released = false;

        // Prevents event propagation to other components
        e.consume();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        released = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
