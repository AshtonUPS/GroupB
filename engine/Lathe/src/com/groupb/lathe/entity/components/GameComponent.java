package com.groupb.lathe.entity.components;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

/**
 * Template for creating a GameComponent. GameComponents are attached to
 * GameObjects allowing infinite possibilities.
 * 
 * @author ashtonwalden
 *
 */
public abstract class GameComponent {

	protected GameComponent child; // Parent gameObject
	
	public GameComponent(GameObject parent) {
		parent.addComponent(this);
	}

	public boolean setChild(GameComponent newChild) {
		if (child == null) {
			child = newChild;
			return true;
		}
		return false;
	}

	/**
	 * Handle input
	 * 
	 * @param w
	 */
	public void input(Window w) {
		child.input(w);
		return;
	}

	/**
	 * Handle updates
	 */
	public void update() {
		child.update();
		return;
	}

	/**
	 * Handle rendering
	 */
	public void render() {
		child.render();
		return;
	}

	public Vector3f getRotation() {
		return child.getRotation();
	}

	public Vector3f getPosition() {
		return child.getPosition();
	}

	public Vector3f getScale() {
		return child.getScale();
	}

	public Vector3f getSize() {
		return child.getSize();
	}

	public Matrix4f getMatrix() {
		return child.getMatrix();
	}

	public String getStructure() {
		return this.getClass().getSimpleName() + " -> " + child.getStructure();
	}
}
