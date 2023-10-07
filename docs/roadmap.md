_Roadmap from the top, to the bottom._
### Bug fix bounties
- [X] InputHandler (low urgency)
  - issue: while pressing at the same time two keys, one the horiz. and one vert. axies, the player is much faster.

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
    - [ ] Change the array of tiles, into an HashMap (so you can refer to a tile by name).
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
### Chill
- [x] Implement a 2D vector class.
  - REF.: 
    - [GitHub](https://gist.github.com/gunvirranu/6816d65c0231981787ebefd3bdb61f98) 
    - [YouTube](https://www.youtube.com/watch?v=RrjRbTg6T2c&ab_channel=M3832)
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