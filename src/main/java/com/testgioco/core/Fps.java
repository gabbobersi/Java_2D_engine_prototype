package com.testgioco.core;

import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;

public class Fps {
    private final GameSettings settings = new GameSettings();
    private final Constants constants = new Constants();

    int fps = settings.fps;
    double drawInterval;
    double delta;
    long lastTime;
    long currentTime;
    long timer;
    int drawCount;

    double nextDrawTime;

    public Fps(){
        resetValues();
    }

    public Fps(int fps){
        this.fps = fps;
        resetValues();
    }

    private void resetValues(){
        drawInterval = (double) constants.ONE_SECOND_IN_MILLISECONDS / (double) fps;
        delta = 0;
        lastTime = System.nanoTime();
        currentTime = System.nanoTime();
        timer = 0;
        drawCount = 0;
        nextDrawTime = System.nanoTime() + drawInterval;
    }

    public boolean canDraw_accumulator(boolean debugMode){
        // FPS System with accumulator
        currentTime = System.nanoTime();
        delta += (currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;

        if (debugMode){
            debugFPS();
        }
        if (delta >= 1) {
            delta--;      // Reset delta to 0
            drawCount++;
            return true;
        }
        return false;
    }

    private void debugFPS(){
        if (timer >= constants.ONE_SECOND_IN_MILLISECONDS) {
            System.out.println("FPS: " + drawCount);
            drawCount = 0;
            timer = 0;
        }
    }

    public void canDraw_sleep(boolean debugMode){
        try {
            currentTime = System.nanoTime();

            // Tempo rimanente fino a prossimo disegno.
            double remainingTime = nextDrawTime - System.nanoTime();
            // Converto i nanosecondi in millisecondi (accettati dal metodo sleep).
            remainingTime = remainingTime / 1000000;

            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (debugMode){
                debugFPS();
            }

            if (remainingTime < 0){
                remainingTime = 0;
            }

            // Fermo il thread per il tempo necessario.
            Thread.sleep((long) remainingTime);
            drawCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        nextDrawTime += drawInterval;
    }
}
