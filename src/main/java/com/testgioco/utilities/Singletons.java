package com.testgioco.utilities;

import com.testgioco.core.handlers.InputHandler;
import com.testgioco.core.handlers.MouseHandler;
import com.testgioco.core.handlers.MouseMotionHandler;
import com.testgioco.entities.Player;

public class Singletons {
    public static MouseHandler mouseH = new MouseHandler();
    public static MouseMotionHandler mouseMotionH = new MouseMotionHandler();
}
