Le eccezioni sono degli **oggetti** e hanno quindi metodi e attributi. \
Il loro scopo, è quello di segnalare in modo appropriato un errore.

Le eccezioni hanno una gerarchia di ereditarietà.

In Java, ci sono due tipi di eccezioni:
- Eccezioni controllate _(checked exceptions)_
  - Sono gestite dal programmatore (vedi sotto).
  - Devono essere dichiarate o gestite (vedi sotto)
- Eccezioni non controllate _(unchecked exceptions)_
  - Sono impreviste (es. a runtime) o comunque non gestite.
  - Non devono essere dichiarate o gestite.

E' solitamente buona norma (ma non obbligatorio) creare eccezioni personalizzate, 
in modo da avere a disposizione un'eccezione che più si adatta al contesto.

#### Esempio di creazione di una eccezione "personalizzata":
```Java
// E' buona norma che tutte le nuove exception ereditino dalla classe standard Exception.
class InvalidResourcesException() extends Exception{
    // Il costruttore è obbligatorio!
    public InvalidResourcesException(String message){
        super(message);
    }
}
```
#### Esempio di utilizzo di una eccezione "personalizzata":
```Java
try{
    image = ImageIO.read(new File("resources/test.png"));
    if (image == null){
        // Sollevo manualmente l'eccezione personalizzata precedentemente creata.
        throw new InvalidResourcesException("Can't load the resource.");
    }
}
```

### Dichiarazione di una eccezione:
```Java
public void metodoConEccezioneControllata() throws IOException {
// Codice che può generare un'eccezione controllata (ad esempio, IOException)
}
```

### Lancio eccezione:
```Java
throw new ExceptionType("Questo è un messaggio di errore");
```
### try/catch
```Java
try {
    // Codice che potrebbe fallire (es. divisione per zero, caricamento risorsa fallito, ecc...)
} catch (ExceptionType1 e){
    // Gestione errore di tipo 1.    
} catch (ExceptionType2 e){
    // Gestione errore di tipo 2.
}
...
```

### try/catch/finally
```Java
try {
// Codice che potrebbe fallire (es. divisione per zero, caricamento risorsa fallito, ecc...)
} catch (ExceptionType1 e){
// Gestione errore di tipo 1.    
} catch (ExceptionType2 e){
// Gestione errore di tipo 2.
} finally{
    // Codice che verrà sempre eseguito (sia in caso di successo, che in caso di errori).
}
...
```
### Multi-catch
```Java
try {
// Codice che potrebbe generare un'eccezione
} catch (ExceptionType1 | ExceptionType2 e) {
// Gestione delle eccezioni di tipo ExceptionType1 o ExceptionType2
}
```