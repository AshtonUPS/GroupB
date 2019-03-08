package com.groupb.lathe.entity;

import java.util.ArrayList;
import java.util.List;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Vector3f;

public class GameObject {

	private Vector3f position;

	private List<GameComponent> components;

	public GameObject() {
		position = new Vector3f();
		components = new ArrayList<GameComponent>();
	}

	public void input(Window w) {
		for (GameComponent gc : components) {
			gc.input(w);
		}
	}

	public void update() {
		for (GameComponent gc : components) {
			gc.update();
		}
	}

	public void render() {
		for (GameComponent gc : components) {
			gc.render();
		}
	}

	public float getRotation() {
		return 0;
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getScale() {
		return 1;
	}

	public void addComponent(GameComponent c) {
		components.add(c);
		c.init(this);
	}

}
