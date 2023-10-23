Possono essere viste come una via di mezzo tra una classe e una interfaccia.

**Caratteristiche:**
- Come per le interfacce, le classi astratte **non possono essere istanziate**.
- A differenza delle interfacce, possono avere attributi non statici, metodi non pubblici. 
Parliamo quindi di una classe a tutti gli effetti, ma **non istanziabile**.
- Possono implementare altre interfacce.
- Possono ereditare solamente altri classi astratte!

#### Quando usarle
Non sono istanziabili e sono utilizzabili solo come classi base.\
Lo scopo principale delle classi astratte, è quello di controllare il comportamento delle classi base che le derivano.

#### Metodi astratti
Le classi astratte, possono implementare i normali metodi concreti, ma anche quelli astratti.\
I metodi astratti sono gli stessi che implementi nelle interfacce.

```Java
public abstract Shape {
  private String color;

  public Shape(String color){
    this.color = color;
  }

  // Metodo astratto. Obbligo la classe figlia a implementarlo.
  public abstract double calculateArea();

  // Metodo concreto. E' già pronto all'uso, ma può essere sovrascritto.
  public void PrintColor(){
    System.out.println("Questa forma è di colore: " + this.color);
  }
}
```

### Esempio di dichiarazione
```Java
// Classe astratta che rappresenta un'entità di gioco generica
public abstract class GameEntity {
    private String name;
    private int health;

    public GameEntity(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Metodo astratto per eseguire un'azione specifica dell'entità
    public abstract void performAction();

    // Metodo concreto per ricevere danni
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " ha subito " + damage + " danni. Salute rimanente: " + health);
    }
}
```

### Esempio di utilizzo
Ora, supponiamo di avere due classi concrete che estendono GameEntity - Player (Personaggio) e Enemy (Nemico):

```Java
public class Player extends GameEntity {
    public Player(String name, int health) {
        super(name, health);
    }

    @Override
    public void performAction() {
        System.out.println("Il giocatore " + getName() + " sta eseguendo un'azione.");
    }
}

public class Enemy extends GameEntity {
    public Enemy(String name, int health) {
        super(name, health);
    }

    @Override
    public void performAction() {
        System.out.println("Il nemico " + getName() + " sta eseguendo un'azione.");
    }
}
Ora puoi creare istanze di Player e Enemy e utilizzarle nel tuo gioco:

java
Copy code
public class GameMain {
    public static void main(String[] args) {
        Player player = new Player("Eroe", 100);
        Enemy enemy = new Enemy("Cattivo", 50);

        player.performAction();
        enemy.performAction();

        player.takeDamage(20);
        enemy.takeDamage(30);
    }
}
// In questo esempio, abbiamo utilizzato una classe astratta GameEntity come base per le classi concrete Player e Enemy, 
// consentendo di definire comportamenti comuni e garantendo che ciascuna classe concreta implementi il proprio performAction().
```

### Risorse utilizzate
[HTML.it](https://www.html.it/pag/51820/classi-astratte-in-java/)
