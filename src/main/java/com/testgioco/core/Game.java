package com.testgioco.core;

import com.testgioco.ui_elements.Panel;
import com.testgioco.ui_elements.Window;

public class Game {
    private Panel panel;
    private Window window;
    public Game() {
        panel = new Panel();
        window = new Window(620, 480, panel);
    }

    public void run(){
        panel.run();
    }
}
