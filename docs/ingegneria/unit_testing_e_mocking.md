# Unit Testing e Mocking in Java
## Unit Test
### 1. Comportamento di un metodo:
- Uno unit test si concentra sul verificare il comportamento di una singola unità di lavoro, spesso identificata come un singolo metodo.
- Esamina se la chiamata a un metodo con un dato input produce il risultato atteso.

### 2. Conformità al contratto:
- Verifica che il metodo segua i termini del contratto definiti dalla sua API.
- Assicura che il metodo si comporti come promesso nella sua firma, rispettando le precondizioni e le postcondizioni.

### 3. Documentazione eseguibile:
- Funge da documentazione eseguibile, fornendo esempi concreti di come utilizzare il metodo.
- Aiuta a comprendere il modo corretto di interagire con il metodo, migliorando la comprensione e facilitando l'uso corretto.

### Altre Tipologie di test:

#### Integration Test:
- Verifica il corretto funzionamento di più unità che interagiscono tra loro.
- Assicura che le diverse componenti del sistema collaborino correttamente quando vengono integrate.

#### End-to-End Test:
- Verifica il comportamento dell'intero sistema.
- Si concentra sull'esperienza dell'utente finale e può coinvolgere interazioni con l'interfaccia grafica o le API esposte.

Ognuna di queste tipologie di test svolge un ruolo diverso nel garantire la qualità del software. Gli unit test forniscono una base solida, 
mentre gli integration test e gli end-to-end test si estendono per assicurare che l'interazione tra diverse parti del sistema e l'esperienza complessiva dell'utente siano coerenti e affidabili.

![piramide_test.png](..%2Fresources%2Fpiramide_test.png)

# JUnit
- **JUnit:** è un framework per facilitare l'implementazione di programmi di test in Java.
- **Versione JUnit:** JUnit 4.
- **Principi del Framework JUnit:**
    - Ciascuno unit test è un metodo.
    - Ogni metodo di test fornito è trovato ed eseguito dal framework usando la riflessione computazionale.
    - Si usano istanze di classi di test separate e class loader separati per evitare effetti collaterali, garantendo esecuzioni indipendenti.
    - Si hanno una varietà di asserzioni per automatizzare il controllo dei risultati dei test.
    - Integrazione con tool e IDE diffusi come Eclipse, IntelliJ, VS Code.

## Esempio
```java
import org.junit.Test;
import static org.junit.Assert.*;
public class TestCalc { // classe di test
    @Test
    public void testAdd() { // l'annotazione indica il test
        Calculator c = new Calculator(); // crea istanza
        double result = c.add(10, 50); // chiama metodo da testare
        assertEquals(60, result, 0); // controlla il risultato e
    } // genera eccezione se result != 60
}
```

_Il codice di esempio rappresenta un semplice test unit per il metodo add della classe Calculator_

## Fondamenti

- JUnit crea una nuova istanza della classe di test prima di invocare ciascun metodo annotato con `@Test`.
    - Per evitare effetti indesiderati.
    - Non si possono quindi riutilizzare variabili fra un metodo e un altro.
    - Ogni test è indipendente dagli altri.

**Esempio:**

```java
public class TestCalc {
    @Test
    public void testAdd1() { ... }
    @Test
    public void testAdd2() { ... }
}
```
## Assert e verifica del comportamento

Per verificare se il codice si comporta come ci si aspetta, si utilizza una **assertion**. Una chiamata al metodo `assert` verifica se il risultato ottenuto (`actual`) coincide con il risultato atteso (`expected`). La classe che fornisce i metodi per valutare le esecuzioni è la classe `Assert`.

Esempi di asserzioni comuni includono:

- `assertTrue(boolean condition)`: Valuta se la condizione è true; altrimenti, il test segnala un errore.
- `assertEquals(int a, int b)`: Verifica se due valori int sono uguali; altrimenti, il test segnala un errore.

I metodi `assert` registrano fallimenti o errori e li riportano. Quando si verifica un fallimento o un errore, l’esecuzione del metodo di test viene interrotta, ma verranno comunque eseguiti gli altri metodi di test della stessa classe.

