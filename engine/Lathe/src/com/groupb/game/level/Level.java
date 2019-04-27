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

	private int time;
	private int max_time;
	private boolean spike_placed;
	private Random rand;


	public Level() {
		linkedBuildings = new LinkedList<Building>();
		linkedObstacles = new LinkedList<Obstacle>();
		rand = new Random();
		time = 0;
		max_time = 80;// Beginning space between generating spikes
		spike_placed = false;
		
		for (int i = 0; i < lengthOfGround; i++) {
			linkedBuildings.add(new Building(-10, 0 + (i * 10) - (95)));// add buildings
		}
		for (Building building : linkedBuildings) {
			new SpriteRenderer(building, Texture.getByPath("resources/default.png")); // SHOW ME
		}
	}

	public void update() {
		//GENERATE SPIKES
				if (time == 0) {
					spike_placed = true;
					generate_spikes();
					time++;
				} 
				else if (time >= max_time) { // generate a new time frame to generate the next block
					time = 0;
					max_time = time_generate();
				} 
				else {
					time++;
					spike_placed = false;
				}
		
		//GROUND GENERATION
		if (linkedBuildings.peekLast().getPosition().x <= rightEndOfScreen) {
				generate_land();
			
		}

		//CLEAN UP
		if (linkedBuildings.peek() != null && linkedBuildings.peek().getPosition().x <= leftEndOfScreen) {
			/// linkedBuildings.removeFirst(); // clean up
			// linkedBuildings.poll().destroy();
		}
		
		//Clean up make for obstacles
		
		// System.out.println(linkedBuildings.size());
		// System.out.println(linkedBuildings.peek().getPosition().x);

	}

	private void generate_spikes() {
		linkedObstacles.add(new Obstacle(0, rightEndOfScreen));
		new SpriteRenderer(linkedObstacles.getLast(), Texture.getByPath("resources/spike_grey.png"));
	}
	
	private void generate_land() {
		linkedBuildings.add(
				new Building((int) (linkedBuildings.get(linkedBuildings.size() - 1).getPosition().y), (int) (109))); // deleted
																														// (linkedBuildings.get(linkedBuildings.size()
																														// -
																														// 1).getPosition().x)
																														//changed this because if we are adding holes
																														//then new buildings will be added not based on
																														//the last block but around the same place
		new SpriteRenderer(linkedBuildings.getLast(), Texture.getByPath("resources/default.png"));
		
	}
	
	private int time_generate() {
		int random_time = 40 + rand.nextInt(100); //change the number in nextInt to increase or decrease the possible amount of time between obstacles
		return random_time;
	}
	

}
