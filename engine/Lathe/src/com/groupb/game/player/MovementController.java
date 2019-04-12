package com.groupb.game.player;

public class MovementController {
	
	public float pos_y;
	public int velocity;
	public int player_mass;
	
	public MovementController(int velocity, float y)	{
		this.velocity = velocity;
		this.pos_y = y;
		this.player_mass = 1;
	}
}
