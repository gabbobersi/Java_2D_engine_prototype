## Cos'è uno Stream?
Sono contenuti nel package java.util.stream che comprende una serie di classi per gestire delle sequenze di elementi.

Gli Stream in Java vanno visti come un nastro trasportatore che lavora con una serie di oggetti, come numeri o parole, uno alla volta, in modo efficiente.

Consentono di eseguire operazioni come la **trasformazione**, il **filtraggio** e la **riduzione** dei dati in modo dichiarativo. 

Non memorizzano i dati, ma piuttosto definiscono una serie di operazioni da eseguire sui dati sorgente: questo li rende efficienti per elaborare grandi quantità di dati senza doverli memorizzare completamente in memoria.

## Concetto di collectors
I collectors sono parte del framework di stream in Java e sono utilizzati per eseguire **operazioni** su un flusso di dati, come la **somma**, la **media** o la **raccolta** in una collezione. Sono spesso usati insieme agli stream per elaborare dati in modo efficiente.

Esempio:
```Java
// Creare uno stream di numeri interi
Stream<Integer> numeri = Stream.of(1, 2, 3, 4, 5);

// Usare un collector per sommare i numeri
int somma = numeri.collect(Collectors.summingInt(Integer::intValue));

System.out.println(somma); // Stampa 15 (1 + 2 + 3 + 4 + 5)
```

### Esempi con gli Stream
- #### Esempio n.1: Filtrare una lista di numeri pari
Da una lista di numeri vogliamo avere solo quelli pari dalla lista:
```Java
List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> numeriPari = numeri.stream()
        .filter(numero -> numero % 2 == 0)
        .collect(Collectors.toList());

        System.out.println(numeriPari);
```
In questo esempio, abbiamo creato uno Stream dalla lista di numeri, quindi abbiamo applicato un filtro che seleziona solo i numeri pari. Infine, abbiamo raccolto i risultati in una nuova lista chiamata numeriPari. Il risultato sarà [2, 4, 6, 8, 10].

- #### Esempio n.2: Mappare una lista di stringhe in maiuscolo
Da una lista di stringhe e voglio trasformarle tutte in maiuscolo:
```Java
List<String> parole = Arrays.asList("casa", "auto", "albero", "computer");

        List<String> maiuscole = parole.stream()
        .map(parola -> parola.toUpperCase())
        .collect(Collectors.toList());

        System.out.println(maiuscole);
```
In questo caso, stiamo creando uno Stream dalla lista di stringhe, quindi stiamo trasformando ogni stringa in maiuscolo con un metodo chiamato *toUpperCase()*. Alla fine, otteniamo una nuova lista chiamata maiuscole con le stringhe in maiuscolo. Il risultato sarà ["CASA", "AUTO", "ALBERO", "COMPUTER"].

### Alcuni metodi nello Stream

- **.filter(Predicate<T> predicate)**: Questo metodo crea un nuovo Stream che contiene solo gli elementi che soddisfano il predicato specificato. Ad esempio:
```Java
List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numeriPari = numeri.stream()
        .filter(numero -> numero % 2 == 0)
        .collect(Collectors.toList());
```
Questo creerà uno Stream contenente solo i numeri pari.
- **.map(Function<T, R> mapper)**: Questo metodo trasforma ogni elemento dello Stream applicando una funzione specificata e restituisce un nuovo Stream contenente i risultati della trasformazione. Ad esempio:
```Java
List<String> parole = Arrays.asList("casa", "auto", "albero");
        List<Integer> lunghezze = parole.stream()
        .map(parola -> parola.length())
        .collect(Collectors.toList());
```
Questo creerà uno Stream contenente le lunghezze delle parole.

- **.collect(Collector<T, A, R> collector)**: Questo metodo raccoglie gli elementi dello Stream in una struttura dati specificata, come una lista, un set o una mappa, utilizzando un oggetto Collector personalizzato. Ad esempio:
```Java
List<String> parole = Arrays.asList("casa", "auto", "albero");
Set<String> setParole = parole.stream()
        .collect(Collectors.toSet());
```