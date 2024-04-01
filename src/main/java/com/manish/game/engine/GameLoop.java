package com.manish.game.engine;

import org.lwjgl.glfw.GLFW;

public class GameLoop{
    private final GameEngine gameEngine;

    public GameLoop(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000.0 / 60.0; // 60 ticks per second
        double delta = 0.0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;

        while (gameEngine.isRunning()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            while (delta >= 1.0) {
                // Update game logic
                gameEngine.update();
                ticks++;
                delta--;
            }

            // Render graphics
            gameEngine.render();
            frames++;

            // Check if one second has passed
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Ticks: " + ticks + ", Frames: " + frames);
                ticks = 0;
                frames = 0;
            }

            // Swap buffers
            GLFW.glfwSwapBuffers(gameEngine.getWindow());

            // Poll for events
            GLFW.glfwPollEvents();

            // Check if the window should close
            if (GLFW.glfwWindowShouldClose(gameEngine.getWindow())) {
                gameEngine.setRunning(false);
            }
        }

    }
}
