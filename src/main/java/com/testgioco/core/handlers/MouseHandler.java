package com.testgioco.core.handlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public int x;
    public int y;
    public boolean released = true;
    public boolean clicked = false;
    public int clickCount;

    Timer clickedTimer = new Timer(30, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clicked = false;
        }
    });

    public MouseHandler(){
        clickedTimer.setRepeats(false);
    }

    /**
     * Fired with a "complete" click (pressed, and then released)
     * */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (released) {
            clicked = true;
            clickedTimer.start();
            x = e.getX();
            y = e.getY();
            clickCount = e.getClickCount();
            // Prevents event propagation to other components
            e.consume();
        }
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
        released = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Prevents that mouse pressed event propagate through panels.
     * */
    public void reset(){
        released = true;
        x = 0;
        y = 0;
    }

}
