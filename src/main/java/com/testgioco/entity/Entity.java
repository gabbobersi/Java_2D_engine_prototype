package com.testgioco.entity;

public class Entity {
    public String name;     // Es. "Laradiel Umbria", "Alessio Trap", "Harry Potter".
    public String type;     // Es. "Gnomo dei boschi", "Elfo", "Giocatore", "Arbusto")
    public int x, y;        // Coordinate della "sprite" (immagine di questa entità)
    public int speed;       // Velocità di movimento
    public double life;     // Vita. Da 0 a 100
}
