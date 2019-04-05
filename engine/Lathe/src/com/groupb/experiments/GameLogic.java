package com.groupb.experiments;

import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.IGameObject;
import com.groupb.lathe.entity.components.CameraComponent;
import com.groupb.lathe.entity.components.DummyComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.Texture;

public class GameLogic implements IGameLogic {

	IGameObject camera, obj;

	@Override
	public void init() {
		// Setup Camera
		camera = new CameraComponent(new GameObject(), Shader.BASIC);

		((CameraComponent) camera).enable();

		GameObject g = new GameObject();
		SpriteRenderer sr = new SpriteRenderer(g, Texture.getByPath("resources/Block_Pack/PNG/Retina/tileDirt.png"));
		sr.setResolution(128, 200);

		obj = new DummyComponent(sr);

	}

	@Override
	public void input(Window window) {
		camera.input(window);
		obj.input(window);
	}

	@Override
	public void update() {
		camera.update();
		obj.update();
	}

	@Override
	public void render() {
		camera.render();
		obj.render();
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
