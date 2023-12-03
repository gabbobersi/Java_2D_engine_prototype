### Riassunto
#### Array
- PRO:
  - Memory efficient.
  - Accesso e modifica rapidi.
- CONTRO:
  - Dimensione statica.

#### ArrayList
- PRO:
  - Dimensione dinamica.
  - Buoni per l'accesso ai dati.
- CONTRO:
  - Meno efficienti degli array.
  - Possono contenere solo oggetti.
  - Lento nell'eliminazione o inserimento di elementi.

#### LinkedList
- PRO:
  - Dimensione dinamica.
  - Buoni per l'inserimento o la rimozione di elementi.
- CONTRO:
  - Lentezza di accesso.
  - Occupano memoria superiore agli ArrayList.    

****

### Array vs ArrayList
- Array:
  - Dimensione statica, stabilita al momento della creazione.
  - Può contenere tipi primiti o oggetti.
  - Utilizza meno memoria degli ArrayList, per via della mancanza di dinamicità.
- ArrayList:
  - Dimensione dinamica, modificabile al bisogno.
  - Può contenere solo oggetti.
  - Utilizza più memoria degli Array, per via della sua dinamicità.
 
#### Accesso Array vs ArrayList
```Java
// Array
int []numbers = {1, 2, 3, 4, 5, 6};
numbers[0]; // 1
numbers[1]; // 2
numbers[2]; // 3
numbers[3]; // 4
numbers[4]; // 5
numbers[5]; // 6

// ArrayList
ArrayList<Integer> arr = new ArrayList();
arr.add(1);
arr.add(2);
arr.add(3);
arr.add(4);
arr.add(5);
arr.add(6);

arr.get(0); // 1
arr.get(1); // 2
arr.get(2); // 3
arr.get(3); // 4
arr.get(4); // 5
arr.get(5); // 6
```

### ArrayList vs LinkedList
Entrambe possono contenere solo oggetti.\
Esempio:
```Java
ArrayList<Integer> arr = new ArrayList();   // OK
ArrayList<int> arr = new ArrayList();       // ERRORE

// Quanto sopra, vale anche per le LinkedList.
```
- ArrayList:
  - E' efficiente nell'accesso ai dati, poiché utilizza un Array sottostante.
  - Potrebbe essere lento (dipendentemente dalla dimensione dell'array) nell'inserimento ed eliminazione di elementi. Il motivo è che è richiesto il ridimensionamento dell'Array sottostante (come sappiamo, gli array sono statici).
- LinkedList:
  - E' efficiente quando si devono fare molti inserimenti, eliminazioni di elementi, poiché non richiede il ridimensionamento di un Array (non lo utilizza!).
  - L'accesso agli elementi è lento, in quanto è richiesto l'attraversamento sequenziale della lista.
