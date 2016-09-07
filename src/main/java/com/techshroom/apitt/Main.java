package com.techshroom.apitt;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.opengl.GL11.GL_COLOR;
import static org.lwjgl.opengl.GL11.GL_VERSION;
import static org.lwjgl.opengl.GL11.glGetString;
import static org.lwjgl.opengl.GL30.glClearBufferfv;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class Main {

    public static void main(String[] args) throws Exception {
        System.err.println(Version.getVersion());
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("glfwInit failed!");
        }
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        long window = GLFW.glfwCreateWindow(800, 600, "Title", 0, 0);
        if (window == 0) {
            // uh oh.
            throw new IllegalStateException("window creation failed.");
        }

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities(true);

        GLFW.glfwSwapInterval(1);

        System.err.println("Using OpenGL v" + glGetString(GL_VERSION));
        float[] color = { 1.0f, 0f, 0f };
        while (!GLFW.glfwWindowShouldClose(window)) {
            glClearBufferfv(GL_COLOR, 0, color);
            Thread.sleep(10);
            GLFW.glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

}
