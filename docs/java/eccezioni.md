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

#### Gestione vs propagazione eccezioni
- Gestire significa utilizzare un blocco `try/catch` per gestire una eccezione dell'interprete (sollevata automaticamente) o del programmatore (sollevata manualmente con `throw`).
- Propagare significa utilizzare le clausole `throws` e `throw`.
  - Quando utilizzi `throw`, stai propagando (o sollevando) quella eccezione. 

#### throws vs throw
`throws` si mette alla fine della firma del metodo, per indicare che tipo di eccezione il metodo può sollevare.\
Una volta impostato, è obbligatorio gestire (o ulteriormente propagare, sempre con `throws`) l'eccezione, nel metodo chiamante il metodo con `throws` nella firma.

`throw` si utilizza nel codice, per sollevare manualmente un'eccezione.\
Se è contenuto in un blocco `try/catch`, sei già a posto.\
Se non è contenuto in un blocco `try/catch`, allora bisogna passare al throws nel firma del metodo (stessa storia sopra).

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
} catch (ExceptionClass1 e){
    // Gestione errore di tipo 1.    
} catch (ExceptionClass2 e){
    // Gestione errore di tipo 2.
} catch (Exception e){
    // Consigliato alla fine, di gestire un generico "Exception" in modo da
    // gestire anche le eccezioni che non ho previsto sopra.
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
