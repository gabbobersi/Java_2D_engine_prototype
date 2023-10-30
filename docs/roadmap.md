_Roadmap from the top, to the bottom._
### Bug fix bounties
- [X] InputHandler (low urgency)
  - issue: while pressing at the same time two keys, one the horiz. and one vert. axies, the player is much faster.
  - solution: Vector2D
- [X] FPS:
  - Issues:
    - [x] Unstable FPS.
      - [x] Player moving faster and slower, since it is rendered with unstable FPS
    - [x] Player being rendered not fluid, in 30 FPS (it should be fluid, over 24 FPS!)
    - All fixed with refactoring. 
- Possible fixes:
  - [x] Independent movement FPS.
  - [x] Fixed Update
### Core
- [x] Main class
- [x] Game class
- [x] JPanel class
- [x] JFrame class
- [x] FPS
- [x] Secondary thread (`Runnable` interface)
- [x] `paintComponent` method to draw something
- [x] Input handler
- [x] Sprites loading
- [x] Animations system
- [x] Tile system
  - [ ] OPTIONALS
    - [ ] Tile maps generator
- [ ] World map
- [ ] Camera
- [ ] Collision detection
- [ ] Object placement
- [ ] Object interaction
- [ ] Sound
- [ ] State machine
- [ ] Scenes
  - [ ] Main menu
  - [ ] Option menu
  - [ ] Quit game menu
  - [ ] TEST

### Responsabilità
- Bersi
  - UI 
    - [x] Label (etichetta, cioè testo a video) 
    - [ ] LayoutManager (disporre le robe UI a schermo)
  - [ ] Audio
  - Game design
    - [ ] World map (movimento personaggio sulla mappa)
    - [ ] Interazione con gli oggetti
    - [ ] Generazione personaggi causali
  - [ ] Core
- Giammarco
  - UI / TileMap generator
    - [x] Box (cioè un quadrato con uno sfondo)
    - [ ] Button (cioè un box, interagibile)
  - Level design
  - Game design
    - [ ] Bar varie
      - Health
      - Stamina
    - Dialoghi / Narrativa / Lore
- Alessio
  - UI / TileMap generator
    - [x] Box (cioè un quadrato con uno sfondo)
    - [ ] Button (cioè un box, interagibile)
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

TileMap generator:
- Quanti tile ho adesso nella cartella assets/tiles?
  - Guarda il numero dei file.
- Che etichetta do al tile?
  - Prendi il nome
- UI
  - Bottoni
  - Grid, in cui dove clicki genera un tile (es cambia da 0 a 3, se abbiamo 4 tile)



### Chill
- [x] Implement a 2D vector class.
- [ ] MVP game (Minimum Viable Product)
- [x] Some entities to test
- [x] Test FPS vs no FPS logic.
- [ ] Improving rendering
- [x] Draw sprites (software Piskel)
- [ ] Game systems
  - [ ] Inventory system
  - [ ] Health, stamina, magick bars
  - [ ] Skill tree
  - [ ] XP points
### Optional
- [ ] Game tools (of any kind, to help development)
- [ ] Automated test (Unit test)
- [ ] Splash screen
- [ ] Beautify UI (buttons, labels, ...)



### Completed details
- Tile System:
  - [x] Tile class
    - Features of a tile.
  - [x] TileManager class
    - [x] Constructor
    - [x] Array of all tile types.
    - [x] Method to draw all tiles
    - [x] Create the first tile map
    - [x] Method to read the tile map
    - [x] Method to load the tile map 
