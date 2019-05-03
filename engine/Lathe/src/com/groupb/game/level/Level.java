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

	// change this, getWidth of screen
	int lengthOfGround = 23;

	//screen dimensions
	int leftEndOfScreen = -104;
	int rightEndOfScreen = (leftEndOfScreen * -1) - 4;

	//var used for spikes
	private int timerSpikes;
	private int genSpikes;
	private Random rand;
	
	//var used for speed of level
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

		// Generate ground
		for (int i = 0; i < lengthOfGround; i++) {
			linkedBuildings.add(new Building(-10, 0 + (i * 10) - (95)));// add buildings
		}
		for (Building building : linkedBuildings) {
			new SpriteRenderer(building, Texture.getByPath("resources/default.png")); // SHOW ME
		}

		// fill array with obstacles
		for (int i = 0; i < lengthOfGround; i++) {
			linkedObstacles.add(new Obstacle(0, rightEndOfScreen));// add buildings

		}
		for (Obstacle obs : linkedObstacles) {
			new SpriteRenderer(obs, Texture.getByPath("resources/spike_grey.png"));
		}

	}

	/**
	 * 
	 */
	public void update() {
		
		// GENERATE SPIKES
		if (timerSpikes == 0) {
			generate_spikes(rand.nextInt(3));// 1 or 2 spikes?
			timerSpikes++;
		} else if (timerSpikes >= genSpikes) { // generate a new time frame to generate the next block
			timerSpikes = 0;
			genSpikes = generateNewSpikeTime();

		} else {
			timerSpikes++;
		}
		

		// GENERATE LAND
		if (linkedBuildings.peek() != null && linkedBuildings.peek().getPosition().x <= leftEndOfScreen - 10) {
			generate_land();
		}

		/*
		 * TEST SPEED FOR GROUND NOT WORKING YET if (timerSpeed >= timerOfNextSpeed) {
		 * speed = speed + .02f; timerSpeed = 0; } else { timerSpeed++; }
		 * 
		 * System.out.println(timerSpeed);
		 */

		// TODO Clean up make for obstacles

		// System.out.println(linkedBuildings.size());
		// System.out.println(linkedBuildings.peek().getPosition().x);

	}

	/**
	 * 
	 * @param num
	 */
	private void generate_spikes(int num) {// will have to implement speed if were going faster.
		Obstacle obs;
		obs = linkedObstacles.pop();
		obs.setXPosition(rightEndOfScreen);
		linkedObstacles.add(obs);
		if (num == 1) {// if two spikes
			obs = linkedObstacles.pop();
			obs.setXPosition(rightEndOfScreen + 9);
			linkedObstacles.add(obs);
		} else if (num == 2) {
			obs = linkedObstacles.pop();
			obs.setXPosition(rightEndOfScreen + 7);
			linkedObstacles.add(obs);
			
			obs = linkedObstacles.pop();
			obs.setXPosition(rightEndOfScreen + 14);
			linkedObstacles.add(obs);;
		}
	}

	/**
	 * 
	 */
	private void generate_land() {
		Building build;
		build = linkedBuildings.removeFirst();
		build.setXPosition(rightEndOfScreen + 10);
		linkedBuildings.add(build);
		//System.out.println();

	}

	private void generate_land(boolean hole) {

	}

	private int generateNewSpikeTime() {
		int random_time = 40 + rand.nextInt(150); // change the number in nextInt to increase or decrease the possible
													// amount of time between obstacles
		return random_time;
	}

}
