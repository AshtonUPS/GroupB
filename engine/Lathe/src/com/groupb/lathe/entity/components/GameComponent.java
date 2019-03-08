package com.groupb.lathe.entity.components;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;

public abstract class GameComponent {
	
	protected GameObject gameObject;
	
	public void init(GameObject g) {
		this.gameObject = g;
	}

	public void input(Window w) {
		return;
	}

	public void update() {
		return;
	}

	public void render() {
		return;
	}

}
