package com.testgioco.core;

import com.testgioco.utilities.Constants;
import com.testgioco.utilities.GameSettings;

public class Fps {
    private final GameSettings settings = new GameSettings();
    private final Constants constants = new Constants();

    private int fps = settings.fps;
    private double drawInterval;
    private double delta;
    public double deltaTime;
    private long lastTime;
    private long currentTime;
    private long timer;
    private int drawCount;

    double nextDrawTime;

    public Fps(){
        resetValues();
    }

    public Fps(int fps){
        this.fps = fps;
        resetValues();
    }

    private void resetValues(){
        drawInterval = (double) constants.ONE_SECOND_IN_NANOSECONDS / (double) fps;
        delta = 0;
        deltaTime = 0;
        lastTime = System.nanoTime();
        currentTime = System.nanoTime();
        timer = 0;
        drawCount = 0;
        nextDrawTime = System.nanoTime() + drawInterval;
    }

    public boolean canDrawAccumulator(boolean debugMode){
        // FPS System with accumulator
        currentTime = System.nanoTime();

        if (currentTime > lastTime) {
            deltaTime = (currentTime - lastTime) / 1e9;
        } else {
            deltaTime = 0; // Il tempo si è fermato o ha subito un'anomalia
        }

        delta +=  (currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;

        if (debugMode){
            debugFPS();
        }

        if (delta >= 1) {
            delta--;
            drawCount++;
            return true;
        }
        return false;
    }

    private void debugFPS(){
        if (timer >= constants.ONE_SECOND_IN_NANOSECONDS) {
            System.out.println("FPS: " + drawCount);
            drawCount = 0;
            timer = 0;
        }
    }

    public void canDrawSleep(boolean debugMode){
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
