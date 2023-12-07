package com.testgioco.core.ui_elements.inventory;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.ui_elements.ButtonImage;
import com.testgioco.core.ui_elements.Image;
import com.testgioco.utilities.GameSettings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private final JPanel panel;
    private List<Slot> slots;

    private final int rows;
    private final int columns;
    private final int slotWidth;
    private final int slotHeight;
    private final int padding;
    private int margin = 5;
    private final Vector2DInt inventoryPosition;
    private Vector2DInt slotPosition = new Vector2DInt(0, 0);
    private int inventoryWidth = 0;

    private boolean isActive = false;
    private boolean canDisable = false;
    private boolean canEnable = true;

    Timer disableTimer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            canEnable = true;
        }
    });

    Timer enableTimer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            canDisable = true;
        }
    });

    public InventoryManager(JPanel panel, int rows, int columns, int slotWidth, int slotHeight, int padding) {
        disableTimer.setRepeats(false);
        enableTimer.setRepeats(false);

        this.panel = panel;
        this.rows = rows;
        this.columns = columns;
        this.slotWidth = slotWidth;
        this.slotHeight = slotHeight;
        this.padding = padding;

        initSlots();
        inventoryWidth = columns * (slotWidth + padding) - padding + margin * 4;
        inventoryPosition = new Vector2DInt(GameSettings.screenWidth - inventoryWidth - margin, margin);
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
                Slot slot = new Slot(panel, new Vector2DInt(x, y), new Dimension(slotWidth, slotHeight), defaultImage);
                slot.setId(counter);
                counter++;
                slots.add(slot);
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (!isActive) {
            return;
        }

        // reset starting position
        slotPosition.setX(inventoryPosition.getX());
        slotPosition.setY(inventoryPosition.getY());

        for (Slot slot : slots) {
            slot.setPosition(new Vector2DInt(slotPosition.getX(), slotPosition.getY()));
            slot.draw(g2);

            slotPosition.setX(slotPosition.getX() + slotWidth + padding);

            if (slot.isClicked()){
                System.out.println("Clicked slot " + slot.getId());
                BufferedImage slotImage;
                try {
                    slotImage = ImageIO.read(new File("assets/tiles/grass_01.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                setItem(slot.getId(), new Item("test", "test", new Image(slotImage)));
            }

            if (slotPosition.getX() >= GameSettings.screenWidth - margin - slotWidth){
                // reset x, increment y
                slotPosition.setX(inventoryPosition.getX());
                slotPosition.setY(slotPosition.getY() + slotHeight + padding);
            }
        }
    }

    public void setItem(int slotId, Item item){
        slots.get(slotId).setItem(item);
    }

    public void removeItem(int slotId){
        slots.get(slotId).setItem(null);
    }

    public void enable(){
        if (isActive){
            return;
        }

        if (canEnable){
            System.out.println("Inventory enabled");
            isActive = true;
            canEnable = false;
            enableTimer.start();
        }
    }

    public void disable(){
        if (!isActive){
            return;
        }

        if (canDisable){
            System.out.println("Inventory disabled");
            isActive = false;
            canDisable = false;
            disableTimer.start();
        }
    }

    public boolean isActive(){
        return isActive;
    }
}
