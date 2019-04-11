package com.groupb.lathe.tests;

import com.groupb.lathe.math.Vector3f;

public class JumpCommand implements Command{

	private MovementController mc;

	public JumpCommand(MovementController mc)	{
		this.mc = mc;

	}
	
	@Override
	public void execute() {
		
		double force = 0;
		
		if(mc.velocity < 1)	{
			//reached the apex of the jump
			force = (mc.player_mass)*(mc.velocity);
			mc.pos_y = mc.pos_y + (int)force;
		}
		else	{
			//going upwards
			force = -(mc.player_mass)*(mc.velocity);
			mc.pos_y = mc.pos_y - (int)force;
		}
		//decrement the velocity
		mc.velocity = mc.velocity - 1;
	}

}
