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
    private JPanel panel;
    private List<ButtonImage> slots;
    private int rows;
    private int columns;
    private int slotWidth;
    private int slotHeight;
    private int padding;
    private int margin;

    private int inventoryWidth;
    private int inventoryX;
    private int inventoryY;

    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);

    public InventoryManager(JPanel panel, int rows, int columns, int slotWidth, int slotHeight, int padding) {
        this.panel = panel;
        this.rows = rows;
        this.columns = columns;
        this.slotWidth = slotWidth;
        this.slotHeight = slotHeight;
        this.padding = padding;
        this.margin = 10;
        initSlots();

        inventoryWidth = columns * (slotWidth + padding) - padding;
        inventoryX = settings.screenWidth - inventoryWidth - margin;
        inventoryY = margin;
    }

    private void initSlots() {
        slots = new ArrayList<>();
        BufferedImage defaultImage;
        try {
            defaultImage = ImageIO.read(new File("assets/tiles/grass_01.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = col * (slotWidth + padding);
                int y = row * (slotHeight + padding);

                ButtonImage slot = new ButtonImage(panel, new Vector2DInt(x, y), slotWidth , slotHeight, 4,
                        defaultImage);
                slots.add(slot);
            }
        }
    }

    public void draw(Graphics2D g2) {
        int currentX = inventoryX;
        int currentY = inventoryY;

        for (ButtonImage slot : slots) {
            slot.setVector(new Vector2DInt(currentX, currentY));
            slot.draw(g2);

            currentX += slotWidth + padding;

            if (currentX >= inventoryX + inventoryWidth) {
                currentX = inventoryX;
                currentY += slotHeight + padding;
            }
        }
    }
}
