package com.groupb.lathe.tests;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.math.Vector3f;

public class BasicMovement extends GameComponent {

	private float vx, vy, rotation;
	private float speed = 2f;

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
		if (w.isKeyPressed(GLFW_KEY_E)) {
			rotation -= 1f;
		}
		if (w.isKeyPressed(GLFW_KEY_Q)) {
			rotation += 1f;
		}
	}

	public void update() {
		Vector3f pos = gameObject.getPosition();
		pos.x += vx;
		pos.y += vy;
		gameObject.setRotation(rotation);
	}

}
