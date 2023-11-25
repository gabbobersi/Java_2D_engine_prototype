package com.testgioco.core.ui_elements.inventory;

import com.testgioco.core.Vector2DInt;
import com.testgioco.utilities.GameSettings;
import com.testgioco.core.ui_elements.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private GameSettings settings = new GameSettings();
    private JPanel panel;
    private List<Button> slots;
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

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = col * (slotWidth + padding);
                int y = row * (slotHeight + padding);

                Button slot = new Button(panel, new Vector2DInt(x, y), slotWidth , slotHeight, "", 4,
                        Color.GRAY, btnFont);
                slots.add(slot);
            }
        }
    }

    public void draw(Graphics2D g2) {
        int currentX = inventoryX;
        int currentY = inventoryY;

        for (Button slot : slots) {
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
