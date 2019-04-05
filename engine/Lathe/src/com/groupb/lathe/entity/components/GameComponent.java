package com.groupb.lathe.entity.components;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.IGameObject;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

/**
 * Template for creating a GameComponent. GameComponents are attached to
 * GameObjects allowing infinite possibilities.
 * 
 * @author ashtonwalden
 *
 */
public abstract class GameComponent implements IGameObject {

	protected IGameObject gameObject; // Parent gameObject
	
	
	public GameComponent(IGameObject gameObject) {
		this.gameObject = gameObject;
	}
	
	/**
	 * Handle input
	 * 
	 * @param w
	 */
	public void input(Window w) {
		gameObject.input(w);
		return;
	}

	/**
	 * Handle updates
	 */
	public void update() {
		gameObject.update();
		return;
	}

	/**
	 * Handle rendering
	 */
	public void render() {
		gameObject.render();
		return;
	}
	
	public Vector3f getScale() {
		return gameObject.getScale();
	}
	
	public Vector3f getSize() {
		return gameObject.getSize();
	}
	
	public Vector3f getRotation() {
		return gameObject.getRotation();
	}
	
	public Matrix4f getMatrix() {
		return gameObject.getMatrix();
	}
	
	public String getStructure() {
		return this.getClass().getSimpleName() + " -> " + gameObject.getStructure();
	}

}
