package com.groupb.game.level;

import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.ColorRenderer;

public class Building extends GameObject{
	
	private int width, height;
	private final float speed = 0.1f;
	
	public Building(int x, int width, int height) {
		super();
		position.x = x;
		this.width = width;
		this.height = height;
		addComponent(new ColorRenderer(255,255,255, width, height));
	}
	
	@Override
	public void update() {
		position.x-=speed;
	}
	

	
}
