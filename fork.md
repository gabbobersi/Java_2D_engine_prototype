Premessa:\
fork è un concetto di GitHub e non è proprio di git.\
Il termine deriva dall'ambiente Unix, in cui fare il "fork" significava clonare (o fare la copia di) un processo esistente.

### Cos'è
Una fork è una nuova repository, clone di un progetto esistente (quest'ultimo lo chiameremo **upstream**).\
La fork condivide codice e regole di visibilità con l'upstream.

### A cosa serve
L'utilizzo principale di un fork, è quello **effettuare suggerimenti** all'upstream.\
In altre parole, la fork va utilizzata solo per proporre nuove idee.\

### Fork syncing
#### Impostare il syncing
Per mantenere una fork sincronizzata e quindi aggiornata al progetto originale, occorre impostare l'upstream della repository locale.
Per farlo:
1. (se non hai già clonato/scaricato i file localmente) Clona la tua fork: `git clone <url della fork>`
2. Verifica le configurazioni delle remote, presenti sulla tua repo locale: `git branch -v`
3. Noterai che ci sono solamente **origin**, noi dobbiamo impostare **upstream**.
4. Quindi: `git remote add upstream <url del UPSTREAM`.
5. A questo punto, rilanciando `git branch -v` vedrai anche una riga per il pull e una per il push di tipo upstream.

#### Effettuare il sync


### Branching vs Fork
Il sistema di branching di git, deve rimanere il default.\
Lo scopo delle fork, come visto sopra, non è quello di rimpiazzare il sistema di branching, quanto più di effettuare suggerimenti (anceh "rapidi") a "server side" di GitHub.

#### Risorse utilizzate:
- Ricerche generali non categorizzate
- [StackOverflow_1](https://stackoverflow.com/questions/3611256/forking-vs-branching-in-github)
- [GitHub_1](https://docs.github.com/en/get-started/quickstart/fork-a-repo)

