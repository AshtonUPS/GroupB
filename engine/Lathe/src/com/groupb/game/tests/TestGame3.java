package com.groupb.game.tests;

import com.groupb.game.level.Level;
import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.CameraComponent;
import com.groupb.lathe.graphics.Shader;

public class TestGame3 implements IGameLogic {
	GameObject camera;
	Level l;
	
	
	
	
	@Override
	public void init() {	// Where you add the game components
		
		l =  new Level(); // creates the ground, No obstacles

		camera = new GameObject();
		CameraComponent c = new CameraComponent(Shader.BASIC);
		camera.addComponent(c);
		c.enable();		
		
		
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
