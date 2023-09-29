Il mondo delle applicazioni desktop, così come le applicazioni web, utilizza gli eventi
per interagire con l'esterno (es. l'utente preme "a").

Gli eventi vengono solitamente rappresetati da delle enumerazioni:
```Java
enum Events {
    W(1), A(2), S(3), D(4), SPACE(5)
}

class Game(){
    Events event = new Events();
    
    public void checkInput(){
        if (user_input == event.A){
            // Left
        } else if (user_input == event.W){
            // Up
        }
        .....
    }
}
```

Ci sono altre 2 distinzioni da conoscere:
- Event **handler**: è il metodo che viene eseguito quando l'evento viene rilevato.
- Event **listener**: è un oggetto o entità che è in ascolto di eventi generati da un'altra parte del programma.


