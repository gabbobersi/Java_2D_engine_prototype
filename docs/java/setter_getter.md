## _**Metodi Setter & Getter**_ 
***
#### Incapsulamento
Si intende, che i dati "sensibili" siano nascosti agli utenti. Per raggiungere questo obiettivo, è necessario:

- Dichiarare le variabili/attributi di classe come privati.
- Fornire **metodi pubblici di get e set** per accedere e aggiornare il valore di una variabile privata.
***
### Ora possiamo procedere per i metodi Setter e Getter
Dunque le **_variabili private_** possono essere accessibili solo all'interno 
della stessa classe (una classe esterna non ha accesso ad esse). \
Tuttavia, è possibile accedervi fornendo metodi pubblici di get e set.
Il metodo "get" restituisce il valore 
della variabile, mentre il metodo "set" ne imposta il valore.

La sintassi per entrambi è che iniziano con "get" o "set", seguiti dal nome della variabile, con la prima lettera in maiuscolo.
``` Java
public class Person {
private String name; // private = restricted access
    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
    this.name = newName;
    }
}
```

Il metodo **_"get"_** restituisce il valore della variabile "name".
\
Il metodo **_"set"_** prende un parametro (newName) e lo assegna alla variabile "name". La parola chiave "this" viene utilizzata per fare riferimento all'oggetto corrente.


**NB**: \
**Tuttavia, poiché la variabile "name" è dichiarata come privata, non possiamo accedervi dall'esterno di questa classe.**
***
### Altro Esempio
``` Java
public class Main {
    public static void main(String[] args) {
        Person myObj = new Person();
        myObj.name = "Francesco";  // error
        System.out.println(myObj.name); // error
    }
}
```
Se la variabile fosse stata dichiarata come **pubblica**, ci aspetteremmo il seguente output:

``` Output
Francesco
```

Invece, se fosse stata dichiarata come **privata**, avremmo un errore:

``` Code
MyClass.java:4: error: name has private access in Person
    myObj.name = "Francesco";
         ^
MyClass.java:5: error: name has private access in Person
    System.out.println(myObj.name);
                  ^
2 errors 
```
Tuttavia, se usassimo getName() e setName() (metodi) per accedere ed aggiornare le variabili:
``` Java
public class Main {
    public static void main(String[] args) {
        Person myObj = new Person();
        myObj.setName("Francesco"); // Set the value of the name variable to "Francesco"
        System.out.println(myObj.getName());
    }
}

// Outputs "Francesco"
```
***
### Concludiamo
Perchè usare incapsulamento?

- Miglior controllo degli attributi e dei metodi della classe;
- Gli attributi della classe possono essere resi solo in lettura (se si utilizza solo il metodo "get") o solo in scrittura (se si utilizza solo il metodo "set");
  
- Flessibilità: il programmatore può modificare una parte del codice senza influenzare altre parti;
 
- Maggiore sicurezza dei dati.
***