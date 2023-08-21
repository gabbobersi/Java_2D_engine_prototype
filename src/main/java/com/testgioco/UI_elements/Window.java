package com.testgioco.UI_elements;

import javax.swing.*;

public class Window {
    final JFrame window;
    public Window(Panel pannello){
        this.window = new JFrame();
        this.window.add(pannello);
        this.window.pack();
        this.window.setSize(620, 480);

        this.window.setTitle("Gioco di esempio");
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
    }
}
