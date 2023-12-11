### Decisioni
- [x] Palette per tutte le sprite
- [x] Dimensione sprite: 32x32
- [x] Procedurale o a livelli: procedurale
- [x] Formato sprite: PNG

### Premesse
Le seguenti scadenze sono opzionali.\
Se portate avanti (o oltre) dovrebbero garantire un buon rilascio del progetto finale.

Si è liberi di fare ciò che si vuole con esse.\
Seguirle, anticiparle, ignorarle. In quest'ultimo caso, è necessario informare uno degli altri programmatori perché si prenda carino dell'attività al posto vostro.

Se viste attentamente, si noterà che sono attività relativamente (in base alle competenze) brevi. Ciò per consentire ulteriore libertà di organizzarsi meglio.

### Premesse per studenti universitari
Il periodo che va da dicembre a inizio marzo, è considerato prioritario verso l'università.\
Nessun ritardo o mancanza di contenuti sarà evidenziata.\
**E' comunque sempre necessario comunicare se non si è in grado di portare avanti una delle attività sottostanti, visto il rilascio in prossimità di febbraio/marzo.**

### Regole generali
- Le nozioni tecniche imparate fino al giorno corrente (qualsiasi esso sia) sono date per scontate. Quindi git, java, project management, ...
- Le attività da sviluppare invece, sono permesse in collaborazione (aka potete sempre chiedere una mano lì).
- **Unica "minaccia":** un'attività che sfora il periodo di scadenza, sarà redistribuita a chi ha tempo di svilupparla. 

## Scadenze mensili
#### Sistemi
| Nome      | Novembre                                   | Dicembre                                          | Gennaio                                                              | Febbraio |
|-----------|--------------------------------------------|---------------------------------------------------|----------------------------------------------------------------------|----------|
| Bersi     | Audio                                      | Interazione con oggetti, logging system           | IA nemici, ciclo giorno/notte, resources system (legno, pietra, ...) | BugFix   |
| Giammarco | Sistema delle barre (health, stamina, ...) | Dialog System, nemici/npc                         | Abbellimento UI, mana system                                         | BugFix   |
| Alessio   | Inventory system                           | Level System, creare livelli di test funzionalità | Abbellimento UI, generazione procedurale mondi                       | BugFix   |
| Fra       | Fisica                                     | Stilare/implementare regole di gioco, collisioni  | Sistema degli obiettivi, particles system                            | BugFix   |


Mancanti:
- Effetto riduzione visibilità durante la notte (vedo meglio con una torcia?)
- Crafting system (basico)
- Building system (posiziono tile che hanno collision = true, oppure estetici con collision= false)
- Personalizzazione personaggio
- Difficoltà di gioco diverse (hardcore, easy, ...)

#### Sprite
Software consigliato: [Piskel](https://www.piskelapp.com/)\
NOTA: Per tutte le sprite, dovremmo decidere un'unica palette di colori!!!! [Lospec](https://lospec.com/palette-list)

| Nome      | Novembre | Dicembre | Gennaio  | Febbraio            |
|-----------|----------|----------|----------|---------------------|
| Bersi     | 5 tile   | 3 items  | 1 npc    | Abbellimento tile   |
| Giammarco | 2 nemici | 5 tile   | 2 nemici | Abbellimento nemici |
| Alessio   | 3 items  | 2 nemici | 3 items  | Abbellimento npc    |
| Fra       | 2 npc    | 3 items  | 5 tile   | Abbellimento tile   |

(npc e nemici saranno composti da diverse sprite ciascuno, per via di animazioni. Prevedo minimo 4 sprite per le 4 direzioni di movimento + 2 per talk/attack forse?)

Totali
- Nemici: 6
- Npc: 3
- Tile: (3 vecchi) + 15
- Items: 12

### Responsabilità
- Bersi
    - UI
        - [x] Label (etichetta, cioè testo a video)
        - [ ] LayoutManager (disporre le robe UI a schermo)
    - [ ] Audio
        - [x] JavaFX
        - [ ] OpenAl
    - Game design
        - [x] World map (movimento personaggio sulla mappa)
        - [ ] Interazione con gli oggetti
        - [ ] Generazione personaggi causali
    - [ ] Core
        - [x] State machine
            - [x] Panel add/removal
            - [x] Input focus for new panels
            - [x] Game states system
            - [x] Scenes system
            - [x] Animation system
            - [x] Axis system
            - [x] Refactoring UI with inheritance
- Giammarco
    - UI / TileMap generator
        - [x] Box (cioè un quadrato con uno sfondo)
        - [x] ButtonLabel (cioè un box, interagibile)
    - Level design
    - Game design
        - [x] Bar varie
            - Health
            - Stamina
        - Dialoghi / Narrativa / Lore
- Alessio
    - UI / TileMap generator
        - [x] Box (cioè un quadrato con uno sfondo)
        - [x] ButtonLabel (cioè un box, interagibile)
    - Level design
    - Game design
        - [x] Inventario
        - [ ] Dialoghi / Narrativa / Lore
- Francesco
    - [x] Physics
    - [x] Audio
    - Game design
        - [ ] Obiettivi
        - [ ] Regole gioco
    - Core
