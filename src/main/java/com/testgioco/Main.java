package com.testgioco;

import com.testgioco.entity.Player;

public class Main {
    public static void main (String[] args){
        System.out.println("Gioco iniziato");
        new Game();
        System.out.println("Gioco terminato corretamente.");

        Player player1 = new Player();
        Player player2 = new Player("pippo", "Giocatore", 50, 50, 10, 100);
        System.out.println(player1.name);
        System.out.println(player2.name);

    }



}
