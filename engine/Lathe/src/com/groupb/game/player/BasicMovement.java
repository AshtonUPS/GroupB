package com.groupb.game.player;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.math.Vector3f;

public class BasicMovement extends GameComponent {

	
	public BasicMovement(GameObject parent) {
		super(parent);
	}

	private int velocity = 8;
	private int cooldown = 20;
	private int cooldown_timer = 0;
	private int ground_level = 0;
	private float rotation = 0f;
	
	private boolean isJumping = false;
	private boolean inCoolDown = false;
	private boolean keyresponded = false;
	
	/*
	 * Set the current ground level to a particular value
	 */
	public void setGndLvl(int gl) {
		this.ground_level = gl;
	}
	/*
	 * Return the current velocity
	 */
	public int getVelocity()	{
		return this.velocity;
	}
	
	public boolean keyReponse()	{
		return keyresponded;
	}
	/*
	 * Return the status of isJumping
	 */
	public boolean returnIsJumping()	{
		return this.isJumping;
	}
	/*
	 * Return the status of inCoolDown
	 */
	public boolean returnInCoolDown()	{
		return this.inCoolDown;
	}
	
	public void simulateKeyPress()	{
		if(inCoolDown == false)	{
			//jump if not in cool down
			isJumping = true;
			keyresponded = true;
		}
		else	{
			keyresponded = false;
		}
	}
	
	
	public void input(Window w) {
		if (w.isKeyPressed(GLFW_KEY_SPACE)) {
			//assert isJumping to be true
			
			if(inCoolDown == false)	{
				//jump if not in cool down
				isJumping = true;
			}
		}
	}

	public void update() {
		Vector3f pos = getPosition();
		Vector3f rotation = getRotation();
		
		if(isJumping == true) {
			inCoolDown = true;
			MovementController mc = new MovementController(velocity, pos.y);
			Command jump = new JumpCommand(mc);
			jump.execute();
			
			velocity = mc.velocity;
			pos.y = mc.pos_y;
			rotation.z -= 5f;
			//setRotation(rotation -= 5f);
		}
		
		//check if cool down is active and perform accordingly
		if(inCoolDown == true) {
			cooldown_timer ++;
			if(cooldown_timer == cooldown)	{
				cooldown_timer = 0;
				inCoolDown = false;
			}
		}

		if(pos.y < ground_level)	{
			pos.y = ground_level;
			velocity = 8;
			isJumping = false;
		}
	}
}
