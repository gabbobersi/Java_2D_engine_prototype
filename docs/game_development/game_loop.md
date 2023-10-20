# Il Game Loop
Un "game loop" è un concetto fondamentale nell'ambito dello sviluppo di videogiochi e si riferisce a una struttura ciclica utilizzata per mantenere un gioco in esecuzione.

Gestire gli **input** del giocatore, **aggiornare lo stato del gioco** e **renderizzare le immagini sullo schermo**. La sua funzione principale è quella di assicurare che il gioco sia eseguito in modo continuo e fluido.

Si chiama loop poiché vengono eseguite **iterazioni cicliche** di aggiornamento con una data frequenza, fino a quando l’utente termina il gioco. 

## Iterazioni cicliche nel game loop
Ogni iterazione prepara la visualizzazione di un frame. 
Durante ogni ciclo il game loop legge gli input esterni, aggiorna lo stato degli oggetti e prepara l’immagine della scena da visualizzare.
In genere la frequenza di aggiornamento del frame è di 30 o 60 frame al secondo (fps). 

In un gioco che gira a 30 fps il game loop esegue 30 iterazioni ogni secondo. Se fissiamo la frequenza a 30, allora il tempo per completare l’aggiornamento del frame non deve superare 33.3 millisecondi; se invece fissiamo gli fps a 60, dobbiamo finire l’aggiornamento in 16,6 millisecondi:

```Java
 1 secondo = 1000 millisecondi
   1000/30 = ~33.3 millisecondi
   1000/60 = ~16.6 millisecondi
```

*N.d.A.* \
**I calcoli che ho fornito si riferiscono alla conversione del tempo tra secondi e millisecondi, nonché alla suddivisione di un secondo in frammenti più piccoli, specificamente in 1/30 di secondo e 1/60 di secondo.**

In sintesi, questi calcoli ti aiutano a capire come suddividere il tempo in millisecondi per regolare l'aggiornamento e la renderizzazione del gioco in modo da ottenere una frequenza desiderata, come 30 FPS o 60 FPS.

Vedremo in seguito un esempio di algoritmo tradizionale di base e può essere rappresentato con il seguente diagramma a blocchi:

![game_loop.png](..%2Fresources%2Fgame_loop.png)

## Gli FPS
Acronimo di “Frame per Second“, o “Fotogrammi al secondo” in italiano, gli FPS non sono nient’altro che un’unità di misura, che indica, appunto, il numero di immagini, detti fotogrammi, che il PC è in grado di generare in un secondo.

Tante immagini statiche in rapida successione creano un movimento continuo, o per meglio dire l’illusione del movimento. Nei videogiochi sono molto più importanti che negli altri media e si misurano appunto in Fps.

![fps.png](..%2Fresources%2Ffps.png)

Sulle console, 30 o 60 FPS sono di solito definiti come standard, ma a seconda dello sviluppatore, i giocatori hanno la possibilità di scegliere una delle due varianti FPS nelle impostazioni. Di solito, ciò ha un impatto sulle prestazioni complessive. Per esempio, un frame rate più elevato influisce sulla visualizzazione grafica, che è quindi in qualità ridotta.

Fondamentalmente, 60 FPS sono il valore di riferimento per un gioco fluido, che inoltre (come descritto in precedenza) comportano un input più diretto. A 30 FPS possono verificarsi dei ritardi, che possono risultare in mosse ritardate nei giochi pieni d’azione. 120 FPS non sono ancora standard nei giochi, ma riducono la latenza, quindi questa impostazione è raccomandata per sistemi di PC ad alte prestazioni. Tuttavia, qui gioca un ruolo decisivo anche il genere:

| Genere del gioco            | FPS Raccomandati |
|-----------------------------|------------------|
| Indie/Pixel Art             | 30               |
| Giochi di ruolo             | 30               |
| Giochi di strategia         | 30               |
| Avventura                   | 60               |
| Sparatutto in prima persona | 60               |
| Giochi di corse             | 60               |

