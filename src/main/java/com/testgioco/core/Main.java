package com.testgioco.core;


import com.testgioco.utilities.LogSystem;

import java.util.logging.Level;

public class Main {
    public static void main (String[] args){
        Game game = new Game();
        game.start();
        try {
            LogSystem my_log = new LogSystem( Main.class.getName(), Level.INFO,"log.txt");
            my_log.logInfo("info message");



        } catch (Exception e) {

        }
    }
}
