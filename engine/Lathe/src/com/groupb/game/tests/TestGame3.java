package com.groupb.game.tests;

import com.groupb.game.level.Level;
import com.groupb.game.player.BasicMovement;
import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.Camera;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Texture;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;

public class TestGame3 implements IGameLogic {
	Camera c;
	Level l;
	GameObject obj;
	
	
	
	
	@Override
	public void init() {
		
		l =  new Level();

		c = new Camera();
		c.enable();
		
		obj = new GameObject();
		SpriteRenderer sr = new SpriteRenderer(obj, Texture.getByPath("resources/player.png"));
		
		new BasicMovement(obj, GLFW_KEY_SPACE);
		
		
	}

	@Override
	public void input(Window w) {
		GameObject.dispatchInputs(w);
	}

	@Override
	public void update() {
		GameObject.updateAll();
		l.update();
		
	}

	@Override
	public void render() {
		GameObject.renderAll();
	}

	@Override
	public void cleanup() {
	}

	

}
