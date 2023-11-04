package com.testgioco.utilities;

import com.testgioco.core.InputHandler;
import com.testgioco.core.MouseHandler;
import com.testgioco.core.MouseMotionHandler;

public class Singletons {
    public static InputHandler keyH = new InputHandler();
    public static MouseHandler mouseH = new MouseHandler();
    public static MouseMotionHandler mouseMotionH = new MouseMotionHandler();
}
