package com.groupb.lathe.entity.components;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;

/**
 * Template for creating a GameComponent. GameComponents are attached to
 * GameObjects allowing infinite possibilities.
 * 
 * @author ashtonwalden
 *
 */
public abstract class GameComponent {

	protected GameObject gameObject; // Parent gameObject

	/**
	 * Initialize the game component with a Game Object
	 * 
	 * @param g Parent GameObject
	 */
	public void init(GameObject g) {
		this.gameObject = g;
	}

	/**
	 * Handle input
	 * 
	 * @param w
	 */
	public void input(Window w) {
		return;
	}

	/**
	 * Handle updates
	 */
	public void update() {
		return;
	}

	/**
	 * Handle rendering
	 */
	public void render() {
		return;
	}

}
