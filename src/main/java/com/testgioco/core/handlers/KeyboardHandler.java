package com.testgioco.core.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    public boolean a_pressed;
    public boolean d_pressed;
    public boolean w_pressed;
    public boolean s_pressed;
    public boolean esc_pressed;
    public boolean space_pressed;
    public boolean i_pressed;
    public boolean h_pressed;

    private boolean anyKey_pressed;

    public KeyboardHandler(){
        reset();
    }

    public void reset(){
        resetKeys();
    }

    public void resetKeys(){
        a_pressed = false;
        d_pressed = false;
        w_pressed = false;
        s_pressed = false;
        esc_pressed = false;
        anyKey_pressed = false;
        space_pressed = false;
        i_pressed = false;
        h_pressed = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            w_pressed = true;
        }
        if (code == KeyEvent.VK_S){
            s_pressed = true;
        }
        if (code == KeyEvent.VK_A) {
            a_pressed = true;
        }
        if (code == KeyEvent.VK_D) {
            d_pressed = true;
        }

        if (code == KeyEvent.VK_ESCAPE) {
            esc_pressed = true;
        }

        if (code == KeyEvent.VK_SPACE) {
            space_pressed = true;
        }

        if (code == KeyEvent.VK_I) {
            i_pressed = true;
        }

        if (code == KeyEvent.VK_H) {
            h_pressed = true;
        }

        // A key is being pressed.
        if (code != KeyEvent.VK_UNDEFINED){
            anyKey_pressed = true;
        }
    }

    @Override public void keyReleased (KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            w_pressed = false;
        }
        if (code == KeyEvent.VK_S) {
            s_pressed = false;
        }
        if (code == KeyEvent.VK_A) {
            a_pressed = false;
        }
        if (code == KeyEvent.VK_D) {
            d_pressed = false;
        }

        if (code == KeyEvent.VK_SPACE) {
            space_pressed = false;
        }

        if (code == KeyEvent.VK_I) {
            i_pressed = false;
        }

        if (code == KeyEvent.VK_H) {
            h_pressed = false;
        }

        // A key is being pressed.
        if (!w_pressed && !s_pressed && !a_pressed && !d_pressed){
            anyKey_pressed = false;
        }
    }

    public boolean isAnyKeyPressed(){
        return anyKey_pressed;
    }
}

