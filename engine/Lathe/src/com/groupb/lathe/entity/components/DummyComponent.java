package com.groupb.lathe.entity.components;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.math.Vector3f;

public class DummyComponent extends GameComponent {

	public DummyComponent(GameObject parent) {
		super(parent);
	}

	private int vx, vy;

	@Override
	public void input(Window w) {
		vx = 0;
		vy = 0;
		if (w.isKeyPressed(GLFW_KEY_W)) {
			vy += 1f;
		}
		if (w.isKeyPressed(GLFW_KEY_S)) {
			vy -= 1f;
		}
		if (w.isKeyPressed(GLFW_KEY_A)) {
			vx -= 1f;
		}
		if (w.isKeyPressed(GLFW_KEY_D)) {
			vx += 1f;
		}
	}

	@Override
	public void update() {
		super.update();
		Vector3f pos = child.getPosition();
		pos.x += vx;
		pos.y += vy;

		return;
	}

}
