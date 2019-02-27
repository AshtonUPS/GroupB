package com.groupb.lathe.engine;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public class Engine implements Runnable {

	final float FPS = 60f;
	final float UPS = 60f;

	private Window window;

	private final Thread gameThread;

	private IGameComponent gameLogic;

	public Engine(String name, int width, int height, IGameComponent gameLogic) {
		gameThread = new Thread(this, "GAMELOOP");
		this.gameLogic = gameLogic;
		this.window = new Window(name, width, height);
	}

	public void start() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Mac")) {
			gameThread.run();
		} else {
			gameThread.start();
		}
	}

	@Override
	public void run() {
		init();
		gameLoop();
	}

	private boolean init() {
		window.init();
		gameLogic.init();
		return true;
	}

	private void gameLoop() {

		double lastTime = glfwGetTime();
		double now;
		double timer = lastTime;
		double delta = 0.0;
		int updates = 0;
		int frames = 0;

		while (!window.shouldClose()) {
			now = glfwGetTime();
			delta += (now - lastTime) * UPS;
			lastTime = now;

			input();

			if (delta >= 1.0) {
				update();
				updates++;
				delta--;
			}

			render();
			window.update();
			frames++;

			if (now - timer > 1) {
				timer++;
				System.out.println("Updates : " + updates + " Frames : " + frames);
				frames = 0;
				updates = 0;
			}

		}

		cleanup();

		/*
		 * float delta; float accumulator = 0f; float interval = 1f / UPS; double
		 * lastTime = glfwGetTime(); double currentTime = lastTime;
		 * 
		 * while (!window.shouldClose()) { currentTime = glfwGetTime();
		 * 
		 * delta = (float) (currentTime - lastTime); lastTime = currentTime; accumulator
		 * += delta;
		 * 
		 * input();
		 * 
		 * while (accumulator >= interval) { update(); accumulator -= interval; }
		 * 
		 * render();
		 * 
		 * window.update(); }
		 * 
		 * cleanup();
		 * 
		 */
	}

	private void input() {
		gameLogic.input();
	}

	private void update() {
		gameLogic.update();
	}

	private void render() {
		window.clear();
		gameLogic.render();
	}

	private void cleanup() {
		window.cleanup();
		gameLogic.cleanup();
	}

}
