package com.groupb.lathe.entity;

import java.util.ArrayList;
import java.util.List;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

public class GameObject {

	public static final List<GameObject> GAMEOBJECTS = new ArrayList<GameObject>();

	private Vector3f position;

	private List<GameComponent> components;

	private float rotation = 0f;
	private float scale = 1f;

	public GameObject() {
		position = new Vector3f();
		components = new ArrayList<GameComponent>();
		GAMEOBJECTS.add(this);
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
		return rotation;
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getScale() {
		return scale;
	}

	public void addComponent(GameComponent c) {
		components.add(c);
		c.init(this);
	}

	public Matrix4f getMatrix() {
		return Matrix4f.rotate(getRotation())
				.multiply(Matrix4f.translate(getPosition()).multiply(Matrix4f.scale(getScale())));
	}

	public void setScale(float f) {
		scale = f;
	}

	public void destroy() {
		GAMEOBJECTS.remove(this);
	}

	public static void dispatchInputs(Window w) {
		for (GameObject go : GAMEOBJECTS) {
			go.input(w);
		}
	}

	public static void updateAll() {
		for (GameObject go : GAMEOBJECTS) {
			go.update();
		}
	}

	public static void renderAll() {
		for (GameObject go : GAMEOBJECTS) {
			go.render();
		}
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

}
