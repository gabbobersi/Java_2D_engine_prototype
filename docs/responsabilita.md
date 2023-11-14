### Scadenze mensili

| Nome      | Novembre                                   | Dicembre                                          | Gennaio                  | Febbraio |
|-----------|--------------------------------------------|---------------------------------------------------|--------------------------|----------|
| Bersi     | Audio                                      | Interazione con oggetti, logging system           | IA nemici                | BugFix   |
| Giammarco | Sistema delle barre (health, stamina, ...) | Dialog System, nemici/npc                         | Sprite + abbellimento UI | BugFix   |
| Alessio   | Inventory system                           | Level System, creare livelli di test funzionalità | Sprite + abbellimento UI | BugFix   |
| Fra       | Fisica                                     | Stilare/implementare regole di gioco, collisioni  | Sistema degli obiettivi  | BugFix   |


Mancanti:
- Particles system
- Ciclo giorno/notte
    - Effetto scurimento interfaccia (vedo meglio con una torcia?)
- Resources system (legno, pietra, ...)
- Crafting system (basico)
- Building system (posiziono tile che hanno collision = true, oppure estetici con collision= false)
- Mana system
- Personalizzazione personaggio
- Modalità di gioco diverse dall'avventura (aka campagna statica)
- Generazione procedurale mondi


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
