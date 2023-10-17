#### Premessa
L'articolo sottostante rappresenta più un "flusso" pragramtico, che una guida teorica.\
Per la guida tecnica (analisi problema + soluzione), vi rimando a "01_the_fps_problem".


### Esempio: stesso movimento (in pixel) su differenti macchine

| FPS | Movimento in pixel | Movimento reale |
|-----|--------------------|-----------------|
| 10  | 10                 | 10 * 10 = 100   |
| 30  | 10                 | 30 * 10 = 300   |
| 60  | 10                 | 60 * 10 = 600   |
| 120 | 10                 | 120 * 10 = 1200 |
| 600 | 10                 | 600 * 10 = 6000 |

Già da sopra è chiaro che a 10 fps, ci muoviamo nettamente più lenti rispetto alla \
situazione con 600 fps.

## Soluzione 1: limitare gli fps superiormente
Come esempio possiamo prendere Elder Ring, che risolve il problema limitando il gioco a 60 fps massimi,
indipendentemente dalla macchina che esegue il gioco.

Ci sono però due **svantaggi** a questo approccio:
1. Questa soluzione non tiene conto delle situazioni sotto al limite degli fps. \
   Es. se giro a 10 fps, il gioco continuerà ad andare più lento, rispetto ai 60 limite.
2. Più fps == gioco più fluido e responsivo. Se limiti gli fps, limiti la qualità teorica del gioco.

## Soluzione 2: delta time (dt)
Sempre Elder Ring, per risolvere il problema degli fps sotto al limite imposta, ha implementato il sistema del
delta time (o dt).

Il delta time, serve per raggiungere un movimento costante, in tutti i frame, ed è
dato dalla **differenza tra il frame corrente e il frame precedente**.

Moltiplicando tale differenza con qualsiasi movimento, la velocità di gioco risulterà consistente.

### Esempio: fps diversi con il medesimo movimento
_Attenzione: questo esempio utilizza il **fixed time** per motivi di dimostrazione._\
**60 FPS** \
Delta = 1 / 60 = 0.016666666 \
Movimento reale = Movimento x FPS x delta = 10 * 60 * 0.016666666 = 10

**30 FPS** \
Delta = 1 / 30 = 0.033333333 \
Movimento reale = Movimento x FPS x delta = 10 * 30 * 0.033333333 = 10

Potremmo fare gli stessi calcoli per tutti gli fps elencati all'inizio, e il movimento
risulterebbe sempre 10.

Anche il dt presenta cose da tenere a mente:
1. Se implementi il delta, qualsiasi movimento (rotazione, animazione, ...) nel gioco dovrà venir moltiplicato per esso.
2. Il delta, richiede numeri più grandi rispetto alle velocità di movimento pre-impostate.\
   Esempio, se prima avevo speed = 5, con il dt dovrò aggiustarli in modo incrementale perché il movimento risulti lo stesso (es. speed = 500).
3. Tutto ciò che interagisce con il delta time, dev'essere di tipo (o castato a) double.

### Riassunto calcolo delta time
```Java
long previous_time = System.nanoTime();
double dt = System.nanoTime() - previous_time;
previous_time = System.nanoTime();
```

Il valore della variabile `dt` andrà ora moltiplicato a tutti i movimenti, rotazioni, animazioni, all'interno del gioco.
Questa moltiplicazione renderà il movimento indipendente dai frame.
### Nota importante - double a int
Bisogna tenere a mente che le librerie grafiche vogliono sapere il punto esatto in pixel in cui
disegnare l'immagine. Si parla quindi di valori **interi**.\
Il delta time però è **double**! Quindi occorrerà fare una conversione (cast) prima di passarla a (esempio) drawImage!

## Fixed time step
Esiste anche un delta time che non tiene conto delle variazioni tra i frame, ma permette di aggiornare
il gioco a battiti "regolari" (che in realtà, vengono percepiti come irregolari). Si chiama fixed time step e si calcola come:
```Java
double fixedDeltaTime = 1 / fps;
```
E' ovviamente sconsigliato....\
Immagina di avere due situazioni:
```Java
// 60 FPS
double fixedDeltaTime = 1 / fps;       // Es. 1 / 60 = 0.016666

// 30 FPS
double fixedDeltaTime = 1 / fps;       // Es. 1 / 60 = 0.033333
```
Ai 30 FPS, tutto si muoverebbe il doppio della velocità!\
Inoltre, non venendo presa in considerazione la differenza tra un frame e il successivo, i disegni avverrebbero a
ritmi in realtà irregolari!