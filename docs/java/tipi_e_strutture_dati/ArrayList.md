#### ArrayList
Innanzitutto è contenuta nel java.util package a differenza dell'Array, per cui bisognerebbe importarla ogni volta che si usa.
- **Dimensione dinamica**: Gli ArrayList hanno una dimensione dinamica, il che significa che possono crescere o diminuire automaticamente a seconda delle operazioni di inserimento o rimozione.
- **Diversi tipi**: Gli ArrayList possono contenere elementi di diversi tipi poiché utilizzano il concetto di "Object" (oggetto) per memorizzare elementi.
- **Varietà**: Gli ArrayList forniscono una serie di metodi utili per l'inserimento, la rimozione e la ricerca di elementi.

Per scrivere un ArrayList si usa invece la seguente sintassi:
```Java
ArrayList<tipo> nomeArrayList = new ArrayList<tipo>();
```
- **Esempio**:
```Java
// Si importa la classe ArrayList dalla libreria java.util
import java.util.ArrayList;

ArrayList<String> nomi = new ArrayList<String>();

// Aggiunta di elementi all'ArrayList
        nomi.add("Alice");
        nomi.add("Bob");
        nomi.add("Charlie");

// Accesso e stampa di un elemento
        System.out.println("Il secondo elemento dell'ArrayList è: " + nomi.get(1));
```
Nell'ArrayList possiamo inserire e rimuovere gli elementi a nostro piacimento.