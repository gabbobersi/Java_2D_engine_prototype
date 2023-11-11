## Funzioni Lambda

In matematica e informatica in generale, un’espressione lambda è una **funzione**.


- In Java, un’espressione lambda fornisce un modo per creare una **funzione anonima**,
introducendo un nuovo **tipo Java**: il tipo **funzione anonima** che può quindi
essere passato come argomento o restituito in uscita nei metodi. 


- In poche parole, si tratta di un **metodo senza una dichiarazione** ed
è spesso utilizzato per semplificare il codice quando si ha bisogno di
passare una piccola porzione di codice come **argomento** a un **metodo**.


- Sono particolarmente utili nei casi in cui serve definire una **breve funzione** che ha poche
linee di codice e che verrà utilizzata una **sola volta**:
In questi casi si risparmia la fatica di scrivere un metodo a parte con modificatore, nome, ecc.

In generale le lambda ci permettono di scrivere codice più chiaro e meno verboso.

- Le espressioni lambda sono ampiamente utilizzate con le **interfacce funzionali**, cioè le interfacce
che dichiarano un **singolo metodo astratto**.

(**Reminder**: Un'interfaccia funzionale in Java è un'interfaccia che ha un solo metodo astratto.
Un metodo astratto è un metodo **senza implementazione**.)

La sintassi è la seguente:
```
(argomenti) -> espressione
```
- Gli argomenti sono quelli che la funzione prenderà come input.
- L'espressione è ciò che la funzione farà e restituirà.

Esempio:
```Java
// Definizione di un'interfaccia funzionale con un metodo astratto
interface Operazione {
    int esegui(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // Utilizzo di un'espressione lambda per sommare due numeri
        Operazione somma = (a, b) -> a + b;
        
        int risultato = somma.esegui(5, 3);
        System.out.println("Risultato: " + risultato);
    }
}
```