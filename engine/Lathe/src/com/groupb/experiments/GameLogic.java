package com.groupb.experiments;

import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.Camera;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.CameraComponent;
import com.groupb.lathe.entity.components.DummyComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.Texture;

public class GameLogic implements IGameLogic {

	GameObject obj;
	Camera c;

	@Override
	public void init() {
		// Setup Camera
		c = new Camera();
		c.enable();

		obj = new GameObject();
		SpriteRenderer sr = new SpriteRenderer(obj, Texture.getByPath("resources/Block_Pack/PNG/Retina/tileDirt.png"));
		sr.setResolution(128, 200);
		new DummyComponent(obj);

		System.out.println(obj);
		System.out.println(c);
		
	}

	@Override
	public void input(Window window) {
		GameObject.dispatchInputs(window);
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
		// TODO Auto-generated method stub

	}

}
