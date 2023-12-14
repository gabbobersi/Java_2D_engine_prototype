**Riassunto pratico:**\
Garantisco che una classe abbia una sola istanza e fornisco 
un punto di accesso globale a quella istanza.

### Come impostare una classe come Singleton
1. Costruttore privato
2. Metodo per ottenere l'unica istanzia disponibile in tutta l'applicazione.
3. Attributo che consenta di verificare se l'istanza è già stata generata dal metodo del punto 2.

```Java
public class Singleton {
    private static Singleton instance;
    
    // Costruttore privato per evitare l'istanziamento diretto.
    private Singleton() {
    }

    // Metodo statico per ottenere l'istanza unica della classe
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    // codice...
}
```

Notare che l'attributo `instance` è statico, in modo che appartenga alla classe
stessa e non all'istanza.

Se non lo imposti `static`, ottieni una nuova istanza ogni volta che ne viene chiamato
il metodo `getInstance`!
