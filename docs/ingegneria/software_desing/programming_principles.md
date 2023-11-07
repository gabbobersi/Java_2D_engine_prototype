Sotto una raccolta dei principi di programmazione più diffusi.

## DRY
`Don't repeat yourself`\
Dovresti organizzare il tuo codice in modo da minimizzare le ripetizioni di codice e logica.\
Ridurre le ripetizioni porta a un codice più ordinato e riduce notevolmente la possibilità di errori.

## YAGNI
`You Ain't Gonna Need It`\
Non aggiungere funzionalità o codice che non è attualmente necessario per il funzionamento del software
solo perché "potresti averne bisogno in futuro".

## AOOO
`Any Order, Only Once`\
Un'azione dovrebbe essere eseguita in un ordine specifico e solo una volta. 
Questo riduce il rischio di errori e garantisce una corretta sequenza di operazioni.

## LBYL
`Look before you leap`\
"guardare prima di saltare", cioè mirare a evitare eccezioni
o errori esaminando le condizioni in anticipo invece di affrontare le conseguenze di un'azione errata.

## EAFP
`Easier to Ask for Forgiveness than Permission`\
Invece di verificare preventivamente se un'operazione è possibile, 
si prova ad eseguirla e, in caso di errore, si gestisce l'eccezione.

Questo approccio **è spesso associato a Python** e indica che è più 
semplice scrivere codice che "cerchi il perdono" in caso di errore anziché cercare 
di evitare ogni possibile errore in anticipo.