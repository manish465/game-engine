package com.manish.game.display;

import static org.lwjgl.opengl.GL11.*;

public class DemoDisplay {
    public void render() {
        glClear(GL_COLOR_BUFFER_BIT);

        // Render game objects here

        glBegin(GL_TRIANGLES);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex2f(-0.5f, -0.5f);
        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex2f(0.5f, -0.5f);
        glColor3f(0.0f, 0.0f, 1.0f);
        glVertex2f(0.0f, 0.5f);
        glEnd();
    }
}
