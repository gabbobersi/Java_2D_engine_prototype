### Modificatori di accesso
```Java
class Test(){
    private int a;      // PRIVATO      Visibile a classe.
    int b;              // DEFAULT      Visibile a classe + stesso package.
    protected int c;    // PROTETTO     Visibile a classe + stesso package + sotto classi (anche in altri package).
    public int d;       // PUBBLICO     Visibile a tutti.
}
```

### Istanziamento
```Java
class Test(){
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
class Test(){
    static Grid griglia = new Grid();          // Attr. di classe
    static int x;                              // Attr. di classe
    int y;                                     // Attr. di istanza
    
    static private int z = 5;                  // Attr. di classe   
    static public int j = 4;                   // Attr. di classe
    private double k = 2;                      // Attr. di istanza
}
```