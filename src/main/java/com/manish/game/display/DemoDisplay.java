package com.manish.game.display;

import static org.lwjgl.opengl.GL11.*;

public class DemoDisplay {
    public void render() {
        glClear(GL_COLOR_BUFFER_BIT);

        // Render game objects here

        // Example: Render a red triangle
        glBegin(GL_TRIANGLES);
        glColor3f(1.0f, 0.0f, 0.0f); // Red
        glVertex2f(-0.5f, -0.5f);
        glVertex2f(0.5f, -0.5f);
        glVertex2f(0.0f, 0.5f);
        glEnd();
    }
}
