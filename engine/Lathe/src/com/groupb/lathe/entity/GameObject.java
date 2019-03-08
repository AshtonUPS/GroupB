package com.groupb.lathe.entity;

import java.util.ArrayList;
import java.util.List;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

/**
 * The GameObject is any object that exists inside of a Game. Can have
 * components attached. Instantiated objects are added to the GAMEOBJECTS list,
 * and must be destroyed properly.
 * 
 * @author ashtonwalden
 *
 */
public class GameObject {

	public static final List<GameObject> GAMEOBJECTS = new ArrayList<GameObject>(); // Global list of all gameobjects

	private Vector3f position; // The objects position in the game world

	private List<GameComponent> components; // List of the instance's components

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

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public void setScale(float f) {
		scale = f;
	}

	public void addComponent(GameComponent c) {
		components.add(c);
		c.init(this);
	}

	public Matrix4f getMatrix() {
		return Matrix4f.rotate(getRotation())
				.multiply(Matrix4f.translate(getPosition()).multiply(Matrix4f.scale(getScale())));
	}

	public void destroy() {
		GAMEOBJECTS.remove(this);
	}

	// Static methods

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

}
