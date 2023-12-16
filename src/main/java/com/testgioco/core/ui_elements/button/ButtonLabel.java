package com.testgioco.core.ui_elements.button;

import com.testgioco.core.audio.AudioMaster;
import com.testgioco.core.interfaces.Interactive;
import com.testgioco.core.interfaces.ui.VisibleUI;
import com.testgioco.core.ui_elements.Label;
import com.testgioco.core.ui_elements.box.BoxColor;
import com.testgioco.utilities.Vector2DInt;

import java.awt.*;

public class ButtonLabel extends BaseButton implements VisibleUI, Interactive {
    private final BoxColor boxColor;
    private final Label label;
    private boolean audioOverPlayed = false;
    private boolean audioClickedPlayer = false;

    public ButtonLabel(Vector2DInt positionOnTheScreen, int width, int height, String text, int bordThickness,
                  Color buttonColor, Font font){
        super(positionOnTheScreen, width, height, bordThickness, buttonColor, font);
        boxColor = new BoxColor(positionOnTheScreen, width, height, bordThickness, buttonColor);
        label = new Label(positionOnTheScreen, text, font, Color.BLACK);
        update();
    }
    private void setBox(){
        boxColor.setX(positionOnTheScreen.getX());
        boxColor.setY(positionOnTheScreen.getY());
        boxColor.setWidth(width);
        boxColor.setHeight(height);
        boxColor.setThickness(bordThickness);
        boxColor.setColor(buttonColor);
    }

    private void setLabel(){
        FontMetrics fontMetrics = new Canvas().getFontMetrics(label.getFont());

        int textWidth = fontMetrics.stringWidth(label.getText());
        int midLabelWidth = (int)Math.round((double)textWidth / 2);
        int xPos = positionOnTheScreen.getX() + width / 2 - midLabelWidth;

        int textHeight = fontMetrics.getDescent() + fontMetrics.getDescent() + fontMetrics.getLeading();
        int midLabelHeight = textHeight / 2;
        int yPos = positionOnTheScreen.getY() + height / 2 + midLabelHeight;

        Vector2DInt label_vector = new Vector2DInt(xPos, yPos);
        label.setVector(label_vector);
    }

    public void draw(Graphics2D g2){
        if (hasBeenPressed()){
            boxColor.setColor(Color.BLUE);
            if (!audioClickedPlayer){
                // AudioMaster.play("assets/audio/buttons/btn_clicked_1.wav");
                audioClickedPlayer = true;
            }
        } else {
            boxColor.setColor(buttonColor);
            audioClickedPlayer = false;
        }

        if (hasMouseOver()){
            label.setColor(Color.ORANGE);
            if (!audioOverPlayed){
                AudioMaster.play("assets/audio/buttons/btn_over_1.wav");
                audioOverPlayed = true;
            }
        } else {
            label.setColor(Color.BLACK);
            audioOverPlayed = false;
        }

        boxColor.draw(g2);
        label.draw(g2);
    }

    public String getText(){
        return label.getText();
    }

    /**
     * Updates ButtonLabel's elements.
     * */
    private void update(){
        setBox();
        setLabel();
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public Vector2DInt getPositionOnTheScreen() {
        return positionOnTheScreen;
    }

    @Override
    public boolean hasBeenPressed() {
        return mouseInteractivityManager.hasBeenPressed();
    }

    @Override
    public boolean hasBeenClicked() {
        return mouseInteractivityManager.hasBeenClicked();
    }

    @Override
    public boolean hasMouseOver() {
        return mouseInteractivityManager.hasMouseOver();
    }
}
