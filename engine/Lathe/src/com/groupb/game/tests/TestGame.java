package com.groupb.game.tests;

import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.CameraComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;

public class TestGame implements IGameLogic { 
	
	GameObject g, g2, g3;
	GameObject camera;

	@Override
	public void init() {

		g = new GameObject();
		g2 = new GameObject();
		//g3 = new GameObject();
		camera = new GameObject();
		g.addComponent(new SpriteRenderer());
		g2.addComponent(new SpriteRenderer());
		//g3.addComponent(new SpriteRenderer());
		CameraComponent c = new CameraComponent(Shader.BASIC);
		camera.addComponent(c);
		c.enable();
		g2.getPosition().x += 8f;
		//g3.getPosition().x += 16f;

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
