## Main thread e secondari
Ogni gioco dispone di un thread principale (per default) e almeno un thread secondario. 
#### Thread principale (o main thread):
- Creato in automatico all'avvio dell'applicazione. 
- Esegue subito il main().
- Dovrebbe gestire: 
  - interfaccia
  - eventi (input utente, ...)
  - rendering finestre di gioco
#### Thread secondario:
- Creato dal programmatore.
- Gestisce le operazioni specifiche dell'apllicazione:
  - Fisica
  - Rendering
  - Game loop
  - eventi (input utente, ...)
- Perché è necessario:
  - Permette di suddivere il carico computazionale tra diversi thread (in modo che uno solo non si occupi di tutto).
  - Permette di evitare che, se il thread secondario crasha, si blocca anche l'interfaccia utente.
```Java
Thread td = new Thread(this);
```
## Intefacce incontrate
### Runnable
  - Permette di implementare il metodo **run**.
    - Tale metodo parte appena viene fatto lo start del thread della classe. 
    - Tutto il codice all'interno di run, viene eseguito in un thread secondario (nuovo).
  - In altre parole, runnable consente di eseguire del codice all'interno di un thread secondario.

```Java
class ProgramLoop implements Runnable {
  private boolean running = false;

  public void start() {
    running = true;
    
    // Notare il "this". Gli passo l'istanza della classe stessa.
    Thread gameThread = new Thread(this);
    gameThread.start();
  }
  
  public void stop() {
      running = false;
  }

  @Override
  public void run() {
      while(running){
        // Codice eseguito allo start del game thread.         
      }
  }
} 
```