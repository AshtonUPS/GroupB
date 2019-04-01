package com.groupb.game.level;

//import java.util.ArrayList;
import java.util.LinkedList;

import com.groupb.lathe.entity.components.SpriteRenderer;

/**
 * 
 * 
 *
 */
public class Level {

	// ArrayList<Building> buildings;
	LinkedList<Building> linkedBuildings;
	Building b;

	public Level() {
		linkedBuildings = new LinkedList<Building>();

		for (int i = 0; i < 21; i++) {
			linkedBuildings.add(new Building(-52, 0 + (i * 10) - (95), 4, 4));// add buildings
		}
		for (Building building : linkedBuildings) {
			building.addComponent(new SpriteRenderer());				//SHOW ME		
		}
	}


	public void update() {
		//To-do Obstacles? Added ground - buildings, Lack of ground
		linkedBuildings.add(new Building((int) (linkedBuildings.get(linkedBuildings.size() - 1).getPosition().y) + 5,
				(int) (linkedBuildings.get(linkedBuildings.size() - 1).getPosition().x) + 10, 4, 4)); // add one Building to linked list
		//remove +5 in position() if no hill
		linkedBuildings.getLast().addComponent(new SpriteRenderer());	// make it visible
		linkedBuildings.removeFirst();	// clean up
		//System.out.println(linkedBuildings.size());
	}
}
