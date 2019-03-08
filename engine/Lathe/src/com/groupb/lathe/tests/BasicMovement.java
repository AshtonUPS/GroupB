package com.groupb.lathe.tests;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.math.Vector3f;

public class BasicMovement extends GameComponent {

	private float vx, vy;
	private float speed = 5f;

	public void input(Window w) {
		vx = 0f;
		vy = 0f;
		
		if (w.isKeyPressed(GLFW_KEY_A)) {
			vx -= speed;
		}
		if (w.isKeyPressed(GLFW_KEY_D)) {
			vx += speed;
		}
		if (w.isKeyPressed(GLFW_KEY_W)) {
			vy += speed;
		}
		if (w.isKeyPressed(GLFW_KEY_S)) {
			vy -= speed;
		}
	}

	public void update() {
		Vector3f pos = gameObject.getPosition();
		pos.x += vx;
		pos.y += vy;
	}

}
