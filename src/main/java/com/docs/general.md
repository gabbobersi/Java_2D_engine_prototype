### Application structure
Classes are grouped into packages. Each package has a specific purpose.

**core**: Core classes.\
**entities**: Player, enemies, ...\
**scenes**: Menus, levels, ...\
**utilities**: Utility classes.

### Important core classes
`Main` is the entry point of the game.\
`Window` is the unique JFrame.\
`Game` is the state machine, so it manages game states and it contains the game loop.\
`GameState` represents a game state. Allow to retrieve current, previous and next game state.\

### JFrame and JPanel
There is only 1 frame in `Game` class.\
There is only 1 main panel in `Game` class, and multiple secondary panels (**scenes**).

Panels are showed and hidden by the `CardLayout`, based on the current game state.

### Scene system
Every scene is managed by the `Game` class.\
`GameState` class allow to retrieve current, previous and next game state.\

