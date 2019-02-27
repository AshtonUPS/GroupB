package com.groupb.lathe.engine;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class Window {
	
	private long handle;
	
	private final String name;

	private int width, height;

	public Window(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

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

		//glEnable(GL_TEXTURE_2D);
		//glEnable(GL_BLEND);
		//glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		//glClearColor(1f, 0f, 0f, 0f);

	}
	
	public boolean shouldClose() {
		return glfwWindowShouldClose(handle);
	}
	
	public void update() {
		glfwSwapBuffers(handle);
		glfwPollEvents();
	}
	
	public void clear() {
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public void cleanup() {
		glfwTerminate();
	}

}
