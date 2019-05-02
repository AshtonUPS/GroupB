package com.groupb.lathe.engine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MINOR;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_CORE_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_FORWARD_COMPAT;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

/**
 * Handles the glfw window. Most of this is a refactor from the example code on
 * lwjgl's website.
 * 
 * @author ashtonwalden
 *
 */
public class Window {

	private long handle;

	private final String name;

	private int width, height;

	/**
	 * Creates a glfw window
	 * 
	 * @param name   Name of the window
	 * @param width  Width of the window
	 * @param height Height of the window
	 */
	public Window(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	/**
	 * Initializes the window and displays it.
	 */
	public void init() {

		if (!glfwInit()) {
			System.err.println("Failed to initialize GLFW");
		}

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE); // the window will be resizable
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

		handle = glfwCreateWindow(width, height, name, 0, 0);

		glfwShowWindow(handle);

		glfwMakeContextCurrent(handle);

		GL.createCapabilities();

		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		// glClearColor(1f, 0f, 0f, 0f);
		glClearColor(1f, 1f, 1f, 0f);

	}

	/**
	 * Check's if the quit button has been clicked.
	 * 
	 * @return True if someone has clicked the close button.
	 */
	public boolean shouldClose() {
		return glfwWindowShouldClose(handle);
	}

	/**
	 * Updates the window's frame buffers.
	 */
	public void update() {
		glfwSwapBuffers(handle);
		glfwPollEvents();
	}

	/**
	 * Clears the window
	 */
	public void clear() {
		glClear(GL_COLOR_BUFFER_BIT);
	}

	public boolean isKeyPressed(int keyCode) {
		return glfwGetKey(handle, keyCode) == GLFW_PRESS;
	}

	/**
	 * Deconstructor. This one is VERY important.
	 */
	public void cleanup() {
		glfwTerminate();
	}

}
