package com.testgioco.core.ui_elements.inventory;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.ui_elements.ButtonImage;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private GameSettings settings = new GameSettings();
    private final JPanel panel;
    private List<ButtonImage> slots;

    private final int rows;
    private final int columns;
    private final int slotWidth;
    private final int slotHeight;
    private final int padding;
    private int margin = 5;
    private Vector2DInt inventoryPosition;
    private Vector2DInt slotPosition = new Vector2DInt(0, 0);
    private int inventoryWidth = 0;

    public InventoryManager(JPanel panel, int rows, int columns, int slotWidth, int slotHeight, int padding) {
        this.panel = panel;
        this.rows = rows;
        this.columns = columns;
        this.slotWidth = slotWidth;
        this.slotHeight = slotHeight;
        this.padding = padding;

        initSlots();
        inventoryWidth = columns * (slotWidth + padding) - padding;
        inventoryPosition = new Vector2DInt(settings.screenWidth - inventoryWidth - margin, margin);
    }

    private void initSlots() {
        slots = new ArrayList<>();
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = col * (slotWidth + padding);
                int y = row * (slotHeight + padding);
                BufferedImage defaultImage;
                try {
                    defaultImage = ImageIO.read(new File("assets/tiles/not_loaded.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ButtonImage slot = new ButtonImage(panel, new Vector2DInt(x, y), slotWidth , slotHeight, 4, defaultImage);
                slot.id = counter;
                counter++;
                slots.add(slot);
            }
        }
    }

    public void draw(Graphics2D g2) {
        // reset starting position
        slotPosition.setX(inventoryPosition.getX());
        slotPosition.setY(inventoryPosition.getY());

        for (ButtonImage slot : slots) {
            slot.setVector(new Vector2DInt(slotPosition.getX(), slotPosition.getY()));
            slot.draw(g2);

            slotPosition.setX(slotPosition.getX() + slotWidth + padding);

            if (slot.isClicked()){
                System.out.println("Clicked slot " + slot.id);
            }

            if (slotPosition.getX() >= settings.screenWidth - margin) {
                // reset x, increment y
                slotPosition.setX(inventoryPosition.getX());
                slotPosition.setY(slotPosition.getY() + slotHeight + padding);
            }
        }
    }
}
