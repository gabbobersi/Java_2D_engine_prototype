package com.testgioco;

import com.testgioco.ui_elements.Panel;
import com.testgioco.ui_elements.Window;

public class Game {
    private Panel panel;
    private Window window;
    public Game(){
        this.panel = new Panel();
        this.window = new Window(this.panel);
    }

    public void run(){
        this.panel.run();
    }
}
