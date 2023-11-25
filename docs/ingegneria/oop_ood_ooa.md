## OOP, OOD E OOA: Cosa sono?
**OOP (Object-Oriented Programming)**, **OOD (Object-Oriented Design)**, 
e **OOA (Object-Oriented Analysis)** sono concetti correlati ma _distinti_ nel
contesto della programmazione orientata agli oggetti.

La programmazione Object Oriented è diventata lo stile di programmazione
nell'industria del software negli ultimi anni. La ragione di questo è da
ricercare nella crescita di dimensione dei progetti software.


I programmi Object Oriented sono più semplici
da **scrivere**, **capire** e **mantenere**.

Le ragioni fondamentali sono:

- I programmi OO (Object-Oriented) tendono a essere scritti in termini di **oggetti del
mondo reale**


- I programmi OO incoraggiano **l'incapsulamento**: che è un principio che suggerisce di
nascondere i dettagli interni di un oggetto da un utilizzatore esterno. In altre parole,
l'oggetto fornisce un'interfaccia chiara e specifica per interagire con esso, ma _mantiene
nascoste_ le implementazioni interne complesse.


- I programmi OO incoraggiano la **modularità**: ovvero la suddivisione in parti (moduli)
di un sistema,
in modo che esso risulti più semplice da comprendere e manipolare.
Ogni oggetto in un programma orientato agli oggetti rappresenta un modulo
autonomo che può essere modificato senza influire sugli altri oggetti,
purché l'interfaccia dell'oggetto rimanga **invariata**.

Detto questo, diamo la definizione ai seguenti concetti:

### OOA (Object-Oriented analysis)
- L'**OOA (Object-Oriented analysis)** è la fase del ciclo di vita del software
che si occupa di **descrivere la realtà che stiamo considerando**. Consiste nel produrre
un **modello concettuale** di tale realtà, utilizzando gli oggetti e le classi.

In sostanza, nella fase di OOA si fornisce una **rappresentazione del problema da analizzare**).

Le domande che ci porremo saranno: 
- "Di che cosa il mio programma necessita?",
- "Quali classi saranno presenti nel mio programma?"
- "Qual è la responsabilità di ciascuna classe?".

### OOD (object Oriented Design)
- L'**OOD (object Oriented Design)** è la fase del ciclo di vita del
software che si occupa della **ricerca di una soluzione**. 


È l'**analisi di un problema** e la **costruzione di modelli del mondo reale** con
una **visione orientata agli oggetti**: in altre parole è una _metodologia di analisi_
che esamina le necessità di un problema dal punto di vista delle classi e degli oggetti.

L'obiettivo dell'Object-Oriented Design è creare una struttura
di sistema che sia **robusta**, **flessibile** e **facilmente manutenibile**.

Le domande che ci porremo in questa situazione saranno:
- "Come gestirà la classe le sue responsabilità?"
- "Quali informazioni sono necessarie alla classe?"
- "Come comunicheranno le classi tra loro?"

Il tutto si riassume in: "Quali sono gli attributi e i metodi che ciascuna classe deve avere?".

### OOP (Object Oriented Programming)
- L'**OOP (Object Oriented Programming)** è la fase di codifica,
che porta a una **vera applicazione a oggetti**. Essa fa corrispondere
**oggetti del modello di progettazione** a **oggetti software scritti in un vero e proprio linguaggio di programmazione.**

- Si può dire quindi che la fase di OOP, implementa i modelli derivati dalle fasi precedenti,
ottenendo un **codice a oggetti**.

Ci sono tre parti particolarmente importanti nella definizione di un OOP:

- Utilizza un insieme di oggetti (non algoritmi);
- Ogni **oggetto** è **istanza** di una **classe**;
- Ogni **classe** è _legata_ alle altre attraverso una _relazione_ detta **eredità**.

Se in un programma manca anche solo una di queste caratteristiche, NON lo si può definire object-oriented.