(per uno studio più approfondito e tecnico sugli Fps passate da [qui](fps)).

# The Game Loop pattern

Il pattern del game loop viene utilizzato nella creazione di giochi, animazioni o interfacce utente che devono aggiornare lo stato indipendentemente dall'input dell'utente. 
In questo caso si discuterà le diverse implementazioni dei cicli di gioco.

## Implementazioni
*Nota: Lo stato di gioco è lo stato effettivo del gioco. Lo stato di rendering è lo stato dell'output/display o del rendering*.

### Applicabilità
Utilizzando questo pattern, si è in grado di consentire al sistema di aggiornare lo stato mentre gestisce il rendering separatamente, consentendoti efficacemente di controllare il frame rate dell'utente nel modo che meglio si adatta all'applicazione.

**Il pattern del Game Loop funziona meglio quando**:
<ul>
<li>
Si stanno creando giochi, animazioni o interfacce utente.
</li>
<li>
È necessario separare lo stato e il rendering.
</li>
<li>
Si desidera ottimizzare le prestazioni del gioco (cioè i frame per secondo).
</li>
</ul>

**Ci sono quattro esempi in questo progetto**:
1. **Basic (base)**: stato e rendering influenzati dalla velocità dell'hardware.
2. **Locked (bloccato)**: stato e rendering bloccati su un numero fisso di aggiornamenti.
3. **Capped (limitato)**: stato bloccato a un tasso di aggiornamento fisso, il rendering può aggiornarsi fino al numero di volte in cui lo stato lo fa al secondo.
4. **Independent (indipendente)**: lo stato si aggiorna a un tasso fisso, il rendering può aggiornarsi più volte rispetto al tasso di aggiornamento dello stato tramite l'interpolazione.


### Basic
```Java
 public void gameLoop() {
    while (true) {
        updateState ();
        updateView ();
    }
}
```
Il ciclo di base aggiorna contemporaneamente lo stato di gioco e lo stato di rendering. 
Ciò significa che gli stati di gioco e di rendering sono sempre gli stessi. 
Tuttavia, il ciclo di base non è limitato e semplicemente funzionerà alla massima velocità consentita dall'hardware. 
Ciò non è utile poiché significa che il gioco/l'animazione funzionerà a diverse velocità a seconda della velocità dell'hardware.

### Locked
```Java
public void gameLoop() {

    final int framesPerSecond = 25;
    final long skipTicks = 1000 / framesPerSecond;

    long sleepPeriod;
    long nextUpdateTick = System.currentTimeMillis();

    while (true) {

        updateState();
        updateView();

        nextUpdateTick += skipTicks;
        sleepPeriod = nextUpdateTick - System.currentTimeMillis();

        if (sleepPeriod >= 0) {
            try {
                sleep(sleepPeriod);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
            }
        }
    }
```
Anche il ciclo bloccato aggiorna contemporaneamente lo stato di gioco e lo stato di rendering. 
Per contrastare il problema della dipendenza della velocità di aggiornamento dal hardware, viene impostato un limite di frame. 
Ciò garantisce che il ciclo attenda un intervallo uniforme tra gli aggiornamenti, assicurando una coerenza tra le diverse macchine.

I problemi con questa implementazione si verificano su hardware lento. 
Se l'hardware non riesce a tenere il passo con il numero di aggiornamenti necessari per assicurare un'esperienza uniforme, 
il ciclo continuerà non appena possibile nel tentativo di soddisfare il requisito. Tuttavia, ciò causerà uno scattoso nelle fasi di gioco e di rendering man mano che gli aggiornamenti si rallentano.

Un altro inconveniente del ciclo bloccato è che l'hardware veloce lo gestirà bene, ma il potenziale dell'hardware viene limitato.

