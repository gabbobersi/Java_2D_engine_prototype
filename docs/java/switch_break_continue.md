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
    case 2:
        System.out.println("Il numero è 2");
        break;
    case 3: 
        System.out.println("Il numero è 3");
    default:
        System.out.println("Il numero non è né 1 né 2 né 3");
}
```
Se numero è = 1 vengono eseguiti case 1 e case 2 (manca `break` nel case 1).
Se numero è = 2 viene eseguito case 1.
Se numero è = 3 vengono eseguiti case 3 e default.

### Continue
Salta l'iterazione attuale spostando l'esecuzione all'iterazione successiva.
```Java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue; // Salta l'iterazione quando i è uguale a 3
    }
    System.out.println("Numero " + i);
}
```
In questo caso, l'output sarà:
```text
Numero 1
Numero 2
Numero 4
Numero 5
```

### Break
Interrompe l'esecuzione di case e loop.
```Java
for (int i = 0; i < 5; i++){
    for(int k=0; k < 6; k++){
        if(k == 2){
            continue; 
        }
        if(k == 5){
            // L'esecuzione salta al for esterno
            break; 
        }
    }
}
```
### Switch Expression (NEW)
È un'aggiunta introdotta in **Java 12**, chiamata **"Switch Expressions,"**
che ha reso il costrutto switch **più espressivo** rispetto al
tradizionale switch. Invece di utilizzare le istruzioni case e break,
le espressioni switch con frecce consentono di **valutare** una *singola
espressione* e *restituire un valore*, il che può rendere il codice più
conciso e leggibile.

Consideriamo la classe Semaforo:
```Java
public class Semaforo {
    public enum Colore {
        VERDE, GIALLO, ROSSO;
    }
    public void cambiaColore(Colore colore) {
        switch (colore) {
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
    }
}
```
La riscriviamo nel seguente modo:
```Java
public class Semaforo {
    public void cambiaColore(Colore colore) {
        switch(colore) {
            case VERDE  ->  { 
                // Notare che è possibile inserire più righe
                accendiLuceVerde();
                accelera();
            }
            case GIALLO ->  accendiLuceGialla();
            case ROSSO  ->  {
                accendiLuceRossa();
                frena();
            }
        }   
    }
}
```
Nel metodo **cambiaColore** abbiamo utilizzato
un costrutto switch con notazione freccia, che per
ogni **case** esegue uno **statement**. Da notare che non c’è
stato bisogno di utilizzare la parola chiave break.