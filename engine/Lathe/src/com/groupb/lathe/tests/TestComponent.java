package com.groupb.lathe.tests;

import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.math.Vector3f;

public class TestComponent extends GameComponent{

	
	Vector3f position, rotation;
	
	public TestComponent(GameObject parent) {
		super(parent);
	}
	
	
	@Override
	public void update() {
		super.update();
		position = getPosition();
		rotation = getRotation();
		
		position.x += 1f;
		position.y += 1f;
		
		rotation.z += 0.1f;
	}
}
