Il file sottostante è diviso in 4 parti:
1. Modalità per aggiungere variabili/classi al codice.
2. Struttura codice.
3. Naming convention
4. Quiz
****
Ci sono 3 tipi di modi per aggiungere una variabile a un programma:
- Dichiarazione
- Definizione
- Inizializzazione

### Dichiarazione
```Java
int x;
```
### Definizione
```Java
int x;          // Dichiaro
x = 5;          // Definisco
```
### Inizializzazione
```Java
int x = 5;      // Dichiaro e definisco in una riga == inizializzo
```

I tipi sopra valgono anche per le classi, esempio:
```Java
Build build;                // Dichiaro
build = new Build();        // Definisco (o istanzio)
House house = new House();  // Inizializzo (o istanzio)
```
****
## Capiamo la struttura del codice
In Java, le variabili di dichiarano in questo modo:

`[ TIPO ]` `[ IDENTIFICATIVO ]`

Esempio:
```Java
int x;          // int è il tipo, x è l'identificativo della variabile.
```
Lo stesso vale per le classi:
```Java
Build build;    // Build è il tipo (o classe), build è l'identificativo.
```
****
## Naming convention
Ogni linguaggio ha delle "naming convention". \
Esse non sono altro che regole (delle convenzioni) che la community in tale linguaggio 
ha stabilito, per identificare in modo chiaro variabili, metodi, classi.

Ecco sotto le naming convention in Java:
```Java
int sonoUnaVariabile;           // Lettera minuscola iniziale, lettere maiuscole per separare le singole parole.
final int SONOUNACOSTANTE;      // Tutto maiuscolo per le costanti.


class SonoUnaClasse(){          // Lettera MAIUSCOLA iniziale, lettere maiuscole per separare le singole parole.
    void SonoUnaClasse(){ 
        // Il costruttore ha lo stesso nome della classe. 
        // Esso è quindi l'unica eccezione tra i metodi ad iniziare con la lettera maiuscola.
    }
    void sonoUnMetodo(){}       // Uguale alle variabili
}}
```

_La naming convention delle classi si applica anche a interfacce e classi astratte._

Oltre al codice, le naming convention influenza anche la struttura di
package (cartelle) e moduli (file):
- sonoUnPackage
- SonoUnModulo (notare che la sintassi è la stessa delle classi. Appunto perché le classi devono avere LO STESSO NOME del modulo in cui sono ospitate!)
****

## Quiz
*Questo quiz è stato pensato per essere svolto una sola volta. \
Accertati di sapere tutto prima di provarlo!*

E' sconsigliata la consultazione della soprastante guida durante lo svolgimento
del quiz! \
Se non sai qualcosa, semplicemente non segnarlo. Alla fine verifica le cose che non sai utilizzando la guida.

1. Spiega la struttura del codice sottostante:
```Java
Aereo airLineF15 = new Aereo();
```
2. Il seguente codice rispetta le naming convention?
```Java
String statoprogramma = "Partito";
bool Attivato = false;
```
3. Il seguente codice rispetta le naming convention?
```Java
int Pippo = 0;
String sonoUnaStringa = "Ciao mondo!";
```
4. Spiega cosa significa "definire" una classe.
5. Il metodo costruttore, che tipo di naming convention segue? (spiega la sua naming convention)
6. Spiega la struttura del codice sottostante:
```Java
int stato;
stato = 1;
```