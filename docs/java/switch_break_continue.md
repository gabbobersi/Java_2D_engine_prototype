## Switch/Break/Continue

In Java, **switch**, **break**, and **continue** sono tre parole chiave
utilizzate per controllare il flusso di esecuzione di un programma.

Switch, Break e Continue sono comunemente detti **costrutti di branching** e in Java servono a controllare l'esecuzione di un blocco di codice in un modo sostanzialmente opposto
a come operano i *costrutti iterativi* e *condizionali*.
La differenza sostanziale è:
- I costrutti **iterativi** e **condizionali** si focalizzano sull'esecuzione
(eventualmente ripetuta) di un intero blocco di codice
- Break e Continue servono per **terminare** l'esecuzione
di un blocco di codice in un ciclo o uno **statement** switch.

### Switch
Il costrutto switch è utilizzato per **selezionare** uno
dei molti blocchi di codice da eseguire in base al valore di un'espressione.
```Java
int numero = 2;
switch (numero) {
    case 1:
        System.out.println("Il numero è 1");
        break;
    case 2:
        System.out.println("Il numero è 2");
        break;
    case 3: 
        System.out.println("Il numero è 3");
        break;
    default:
        System.out.println("Il numero non è né 1 né 2 né 3");
        }

```
In questo esempio, l'output sarà "Il numero è 2", poiché numero è uguale a 2.
### Break
**Break** è utilizzato all'interno di uno statement switch o
di un ciclo (come for o while) per uscire immediatamente
da tale blocco di codice e continuare con l'esecuzione del
codice successivo al blocco.
```Java
int giorno = 3;
switch (giorno) {
    case 1:
        System.out.println("Lunedì");
        break;
    case 2:
        System.out.println("Martedì");
        break;
    case 3:
        System.out.println("Mercoledì");
        break;
    default:    
        System.out.println("Altro giorno della settimana");
        }
```
Nel caso di giorno uguale a 3, verrà stampato solo "Mercoledì",
e poi il programma uscirà dallo statement switch usando break.
### Continue
Similmente a break, lo statement **Continue** serve per saltare
alla fine di un blocco ma in questo caso NON viene terminato il
ciclo ma solamente interrotta l'iterazione corrente e l'esecuzione
salta immediatamente alla valutazione della condizione di terminazione.

Questo può essere utile per **escludere** un'iterazione specifica del ciclo
senza terminare il ciclo stesso.
```Java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue; // Salta l'iterazione quando i è uguale a 3
    }
        System.out.println("Numero " + i);
}
```
In questo caso, l'output sarà:
```makefile
Numero 1
Numero 2
Numero 4
Numero 5
```
### Switch Expression (NEW)
È un'aggiunta introdotta in **Java 12**, chiamata **"Switch Expressions,"**
che ha reso il costrutto switch **più espressivo** rispetto al
tradizionale switch. Invece di utilizzare le istruzioni case e break,
le espressioni switch con frecce consentono di **valutare** una *singola
espressione* e *restituire un valore*, il che può rendere il codice più
conciso e leggibile.

All’interno del costrutto switch, si usa la **notazione
freccia**, ovvero il simbolo costituito dai caratteri ->
che già utilizziamo nelle **espressioni lambda**. Esso può seguire la parola chiave
case al posto del simbolo “:”.

Ora come esempio, supponiamo di avere un **enumerazione** che definisce i colori di un semaforo:
```Java
public enum Colore {
    VERDE, GIALLO, ROSSO;
}
```
Consideriamo la classe Semaforo:
```Java
public class Semaforo {
      public void cambiaColore(Colore colore) {
          switch(colore) {
              case VERDE: 
                  accendiLuceVerde();
              break; 
              case GIALLO: 
                  accendiLuceGialla();
              break; 
              case ROSSO: 
                  accendiLuceRossa();
              break;
          }
      }
// resto del codice omesso
}
```
La riscriviamo nel seguente modo:
```Java
public class Semaforo {
    public void cambiaColore(Colore colore) {
        switch(colore) {
            case VERDE  ->  accendiLuceVerde();
            case GIALLO ->  accendiLuceGialla();
            case ROSSO  ->  accendiLuceRossa();
        }
    }
    // resto del codice omesso
}
```
Nel metodo **cambiaColore** abbiamo utilizzato
un costrutto switch con notazione freccia, che per
ogni **case** esegue uno **statement**. Da notare che non c’è
stato bisogno di utilizzare la parola chiave break.