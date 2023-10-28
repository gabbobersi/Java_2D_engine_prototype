Il cast riguarda i tipi primitivi.

Il cast (o casting) in Java, consiste nel cambiare il tipo del valore di una variabile, in un altro.

Il cast è automatico se passi da un tipo a uno più grande e se non c'è perdita di dati:
- Da int a float il cast è automatico (infatti non ho perdita di dati)
- Da float a int il cast è obbligatorio, in quanto perdo la virgola (precisione)

In sostanza, la regola base è che se ho perdita di dati durante il cast, devo esplicitarlo.

### Esempio
```Java
// Conversione implicita - Non ho perdita di dati.
// int (4 byte) --> float (4 byte)
int x = 5;
float xF = x;

// Conversione esplicita - Ho perdita di dati. Perdo i valori dopo la virgola, del float.
// float (4 byte) --> int (4 byte)
float xF = 5.3;
int x = (int)xF; // Diventerà 5

// Conversione esplicita - Ho perdita di dati. Oltre al perdere alcuni tra i valori con più precisione (più piccoli/meno significativi)
// sto passando da un tipo di dato PIU GRANDE a uno PIU PICCOLO.
// double (8 byte) --> float (4 byte)
double x = 5.4;
float xF = (float) x; // Diventerà 5.4, ma passando da un tipo più grande a uno più piccolo, c'è stata comunque perdita di dati, anche se non ha impattato il valore 5.4
```
