### Metodi Setter e Getter
Una singola _classe_ può avere _diversi_ **costruttori** con un numero _diverso_ di **parametri**.
I getter e i setter in Java sono utilizzati per controllare l'accesso
e la modifica dei dati di una classe,
garantendo incapsulamento e protezione dei dati.

I getter, definiti con il prefisso "get", consentono di ottenere
il valore di una variabile di istanza, mentre i setter, con il prefisso "set",
permettono di impostarne o aggiornarne il valore.


Questa convenzione, chiamata anche accessori e mutatori,
aiuta a mantenere una buona pratica di denominazione dei metodi in Java.

```Java
public class Vehicle {
    private String color;

    // Getter
    public String getColor() {
        return color;
    }

    // Setter
    public void setColor(String c) {
        this.color = c;
    }
}
```
I metodo getter restituisce il valore di un attributo all'interno di una classe,
permettendo di accedere a tale valore dall'esterno.

D'altro canto, il metodo setter accetta un parametro
e lo assegna all'attributo della classe, consentendo di modificarne il valore.

Una volta definiti questi metodi, possono essere utilizzati
nel programma principale (main) per ottenere o modificare i dati dell'oggetto.

``` Java
public static void main(String[] args) {
Vehicle v1 = new Vehicle();
v1.setColor("Blue");
System.out.println(v1.getColor());
}

// l'output è "Blue"
```

Dunque, i getter e setter offrono un controllo sui dati,
incluso il potere di verificare e garantire la validità del valore
inserito nel setter prima di assegnarlo come attributo.

Questa capacità di validare all'interno del setter assicura
che il valore fornito rispetti determinate condizioni o regole
specifiche prima di essere accettato e applicato come parte delle proprietà dell'oggetto.
***
### Per quale motivo dovrei usarli?
I metodi getter e setter consentono di gestire come
le variabili nel tuo codice vengono lette e modificate.

Ad esempio, se prendiamo in considerazione un metodo setter,
questo ti offre la possibilità di controllare e personalizzare
la modalità con cui una variabile può essere aggiornata, applicando regole o
logiche specifiche prima di accettare e impostare il nuovo valore per quella variabile.

``` Java
public void setNumber(int number) {
if (number < 1 || number > 10) {
throw new IllegalArgumentException();
}
this.number = num;
}
```

Utilizzando il metodo `setNumber`, è garantito che il valore di `number`
sia limitato tra 1 e 10, offrendo una gestione
controllata e conveniente rispetto alla modifica diretta della variabile `number`.


```Java
obj.number = 13;
```
Fornendo solo il metodo `setNumber`,
si garantisce il rispetto dei limiti desiderati per la variabile
`number` (1-10), prevenendo modifiche indesiderate che potrebbero
influenzare il comportamento del codice. Per accedere al valore di `number`,
è necessario utilizzare il metodo getter,
garantendo un accesso controllato e conforme alle restrizioni previste.

D'altra parte, l'unico modo per leggere il valore di number è l'uso di un metodo getter:
```Java
public int getNumber() {
return this.number;
}
```
***