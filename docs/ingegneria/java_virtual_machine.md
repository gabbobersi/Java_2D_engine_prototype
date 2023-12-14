## Java Virtual Machine

### Cos'è una Virtual Machine?
Innanzitutto, occorre specificare cos'è una Virtual Machine:
Una macchina virtuale è una _rappresentazione virtuale di un
computer fisico_. La macchina virtuale può essere chiamata **guest**,
e il computer fisico su cui gira la macchina virtuale può essere detto **host**.

****
### Concetti principali
La **JVM** è il fulcro dell'ecosistema Java e rende possibile
per i programmi basati su Java di seguire l'approccio **"write once,
run anywhere"** (ovvero scrivi una volta ed esegui ovunque).

- Puoi scrivere del codice Java su una macchina ed eseguirlo
su qualsiasi altra macchina che utilizza la JVM.

- La JVM è stata inizialmente progettata per supportare
soltanto Java anche se nel tempo sono stati adottati altri linguaggi
come Scala, Kotlin e Groovy
sulla piattaforma Java. Tutti questi linguaggi
sono collettivamente conosciuti come **linguaggi JVM**.

Nel documento "The Java Virtual Machine Specification"
abbiamo questa definizione:

«La Java Virtual Machine è una **macchina immaginaria
(astratta)** la cui implementazione può essere effettuata
attraverso l'utilizzo di un **software di emulazione** che
venga eseguito su una **macchina reale**. I programmi che
una JVM sono in grado di eseguire devono essere scritti
in appositi file con estensione **.class**, ognuno dei quali
deve contenere al suo interno il codice per, al massimo,
una classe pubblica.»

