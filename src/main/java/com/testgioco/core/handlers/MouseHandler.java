package com.testgioco.core.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public int x;
    public int y;
    public boolean released;

    public MouseHandler(){
        released = true;
    }

    /**
     * Fired with a "complete" click (pressed, and then released)
     * */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
        x = e.getX();
        y = e.getY();
        released = false;

        // Prevents event propagation to other components
        e.consume();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        released = false;

        // Prevents event propagation to other components
        e.consume();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
        released = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
