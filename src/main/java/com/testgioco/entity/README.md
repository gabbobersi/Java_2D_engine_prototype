#### Cosa implementare
- Classe **Player**
  - Rappresenta il giocatore.
  - Deve estendere: Entity
  - Dovrà avere un metodo che imposta i valori di default (vedi classe "Gnomo").
- Classe **Elf**
  - Rappresenta un elfo.
  - Deve estendere: Entity
  - Dovrà avere un metodo che imposta i valori di default (vedi classe "Gnomo").
- Classe **Orc**
  - Rappresenta un orco.
  - Deve estendere: Entity
  - Dovrà avere un metodo che imposta i valori di default (vedi classe "Gnomo").
 
**Note**:
- Ho creato (erroneamente in Italiano) la classe "Gnomo" che potete usare come esempio.
- Ricordatevi che le classi da creare, estendendo Entity, hanno già delle caratteristiche ereditate da essa (quindi verificate cosa c'è già su Entity, e cosa dovete aggiungere).
- Non vi aspettate che qualcosa appaia sullo schermo. Basta implementarle per ora.
- In futuro, aggiungeremo una cartella (package) "base_classes" che conterrà, oltre a Entity, anche le classi tipo Archer, Warrior, Sourcerer, Witch, ... così potremo stabilire il tipo di classe dei nostri Elf, Orc, ... tramite l'ereditarietà (es. Elf estende Archer). 
