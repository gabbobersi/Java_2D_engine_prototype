package com.tilemapgenerator;

import com.testgioco.core.Vector2DInt;
import com.testgioco.core.interfaces.Scene;
import com.testgioco.core.ui_elements.Button;
import com.testgioco.utilities.GameSettings;
import com.testgioco.utilities.Singletons;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

public class TileMapGenerator extends JPanel implements Scene {
    private final GameSettings settings = new GameSettings();

    //Dimensioni della mappa
    private final int ROWS = 10;
    private final int COLS = 10;

    //Probabilità per la generazione di erba, muri e acqua
    private static final int PROBABILITY_GRASS = 60;
    private static final int PROBABILITY_WALL = 20;
    private static final int PROBABILITY_WATER = 5;

    //Probabilità di generare muri ai bordi
    private static final int PROBABILITY_BORDER_WALL = 90;

    // Costanti per lo stato della mappa
    private static final int GRASS = 0;
    private static final int WALL = 1;
    private static final int WATER = 2;

    //Stato della generazione della mappa
    private boolean generationInProgress = false;
    private boolean generationCompleted = false;
    private final int btnHorizontalAlignment = settings.screenWidth / 2 - 75;
    private final int btnWidth = 150;
    private final int btnHeight = 80;
    private final int bordThickness = 6;
    private final Color btnColor = Color.GRAY;
    private final Font btnFont = new Font("Comic Sans", Font.PLAIN, 25);
    private Button btnGenerate = new Button(this, new Vector2DInt(btnHorizontalAlignment, 100), btnWidth, btnHeight, "Generate",
            bordThickness, btnColor, btnFont);

    public TileMapGenerator() {
        setBackground(Color.WHITE);
        addMouseListener(Singletons.mouseH);
        addMouseMotionListener(Singletons.mouseMotionH);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setPreferredSize(new Dimension(settings.screenWidth, settings.screenHeight));
    }

    public void run() {
        if (btnGenerate.isClicked() && !generationInProgress && !generationCompleted) {
            generationInProgress = true;
            generateAndWriteTileMap();
        }
    }
    private void generateAndWriteTileMap() {
        File file = new File("assets/maps/tmapgen_1.txt");

        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    int randNum = generateRandomNumber(row, col);
                    fileWriter.write(randNum + " ");
                }
                fileWriter.write("\n");
            }
            System.out.println("Generated and written tile map!");
            generationCompleted = true;
        } catch (Exception e) {
            handleException(e);
        } finally {
            generationInProgress = false;
        }
    }

    //Gestisce le eccezioni durante la generazione della mappa
    private void handleException(Exception e) {
        e.printStackTrace();
        //Possibilità di personalizzare questo metodo per gestire le eccezioni in modo più specifico
    }

    //Genera un numero casuale in base alle probabilità specificate
    private int generateRandomNumber(int row, int col) {
        Random rnd = new Random();

        int[] probabilities = {PROBABILITY_GRASS, PROBABILITY_WALL, PROBABILITY_WATER};

        probabilities[0] += Math.abs(row - ROWS / 2) * 2;

        if (isInCenter(row, col)) {
            probabilities[1] = 5;
        }

        if (isAtBorder(row, col) && rnd.nextInt(100) < PROBABILITY_BORDER_WALL) {
            return WALL;
        }

        if (isInCenter(row, col)) {
            return GRASS; //Passaggio
        }

        return getRandomValueBasedOnProbabilities(rnd, probabilities);
    }

    //Genera un numero casuale basato sulle probabilità specificate
    private int getRandomValueBasedOnProbabilities(Random rnd, int[] probabilities) {
        int total = Arrays.stream(probabilities).sum();
        int randomValue = rnd.nextInt(total);

        //Assegna il valore in base alle probabilità
        if (randomValue < probabilities[0]) {
            return 0;
        } else if (randomValue < probabilities[0] + probabilities[1]) {
            return 1;
        } else {
            return 2;
        }
    }

    //Verifica se la posizione è nel centro della mappa
    private boolean isInCenter(int row, int col) {
        return row >= ROWS / 4 && row <= 3 * ROWS / 4 && col >= COLS / 4 && col <= 3 * COLS / 4;
    }

    //Verifica se la posizione è ai bordi della mappa
    private boolean isAtBorder(int row, int col) {
        return col == 0 || col == COLS - 1 || row == 0 || row == ROWS - 1;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        btnGenerate.draw(g2);

        if (generationInProgress && generationCompleted) {
            System.out.println("Generation completed!");
            generationCompleted = false;
        }

        g2.dispose();
    }
}
