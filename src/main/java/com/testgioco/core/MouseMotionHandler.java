package com.testgioco.core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {
    public int x;
    public int y;

    public MouseMotionHandler(){
        x = 0;
        y = 0;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
