#### Cosa implementare
- Classe "Player"
  - Rappresenta il giocatore.
  - Deve estendere la classe Entity.
  - Dovrà avere un metodo che imposta i valori di default, non appena la classe viene istanziata (vedi classe di esempio "Gnomo").
- Classe "Enemy"
  - Rappresenta un nemico generico.
  - Deve estendere la classe Entity.
- Classe "Elf"
  - Rappresenta un elfo.
  - Deve estendere la classe **Enemy**.
  - Dovrà avere un metodo che imposta i valori di default, non appena la classe viene istanziata (vedi classe di esempio "Gnomo").
 
**Note**:
- La classe "Enemy" sarà una classe base per le sottoclassi nemiche (es. Elf estende Enemy. Elf è la classe figlia di enemy).
- Player eredita direttamente da Entity, come mai? Mi sono sbagliato. **Sarebbe meglio creare una classe Hero, estesa da Player.**