### Capped
```Java
public void gameLoop() {

  final long ticksPerSecond = 50;
  final long skipTicks = 1000 / ticksPerSecond;
  final int maxFrameSkip = 10;

  long nextUpdateTick = System.currentTimeMillis();
  int loops;

  while (true) {
    loops = 0;
    while (System.currentTimeMillis() > nextUpdateTick && loops < maxFrameSkip) {
      updateState();
      nextUpdateTick += skipTicks;
      loops++;
    }
    updateView();
  }
}
```
Il ciclo limitato è il primo di questi esempi che consente aggiornamenti separati dello stato di gioco e dello stato del frame. In questo caso, viene impostato un tasso di aggiornamento dello stato di gioco (ticksPerSecond) per garantire un aggiornamento coerente dello stato di gioco. In questo senso, questa implementazione è simile al ciclo bloccato.

Nella maggior parte dei casi, possiamo assumere che il rendering di un frame sia più intensivo dell'aggiornamento dello stato di gioco. Partendo da questa assunzione, questo ciclo assicura che, se l'hardware lento sta rimanendo indietro rispetto al tasso di aggiornamento, il ciclo darà la priorità all'aggiornamento dello stato di gioco e interromperà il rendering finché non si sarà messo in pari. Viene spesso implementato un "maxFrameSkip" per garantire che il gioco/animazione non si blocchi su un singolo frame se l'hardware fatica a soddisfare la richiesta del tasso di aggiornamento.

Questo ciclo consente all'hardware più lento di funzionare meglio rispetto al ciclo bloccato. Tuttavia, l'hardware veloce è comunque limitato dal tasso di aggiornamento: il frame rate non supererà mai il tasso di aggiornamento dello stato di gioco.

### Independent
```Java
public void gameLoop() {

  final long ticksPerSecond = 25;
  final long skipTicks = 1000 / ticksPerSecond;
  final int maxFrameSkip = 5;

  long nextUpdateTick = System.currentTimeMillis();
  int loops;
  float interpolation;

  while (true) {
    loops = 0;
    while (System.currentTimeMillis() > nextUpdateTick && loops < maxFrameSkip) {
      updateState();
      nextUpdateTick += skipTicks;
      loops++;
    }
    interpolation =
        (System.currentTimeMillis() + skipTicks - nextUpdateTick)
            / (float) skipTicks;
    updateView(interpolation);
  }
}
```

Il ciclo più potente in questi esempi è il ciclo indipendente. Come suggerisce il nome, questo ciclo consente lo stato di gioco e lo stato di rendering di essere aggiornati in modo indipendente l'uno dall'altro. Dato il limite del ciclo precedente, potresti chiederti come sia possibile renderizzare più frame di quanto ci siano stati di gioco. Questo ciclo lo realizza tramite l'interpolazione.

L'interpolazione produce un valore utilizzato per comprendere quale sarebbe lo stato di gioco equivalente in un punto esatto tra due stati reali. Con il valore di interpolazione, il rendering può fare una previsione e produrre un frame che non esisterebbe effettivamente in nessuno dei veri stati di gioco. Come effetto collaterale, la logica dello stato di gioco deve essere modificata per prendere in considerazione l'interpolazione, il che significa che questo ciclo non è completamente intercambiabile.

*N.d.A.* \
*Per ottenere una comprensione più approfondita di questo concetto, è possibile trovare il codice sorgente e un esempio pratico di ciascun ciclo nel seguente [repository Git](https://github.com/okinskas/java-design-patterns/tree/game-loop/game-loop).*


## Link utili
Per saziare la vostra fame di conoscenza metterò a dispozione dei link utili che riguardano il game loop, da esempi pragmatici a video tutorial utili per il nostro progetto, essendo molto grande e complesso come argomento ho messo a disposizione questo materiale.

Su questo [sito](https://java-design-patterns.com/patterns/game-loop/) troverete a vostra disposozione un'ottima documentazione su esempi pragmatici sul game loop e tutte le sue funzionalità.

Per non farci mancare niente cliccando su questo [video](https://youtu.be/fgxHNPb-7as?si=m8J17VwvtGQr7Y9-) vi reindirizzerà ad un canale Youtube molto interessante che tratta appunto lo sviluppo videogiochi, il video in questione parla del **Game Loop**.





