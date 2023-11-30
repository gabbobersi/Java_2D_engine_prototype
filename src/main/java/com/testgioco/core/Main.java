package com.testgioco.core;


import com.testgioco.utilities.LogSystem;

import java.util.logging.Level;

public class Main {
    public static void main (String[] args){
        Game game = new Game();
        game.start();
        try {
            LogSystem my_log = new LogSystem("log.txt");

            my_log.logger.setLevel(Level.WARNING);

            my_log.logger.info("Info msg");
            my_log.logger.warning("worning msg");
            my_log.logger.severe("Severe msg");

        } catch (Exception e) {

        }
    }
}
