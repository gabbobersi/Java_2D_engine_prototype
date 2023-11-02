package com.testgioco.core.ui_elements;

import com.testgioco.core.Vector2D;

import java.awt.*;

public class Button {
    private Box box = new Box();
    private Label label = new Label(new Vector2D(20, 20),"test");
    private Panel panel;

    public Button(Panel panel){
        this.panel = panel;
        associateSwingComponent();
        setBox();
        setLabel();
    }
    private void associateSwingComponent(){
        panel.add(box);
        panel.add(label.getComponent());
    }
    private void setBox(){
        box.setX(20);
        box.setY(20);
        box.setWidth(200);
        box.setHeight(70);
        box.setThickness(10);
        box.setBoxColor(Color.RED);
    }
    private void setLabel(){
    }
    public void draw(Graphics2D g2){
        box.draw(g2);
        label.draw(g2);
    }
}
