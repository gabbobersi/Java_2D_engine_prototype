# Linguaggio interpretato vs Linguaggio compilato
### Definizione
Innanzitutto, la **compilazione** e **l'interpretazione** sono due metodi per _eseguire_ un programma informatico.
Compilatori e interpreti partono da un codice leggibile scritto da una persona e lo convertono in una forma adatta ad essere letta da un computer.

#### _Ma prima di tutto, facciamo un esempio semplice per capirci meglio_

Immaginate di voler leggere un libro in una lingua straniera, ad esempio il russo (Сука блять), ma non conoscete questa lingua. Avete allora due modi per farlo:

- **Versione Compilata**: Qualcuno ha già tradotto il libro dall'originale russo all'italiano. Ora puoi leggere il libro in italiano, che è una lingua che capisci. Questo è simile a un linguaggio compilato, dove il lavoro di traduzione viene fatto in anticipo e tu leggi semplicemente il risultato tradotto.
- **Versione Interpretata**: Invece di avere una traduzione completa, hai un amico che conosce il russo e l'italiano. Quando leggi il libro, il tuo amico è accanto a te e ti aiuta a tradurre le frasi man mano che le leggi. In questo caso, la traduzione è interpretata in tempo reale mentre leggi il libro, e il tuo amico funge da interprete. Questo è simile a un linguaggio interpretato, dove il codice viene tradotto ed eseguito "al volo" mentre il programma è in esecuzione.

Quindi:

- La **compilazione** consiste nel tradurre il codice di un linguaggio A in codice di un linguaggio B. La compilazione viene eseguita da un software compilatore.
- **L'interpretazione** consiste nell'eseguire, riga per riga, il codice B (precedentemente tradotto dal codice A, tramite un compilatore). E' più lenta rispetto alla compilazione.

L'esecuzione di un programma compilato è **molto più veloce** rispetto a un programma interpretato.


### Linguaggi compilati
I linguaggi **compilati**:
- Vengono convertiti **direttamente** nel codice macchina che viene eseguito dal processore. Di conseguenza, tendono ad essere **più veloci** ed **efficienti** da eseguire rispetto ai linguaggi interpretati.
- Permettono allo sviluppatore di avere un maggior controllo sugli aspetti legati all'hardware, come la gestione della memoria e l'uso della CPU.
- Necessitano di una fase di **"costruzione"**: ovvero, all'inizio devono essere compilati manualmente e occorre **"ricostruire"** il programma ogni volta che lo si vuole modificare.
  Nell'esempio del libro, l'intera traduzione viene fatta prima che il libro arrivi a te. Se viene apportata una modifica al libro russo originale, la traduzione in italiano dovrebbe essere aggiornata manualmente da qualcuno e la nuova traduzione deve essere preparata e sostituire la vecchia traduzione. Questo processo richiede tempo e sforzo, fino a quando la nuova traduzione non è pronta e disponibile

Alcuni esempi di linguaggi compilati sono C, C++, Visual Basic, Rust, e Go.

### Linguaggi interpretati
I linguaggi interpretati funzionano attraverso un programma che esegue ogni comando **riga per riga**.

Nell'esempio del libro in russo, se ci sono modifiche nel testo russo originale, il tuo amico dovrà aggiornare le traduzioni in tempo reale mentre leggi.

Alcuni esempi di linguaggi interpretati sono PHP, JavaScript, Ruby ecc.

### Compilato e intepretato insieme, è possibile?

Ci sono però dei linguaggi che sono sia interpretati che compilati, questo è il caso di Java:

- Il codice sorgente viene compilato in un formato intermedio (chiamato **bytecode**), il quale a sua volta viene interpretato dalla **Java Virtual Machine (JVM)**, che ha il compito di interpretare "al volo" le istruzioni bytecode in istruzioni per il processore. 
- Java inoltre è stato progettato per essere altamente **portabile**, poiché il bytecode Java può essere eseguito su qualsiasi piattaforma che abbia una JVM ed è noto per la sua **compilazione anticipata** (Ahead-of-Time Compilation) in bytecode, e ciò significa che il bytecode viene creato in anticipo e non richiede una traduzione in tempo reale.

## Vantaggi e svantaggi

### Vantaggi e svantaggi dei linguaggi compilati:
Vantaggi:

- I programmi che vengono compilati nel codice macchina tendono a essere più veloci del quelli interpretati. 
Questo accade perché il processo di traduzione del codice durante l'esecuzione può sovraccaricare il sistema, rallentando il programma.

Svantaggi:
- Più tempo necessario per completare la fase di compilazione prima di poter fare test

### Vantaggi e svantaggi dei linguaggi interpretati:
Vantaggi:

- I linguaggi interpretati tendono ad essere più flessibili, 
offrendo spesso caratteristiche come la tipizzazione dinamica e programmi 
con minori dimensioni.

Svantaggi:
- Velocità di esecuzione tipicamente ridotta rispetto a quella dei linguaggio compilati.