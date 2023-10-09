## Concetti base
**Commit**:
- E' un hash (codice alfa-numerico).
- Rappresenta un "checkpoint" del codice in un preciso momento storico.
- I suoi scopi principali sono:
  - "invertire" una modifica sul codice, appunto, "committata"
  - "rimandare indietro nel tempo" il codice.
  - "salvare" le modifiche apportate.

**Branch**:
- Rappresenta una versione del codice.
- E' formato da commit.
- Ogni branch è indipendente dagli altri. Una modifica apportata e poi committata sul branch "X" non impatta i commit di altri branch.
- Il branch principale si chiama **master** (o main).
- Esistono diverse tipologie di branch (metto solo quelle che uso):
  - principale (o master)
  - feature branch
- I suoi scopi principali sono:
  - Avere una copia del codice "principale", su cui sviluppare e testare nuove funzionalità (feature).


**Repository**: (o repo)
- Rappresenta il progetto principale (TestGioco nel nostro caso).
- E' formata da più branch.

**Remote**: (o origin) \
Dire "remote" (o origin), è come dire "server remoto" (es. GitHub, Bitbucket, GitLab,...).

****
## Fasi
1. Working directory:
   1. E' il tuo codice locale.
2. Area di stage (o index):
   1. Sono le tue modifiche, pronte per essere committate.
   2. Il codice entra in stage tramite `git add`
3. Local repository
   1. E' il tuo codice, sotto forma di commit.
   2. E' rappresentata dalla cartella locale `.git`
   3. Il codice entra in `.git` tramite `git commit`
4. Remote repository
   1. E' il codice presente sulla `remote`.
   2. Il codice entra nella `remote` tramite `git push`

****
## Note da sapere
- In git, i commit e i branch sono degli hash.
- Il commit più "in alto" (recente) di un branch, si chiama **HEAD** (è un termine importantissimo! Se dico "siamo sull'HEAD, significa che siamo aggiornati all'ultimo commit!) 
