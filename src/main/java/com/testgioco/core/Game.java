package com.testgioco.core;

import com.testgioco.ui_elements.Panel;
import com.testgioco.ui_elements.Window;
import com.testgioco.utilities.GameSettings;

public class Game {
    private GameSettings settings = new GameSettings();
    private Panel panel;
    private Window window;
    public Game() {
        panel = new Panel();
        window = new Window(panel);
    }

    public void run(){
        panel.run();
    }
}
