**Premessa**:\
fork è un concetto di GitHub e non è proprio di git.\
Il termine deriva dall'ambiente Unix, in cui fare il "fork" significava clonare (o fare la copia di) un processo esistente.

### Cos'è
Una fork è una nuova repository, clone di un progetto esistente (quest'ultimo lo chiameremo **upstream**).\
La fork condivide codice e regole di visibilità con l'upstream.

### A cosa serve
L'utilizzo principale di un fork, è quello **effettuare suggerimenti** all'upstream.\
In altre parole, la fork va utilizzata solo per proporre nuove idee.

E' bene notare anche l'utilizzo secondario della fork, cioè quello di **lavorare in isolamento** su un progetto che si desidera modificare (indipendentemente dallo stato dell'upstream).\
In questa situazione, il progetto forkato (clonato) diventerà a sé stante, non venendo più sincronizzato con il suo upstream.

### Fork syncing
#### Impostare il syncing
Per mantenere una fork sincronizzata e quindi aggiornata all'upstream, occorre impostare il puntamento all'upstream nella repository locale (cioè al clone che hai fatto della tua fork).
Per farlo:
1. (se non hai già clonato/scaricato i file localmente) Clona la tua fork: `git clone <url della fork>`
2. Verifica le configurazioni delle remote, presenti sulla tua repo locale: `git branch -vv`
3. Noterai che ci sono solamente **origin**, noi dobbiamo impostare **upstream**.
4. Quindi: `git remote add upstream <url dell'UPSTREAM>`.
5. A questo punto, rilanciando `git branch -vv` vedrai anche una riga per il pull e una per il push di tipo upstream.

#### Effettuare il sync
Da GitHub:
1. Apri il progetto della fork.
2. Premi in alto a destra sul bottone "Sync fork".
3. Dopo aver visionato le modifiche che ti viene richiesto di integrare nella fork, premi su "Update branch".

Da locale:
1. Recupera le informazioni dall'upstream: `git fetch upstream`
2. Spostati sul branch di default (main o master)
3. Integra le informazioni recuperate al punto 1: `git merge upstream/main`

### Branching vs Fork
Il sistema di branching di git, deve rimanere il principale nonché default, rispetto alle fork.\
Lo scopo delle fork, come visto sopra, non è quello di rimpiazzare il sistema di branching di git, quanto più di effettuare suggerimenti (anche "rapidi").\
Vale la pena notare che le fork sono utilizzabili completamente "server side", quindi direttamente su GitHub (senza clonare il progetto in locale).

### Cose particolari
#### Eliminazione upstream
Se l'upstream viene eliminato, ed ha visibilità pubblica, le fork continueranno a esistere come progetti a parte.\
Viceversa, se la visibilità è privata, le fork scompariranno.
#### Eliminazione da collaboratore
Se il proprietario dell'upstream ti rimuove dai collaboratori, e se l'upstream ha visibilità privata, perderai l'accesso anche alla fork.
#### Disabilitare il forking del progetto
Il proprietario, o gli admin del progetto, possono disabilitare il forking della repository.

### Opinione di Gabri (16/10/23)
Credo che non esistano validi motivi per utilizzare una fork in una situazione "regolare".\
Per "regolare", intendo una situazione di reciproca fiducia, in cui non sia ha certo paura che l'upstream venga eliminato da un momento all'altro.\
Meglio evitare di gestire le fork come "branch" in quanto, in caso di problemi, si ritornerebbe a sistemare tutto tramite branching...

Notare che la gestione delle fork dipende anche dalla visibilità del progetto. Si rischia di incorrere in situazioni spiacevoli, quindi è meglio disabilitarne la creazione nelle configurazioni del progetto.
#### Risorse utilizzate:
- [StackOverflow_1_Forking_vs_Branching](https://stackoverflow.com/questions/3611256/forking-vs-branching-in-github)
- [GitHub_1_Fork_a_repo](https://docs.github.com/en/get-started/quickstart/fork-a-repo)
- [GitHub_2__Syncing_a_fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/syncing-a-fork)
- [GitHub_3_What_happens_to_a_git_fork_when_a_repository_is_deleted_or_changed_visibility](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/what-happens-to-forks-when-a-repository-is-deleted-or-changes-visibility)
