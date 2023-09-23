package com.testgioco;

public class Fps {
    private final long MILLISECONDS = 1000000000;   // One second in milliseconds
    int fps = 1;
    double drawInterval = (double) MILLISECONDS / (double) this.fps;
    double deltaLastDraw = 0;
    long timeFromLastDraw = System.nanoTime();
    long currentTime = System.nanoTime();
    long timer = 0;
    int drawCount = 0;

    public Fps(int fps){
        this.fps = fps;
    }

    public boolean canDraw(boolean debugMode){
        // Tells if external entity can draw.
        this.currentTime = System.nanoTime();
        this.deltaLastDraw += (this.currentTime - this.timeFromLastDraw) / this.drawInterval;
        this.timer += (this.currentTime - this.timeFromLastDraw);
        this.timeFromLastDraw = this.currentTime;

        if (debugMode){
            this.debugFPS();
        }

        if (this.deltaLastDraw >= 1) {
            this.deltaLastDraw--;      // Reset delta to 0
            this.drawCount++;
            return true;
        }
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
