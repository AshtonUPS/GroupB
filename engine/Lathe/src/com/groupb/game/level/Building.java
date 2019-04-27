package com.groupb.game.level;

import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.math.Vector3f;

public class Building extends GameObject{
	
	private int width, height;
	private final float speed = 0.5f;
	private Vector3f position;
	
	
	public Building(int y, int x, int width, int height) {	//Added y
		super();
		position = getPosition();
		position.y = y;
		position.x = x;
		this.width = width;
		this.height = height;
	}
	
	
	
	
	@Override
	public void update() {
		position.x-=speed;
		
	}
	

	
}
