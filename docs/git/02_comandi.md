Elenco comandi spiegati che **vanno saputi**:

Introspezione:
- git status
- git log
- git branch
- git branch -r

Gestione commit:
- git add <file>
- git add .
- git commit
- git commit -m "descrizione"

Spostarsi di branch e commit:
- git switch "branch"
- git switch -c "branch"
- git checkout "hash"

Interazione con la remote:
- git pull
- git push
- git fetch -p

Interazione tra branch:
- git merge --no-commit --log --no-ff "branch"

Inversione modifiche:
- git reverse "hash"
- git reverse -m 1 "hash"

Eliminazione informazioni:
- git branch -D
- git push -D
****

## Comandi di introspezione (analisi)
#### git status
Mostra:
- su quale branch sono
- se ho modifiche locali ancora non in stage.
- se ho commit locali ancora non sulla remote.

#### git log
- Mostra tutti i commit del branch attuale

#### git branch
- Mostra le branch locali (che ho scaricato in passato, dalla remote).

#### git branch -r
- Mostra le branch remote (che vedono tutti)
****
## Comandi per gestire i commit
#### git add "file"
- Aggiunge una modifica locale (un file modificato), in area di stage.

#### git add .
- Aggiunge tutti i file modificati, in area di stage.

#### git commit
- Apre l'editor di testo predefinito, e ti permette di modificare la descrizione del commit.
- Va sempre usata per i **commit di merge**.

#### git commit -m "descrizione"
- Creazione di un commit, con descrizione, one line.
- Rappresenta una versione più "rapida" del normale `git commit`.
- Va sempre usata per i **commit normali**.

****
## Comandi per spostarsi di branch e commit
#### git switch "branch"
- Ti sposta sulla branch

#### git switch -c "branch"
- Crea una nuova branch

#### git checkout "hash"
- Ti sposta sul commit

****
## Comandi per interagire con la remote
#### git pull
- Aggiorna la branch su cui sei, scaricandola dalla remote.

#### git push 
- Aggiorna la branch sulla remote, aggiornandola con i commit da te creati in locale.

## Comandi per interagire tra branch
#### git merge --no-commit --log --no-ff "branch"
1. Te sei sul branch "master" e vuoi integrare delle modifiche (commit) presenti su un branch "controller-giocatore".
2. Questo comando ti permette di aggiungere in stage, le differenze tra quel branch, e il tuo (quindi aggiunge in stage i commit che quel branch ha "in più" rispetto alla branch in cui sei, master).
3. Dovrai comunque fare commit e push.

## Comandi per invertire le modifiche
#### git reverse "hash"
- Inverte le modifiche del **commit normale** specificato (le annulla).
- E' importante notare che i commit successivi, rispetto al commit che hai deciso di "annullare", NON VENGONO ANNULLATI!
  - Se vuoi annullarli, devi fare un git reverse di ognuno dei commit successivi.

#### git reverse -m 1 "hash"
- Inverte le modifiche del **commit di merge** specificato (le annulla).

## Comandi per eliminare branch locali e remoti
#### git branch -D
- Elimina un branch locale.

#### git push -D
- Elimina un branch remoto.
- Mai utilizzarlo su master/main (che comunque sono branch protette...)