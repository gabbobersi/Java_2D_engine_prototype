# Construttori
***

I costruttori sono metodi speciali chiamati quando
un _**oggetto**_  viene creato e vengono utilizzati per **inizializzarli**.

Un costruttore può essere utilizzato per fornire valori iniziali per gli attributi dell'oggetto.

- Il nome di un costruttore deve essere uguale al nome della classe.

- Un costruttore non deve avere un tipo di ritorno esplicito.

***
***Piccolo Esempio:***
``` Java
public class Vehicle {
  private String color;
  Vehicle() {
     color = "Red";
  }
}
```
Il metodo **_Vehicle()_** è il costruttore della nostra classe,
quindi ogni volta che **viene creato** un oggetto di quella classe,
l'attributo color verrà impostato su "Red".
***
Un costruttore può anche _**accettare parametri**_ per inizializzare gli attributi.

```Java
public class Vehicle {
    private String color;
    Vehicle(String c) {
        color = c;
    }
}
```
***
Il costruttore viene chiamato quando si crea un oggetto utilizzando la _**parola chiave 'new'**_.
Esempio:
```Java
public class MyClass {
    public static void main(String[ ] args) {
        Vehicle v = new Vehicle("Blue");
    }
}
```
***


Una singola _classe_ può avere _diversi_ **costruttori** con un numero _diverso_ di **parametri**.

I metodi **_setter_** all'interno dei costruttori possono essere utilizzati per impostare i valori degli attributi.
```Java
public class Vehicle {
  private String color;

  Vehicle() {
    this.setColor("Red");
  }
  Vehicle(String c) {
    this.setColor(c);
  }

  // Setter
  public void setColor(String c) {
    this.color = c;
  }
}
```
La classe sopra **ha due costruttori**, uno senza alcun parametro
che imposta l'attributo color a un valore predefinito di "Red",

e un altro costruttore che accetta un parametro e lo assegna all'attributo.

Ora possiamo utilizzare i costruttori per creare oggetti della nostra classe.
***
