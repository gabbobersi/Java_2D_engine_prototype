## Problema
Quando crei un gioco, vuoi che questo risulti visivamente uguale ovunque. \
Che si tratti di 600 fps oppure 10, il gioco deve procedere allo stesso ritmo.

Gli utenti però, dispongono di differenti dispositivi con differenti caratteristiche.

Inoltre, anche sulla stessa macchina gli fps potrebbero cambiare drasticamente, in base
a scene più dispendiose di risorse, rispetto ad altre più leggere.

### Esempio stessa entità, su differenti macchine

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
Elder Ring, risolve il problema degli fps, limitando superiormente, a 60 fps, tutte
le macchine.

Ci sono però due **svantaggi** a questo approccio:
1. Questa soluzione non tiene conto delle situazioni sotto al limite degli fps. \
Es. se giro a 10 fps, il gioco continuerà ad andare più lento, rispetto ai 60 limite. 
2. Più fps == gioco più fluido e responsivo. Se limiti gli fps, limiti la qualità teorica del gioco.

## Soluzione 2: delta time (dt)
Elder Ring, per risolvere il problema 1 della soluzione sopra, applica anche il delta time.

Il delta time, serve per raggiungere un movimento costante, in tutti i frame, ed è
dato dalla **differenza tra il frame corrente e il frame precedente**.

Moltiplicando tale differenza con qualsiasi movimento, la velocità del gioco risulterà
consistente.

### Esempio stessa entità, diversi delta
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

### Riassumento il calcolo del delta time
```Java
double dt = System.nanotime() - previous_time;
previous_time = System.nanotime();
```

Il valore della variabile `dt` andrà ora moltiplicato a tutti i movimenti, rotazioni, animazioni, all'interno del gioco.
Questa moltiplicazione renderà il movimento indipendente dai frame.

### Risorse utilizzate
[YouTube_1](https://www.youtube.com/watch?v=rWtfClpWSb8&ab_channel=ClearCode)








