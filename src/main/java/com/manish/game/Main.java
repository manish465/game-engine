package com.manish.game;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Main {
    private long window;

    public Main(){
        init();
        loop();
        cleanup();
    }

    private void init(){
        // Initialize GLFW
        if(!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Create a window
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

        window = GLFW.glfwCreateWindow(800, 600, "Basic LWJGL Game", 0,0);
        if(window == 0){
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();

        // Set the clear color
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    private void loop(){
        while (!GLFW.glfwWindowShouldClose(window)){
            // Poll for events
            GLFW.glfwPollEvents();

            // Clear the screen
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            // Render graphics (placeholder)
            // Draw a red triangle
            GL11.glBegin(GL11.GL_TRIANGLES);
            GL11.glColor3f(1.0f, 0.0f, 0.0f);  // Red
            GL11.glVertex2f(-0.5f, -0.5f);
            GL11.glColor3f(0.0f, 1.0f, 0.0f);  // Red
            GL11.glVertex2f(0.5f, -0.5f);
            GL11.glColor3f(0.0f, 0.0f, 1.0f);  // Red
            GL11.glVertex2f(0.0f, 0.5f);
            GL11.glEnd();

            // Swap buffers
            GLFW.glfwSwapBuffers(window);
        }
    }

    private void cleanup(){
        GLFW.glfwTerminate();
    }

    public static void main(String[] args) {
        new Main();
    }
}
