Every visible object in the game has a position.\
The position is represented by a `Vector2D` or a `Vector2DInt`.

### Tiles and entities
- `positionOnTheMap`: the position on the world map
- `positionOnTheScreen`: the position on the screen

### Player
- `positionOnTheMap`: the position on the world map
- `positionOnTheScreen`: is the exact center of the screen

### UI
- `positionOnTheScreen`: the position on the screen

### Scenes
- They are always positioned at (0, 0) on the screen (JFrame).

## Get a certain position
We calculate every position relative to the screen size.

**Screen size:**\
GameSetting.screenWidth x GameSetting.screenHeight

**Center of the screen:**\
GameSetting.screenWidth / 2 x GameSetting.screenHeight / 2

### Examples
Top left corner of the screen:\
(0, 0)

Top right corner of the screen:\
(GameSetting.screenWidth, 0)

Bottom left corner of the screen:\
(0, GameSetting.screenHeight)

Bottom right corner of the screen:\
(GameSetting.screenWidth, GameSetting.screenHeight)