package com.testgioco.core;

public class Fps {
    int fps = 1;
    public static final long MILLISECONDS = 1000000000;   // One second in milliseconds
    double drawInterval;
    double delta;
    long lastTime;
    long currentTime;
    long timer;
    int drawCount;

    public Fps(int fps){
        this.fps = fps;
        this.drawInterval = (double) MILLISECONDS / (double) this.fps;
        this.delta = 0;
        this.lastTime = System.nanoTime();
        this.currentTime = System.nanoTime();
        this.timer = 0;
        this.drawCount = 0;
    }

    public boolean canDraw(boolean debugMode){
        long inizio = System.nanoTime();

        // Tells if external entity can draw.
        this.currentTime = System.nanoTime();
        this.delta += (this.currentTime - this.lastTime) / this.drawInterval;
        this.timer += (this.currentTime - this.lastTime);
        this.lastTime = this.currentTime;

        if (debugMode){
            this.debugFPS();
        }

        if (this.delta >= 1) {
            this.delta--;      // Reset delta to 0
            this.drawCount++;
            return true;
        }
        long fine = System.nanoTime() - inizio;

        return false;
    }

    private void debugFPS(){
        if (this.timer >= MILLISECONDS) {
            System.out.println("FPS: " + this.drawCount);
            this.drawCount = 0;
            this.timer = 0;
        }
    }
}
