package com.testgioco.core;

import com.testgioco.utilities.Constants;

public class Fps {
    private int counter = 0;
    private long timer = 0;

    public void increment(){
        ++counter;
    }

    public void print(double elapsed){
        timer += elapsed;
        // When a second is passed, print the FPS.
        if (timer >= Constants.ONE_SECOND_IN_NANOSECONDS){
            System.out.println("FPS: " + counter);
            counter = 0;
            timer = 0;
        }
    }
}
