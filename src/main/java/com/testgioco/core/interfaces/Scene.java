package com.testgioco.core.interfaces;

public interface Scene {
    /**
     * Executed the only first time the scene is called.
     * For setup.
     * */
    void awake();

    /**
     * Executed every fixed time (not influenced by FPS).
     * For physics or in general, to apply movement by physics forces.
     * */
    void fixedUpdate();

    /**
     * Executed every frame (influenced by FPS).
     * For games logic, input handling.
     * */
    // void update();
}
