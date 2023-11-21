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
- [ ] Button clicked one time, is seen as it was clicked 3 or more times...
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
  - [x] OPTIONALS
    - [x] Tile maps generator
- [x] World map
- [x] Camera
- [ ] Collision detection
- [ ] Object placement
- [ ] Object interaction
- [ ] Sound
- [x] State machine
- [x] Scenes
  - [x] Main menu
  - [x] Option menu
  - [x] Quit game menu
  - [x] TEST

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
