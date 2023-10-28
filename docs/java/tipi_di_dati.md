# Tipi di dati in Java
I dati sono elementi fondamentali nella programmazione, e Java, come linguaggio di programmazione, offre diversi tipi di dati che consentono di rappresentare e manipolare informazioni in modi diversi.
I tipi di dati in Java possono essere suddivisi in **due categorie** principali: **tipi di dati primitivi** e **tipi di dati di riferimento**.

Ecco una spiegazione dettagliata dei tipi di dati in Java con esempi approfonditi per ciascuno:

## Tipi di dati primitivi:
| Tipo      | Numero byte           | Esempio                                    |
|-----------|-----------------------|--------------------------------------------|
| Byte      | 1 byte                | byte eta = 30;                             |
| Short     | 2 byte                | short popolazioneCitta = 255;            |
| Long      | 8 byte                | long popolazioneMondiale = 7_900_000_000L; |
| Int       | 4 byte                | int numeroIntero = 42;                     |
| Short Int | 4 byte                | short int codiceProdotto = 12345;          |
| Float     | 4 byte                | float altezza = 1.75f;                     |
| Double    | 8 byte                | double numeroDecimale = 3.14159;           |
| Boolean   | spesso meno di 1 byte | boolean isLavoroFinito = true;             |
| Char      | 2 byte                | char carattere = 'A';                      |

_Tieni presente che la dimensione in byte dei tipi di dati primitivi può variare leggermente tra diverse implementazioni di Java o architetture hardware, ma queste dimensioni sono le più comuni su molte piattaforme. La dimensione dei tipi di dati primitivi è importante per l'ottimizzazione della memoria e per garantire che i dati vengano memorizzati correttamente nella memoria del computer._

## Tipi di dati di riferimento:

| Tipo                    |
|-------------------------|
| String                  |
| Array                   |
| Oggetto                 |
| Classi personalizzate   |
| Enumerazioni            |
| Wrapper                 |
| Array multidimensionali |

1. **Tipo stringa**:

- **String**: Una stringa è una sequenza di caratteri e rappresenta testo. È uno dei tipi di dati più comuni in Java.
  - Il tipo String è una classe e la dimensione effettiva in memoria varia in base alla lunghezza della stringa, ma solitamente è di circa 16 byte più 2 byte per ogni carattere **Unicode**.

_N.d.A: I caratteri Unicode sono una standardizzazione internazionale per la rappresentazione di caratteri e simboli di tutte le lingue scritte del mondo. Unicode fornisce un sistema di codifica che assegna a ogni carattere un numero unico chiamato "punto di codice Unicode". Questi punti di codice possono essere espressi come valori esadecimali preceduti da "U+"._
```Java
String nome = "Alice";
```
2. **Tipo array**:
- Gli array in Java consentono di archiviare più valori dello stesso tipo in una singola struttura.
  - Gli array utilizzano una quantità di memoria che dipende dalla loro dimensione e dal tipo di dati contenuti. Ad esempio, un array di int richiede 4 byte per ogni elemento, mentre un array di double richiede 8 byte per ogni elemento.
```Java
int[] numeri = {1, 2, 3, 4, 5};
```
3. **Tipo oggetto**:

- Gli oggetti in Java sono istanze di classi e possono rappresentare entità complesse con attributi e comportamenti.
```Java
// Definizione di una classe Persona
class Persona {
String nome;
int età;
}

// Creazione di un oggetto Persona
Persona persona1 = new Persona();
persona1.nome = "John";
persona1.età = 30;
```
4. **Classi personalizzate**:
- Puoi creare classi personalizzate per rappresentare oggetti specifici con attributi e metodi personalizzati.
```java
class Persona {
    String nome;
    int eta;
    
    // Metodo personalizzato
    void saluta() {
        System.out.println("Ciao, sono " + nome);
    }
}

Persona alice = new Persona();
alice.nome = "Alice";
alice.eta = 30;
alice.saluta();
```

5. **Enumerazioni**:
- **enum**: Un tipo speciale di dato utilizzato per rappresentare un insieme finito di costanti.
  - Le enumerazioni sono generalmente piccole e occupano una quantità fissa di memoria, ma la dimensione esatta può variare a seconda di come vengono utilizzate.
```java
enum GiorniDellaSettimana {
    LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA
}

GiorniDellaSettimana giorno = GiorniDellaSettimana.LUNEDI;
```

6. **Tipi di dati wrapper**:
- Integer, Double, Boolean, ecc.: Questi tipi di dati di riferimento avvolgono i tipi primitivi corrispondenti e forniscono funzionalità aggiuntive.
  - Questi tipi di dati wrapper sono oggetti e occupano più memoria rispetto ai tipi primitivi corrispondenti. Ad esempio, Integer utilizza di solito 16-20 byte, mentre int primitivo utilizza solo 4 byte.
```java
Integer numeroIntero = 42;
System.out.println(numeroIntero.toString());
```

7. **Tipi di dati array multidimensionali**:
- Gli array multidimensionali memorizzano dati in più dimensioni.
  - Le dimensioni degli array multidimensionali dipendono dalla loro struttura e dai tipi di dati contenuti in ciascuna dimensione.
```java int[][] matrice = {{1, 2, 3}, {4, 5, 6}};
double[][][] cubo = {{{1.0, 2.0}, {3.0, 4.0}}, {{5.0, 6.0}, {7.0, 8.0}}};
```

Questi sono alcuni dei tipi di dati fondamentali in Java. Java è un linguaggio fortemente tipizzato, il che significa che è necessario dichiarare il tipo di dato prima di utilizzare una variabile.
La scelta del tipo di dato appropriato dipenderà dal tipo di informazione che si vuole rappresentare o manipolare nel programma.
