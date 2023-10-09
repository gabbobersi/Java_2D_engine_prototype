### Generale
Non esiste un git-flow condiviso mondiale.

Ogni git-flow consiste in un insieme di regole, che l'azienda per cui lavorate
impone, per mantenere:
1. Branch in "produzione" sempre attivo e senza bug.
2. Branch di test in cui testare le proprie modifiche.
3. Branch di implementazione (feature) su cui lo sviluppatore crea le nuove modifiche, per poi testarle sul branch di test.

### Procedura generale
1. Stacchi la tua branch da master.
2. Sviluppi le tue funzionalità sulla nuova feature branch.
3. Una volta che tutti i test sono ok, fai il merge con la **branch di test** per testare il tutto in un ambiente il più possibile realistico.
4. Aggiorni LA TUA FEATURE BRANCH a master.
5. Porti le tue modifiche in master

### Procedura dettagliata
1. Sei sulla branch principale `git switch main`
2. La aggiorni `git pull`
3. Crei una nuova feature branch `git switch -c NOME_BRANCH` 
4. Sviluppi le tue modifiche e le committi, pushi sulla tua branch.
5. Ti sposti sulla branch di test `git switch test`
6. La aggiorni `git pull`
7. Fai il merge della tua feature, dentro a test: `git merge --no-commit --log --no-ff NOME_FEATURE_BRANCH ` (devi essere su test mentre lo fai).
8. git commit 
9. git push
10. I test sono ok?
    1. Se si, prosegui la guida
    2. Se no, torni al punto 4.
11. Ti sposti su master `git switch master`
12. Lo aggiorni `git pull`
13. Fai il merge della tua feature, dentro a master: `git merge --no-commit --log --no-ff NOME_FEATURE_BRANCH ` (devi essere su master mentre lo fai).
14. git commit 
15. git push
