## Problema
Quando crei un gioco, vuoi che questo risulti visivamente uguale ovunque. \
Che si tratti di 600 fps oppure 10, il gioco deve procedere allo stesso ritmo.

Gli utenti però, dispongono di differenti dispositivi con differenti caratteristiche.

Inoltre, anche sulla stessa macchina gli fps potrebbero cambiare drasticamente, in base
a scene più o meno dispendiose di risorse.

## Tempo di gioco e tempo reale
E' chiaro che ci sono due "tempi" diversi che dobbiamo coordinare:
1. Tempo di gioco (a ogni update, il tempo di gioco va avanti di un certo ammontare di tempo)
2. Tempo reale (è richiesto un certo ammontare di tempo per processare l'update)

#### Cosa succede quando il gioco rallenta?
Se il punto 2 supera il punto 1, il gioco rallenta.\
In altre parole, se a 60 fps il nostro `drawInterval` è 16 ms, e il nostro update impiega più tempo,
il gioco rallenta (perde un fps, quindi da 60 saremo a 59).

Un intero calcolo è stato quindi perso (ho perso un frame di movimento).

#### Soluzione banale
Invece di rallentare il gioco, faccio più update nello stesso frame, quindi gli fps passeranno lo stesso a 59, ma
l'update fatto sarà 2 volte quello necessario, recuperando così l'update che avrei precedentemente perso.

In altre parole, ciò a cui miriamo è quello di **far avanzare il gioco in base al tempo realmente trascorso.**\
Più il frame ci mette ad essere eseguito, più il gioco avanzerà nel frame successivo.

Ciò permetterà al tempo di gioco, di rimanere sempre al passo con il tempo reale (avanzando più o meno largamente
, adattandosi così al tempo reale).

#### Pseudo codice
```Java
double lastTime = getCurrentTime();
while (true){
    double current = getCurrentTime();
    double elapsed = current - lastTime;
    processInput();
    update(elapsed);
    render();
    lastTime = current;
}
```
In ogni frame, determiniamo quanto tempo è passato rispetto all'ultimo frame (`elapsed`).\
Quando aggiorniamo lo stato del gioco, passiamo tale differenza.\
Sarà poi compito della nostra game engine, utilizzare tale valore per far avanzare correttamente lo stato del gioco.

Per chiudere, invece che aumentare lo stato del gioco a ritmi regolari (fixed time step) lo facciamo tenendo
conto delle differenze di tempo tra i frame (**variable/fluid time step**).

#### Vantaggi ottenuti:
- Il gioco gira a frame consistenti, anche su differenti hardware.
- Il giocatore con la macchina più veloce, sarà ricompensato con un gioco più fluido.

## Obiettivo risolutivo
Se ho un calo di fps, non voglio che il gioco scorra più lentamente, ma voglio disegnare meno frame.

Ora, vediamo le possibili soluzioni.

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

### Risorse utilizzate
- [YouTube_1](https://www.youtube.com/watch?v=rWtfClpWSb8&ab_channel=ClearCode)
Spiegazione fixed time e delta time (Python)
- [Articolo_1](https://gafferongames.com/post/fix_your_timestep/)
Spiegazione fixed time in relazione alla fisica (linguaggio sconosciuto)
- [Articolo_2](https://gameprogrammingpatterns.com/game-loop.html)
Spiegazione game loop e fps
- [YouTube_2](https://www.youtube.com/watch?v=pctGOMDW-HQ&ab_channel=TheCherno)
Spiegazione fixed time step e delta time (c++)








