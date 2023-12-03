## User Input
La classe Scanner è usata per ottenere un **input** dall'user e rappresenta la soluzione più semplice per realizzare in Java un input
da uno **stream di caratteri.** 

La classe Scanner appartiene al package **java.util** e i suoi
oggetti sono in grado di individuare e interpretare i tipi primitivi e le stringhe presenti
all’interno di uno stream di caratteri. 

Essa presenta diversi **costruttori** che permettono di
ottenere un oggetto di tipo **Scanner** a partire da **oggetti** di altri tipi, quali ad esempio:

- _InputStream_: utile in quei casi in cui, per esempio, si debba leggere da **tastiera** (l’oggetto **System.in** è di tipo **InputStream**).
- _String_: utile in quei casi in cui sia necessario procurarsi degli **input da una stringa**.
- _File_: utile in quei casi in cui l’input proviene da un **file di testo**.

In questo esempio vediamo il metodo **nextLine()**, che viene usato per leggere stringhe:

```Java
import java.util.Scanner;  // Si importa the Scanner class

class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Si crea un oggetto di tipo Scanner
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Si legge l'input dell'utente
        System.out.println("Username is: " + userName);  // Otteniamo l'output dell'utente
    }
}
```

La classe Scanner suddivide lo stream dei caratteri in **token**,
ovvero in spezzoni di _stringhe separate dai **caratteri delimitatori**_.

I **caratteri delimitatori** di default sono:
- **Spazi**
- **Caratteri di tabulazione**: usando il tasto TAB, per gestire un incolonnamento
e non è da non confondersi con il carattere spazio!
- **Caratteri di newline**: per intenderci, il ritorno a capo

Per leggere altri tipi si rimanda alla seguente tabella:

- **nextByte()**: Legge un valore di tipo byte dall'utente
- **nextDouble()**: Legge un numero reale e lo restituisce all'utente, o lancia un eccezione
- di tipo **InputMismatchException** se il token **non** è un reale.
- **nextFloat()**: Legge un valore float dall'utente
- **nextInt()**: Legge un numero di tipo intero e lo restituisce all'utente,
o lancia un eccezione di tipo **InputMismatchException** se il token **non** è un intero.
- **nextLine()**: Legge una riga di testo e la restituisce all'utente.
- **next()**: legge il successivo token **senza delimitatori** e lo restituisce all'utente.
- **nextLong()**: Legge un valore long dall'utente
- **nextShort()**: Legge un valore short dall'utente
- **nextBoolean()**: Legge un valore boolean dall'utente

_Tipi booleani:_
- **hasNextInt()**: restituisce vero se il prossimo token può essere interpretato come un numero intero, altrimenti è falso.
- **hasNextDouble()**: restituisce vero se il prossimo token può essere interpretato come un numero reale, altrimenti è falso.
- **hasNextLine()**: restituisce vero se in input è disponibile una ulteriore riga, altrimenti è falso.
- **hasNext()**: restituisce vero se in input è disponibile un ulteriore token, altrimenti è falso.

Esempio:

```Java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter name, age and salary:");

        // Input String
        String name = myObj.nextLine();

        // Input numerico
        int age = myObj.nextInt();
        double salary = myObj.nextDouble();

        // Output dall'utente
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}
```

```Java
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] argv) {
        int i, j;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Primo numero: ");
            i = scanner.nextInt();
            System.out.print("Secondo numero: ");
            j = scanner.nextInt();
            System.out.println(i + j);
        } catch(InputMismatchException ex) {
            System.out.println("Errore, input non valido.);
        } finally {
            scanner.close();
        }
    }
}
```
Nell’esempio di sopra vengono prelevati da tastiera due numeri e vengono sommati.
Il tutto è stato inserito in un blocco **try-catch-finally** poiché gli input forniti
potrebbero **non essere degli interi** e in tal caso viene lanciata l'eccezione
**InputMismatchException**. 

In questo esempio viene utilizzato anche il metodo **close()**
che permette di rilasciare le risorse occupate dall’oggetto di classe Scanner creato.
