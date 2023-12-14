package com.testgioco.utilities;

import com.testgioco.core.handlers.KeyboardHandler;
import com.testgioco.core.handlers.MouseHandler;
import com.testgioco.core.handlers.MouseMotionHandler;

public class Handlers {
    private Handlers(){}

    public static MouseHandler mouseH = new MouseHandler();
    public static MouseMotionHandler mouseMotionH = new MouseMotionHandler();
    public static KeyboardHandler keyH = new KeyboardHandler();
}
