package com.testgioco.core;

import com.testgioco.core.handlers.InputHandler;
import com.testgioco.core.tile.TileManager;
import com.testgioco.entities.Player;
/*
Calcolo della posizione futura del giocatore: Utilizza le variabili futureX e futureY
per rappresentare la posizione
futura del giocatore in base
alla direzione di input fornita
 dall'InputHandler e alla velocità del giocatore (player.speed).

 */
public class CollisionManager {
    private static final int TILE_INDEX_OF_WALL = 1;
    private Cell cell = new Cell();
    private TileManager tileManager;
    private InputHandler inputHandler;
    private Player player;
    private int [][]tileMap;

    public CollisionManager(TileManager tileManager, Player player, InputHandler inputHandler) {
        this.tileManager = tileManager;
        this.inputHandler = inputHandler;
        this.player = player;
    }

    /**
     This code snippet defines a method called canMove() that determines whether
     the player can move in a certain direction based on input from an inputHandler.
     It calculates the future player position (futureX and futureY) based on the current position,
     speed, and the input received. It then calculates the future tile position
     (futureTileColumn and futureTileRow) based on the future player
     position and the size of the tiles. Finally, it calls another
     method canMoveToTile()
     to check if the movement
     will collide with a wall, and returns the result.
     */

    /**
     * Determines if the player can move in the specified direction.
     *
     * @return  true if the player can move, false otherwise.
     */

    public boolean canMove() {
        int futureX = player.positionOnTheMap.getX() - cell.width / 2;
        int futureY = player.positionOnTheMap.getY() - cell.height / 2;

        if (inputHandler.upPressed) {
            futureY -= cell.height;
        }
        if (inputHandler.downPressed) {
            futureY += cell.height;;
        }
        if (inputHandler.leftPressed) {
            futureX -= cell.width;
        }
        if (inputHandler.rightPressed) {
            futureX += cell.width;
        }

        int futureTileColumn = futureX / cell.width;
        int futureTileRow = futureY / cell.height;

        // Controlla se il movimento colpisce un muro
        return canMoveToTile(futureTileRow, futureTileColumn, futureX, futureY);
    }

    /*
     This code snippet defines a method called canMoveToTile that checks
     if a player can move to a specific tile on a game map.
     It first checks if the tile coordinates are within the bounds of the game map.
     If not, it returns false. Next, it checks if the tile at the given coordinates is a wall tile.
     If it is, it calculates the width and height of the player and checks
     if the player's future position overlaps with the wall tile.
     Finally, it returns true if the
     player can move to the tile
     (i.e., it does not collide with a wall), and false otherwise.
     */
    /**
     * Determines if the player can move to the specified tile.
     *
     * @param  tileRow     the row of the tile being checked
     * @param  tileColumn  the column of the tile being checked
     * @param  futureX     the future x-coordinate of the player
     * @param  futureY     the future y-coordinate of the player
     * @return             true if the player can move to the tile, false otherwise
     */

    private boolean canMoveToTile(int tileRow, int tileColumn, int futureX, int futureY) {
        tileMap = tileManager.getTileMap();

        boolean withinBounds = tileRow >= 0 && tileRow < tileMap.length &&
                tileColumn >= 0 && tileColumn < tileMap[0].length;

        if (!withinBounds) {
            return false;
        }

        int tileX = tileColumn * cell.width;
        int tileY = tileRow * cell.height;

        int [][] tileMap = tileManager.getTileMap();
        boolean collides = tileMap[tileRow][tileColumn] == TILE_INDEX_OF_WALL;

        int playerWidth = cell.width; // Ottieni la larghezza del giocatore
        int playerHeight = cell.height; // Ottieni l'altezza del giocatore

        // Verifica se il personaggio si sovrappone al tile del muro considerando un offset
        boolean collidesWithWall = futureX + playerWidth > tileX &&
                futureX < tileX + cell.width &&
                futureY + playerHeight > tileY &&
                futureY < tileY + cell.height;

        return !collides || !collidesWithWall;
    }
}