package com.testgioco.entities.collision_manager;


import com.testgioco.core.TileManager;
import com.testgioco.core.handlers.InputHandler;
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
    private TileManager tileManager;
    private Player player;
    private InputHandler inputHandler;

    public CollisionManager(TileManager tileManager, Player player, InputHandler inputHandler) {
        this.tileManager = tileManager;
        this.player = player;
        this.inputHandler = inputHandler;
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
        int futureX = player.positionOnTheMap.getX();
        int futureY = player.positionOnTheMap.getY();
        int tileSize = tileManager.cell.width;

        if (inputHandler.upPressed) {
            futureY -= player.speed;
        }
        if (inputHandler.downPressed) {
            futureY += player.speed;
        }
        if (inputHandler.leftPressed) {
            futureX -= player.speed;
        }
        if (inputHandler.rightPressed) {
            futureX += player.speed;
        }

        int futureTileColumn = futureX / tileSize;
        int futureTileRow = futureY / tileSize;

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
        boolean withinBounds = tileRow >= 0 && tileRow < tileManager.mapTileNum.length &&
                tileColumn >= 0 && tileColumn < tileManager.mapTileNum[0].length;

        if (!withinBounds) {
            return false;
        }

        int tileX = tileColumn * tileManager.cell.width;
        int tileY = tileRow * tileManager.cell.height;

        boolean collides = tileManager.mapTileNum[tileRow][tileColumn] == TILE_INDEX_OF_WALL;

        int playerWidth = player.getPlayerWidth(); // Ottieni la larghezza del giocatore
        int playerHeight = player.getPlayerHeight(); // Ottieni l'altezza del giocatore

        // Verifica se il personaggio si sovrappone al tile del muro considerando un offset
        boolean collidesWithWall = futureX + playerWidth > tileX &&
                futureX < tileX + tileManager.cell.width &&
                futureY + playerHeight > tileY &&
                futureY < tileY + tileManager.cell.height;

        return !collides || !collidesWithWall;
    }


}