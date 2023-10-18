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
