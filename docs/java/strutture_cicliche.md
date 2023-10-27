## Principali cicli in Java (FOR, WHILE, DO WHILE)

In Java, i principali **cicli (loop)**, chiamati 
anche **costrutti iterativi**, sono utilizzati 
per _eseguire_ una serie di istruzioni 
**ripetutamente** fino a quando una condizione 
specifica 
non è soddisfatta. 

Abbiamo due tipi di cicli:
- **for** (con le sua variante **for each**)
- **while** (con la sua variante **do-while** )

### Ciclo for

il ciclo FOR crea un ciclo determinato ossia esegue 
un blocco di istruzioni per N volte. È spesso 
utilizzato quando si conosce il numero esatto 
di iterazioni che si desidera eseguire. 
Abbiamo una variabile detta **"variabile contatore"** 
per contare il numero di volte in cui un'azione o un 
blocco di codice è stato eseguito

La sintassi è la seguente:
```Java
for (inizializzazione; condizione; incremento) {
        // Istruzioni da eseguire
        }
```
- **Inizializzazione**: Il primo parametro inizializza la variabile 
contatore assegnandola a un valore iniziale.
- **Condizione**: Il secondo parametro fissa la condizione di controllo, 
in genere è legato alla variabile contatore.
- **Incremento**: Il terzo parametro indica l'incremento 
della variabile contatore al termine di ogni ciclo.

Esempio:
```Java
int i = 1
for (int i = 1; i <= 5; i++) {
        System.out.println(i);
        }
```
In questo esempio, il ciclo "for" eseguirà le istruzioni 
all'interno di esso cinque volte e mi stamperà i numeri dall'1 al 5 compreso.

### Variante "for each"
Questo tipo di loop è utilizzato per _attraversare_ e _iterare_ attraverso 
le collezioni (come **array**, **liste** o altri tipi di **strutture dati**) senza dover gestire 
manualmente gli indici o i puntatori agli elementi.
È particolarmente utile quando si deve eseguire un'operazione su ogni 
elemento di una collezione. 

Come già detto, questo ciclo richiede un **array**, cioè un container 
con diversi oggetti di uno stesso tipo di dati.

La sintassi è la seguente:
```Java
for (Tipo elemento : collezione) {
        // Istruzioni da eseguire per ogni elemento
        }
```
Esempio:
```Java
int[] numeri = {1, 2, 3, 4, 5};

        for (int numero : numeri) {
        System.out.println("Numero: " + numero);
        }
```
L'output sarà il seguente:
```makefile
Numero: 1
Numero: 2
Numero: 3
Numero: 4
Numero: 5
```
In questo esempio, stiamo utilizzando un array di interi chiamato "numeri".
Il ciclo "for-each" attraversa l'array e **assegna** ogni elemento dell'array 
alla variabile "numero" una alla volta. All'interno del ciclo,
stampiamo ciascun elemento, ottenendo l'output desiderato.

### while
Il ciclo **"while"** viene utilizzato per ripetere l'esecuzione di un blocco di 
istruzioni _finchè_ la condizione specifica è **soddisfatta**.

La sintassi è la seguente:
```Java
while (condizione) {
        // Istruzioni da eseguire
        }
```
Esempio:
```Java
int i = 1;
        while (i <= 5) {
        System.out.println(i);
        i++; // Incremento della variabile
        }
```
In questo caso, il ciclo "while" continuerà a eseguire le istruzioni 
all'interno di esso fintanto che la variabile "i" è minore o uguale a 5.
La variabile "i" viene incrementata di 1 alla fine di ogni iterazione.

### Variante do-while
Il ciclo "do-while" è un altro tipo di ciclo in Java che è _simile_ al ciclo "while", 
ma ha una differenza fondamentale:
Nel ciclo "do-while", le istruzioni vengono eseguite 
_almeno_ una volta, **indipendentemente** dalla condizione. 
Dopo l'esecuzione iniziale, il ciclo "do-while" verifica la condizione e continua a 
eseguire le istruzioni fintanto che la condizione è vera.

Per la sintassi il while è posto alla fine del ciclo:
```Java
do {
        // Istruzioni da eseguire
        } while (condizione);
```
Esempio:
```Java
int i = 1;
        do {
        System.out.println(i);
        i++; // Incremento della variabile
        } while (i <= 5);
```
In questo caso, il ciclo "do-while" eseguirà le istruzioni all'interno _almeno una volta_,
**indipendentemente** dalla condizione. Dopo l'esecuzione iniziale,
verifica la condizione **i <= 5** e continua a eseguire le istruzioni 
fintanto che la condizione è **vera**