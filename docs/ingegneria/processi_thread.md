## Processi e thread
#### Processi
- **Cosa sono:** Istanza indipende di un programma in esecuzione su un sistema operativo.
- **Risorse:** Ogni processo ha il proprio spazio di memoria separato e risorse isolate (es. variabili d'ambiente, descritto di file).
- **Comunicazione tra processi:** solo mediante le **IPC** (comunicazione interprocessuale), come per esempio le code di messaggi e le pipe.
#### Thread
- **Cosa sono:** Piccola unità di elaborazione all'interno di un processo.
- **Risorse:** Condividono lo spazio di memoria del processo principale.
- **Comunicazione tra thread:** tramite variabili condivise.

**NB:** qui non ho parlato degli stati in cui processi e thread possono trovarsi. Indagare a parte.