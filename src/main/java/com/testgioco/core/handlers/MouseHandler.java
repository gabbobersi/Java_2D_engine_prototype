package com.testgioco.core.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    public int xClick;
    public int yClick;
    public boolean released;

    public MouseHandler(){
        xClick = 0;
        yClick = 0;
        released = false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        released = false;
        xClick = e.getX();
        yClick = e.getY();
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