# Mock e Dependence Injection
Uno unit test, a differenza di un integration test, deve testare una singola unità
(es. metodo) in maniera indipendente dalle classi con cui collabora

## Uso dei Mock

- **Mocking:** Necessario quando si vogliono testare singole unità in modo isolato, indipendentemente dalle classi con cui collaborano.

- **Mock:** Un'istanza di una classe il cui comportamento di alcuni dei suoi metodi viene definito direttamente nel test. Questo consente di controllare il comportamento delle dipendenze della classe in fase di test.

- **Dependence Injection:** Buona pratica in cui le dipendenze di una classe vengono iniettate tramite costruttore, parametro o metodo setter, consentendo l'uso di mock o implementazioni specifiche durante i test.

- **Interfacce:** Legare le classi a un'interfaccia anziché a una classe concreta permette una maggiore flessibilità e disaccoppiamento. I mock possono quindi essere creati come implementazioni di queste interfacce, facilitando il testing.

Queste pratiche favoriscono la scrittura di test efficaci, isolati e manutenibili, fornendo una maggiore sicurezza riguardo al comportamento del codice in fasi di sviluppo e cambiamenti.

## Esempio di Mock senza uso di librerie

- Supponiamo di voler testare il metodo `sum` di una classe `Consumer` che invoca al suo interno il metodo `sum` definito nell'interfaccia `Sommatore`.
- Un'istanza compatibile con l'interfaccia sommatore viene passata in questo caso come dipendenza al costruttore della classe da testare.
- Nel test possiamo definire un'implementazione dell'interfaccia come classe anonima, implementando tutti i metodi dell'interfaccia (in questo caso solo uno) in modo che si limiti a restituire al metodo da testare un risultato predefinito.

```java
@Test
public void testSumTwice() {
    int a = 2;
    int b = 3;
    int expected = 10;
    
    Consumer consumer = new Consumer(new Sommatore() { // Dependence injection
        @Override
        public int sum(int a, int b) {
            return 5;
        }
    });
    
    int res = consumer.sumTwice(a, b);
    
    assertThat(res).isEqualTo(expected);
}
```
# Mockito
![mockito.png](..%2Fresources%2Fmockito.png)

- **Descrizione:** Mockito è una libreria Java utilizzata per semplificare la creazione e la gestione di oggetti mock durante i test unitari.


## Funzionalità durante l'esecuzione del test:

1. **Definizione del valore restituito:**
    - Puoi utilizzare il metodo `when()` o `given()` per definire il comportamento del mock quando un certo metodo viene chiamato durante l'esecuzione del test. Ad esempio, `when(mock.metodo()).thenReturn(valore)`.

2. **Verifica delle chiamate ai metodi:**
    - Puoi utilizzare il metodo `verify()` o `then()` per verificare se un determinato metodo del mock è stato chiamato durante l'esecuzione del test e con quali parametri. Ad esempio, `verify(mock).metodo(parametro)`.

## Differenza dall'approccio tramite classi astratte:
A differenza dell'approccio basato su classi astratte o interfacce, con Mockito non sei obbligato a implementare tutti i metodi di un'interfaccia o classe astratta. Puoi concentrarti solo sui metodi che sono rilevanti per il tuo test, definendo il comportamento desiderato solo per quei metodi.

## Esempio di Mock con Mockito

``` java
public class ConsumerTest {
    @Mock
    Sommatore sommatore;
    @Before
    public void setUp() {
        initMocks(this);
    }
    @Test
    public void testSumTwice_withMockito() {
        int a = 2;
        int b = 3;
        int expected = 10;
// given
        when(sommatore.sum(a,b)).thenReturn(5);
// when
        Consumer consumer = new Consumer(sommatore);
        int res = consumer.sumTwice(a,b);
// then
        verify(sommatore, times(1)).sum(a,b); // posso verficare se è stato chiamato
// una sola volta con i valori di “a” e “b”
        assertThat(res).isEqualTo(expected);
    }
}
```
