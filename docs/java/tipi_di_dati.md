# Tipi di dati in Java
I dati sono elementi fondamentali nella programmazione, e Java, come linguaggio di programmazione, offre diversi tipi di dati che consentono di rappresentare e manipolare informazioni in modi diversi. 
I tipi di dati in Java possono essere suddivisi in **due categorie** principali: **tipi di dati primitivi** e **tipi di dati di riferimento**.

Ecco una spiegazione dettagliata dei tipi di dati in Java con esempi approfonditi per ciascuno:

## Tipi di dati primitivi:

1. **Tipi numerici**:
- **byte**: Il tipo di dati byte rappresenta un numero intero con segno a 8 bit. Questo significa che può rappresentare valori compresi tra -128 e 127.
    - Utilizza 1 byte
  Ad esempio:
```java 
byte eta = 30; // Rappresenta l'età come un valore byte.
```
- **short**: Il tipo di dati short rappresenta un numero intero con segno a 16 bit. Questo consente di rappresentare valori compresi tra -32,768 e 32,767.
    - Utilizza 2 byte
Ad esempio:
```java
short popolazioneCitta = 25000; // Rappresenta la popolazione di una città come un valore short.
 ```
- **long**: Il tipo di dati long rappresenta un numero intero con segno a 64 bit. Questo consente di rappresentare valori molto grandi o molto piccoli.
    - Utilizza 8 byte 
Ad esempio:
```java
long popolazioneMondiale = 7_900_000_000L; // Nota la "L" alla fine per indicare che è di tipo long
```
- **int**: Questo tipo di dato viene utilizzato per rappresentare numeri interi, ad esempio contatori, età, ecc.
    - Utilizza 4 byte 
```Java
int numeroIntero = 42;
```
- **short int**: Questo è un tipo di dati intero più breve, che rappresenta numeri interi con segno a 16 bit. 
Ad esempio:
```java
short int codiceProdotto = 12345;
```
### Numerici a virgola mobile:
- **float**: Il tipo di dati float rappresenta un numero a virgola mobile a 32 bit. È utilizzato per rappresentare valori approssimati con decimali.
    - Utilizza 4 byte
Ad esempio:
```java
float altezza = 1.75f; // Nota la "f" alla fine per indicare che è di tipo float
```
- **double**: Questo tipo di dato rappresenta numeri decimali (a virgola mobile) e viene utilizzato per calcoli con precisione decimale.
    - Utilizza 8 byte 
```Java
double numeroDecimale = 3.14159;
```
2. **Tipo booleano**:

- **boolean**: Questo tipo di dato può avere solo due valori: true o false ed è spesso utilizzato per le decisioni condizionali.
    - Il numero di byte utilizzato per rappresentare un valore booleano può variare secondo l'implementazione specifica di Java, ma di solito è molto piccolo, spesso meno di 1 byte. In pratica, un booleano potrebbe utilizzare solo 1 bit per rappresentare i valori true o false, ma è comune che venga arrotondato a 1 byte per l'allineamento dei dati.
```Java
boolean isLavoroFinito = true;
```
3. **Tipo carattere**:
- **char**: Questo tipo di dato rappresenta un singolo carattere Unicode, come lettere o simboli.
   - Utilizza 2 byte 
```Java
char carattere = 'A';
```
_Tieni presente che la dimensione in byte dei tipi di dati primitivi può variare leggermente tra diverse implementazioni di Java o architetture hardware, ma queste dimensioni sono le più comuni su molte piattaforme. La dimensione dei tipi di dati primitivi è importante per l'ottimizzazione della memoria e per garantire che i dati vengano memorizzati correttamente nella memoria del computer._

## Tipi di dati di riferimento:

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
Questo aiuta a garantire la sicurezza del tipo e la precisione nei calcoli. La scelta del tipo di dato appropriato dipenderà dal tipo di informazione che si vuole rappresentare o manipolare nel programma.