### Classe
E' un template. Descrive come creare oggetti concreti.

Puoi vederla come il "blueprint" che gli architetti utilizzano per pianificare i futuri palazzi.

```Java
class Test{
    // Codice
}
```

Ogni classe ha uno "stato" (dati interni) che condivide solo con le 
sue istanze o con le proprie sottoclassi.

### Istanza (o oggetto)
E' l'oggetto concreto che deriva da una classe.

Puoi vederlo come il palazzo costruito dal blueprint.

```Java
// Dichiaro una variabile chiamata "esperimento" di tipo "Test", e la inizializzo con una nuova istanza della classe Test.
Test esperimento = new Test();
```
Ogni istanza ha il suo "stato" (dati interni) privato mentre condivide 
tutto ciò che è della classe da cui deriva, con le altre istanza della medesima classe.

_(es. se la classe mette a disposizione la variabile int x = 5, tutte le istanze della classe la conosceranno)_

### Istanziamento
```Java
class Test{
    /* Creo una variabile "griglia" di tipo Grid.
     * Assegno alla variabile "griglia" una nuova istanza di Grid. */
    Grid griglia = new Grid();
}
```

### Attributi di classe e istanza
**Attributo di classe:**
- E' un attributo con davanti `static`.
- Il suo valore è condiviso tra tutte le istanze della classe.

**Attributo di istanza:**
- E' un attributo qualsiasi (senza static).
- Il suo valore non è condiviso tra le istanze. In altre parole, ogni istanza avrà il proprio valore.
- **NB:** il costruttore non c'entra niente con gli attributi di istanza!!!!
```Java
class Test{
    static Grid griglia = new Grid();          // Attr. di classe
    static int x;                              // Attr. di classe
    int y;                                     // Attr. di istanza
    
    static private int z = 5;                  // Attr. di classe   
    static public int j = 4;                   // Attr. di classe
    private double k = 2;                      // Attr. di istanza
}
```