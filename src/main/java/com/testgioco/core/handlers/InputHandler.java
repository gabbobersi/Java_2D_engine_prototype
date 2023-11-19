package com.testgioco.core.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean upPressed;
    public boolean downPressed;
    public boolean escPressed;
    public boolean anyKeyPressed;

    public InputHandler(){
        reset();
    }

    public void reset(){
        leftPressed = false;
        rightPressed = false;
        upPressed = false;
        downPressed = false;
        escPressed = false;
        anyKeyPressed = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S){
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

        if (code == KeyEvent.VK_ESCAPE) {
            escPressed = true;
        }

        // A key is being pressed.
        if (code != KeyEvent.VK_UNDEFINED){
            anyKeyPressed = true;
        }
    }

    @Override public void keyReleased (KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        // A key is being pressed.
        if (!upPressed && !downPressed && !leftPressed && !rightPressed){
            anyKeyPressed = false;
        }
    }
}

