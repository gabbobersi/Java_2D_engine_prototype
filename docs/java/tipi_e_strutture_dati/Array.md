## Array
In Java, gli array e ArrayList sono due strutture dati che consentono di memorizzare un insieme di elementi dello stesso tipo. Hanno alcune differenze chiave:

**Array**
- **Dimensione fissa**: Gli array hanno una dimensione **FISSA** che viene definita al momento della loro creazione e **NON** può essere modificata in seguito.
- **Stesso tipo**: Gli elementi di un array devono essere dello stesso tipo, e questo tipo viene dichiarato quando l'array viene creato. Non possiamo avere elementi diversi.
- **Accesso rapido**: Gli elementi di un array possono essere acceduti direttamente tramite un indice.

Per scrivere un array si usa la seguente sintassi:
```Java
tipo[] nomeArray = new tipo[dimensione];
```
Dove _tipo[]_ può essere uno *String*, un *int* ecc.

- **Esempio**:
```Java
int[] numeri = new int[5];

// Inserimento di valori nell'array
numeri[0] = 1;
numeri[1] = 2;
numeri[2] = 3;
numeri[3] = 4;
numeri[4] = 5;

System.out.println("Il primo elemento dell'array è: " + numeri[0]);
```
In questo esempio andrò a prendere il primo numero nella lista, ovvero 1.

*N.B: Se avessi messo [3] al posto di [0] mi avrebbe restituito 4, perchè la lista degli elementi parte dallo 0 e non dall'1!!*