package com.manish.game.engine;

import com.manish.game.display.DemoDisplay;
import com.manish.game.window.GameWindow;
import org.lwjgl.glfw.GLFW;

public class GameEngine {
    private long window;
    private boolean running;

    public GameEngine(){
        window = new GameWindow().getWindow();
        running = true;

        new GameLoop(this).run();
        stop();
    }

    public long getWindow() {
        return window;
    }

    public void setWindow(long window) {
        this.window = window;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private static void stop(){
        // Terminate GLFW
        GLFW.glfwTerminate();
    }

    public void update() {
    }

    public void render() {
        new DemoDisplay().render();
    }
}
