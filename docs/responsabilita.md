### Scadenze mensili

| Nome      | Novembre                        | Dicembre                                                      | Gennaio                  | Febbraio |
|-----------|---------------------------------|---------------------------------------------------------------|--------------------------|----------|
| Bersi     | Audio                           | Interazione con oggetti, generazione personaggi casuale       | IA nemici                | BugFix   |
| Giammarco | Health, stamina, ... system/bar | Dialog System                                                 | Sprite + abbellimento UI | BugFix   |
| Alessio   | Inventory system                | Level System                                                  | Sprite + abbellimento UI | BugFix   |
| Fra       | Fisica                          | Stilare, implementare regole di gioco, creare livelli di test | Sistema degli obiettivi  | BugFix   |

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