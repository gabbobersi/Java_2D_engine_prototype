package com.testgioco;

public class Fps {
<<<<<<< Updated upstream
    public static final long MILLISECONDS = 1000000000;   // One second in milliseconds
=======
    private final long MILLISECONDS = 1000000000;   // One second in milliseconds
>>>>>>> Stashed changes
    double drawInterval;
    int fps = 1;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime = System.nanoTime();
    long timer = 0;
    int drawCount = 0;

    public Fps(int fps){
        this.fps = fps;
        this.drawInterval = (double) MILLISECONDS / (double) this.fps;
    }

    public boolean canDraw(boolean debugMode){
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
