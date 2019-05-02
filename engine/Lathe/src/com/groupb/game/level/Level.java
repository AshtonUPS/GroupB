package com.groupb.game.level;

//import java.util.ArrayList;
import java.util.LinkedList;

import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Texture;
import java.util.Random;

/**
 * 
 * 
 *
 */
public class Level {
	LinkedList<Building> linkedBuildings;
	LinkedList<Obstacle> linkedObstacles;

	// change this, getWidth of screen find a way based on blocks
	int lengthOfGround = 21;
	int leftEndOfScreen = -104;
	int rightEndOfScreen = (leftEndOfScreen * -1) - 4;

	private int timerSpikes;
	private int genSpikes;
	private Random rand;
	private float speed;
	private int timerOfNextSpeed = 500;//
	private int timerSpeed = 0;// IMPLEMENT LATER


	public Level() {
		linkedBuildings = new LinkedList<Building>();
		linkedObstacles = new LinkedList<Obstacle>();
		rand = new Random();
		timerSpikes = 0;
		genSpikes = 80;// Beginning space between generating spikes
		speed = 2.0f;
		
		//Gen ground
		for (int i = 0; i < lengthOfGround; i++) {
			linkedBuildings.add(new Building(-10, 0 + (i * 10) - (95)));// add buildings
		}
		for (Building building : linkedBuildings) {
			new SpriteRenderer(building, Texture.getByPath("resources/default.png")); // SHOW ME
		}
	}

	public void update() {
		//GENERATE SPIKES
				if (timerSpikes == 0) {
					generate_spikes(rand.nextInt(3));// 1 or 2 spikes?
					timerSpikes++;
				} 
				else if (timerSpikes >= genSpikes) { // generate a new time frame to generate the next block
					timerSpikes = 0;
					genSpikes = generate_spikes();
					
				} 
				else {
					timerSpikes++;
				}
		
		//GROUND GENERATION
		if (linkedBuildings.peekLast().getPosition().x <= rightEndOfScreen) {
				generate_land();
			
		}

		//CLEAN UP
		if (linkedBuildings.peek() != null && linkedBuildings.peek().getPosition().x <= leftEndOfScreen) {
			/// linkedBuildings.removeFirst(); // clean up
			linkedBuildings.poll().destroy();
		}
		
		/* TEST SPEED FOR GROUND NOT WORKING YET
		if (timerSpeed >= timerOfNextSpeed) {
			speed = speed + .02f;
			timerSpeed = 0;
		}
		else {
			timerSpeed++;
		}
		
		System.out.println(timerSpeed);
		*/
		
		//TODO Clean up make for obstacles
		
		// System.out.println(linkedBuildings.size());
		// System.out.println(linkedBuildings.peek().getPosition().x);
	}

	private void generate_spikes(int num) {// will have to implement speed if were going faster.
		linkedObstacles.add(new Obstacle(0, rightEndOfScreen));
		new SpriteRenderer(linkedObstacles.getLast(), Texture.getByPath("resources/spike_grey.png"));
		if(num == 1) {// if two spikes
			linkedObstacles.add(new Obstacle(0, rightEndOfScreen + 9));
			new SpriteRenderer(linkedObstacles.getLast(), Texture.getByPath("resources/spike_grey.png"));
		}
		else if (num == 2) {
			linkedObstacles.add(new Obstacle(0, rightEndOfScreen + 7));
			new SpriteRenderer(linkedObstacles.getLast(), Texture.getByPath("resources/spike_grey.png"));
		
			linkedObstacles.add(new Obstacle(0, rightEndOfScreen + 14));
			new SpriteRenderer(linkedObstacles.getLast(), Texture.getByPath("resources/spike_grey.png"));
		}
	}
	
	
	private void generate_land() {
		linkedBuildings.add(
				new Building(-10, (int) (linkedBuildings.get(linkedBuildings.size() - 1).getPosition().x)+ 10)); // 
		new SpriteRenderer(linkedBuildings.getLast(), Texture.getByPath("resources/default.png"));
		
	}
	
	
	private void generate_land(boolean hole) {
		linkedBuildings.add(
				new Building(-10, rightEndOfScreen)); // not dependent on the last block in list
		new SpriteRenderer(linkedBuildings.getLast(), Texture.getByPath("resources/default.png"));
		
	}
	
	private int generate_spikes() {
		int random_time = 40 + rand.nextInt(150); //change the number in nextInt to increase or decrease the possible amount of time between obstacles
		return random_time;
	}
	

}
