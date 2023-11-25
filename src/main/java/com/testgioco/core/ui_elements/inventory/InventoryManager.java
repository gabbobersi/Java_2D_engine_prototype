package com.testgioco.core.ui_elements.inventory;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.ui_elements.Box;
import com.testgioco.utilities.GameSettings;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Box> slots;
    private int rows;
    private int columns;
    private int slotWidth;
    private int slotHeight;
    private int padding;
    private int margin;

    public InventoryManager(int rows, int columns, int slotWidth, int slotHeight, int padding) {
        this.rows = rows;
        this.columns = columns;
        this.slotWidth = slotWidth;
        this.slotHeight = slotHeight;
        this.padding = padding;
        this.margin = 10;
        initSlot();
    }

    private void initSlot() {
        slots = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = col * (slotWidth + padding);
                int y = row * (slotHeight + padding);

                Box slot = new Box(new Vector2DInt(x, y), slotWidth, slotHeight, 2, Color.GRAY);
                slots.add(slot);
            }
        }
    }

    public void draw(Graphics2D g2, GameSettings settings) {
        int inventoryWidth = columns * (slotWidth + padding) - padding;

        int inventoryX = settings.screenWidth - inventoryWidth - margin;
        int inventoryY = margin;

        int currentX = inventoryX;
        int currentY = inventoryY;

        for (Box slot : slots) {
            slot.setX(currentX);
            slot.setY(currentY);

            slot.draw(g2);

            currentX += slotWidth + padding;

            if (currentX >= inventoryX + inventoryWidth) {
                currentX = inventoryX;
                currentY += slotHeight + padding;
            }
        }
    }
}
