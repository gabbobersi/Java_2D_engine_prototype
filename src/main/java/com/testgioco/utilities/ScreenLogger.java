package com.testgioco.utilities;

import com.testgioco.core.interfaces.ui.VisibleUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScreenLogger implements VisibleUI {
    private boolean isVisible = true;
    private boolean canChangeVisibility = true;
    private Vector2DInt positionOnTheScreen;

    private ArrayList<String> commands = new ArrayList<>();
    private ArrayList<String> debugInfo = new ArrayList<>();

    Timer changeVisibilityTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            canChangeVisibility = true;
        }
    });

    public ScreenLogger(Vector2DInt positionOnTheScreen){
        changeVisibilityTimer.setRepeats(false);
        this.positionOnTheScreen = positionOnTheScreen;

        debugInfo.add("Risoluzione: " + GameSettings.screenWidth + " x " + GameSettings.screenHeight);
        debugInfo.add("Numero colonne: " + GameSettings.mapColumnsNumber);
        debugInfo.add("Numero righe: " + GameSettings.mapRowsNumber);
        debugInfo.add("Dimensione cella: " + Constants.cellWidth + " x " + Constants.cellHeight);

        commands.add("========== COMANDI ==========");
        commands.add("> ESC == Menu principale");
        commands.add("> SPACE == Inventario");
        commands.add("> I == Invisibile");

    }

    public void draw(Graphics2D g2){
        if (!isVisible) return;
        int x = positionOnTheScreen.getX();
        int y = positionOnTheScreen.getY();

        g2.setColor(Color.black);
        g2.setFont(new Font("Comic Sans", 1, 15));

        for (int i = 0; i < debugInfo.size(); i++){
            g2.drawString(debugInfo.get(i), x, y + (i * 20));
        }

        for (int i = 0; i < commands.size(); i++){
            g2.drawString(commands.get(i), x, y + (i * 20) + 100);
        }
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean isVisible) {
        if (canChangeVisibility){
            this.isVisible = isVisible;
        }
        canChangeVisibility = false;
        changeVisibilityTimer.start();
    }

    @Override
    public Vector2DInt getPositionOnTheScreen() {
        return null;
    }
}
