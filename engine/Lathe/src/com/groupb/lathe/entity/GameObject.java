package com.groupb.lathe.entity;

import java.util.ArrayList;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.components.BaseComponent;
import com.groupb.lathe.entity.components.GameComponent;
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

	private static final ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	public static void dispatchInputs(Window w) {
		for (GameObject go : gameObjects) {
			go.input(w);
		}
	}

	public static void updateAll() {
		for (GameObject go : gameObjects) {
			go.update();
		}
	}

	public static void renderAll() {
		for (GameObject go : gameObjects) {
			go.render();
		}
	}

	protected GameComponent component;

	public GameObject() {
		new BaseComponent(this);
		gameObjects.add(this);
	}

	public void input(Window w) {
		component.input(w);
		return;
	}

	public void update() {
		component.update();
		return;
	}

	public void render() {
		component.render();
		return;
	}

	public boolean addComponent(GameComponent newComponent) {
		boolean success = newComponent.setChild(component);
		if (success) {
			component = newComponent;
			return true;
		}

		return false;

	}

	public Vector3f getRotation() {
		return component.getRotation();
	}

	public Vector3f getPosition() {
		return component.getPosition();
	}

	public Vector3f getScale() {
		return component.getScale();
	}

	public Matrix4f getMatrix() {
		return component.getMatrix();
	}

	public String getStructure() {
		return component.getStructure();
	}
	
	public void destroy() {
		GameObject.gameObjects.remove(this);
	}
	

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + getStructure();
	}

}
