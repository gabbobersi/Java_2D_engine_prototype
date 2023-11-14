### Scadenze mensili
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
- Modalità di gioco diverse dall'avventura (aka campagna statica)

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
        - [ ] JavaFX
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
- Giammarco
    - UI / TileMap generator
        - [x] Box (cioè un quadrato con uno sfondo)
        - [x] Button (cioè un box, interagibile)
    - Level design
    - Game design
        - [ ] Bar varie
            - Health
            - Stamina
        - Dialoghi / Narrativa / Lore
- Alessio
    - UI / TileMap generator
        - [x] Box (cioè un quadrato con uno sfondo)
        - [x] Button (cioè un box, interagibile)
    - Level design
    - Game design
        - [ ] Inventario
        - [ ] Dialoghi / Narrativa / Lore
- Francesco
    - [ ] Physics
    - [ ] Audio
    - Game design
        - [ ] Obiettivi
        - [ ] Regole gioco
    - Core
