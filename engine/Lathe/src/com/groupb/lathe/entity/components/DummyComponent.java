package com.groupb.lathe.entity.components;

import com.groupb.lathe.entity.IGameObject;

public class DummyComponent extends GameComponent {

	public DummyComponent(IGameObject gameObject) {
		super(gameObject);
	}
	
	@Override
	public void update() {
		super.update();
		gameObject.getRotation().z += 1;
		return;
	}

}
