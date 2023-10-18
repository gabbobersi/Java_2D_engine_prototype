Il file sottostante è diviso in 4 parti:
1. Modalità per aggiungere variabili/classi al codice
2. Struttura codice
3. Naming convention
4. Quiz
****
Ci sono 3 modalità per aggiungere una variabile a un programma:
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
### Variabili e classi
In Java, le variabili si dichiarano in questo modo: \
`[ TIPO ]` `[ IDENTIFICATIVO ]`

Esempio:
```Java
int x;          // int è il tipo, x è l'identificativo della variabile.
```
Lo stesso vale per le classi:
```Java
Build build;    // Build è il tipo (o classe), build è l'identificativo.
```

### Metodi
In Java, i metodi si dichiarano in questo modo: \
`[ TIPO RITORNATO ]` `[ IDENTIFICATIVO ]` (`[PARAM1, PARAM2, ....]`) {`[CODICE]`} 

Esempio:
```Java
// Questo metodo non ritorna nulla, perciò il tipo di ritorno sarà void.
void stampaMessaggio(String messaggio){
    System.out.println(messaggio);
}

// Questo metodo ritorna una stringa, perciò il tipo di ritorno sarà String.
String concatenaStringhe(String str1, String str2){
    return str1 + str2;
}
```

Oltre al tipo, sia per le variabili che per i metodi, è possibile aggiungere un **modificatore di accesso**
(ti rimando alla guida pre-fatta: [link](modificatori_di_accesso.md)) (i modificatori non verranno richiesti).

### Prototipo
Il prototipo rappresenta una breve descrizione di una variabile, metodo (o funzione), classe. \
Ecco le tipologie:
```Java
// Prototipo di una variabile (è la dichiarazione)
int x;

// Prototipo di un metodo (è la dichiarazione)
public int getAge(Person person);

// Prototipo di una classe (è la definizione!)
class Classe(){
    int number = 0;
    
    public Classe() {
        // Costruttore
    }      
    
    public int getNumber(){
        return number;
    };
}
```
In altre parole, il prototipo corrisponde alla dichiarazione, tranne che per le 
classi. \
Nel caso delle classi, il prototipo corrisponde alla definizione.
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

Oltre al codice, le naming convention influenzano anche la struttura di
package (cartelle) e moduli (file):
- sonounpackage
- SonoUnModulo (notare che la sintassi è la stessa delle classi. Appunto perché le classi devono avere LO STESSO NOME del modulo in cui sono ospitate!)
****

## Quiz
*Questo quiz è stato pensato per essere svolto una sola volta. \
Accertati di sapere tutto prima di provarlo!*

E' sconsigliata la consultazione della soprastante guida durante lo svolgimento
del quiz! \
Se non sai qualcosa, semplicemente segnati la domanda. La verificherai al termine della prova, con la guida.

### Cominciamo
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

void StampaQualcosa(String qualcosa){
    System.out.println(qualcosa);    
}
```
7. Il codice sottostante è corretto?
```Java
String ritornaCarrello(String idCarrello){
    return Integer.parseInt(idCarrello);    
}
```
8. Spiega il concetto di prototipo di un metodo.
9. Il codice sottostante è il prototipo di un metodo?
```Java
public void saveFile(String path, File file);
```
10. Il codice sottostante è il prototipo di una classe?
```Java
public class FileManager {
    public File getFile(){
        // Codice...
    }
    public void closeFile(File f){
        // Codice...
    }
}
```
### Risorse
[NamingConvention](https://github.com/nbicocchi/java-core/blob/main/assets/books/Java-Coding-Standard.pdf)
