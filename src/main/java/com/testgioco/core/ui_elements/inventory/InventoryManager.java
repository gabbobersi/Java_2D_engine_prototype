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
    private int index;

    private int rows;
    private int columns;
    private int slotWidth;
    private int slotHeight;
    private int padding;
    private int margin;

    private int inventoryWidth;
    private int inventoryX;
    private int inventoryY;

    private BufferedImage defaultImage;
    private ButtonImage defaultSlot;
    private ButtonImage selectedSlot;

    private int currentX;
    private int currentY;

    public InventoryManager(JPanel panel, int rows, int columns, int slotWidth, int slotHeight, int padding) {
        this.panel = panel;
        this.rows = rows;
        this.columns = columns;
        this.slotWidth = slotWidth;
        this.slotHeight = slotHeight;
        this.padding = padding;
        this.margin = 10;
        index = 1;

        try {
            defaultImage = ImageIO.read(new File("assets/tiles/not_loaded.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        initSlots();

        inventoryWidth = columns * (slotWidth + padding) - padding;
        inventoryX = settings.screenWidth - inventoryWidth - margin;
        inventoryY = margin;

        currentX = inventoryX;
        currentY = inventoryY;

        defaultSlot = new ButtonImage(panel, new Vector2DInt(100, 100), slotWidth, slotWidth, 5,
                defaultImage);
    }

    private void initSlots() {
        slots = new ArrayList<>();
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = col * (slotWidth + padding);
                int y = row * (slotHeight + padding);

                ButtonImage slot = new ButtonImage(panel, new Vector2DInt(x, y), slotWidth , slotHeight, 4,
                        defaultImage);
                slot.id = counter;
                counter++;
                slots.add(slot);
            }
        }
    }

    public boolean anySlotPressed(){
        selectedSlot = defaultSlot;
        boolean isClicked = false;
        for (ButtonImage slot: slots){
            if (slot.isClicked()){
                selectedSlot = slot;
                isClicked = true;
                break;
            }
        }
        return isClicked;
    }

    public ButtonImage getPressedSlot(){
        return selectedSlot;
    }

    private int getIndexOfLastDrawedSlot(){
        if (index == (rows * columns)){
            currentX = inventoryX;
            currentY = inventoryY;
            index = 1;
            return index;
        }
        index++;
        return index;
    }
    private void drawNextSlot(Graphics2D g2){
        System.out.println("Index: " + index);
        ButtonImage slot = slots.get(getIndexOfLastDrawedSlot() - 1);

        slot.setVector(new Vector2DInt(currentX, currentY));
        slot.draw(g2);

        currentX = slotWidth * (index % columns) + inventoryX;
        if (index % 4 == 0){
            currentX = inventoryX;
            currentY += slotHeight + padding;
        }
    }

    public void draw(Graphics2D g2) {
        drawNextSlot(g2);
    }
}
