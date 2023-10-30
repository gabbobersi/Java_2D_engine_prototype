## UML (Unified Modeling Language)
### In generale
- Non è un linguaggio di programmazione.
- E' un linguaggio di modellazione e di specifica, utilizzato per descrivere soluzioni analitiche e
  progettuali in modo sintetico e comprensibile a un vasto pubblico, in relazione a **sistemi orientati agli oggetti**.
- L'UML viene utilizzato principalmente nel contesto dell'ingegneria del software, ma anche per:
    - Sistemi hardware
    - Processi business
    - Database
    - ...
- I diagrammi più diffusi, sono i **diagrammi di classe**, e sono quelli che probabilmente vedrete di più in giro.
- L'UML non definisce alcun metodo per la creazione di diagrammi! Sotto parleremo dello "standard" accettato generalmente.

### Come parlare UML

| OOP             | UML        |
|-----------------|------------|
| Metodo/funzione | Operazione |
| Attributo       | Proprietà  |

(non è fondamentale sapere quanto sopra per l'UML...)

### Come disegnare UML
Esistono software a pagamento e software gratuiti.\
Io consiglio il software [StarUML](https://staruml.io/download/) 
(consigliato anche in università)

### Storicamente
Così come per i design pattern, l'UML ha radici storiche sempre in evoluzione.\
L'obiettivo iniziale infatti, fu di unificare gli approcci de **"i tres amigos"**
(i 3 padri dell'UML che per primi cercarono di raccogliere tali formalismi), migliorarli, e renderli uno standard per l'industria.

A tal proposito, esistono diverse **versioni UML** (NB: sono state saltate le minori):
- UML 1.0 dal 1997
- UML 2.0 dal 2005
- UML 2.5 dal 2013

Cosa cambia tra una versione e l'altra (a grandi linee)?
- Diagrammi aggiuntivi
- Migliorazione semantica
- Semplificazione strutture esistenti

### Elenco diagrammi esistenti
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

Chiaramente ha poco senso impararli a memoria!\
Bisogna valutare il contesto in cui vanno applicati.

### Caratteristiche generali di un modello
Un modello UML è quindi costituito da una collezione **organizzata di diagrammi correlati**.\
La semantica di essi è molto precisa, ed è tale anche il potere descrittivo.
****
## Descrizione secondo 3 aspetti principali
UML consente di descrivere un sistema secondo tre aspetti principali, per ciascuno dei quali si utilizzano diagrammi specifici che possono poi essere messi in relazione fra loro.

### Modello funzionale (functional model)
- **Cos'è:** Descrizione del sistema, lato utente (quindi così com'é percepito dall'esterno).
- **Fase di utilizzo:** raccolta requisiti.
- **Diagrammi utilizzati:** Utilizza il Use Case Diagram
### Modello a oggetti (object model)
- **Cos'è:** Descrizione della struttura e sottostruttura del sistema, utilizzando i concetti Object Oriented (Classi, interfacce, ...).
- **Fase di utilizzo:** analisi del dominio, a diversi livelli di progettazione.
- **Diagrammi utilizzati:** class diagram, sequence diagram, statechar diagram, activity diagram.
### Modello dinamico (dynamic model)
- **Cos'è:** Descrizione del comportamente degli oggetti nel sistema (quindi la loro evoluzione nel tempo e le dinamiche nelle loro interazioni).
- **Fase di utilizzo:** strettamente legato al modello a oggetti, e va usato nei medesimi casi.
- **Diagrammi utilizzati:** Utilizza sequence diagram, activity diagram, statechart diagram.
****
### Struttura modelli
Un modello UML è costituito da:
- Viste:
  - Mostrano diversi aspetti di un sistema, per mezzo di diagrammi.
- Diagrammi
  - Permettono di descrivere graficamente le viste logiche.
- Elementi del modello
  - Caratteristiche base, che permettono la realizzazione di diversi diagrammi (package, oggetti, classi, ...).



### Risorse utilizzate
- [Wikipedia](https://it.wikipedia.org/wiki/Unified_Modeling_Language#Aspetti_della_modellazione)
- [UML DISTILLED (book) - Chapter 3](https://github.com/gcoronelc/PECI-Java-MAR-2015/blob/master/Recursos/UML%20Distilled%203rd%20Ed.pdf)
- [Morrowlinux pt 1](https://www.youtube.com/watch?v=drlRhXL0DD8&ab_channel=morrolinux)