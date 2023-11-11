### Strategy Pattern

#### Motivazione/Uso
Il **Strategy Pattern** viene utilizzato per definire una famiglia di algoritmi, incapsularli come oggetti separati e renderli interscambiabili.
Questo pattern permette agli algoritmi di variare indipendentemente
dai clienti che ne fanno uso, e viene impiegato quando si hanno
molteplici varianti di un algoritmo o quando si prevede che
l'algoritmo possa cambiare.

#### Funzionamento
Nel Strategy Pattern, si definisce un'interfaccia
comune per tutti gli algoritmi concreti che sono interscambiabili.
La classe context contiene un riferimento a una strategia e delega
l'esecuzione dell'algoritmo all'oggetto strategia. Gli algoritmi
concreti implementano l'interfaccia della strategia ed eseguono
l'algoritmo effettivo.

#### Esempio Rilevante
Un caso d'uso comune del Strategy Pattern si
trova nei sistemi di calcolo delle tasse,
dove il calcolo delle tasse può variare in base alla regione,
allo stato o ad altri fattori. Il Strategy Pattern permette di
selezionare dinamicamente l'algoritmo di calcolo delle tasse appropriato.



```Java
// Define the Strategy interface
interface Strategy {
    void executeAlgorithm(data);
}

// Create ConcreteStrategyA implementing the Strategy interface
class ConcreteStrategyA implements Strategy {
    void executeAlgorithm(data) {
        // Implement algorithm A
    }
}

// Create ConcreteStrategyB implementing the Strategy interface
class ConcreteStrategyB implements Strategy {
    void executeAlgorithm(data) {
        // Implement algorithm B
    }
}

// Create the Context class
class Context {
    private Strategy strategy;

    // Method to set the strategy
    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // Method to execute the strategy
    void executeStrategy(data) {
        strategy.executeAlgorithm(data);
    }
}

    // Usage of the Strategy Pattern
    Context context = new Context();
    Strategy strategyA = new ConcreteStrategyA();
    Strategy strategyB = new ConcreteStrategyB();

context.setStrategy(strategyA);
        context.executeStrategy(data);

        context.setStrategy(strategyB);
        context.executeStrategy(data);

```

#### Applicazione a un Determinato Ambito
Nel campo dell'intelligenza artificiale, il Strategy Pattern può essere utilizzato per scegliere tra diversi algoritmi di pathfinding o di decision making in base alla situazione di gioco.


#### Principio di Programmazione Soddisfatto
Il Strategy Pattern soddisfa il principio di **Apertura/Chiusura** in quanto il codice client può estendere le funzionalità senza modificare il codice esistente, semplicemente aggiungendo nuove strategie. Soddisfa anche il principio di **Dipendenza Inversa** poiché il codice client dipende da astrazioni (l'interfaccia Strategy), non da classi concrete. Infine, sostiene il principio di **Sostituzione di Liskov**, poiché ogni strategia concreta può essere sostituita da un'altra senza influenzare il comportamento del contesto in cui è utilizzata.


NB: per il Class Diagram e altri esempi e spiegazione ulteriore https://refactoring.guru/design-patterns/strategy 