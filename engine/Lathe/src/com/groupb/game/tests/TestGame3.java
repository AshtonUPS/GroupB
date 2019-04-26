package com.groupb.game.tests;

import com.groupb.game.level.Level;
import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.Camera;
import com.groupb.lathe.entity.GameObject;

public class TestGame3 implements IGameLogic {
	Camera c;
	Level l;
	
	
	
	
	@Override
	public void init() {	// Where you add the game components
		
		l =  new Level(); // creates the ground, No obstacles

		c = new Camera();
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
