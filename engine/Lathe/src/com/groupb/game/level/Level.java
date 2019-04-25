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
	
	//change this, getWidth of screen find a way based on blocks
	int lengthOfGround = 21;
	int leftEndOfScreen = -104;
	int rightEndOfScreen = (leftEndOfScreen * -1) - 4;

	public Level() {
		linkedBuildings = new LinkedList<Building>();

		for (int i = 0; i < lengthOfGround; i++) {
			linkedBuildings.add(new Building(-52, 0 + (i * 10) - (95), 4, 4));// add buildings
		}
		for (Building building : linkedBuildings) {
			building.addComponent(new SpriteRenderer());				//SHOW ME		
		}
	}


	public void update() {
		//There is a problem.. if the user clicks the last block, thus taking away that block, The up
		///date method will just replace that block. How will I fix this then?
		//Should I create another method or should I keep adding blocks at the same place e.g add them
		// at rightEndOfScreen - 10.
		////Therefore not dependent on the last block... but that would make it less dynamic...
		
		if(linkedBuildings.peekLast().getPosition().x <= rightEndOfScreen) {
			linkedBuildings.add(new Building((int) (linkedBuildings.get(linkedBuildings.size() - 1).getPosition().y),
					(int) (linkedBuildings.get(linkedBuildings.size() - 1).getPosition().x) + 10, 4, 4)); // add one Building to linked list
			//remove +5 in position() if no hill
			
			linkedBuildings.getLast().addComponent(new SpriteRenderer());	// make it visible
			
		}
		//Is this if statement too slow? Would it be easier to just check the size of the linked list?
		
		if(linkedBuildings.peek() != null && linkedBuildings.peek().getPosition().x <= leftEndOfScreen ) {
			///linkedBuildings.removeFirst();	// clean up
			linkedBuildings.poll().destroy();
		}
		
		//System.out.println(linkedBuildings.size());
		//System.out.println(linkedBuildings.peek().getPosition().x);
	}
	
	/**
	 * 
	 */
	protected void obstacles() {
		
	}
	
	/**
	 * 
	 */
	protected void noGround() { // make sure you do not allow user to click a block that already has no hole by it
		//therefore it shouldn't be a hole that the player cannot jump over.
		///Or maybe that could be a challenge they have to double jump or sumthang idk
		
	}
	
	
	
	
}
