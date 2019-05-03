package com.groupb.game.level;

import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.math.Vector3f;

public class Building extends GameObject{
	
	//private int width, height; 
	//private final float speed = 2f;
	private float speed = 2f;
	private Vector3f position;
	
	/*
	public Building(int y, int x, int width, int height) {
		super();
		position = getPosition();
		position.y = y;
		position.x = x;
		this.width = width;
		this.height = height; WIDTH AND HIGHT WERE NEVER USED
	}
	*/
	
	public Building(int y, int x) {	//Added y
		super();
		position = getPosition();
		position.y = y;
		position.x = x;
	}
	
	public Building(int y, int x, float speed) {	//Added y
		super();
		position = getPosition();
		position.y = y;
		position.x = x;
		this.speed = speed;
	}
	
	public void faster(){
		speed = speed + 0.1f;
		//TRIPPY LOL
	}
	
	public void setXPosition(int x) {
		position.x = x;
	}
		
	
	@Override
	public void update() {
		position.x-=speed;
		//faster(); // trippy it looks like this becuase each individual  is being chan 
		
		
	}
	
	

	
}
