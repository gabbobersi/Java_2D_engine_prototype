package com.testgioco.core.interfaces;

public interface Scene {
    /**
     * Executed the only first time the scene is called.
     * For setup.
     * */
    void awake();

    /**
     * Executed every frame (influenced by FPS).
     * For games logic, input handling.
     * */
    void update();

    /**
     * Executed every fixed time (not influenced by FPS).
     * Happens usually every 0.2 seconds.
     * For physics or in general, to apply movement by physics forces.
     * */
    void fixedUpdate();

    /**
     * Executed just before the scene is unloaded.
     * For cleaning, resources unloading.
     * */
    void unload();
}
