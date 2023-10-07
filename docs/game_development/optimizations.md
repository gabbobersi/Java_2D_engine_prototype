Costruendo un semplice game loop, con un sistema di fps per stabilire il ritmo
delle draw, non è comunque garantita la fluidità dell'applicazione.

Nella guida sottostante, cercheremo di capire e risolvere i motivi.

#### Ottimizzazioni
- Ottimizzazioni pre-draw: `createCompatibleImage()` vs `ImageIO.read()`: [link](https://stackoverflow.com/a/13832805)
- Accelerazione grafica OpenGL
- Ottimizzazioni game loop: [link](https://gamedev.stackexchange.com/questions/97933/framerate-is-affecting-speed-of-object)
- Migliorie FPS: [link](https://gafferongames.com/post/fix_your_timestep/)
