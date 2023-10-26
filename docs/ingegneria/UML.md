## UML (Unified Modeling Language)
- Non è un linguaggio di programmazione.
- E' un linguaggio di modellazione e di specifica, utilizzato per descrivere soluzioni analitiche e
  progettuali in modo sintetico e comprensibile a un vasto pubblico, in relazione a sistemi orientati agli oggetti.
- Così come per i design pattern, l'UML ha radici storiche, sempre in evoluzione.
  - L'obiettivo iniziale infatti, fu di unificare gli approcci de **"i tres amigos"**
    (i 3 padri dell'UML che per primi cercarono di raccogliere tali formalismi), migliorarli, e renderli uno standard per l'industria.  

Parliamo quindi di evoluzioni storiche.\
A tal proposito, esistono diverse **versioni UML** (NB: sono state saltate le minori):
- UML 1.0 dal 1997
- UML 2.0 dal 2005
- UML 2.5 dal 2013

Cosa cambia tra una versione e l'altra (a grandi linee)?\
- Diagrammi aggiuntivi
- Migliorazione semantica
- Semplificazione strutture esistenti

### Elenco diagrammi
- Diagramma dei casi d'uso (Use Case Diagram)
- Diagramma delle classi (Class Diagram)
- Diagramma degli oggetti (Object Diagram)
- Diagramma delle sequenze (Sequence Diagram)
- Diagramma delle attività (Activity Diagram)
- Diagramma dei componenti (Component Diagram)
- Diagramma dei deployment (Deploymenti Diagram)
- Diagramma dei package (Package Diagram)
- Diagramma degli oggetti composti (Composite Structure Diagram)
- Diagramma delle collaborazioni (Collaboration Diagram)
- Diagramma degli stati (Statechart Diagram)
- Diagramma del tempo (Timing Diagram)
- Diagramma delle comunicazioni (Communication Diagram)

Chiaramente ha poco senso impararli a memoria.\
Bisogna valutare il contesto in cui vanno applicati!

### Caratteristiche generali
Un modello UML è quindi costituito da una collezione **organizzata di diagrammi correlati**.\
La semantica di essi è molto precisa, ed è tale anche il potere descrittivo.

UML consente di descrivere un sistema secondo tre aspetti principali, per ciascuno dei quali si utilizzano diagrammi specifici che possono poi essere messi in relazione fra loro:
- Modello funzionale (functional model)
  - Descrizione del sistema, lato utente (quindi così com'é percepito dall'esterno).
  - Viene utilizzata in campo ingegneristico, per la fase di **raccolta requisiti** di un progetto.
  - Utilizza il Use Case Diagram
- Modello a oggetti (object model)
  - Descrizione della struttura e sottostruttura del sistema, utilizzando i concetti Object Oriented (Classi, interfacce, ...).
  - Viene utilizzata nella fase di **analisi del dominio**, a diversi livelli di progettazione.
  - Utilizza class diagram, sequence diagram, statechar diagram, activity diagram.
- Modello dinamico (dynamic model)
  - Descrizione del comportamente degli oggetti nel sistema (quindi la loro evoluzione nel tempo e le dinamiche nelle loro interazioni).
  - E' strettamente legato al modello a oggetti, e va usato nei medesimi casi.
  - Utilizza sequence diagram, activity diagram, statechart diagram. 

### Risorse utilizzate
(Wikipedia)[https://it.wikipedia.org/wiki/Unified_Modeling_Language#Aspetti_della_modellazione]
