package com.groupb.lathe.tests;

import org.junit.Test;


import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.math.Vector3f;

public class ComponentSystemTest {
	
	private final GameObject go = new GameObject();
	
	/**
	 * Tests that component binding is working properly
	 */
	@Test
	public void checkBinding() {
		Vector3f pos = go.getPosition();
		assert(pos.x == 0);
		
		new TestComponent(go);
		go.update();
		assert(pos.x == 1);
		new TestComponent(go);
		go.update();
		assert(pos.x == 3);
	}
	
	/**
	 * Tests to see if objects are being stored and handled properly
	 */
	@Test
	public void testDispatching() {
		new TestComponent(go);
		GameObject.updateAll();
		assert(go.getPosition().x == 1);
	}
	
	/**
	 * Tests the destroy method
	 */
	@Test
	public void testDestruction() {
		new TestComponent(go);
		GameObject.updateAll();
		assert(go.getPosition().x == 1);
		go.destroy();
		GameObject.updateAll();
		assert(go.getPosition().x == 0);
	}
	
	/**
	 * Tests that references aren't overwritten after new components are bound
	 */
	@Test
	public void testRefs() {
		Vector3f pos = go.getPosition();
		Vector3f rot = go.getRotation();
		assert(pos.x == 0);
		assert(rot.z == 0);
		go.update();
		assert(pos.x == 0);
		assert(rot.z == 0);
		new TestComponent(go);
		assert(pos.x == 0);
		assert(rot.z == 0);
		go.update();
		assert(pos.x == 1);
		assert(rot.z == 0.1f);
	}
}
