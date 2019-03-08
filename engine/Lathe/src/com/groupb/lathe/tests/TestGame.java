package com.groupb.lathe.tests;

import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.CameraComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;

public class TestGame implements IGameLogic {
	
	GameObject g, g2;
	GameObject camera;

	@Override
	public void init() {

		g = new GameObject();
		g2 = new GameObject();
		camera = new GameObject();
		g.addComponent(new SpriteRenderer());
		g2.addComponent(new SpriteRenderer());
		g.addComponent(new BasicMovement());
		CameraComponent c = new CameraComponent(Shader.BASIC);
		camera.addComponent(c);
		c.enable();
		g2.getPosition().x += 5f;

	}

	@Override
	public void input(Window w) {
		GameObject.dispatchInputs(w);
	}

	@Override
	public void update() {
		GameObject.updateAll();
	}

	@Override
	public void render() {
		GameObject.renderAll();
	}

	@Override
	public void cleanup() {
	}

}