[The Java Virtual Machine Specification](https://docs.oracle.com/javase/specs/jvms/se8/html/)

Da cui estrapoliamo delle informazioni importanti:

- Viene scritto il codice sorgente utilizzando la sintassi propria del linguaggio in questione

- Il codice sorgente viene, quindi, analizzato dal compilatore del linguaggio 
il quale (se non vi sono errori di sintassi) produce un codice macchina (object code),
in stretta relazione al sistema operativo e all'hardware in uso.

- Il codice macchina viene assegnato a un **linker**, il quale si
occupa di effettuare il collegamento con eventuali librerie esterne
richiamate dal codice sorgente e di produrre un file eseguibile al termine
(in Windows un **.exe**).

La JVM consiste di tre componenti distinti:

- **Class Loader**
- **Memoria di runtime/area dati**
- **Execution Engine**

![Components.png](JVM%2FComponents.png)

****

### Class Loader
![ClassLoader.png](JVM%2FClassLoader.png)
Quando si compila un file sorgente **.java**, esso viene trasformato in bytecode,
rappresentato da un file **.class**. Quando si utilizza questa classe in un programma,
il class loader la carica nella memoria principale.

Solitamente, la prima classe caricata in memoria è quella che contiene il metodo **main()**.

Il processo di caricamento di una classe passa attraverso tre fasi: **caricamento (loading)**,
**collegamento (linking)**, e **inizializzazione (initialization)**.

**Caricamento**

Questo processo coinvolge l'ottenimento della **rappresentazione binaria (bytecode)**
di una classe o interfaccia con un nome specifico e la generazione della classe o
interfaccia corrispondente.

In Java, ci sono tre class loader integrati:

1. **Bootstrap Class Loader:** Questo è il class loader radice.
Si occupa del caricamento dei pacchetti standard di Java,
come _**java.lang**_, _**java.net**_, _**java.util**_, _**java.io**_, ecc.
Questi pacchetti sono contenuti nel file **_rt.jar_** e
in altre librerie di base nella cartella **_$JAVA_HOME/jre/lib_**.


2. **Extension Class Loader:** Questa è una sottoclasse del **Bootstrap Class Loader** e
superclasse dell'Application Class Loader e carica le librerie standard Java presenti in
_**$JAVA_HOME/jre/lib/ext**_.


3. **Application Class Loader:** È l'ultimo class loader e si occupa del caricamento
dei file presenti nel **classpath**, che di default è la cartella corrente dell'applicazione.

La JVM utilizza il metodo `ClassLoader.loadClass()` per caricare la classe nella memoria, ammesso
che la classe abbia un nome pienamente abilitato.

Se il class loader genitore non riesce a trovare la classe, il compito viene delegato al class
loader figlio. Se l'ultimo class loader figlio non può caricare la classe, viene restituito un
errore di tipo **NoClassDefFoundError** o **ClassNotFoundException**.

**Collegamento**

Dopo il caricamento di una classe in memoria, si procede al processo di collegamento.
Questo implica la connessione degli **elementi (classi e interfacce)** e delle dipendenze del programma.
Il collegamento comprende tre passaggi:

1. **Verifica:** Controlla la correttezza strutturale del file **.class** rispetto a vincoli
e regole. Se la verifica fallisce, si ottiene una **_VerifyException_**.

_Ad esempio, se il codice è stato creato usando Java 11, ma viene eseguito su un sistema che
ha installato Java 8, la fase di verifica fallirà._

2. **Preparazione:** La JVM alloca memoria per i campi statici di una classe o interfaccia
e li inizializza con valori predefiniti.

Ad esempio, supponiamo di aver già dichiarato la seguente variabile nella nostra classe:
```Java
private static final boolean enabled = true;
```
Durante la fase di preparazione, la JVM alloca memoria per la variabile **enabled** e imposta
il suo valore su quello predefinito per un booleano, ovvero **false**.

3. **Risoluzione:** I **riferimenti simbolici** vengono sostituiti con **riferimenti diretti** al
constant pool durante questa fase.

_Ad esempio, se ci sono riferimenti ad altre classi o variabili costanti presenti in altre
classe, sono risolti durante questa fase e rimpiazzati con i riferimenti attuali._

**Inizializzazione:**
L'inizializzazione comporta l'esecuzione del metodo di inizializzazione della classe o 
interfaccia _**(<clinit>)**_. Questo può includere la chiamata del costruttore della classe,
l'esecuzione del blocco statico e l'assegnazione dei valori alle variabili statiche.
È l'ultimo passo del caricamento di una classe.

Ad esempio, se abbiamo dichiarato una variabile _**enabled**_ in `private static final boolean enabled = true;`,
durante la fase di **preparazione**, la JVM la imposterà su _false_, e nella fase di **inizializzazione**
le assegnerà il valore vero, _true_.

Va notato che la JVM è multi-threaded. La gestione della sicurezza del thread
è necessaria per garantire il corretto funzionamento del programma
in un ambiente multi-thread.
****
### Runtime Data Area
![RunTime.png](JVM%2FRunTime.png)
All'interno dell'area dati di runtime, troviamo **cinque** componenti fondamentali,
ognuna con il suo ruolo specifico. 

**1. Area dei metodi**

In questa sezione sono conservati tutti i dati di **livello classe**, compresi i dati del
constant **pool**, i **campi** e i **metodi**, nonché il codice associato a **metodi** e **costruttori**.
Ad esempio, consideriamo la seguente definizione di classe:

```java
public class Employee {
  private String name;
  private int age;

  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
```
In questo esempio, i dati a livello di campo come **_name_** e **_age_**, insieme ai dettagli del
costruttore, vengono caricati nell'**area dei metodi**. Quest'area è creata all'avvio della
macchina virtuale e ne esiste **_una sola per JVM_**.

**2. Area di heap:**
Qui sono memorizzati tutti gli oggetti e le relative variabili di istanza. È l'area di dati
di runtime dalla quale viene allocata la memoria per tutte le istanze di classe e array. Ad
esempio, consideriamo la seguente istanza:

```java
Employee employee = new Employee();
```
In questo caso, un'istanza di **_Employee_** viene creata e caricata nell'area di heap. Anche
l'area di heap è creata all'avvio della JVM e ne esiste una sola per JVM.

Nota: Poiché l'area dei metodi e l'heap condividono la stessa memoria tra più thread,
i dati memorizzati qui **non** sono thread-safe.

**3. Stack**

Ogni volta che viene creato un nuovo thread nella JVM, viene creato un **proprio stack di
runtime**. Questo stack contiene tutte le **_variabili locali_**, le **_chiamate di metodi_** e i _**risultati
intermedi**_. Se la dimensione del stack richiesta da un thread supera quella disponibile, la JVM
restituirà un **_StackOverflowError_**.

Ogni chiamata di metodo _crea_ un'entrata nel frame dello stack, e quando la chiamata del metodo
è completata, il frame dello stack viene _rimosso_. Un frame dello stack è suddiviso in tre parti:

- **Variabili locali:** Ogni frame contiene un **array di variabili locali**.
La lunghezza di questo array è determinata al momento della compilazione.
- **Stack degli operandi:** Ogni frame include uno stack **LIFO (last-in-first-out)**
conosciuto come _stack degli operandi_, che funge da spazio di lavoro per le operazioni intermedie.

_La profondità massima dello stack è determinata al momento della compilazione._
- **Frame Data:** Contiene simboli relativi ai metodi e informazioni sui **blocchi
catch** in caso di eccezioni.

**4. Registri Program Counter (PC)**

Poiché la JVM supporta più thread contemporaneamente, ogni thread ha il proprio registro
PC che contiene l'indirizzo dell'istruzione JVM attualmente in esecuzione. Dopo l'esecuzione
di un'istruzione, il registro PC viene aggiornato con l'indirizzo dell'istruzione successiva.

**5. Stack dei metodi nativi**

La JVM contiene **stack dedicati** ai **metodi nativi** scritti in linguaggi _diversi_ da Java,
come **_C e C++_**. Per ogni nuovo thread, viene allocato uno stack separato per i metodi nativi.

****
### Execution Engine
![Execution.png](JVM%2FExecution.png)
Una volta che il _**bytecode**_ è stato caricato nella memoria principale e i dettagli sono resi
disponibili nell'area dati di runtime, il passo successivo consiste nell'eseguire il programma,
compito affidato all'execution engine che si occupa di **eseguire il codice presente in ogni classe**.

Prima di procedere all'esecuzione, è necessario convertire il bytecode in istruzioni in
linguaggio macchina. La JVM può utilizzare un interprete o un compilatore JIT (Just-In-Time)
per l'execution engine.

**Interprete**

L'interprete legge ed esegue le istruzioni del bytecode una alla volta.
A causa di questa esecuzione **sequenziale**, l'interprete può risultare relativamente _**più lento**_.
Un altro inconveniente è che ogni volta che un metodo viene chiamato, è necessaria una **nuova
interpretazione**.

**Compilatore JIT**

Il compilatore JIT rimedia allo svantaggio dell'interprete. L'**_execution engine_**
inizia usando l'interprete per eseguire il bytecode, ma quando rileva del codice ripetuto,
passa al compilatore JIT. Quest'ultimo compila l'intero bytecode, trasformandolo in codice
macchina nativo, che viene quindi utilizzato direttamente per le chiamate di metodi ripetute,
migliorando così le prestazioni complessive del sistema.

Il compilatore JIT è composto da diverse componenti, tra cui l'**Intermediate Code Generator**,
il **Code Optimizer**, il **Target Code Generator** e il **Profiler**. Queste fasi lavorano insieme per
_generare_, _ottimizzare_ e _convertire_ il codice intermedio in **_codice macchina nativo_**, identificando
anche gli **hotspot**, ovvero il codice eseguito _ripetutamente_.

Per comprendere meglio la differenza tra **interprete** e **compilatore JIT**, prendiamo in
considerazione il seguente esempio di codice:

```java
int sum = 10;
for(int i = 0; i <= 10; i++) {
   sum += i;
}
System.out.println(sum);
```

- Un interprete accede alla memoria per recuperare il valore di `sum` a ogni iterazione del loop,
esegue l'aggiunta di `i` e scrive il risultato in memoria. Questa operazione può essere
dispendiosa in quanto richiede l'accesso continuo alla memoria.

- Il compilatore JIT riconosce che questo codice è un **hotspot** e **ottimizza**
le operazioni. Conserva una copia locale di `sum` nel registro PC per il thread e
aggiunge il valore di `i` direttamente nel loop. Una volta completato il loop,
scrive il valore finale di `sum` in memoria.

- Sebbene il compilatore JIT richieda più tempo per compilare rispetto
all'interprete, è preferibile quando il programma viene eseguito più volte.
Per esecuzioni singole, l'interprete potrebbe essere più vantaggioso.

**Garbage Collector (GC)**

Il Garbage Collector è responsabile di _**raccogliere**_ e **_rimuovere_** gli _**oggetti non
referenziati**_ dall'area di _**heap**_, recuperando così la memoria di runtime inutilizzata.
Questo processo rende efficiente l'**_allocazione_** e il **_rilascio_** della memoria in Java,
eliminando gli oggetti non più utilizzati.

Il Garbage Collector opera in due fasi principali:
- La fase di **Mark**, in cui vengono identificati
gli oggetti inutilizzati
- La fase di **Sweep**, in cui vengono rimossi gli oggetti identificati
durante la fase precedente. 

Questo processo di raccolta avviene automaticamente a intervalli regolari e
non richiede gestione separata.

Esistono tre tipi principali di Garbage Collector nella JVM:

1. **Serial GC:** Questa è l'implementazione _più semplice_, progettata per applicazioni
mono-thread di dimensioni ridotte. Utilizza un solo thread per la raccolta,
causando un evento "stop the world" durante l'esecuzione.

2. **Parallel GC:** Questo è l'implementazione _predefinita_, nota anche come Throughput
Collector. Utilizza più thread per la raccolta, ma mette comunque in pausa l'applicazione
durante l'esecuzione.

3. **Garbage First (G1) GC:** Progettato per applicazioni multi-thread con un'_ampia
dimensione di heap_. G1GC suddivide l'heap in regioni di dimensioni uguali e utilizza
più thread per la scansione. Identifica le regioni più ricche di oggetti non più
referenziati per una raccolta più efficiente.
****
### Errori nella JVM
- **ClassNotFoundException**: Si verifica quando il class loader sta cercando di caricare
delle classi usando **Class.forName()**, **ClassLoader.loadClass()** o **ClassLoader.findSystemClass()**
ma non viene trovata nessuna definizione per il nome della classe specificato.


- **NoClassDefFoundError**: Si verifica quando un compilatore compila con successo la classe,
ma il class loader non è in grado di individuare il file class durante il runtime.


- **OutOfMemoryError**: Si verifica quando la JVM non può allocare un oggetto perché non c'è memoria,
e non è possibile liberare altra memoria tramite il garbage collector.


- **StackOverflowError**: Si verifica quando la JVM esaurisce la memoria creando un nuovo frame dello
stack processando un thread.