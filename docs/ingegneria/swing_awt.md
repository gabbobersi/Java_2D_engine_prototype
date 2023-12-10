# Java Swing & Java AWT

### Concetto principale non scontato: **GUI (Graphic User Interface)**
GUI sta per **Interfaccia grafica utente**. 

- È un'interfaccia che consente agli utenti
di gestire un'applicazione e svolgere le attività richieste. 


- Una GUI è composta
da vari componenti: finestra, pulsanti, pulsanti di opzione, caselle di controllo, etichette,
elenchi a discesa, campi di testo, caselle combinate ecc.  


- Questi componenti **possono attivare eventi,** Ad esempio, una nuova pagina si apre dopo aver fatto clic
su un pulsante, oppure l'utente può inserire i dettagli della registrazione e premere il pulsante
di invio. 

La maggior parte delle applicazioni ha una GUI che consente all'utente di comunicare
con l'applicazione.

****

### AWT
AWT sta per **Toolkit di finestra astratta (Abstract Window Toolkit)**. 

- È un'**API** per sviluppare **GUI** in Java ed è platform dependent, ovvero che i componenti sono mostrati in base al sistema operativo su cui viene eseguita l'applicazione.
- Richiede un oggetto OS nativo per implementare le funzionalità, inoltre i componenti AWT sono **pesanti**
e richiedono **più spazio di memoria** e **tempo
per essere eseguiti**. 
- ButtonLabel, barre di scorrimento, campi di testo, elenchi, finestre di dialogo
e pannelli sono alcuni componenti AWT. Dopo aver creato gli oggetti, vengono posizionati in un
**contenitore**.
****

### Swing
Swing è un kit di strumenti **widget GUI** per Java. 

- È costruito sopra **l'API AWT**. Fa parte delle **Java Foundation Classes (JFC)** di Oracle.
- Swing fornisce componenti di base come
etichette, caselle di testo, pulsanti, ecc. Nonché componenti avanzati come pannelli a schede,
tabelle e alberi. 
- Questo pacchetto, ad esempio, fornisce un numero di classi come JButton, JTable, JList, JTextArea, JCheckBox.

****

### Differenze?
La differenza principale tra AWT e Swing in Java è che:
- **AWT** è il toolkit di widget di
finestre, grafici e widget dell'interfaccia utente **originale** di Java
- **Swing** è
un toolkit di **widget GUI** per Java che è un'estensione di AWT.  

Un altra differenza tra i componenti AWT e i componenti Swing **("lightweight"
o leggeri)** è che i componenti Swing sono implementati **senza una riga di codice
nativo**.

- Anche l’oggetto swing più semplice ha maggiori
funzionalità del suo analogo presente nell’AWT **("heavyweight" o pesante)**
proprio perché crea un **"peer"**, ovvero 
un aggancio al sistema sottostante per
ciascun componente. Quindi è il **sistema operativo** che fornisce,
per esempio, il bottone o la listbox

|          Differenze          |                   AWT | Swing                  | 
|------------------------------|-----------------------|------------------------| 
|            Genere            |    Componenti pesanti | Componenti leggeri     |
| Dipendenza dalla piattaforma |            Dipendente | Indipendente           |
|           Velocità           |                 Lenta | Veloce                 |
|           Memoria            | Più spazio in memoria | Poco spazio in memoria | 
