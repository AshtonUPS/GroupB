package com.groupb.game.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.groupb.game.player.BasicMovement;
import com.groupb.lathe.entity.GameObject;

class BasicMovementTest {

	// basic initialization of game object and game
	private GameObject testObject = new GameObject();
	private BasicMovement testBM = new BasicMovement(testObject);
	private int cooldown_length = 40;

	/*
	 * Tests whether or not the BasicMovement class recognizes that the object is
	 * currently jumping after a single space bar key press.
	 */
	@Test
	public void isJumpingTest() {
		// initialize the test object
		testObject.getPosition().x -= 70;
		// simulate a single space bar press
		testBM.simulateKeyPress();
		// return true if the object is executing a jump
		assertTrue(testBM.returnIsJumping());
	}

	/*
	 * Tests whether or not the BasicMovement class recognizes that it is not
	 * jumping by default
	 */
	@Test
	public void isNotJumpingTest() {
		// initialize the test object
		testObject.getPosition().x -= 70;
		// return false if the object is not executing a jump
		assertFalse(testBM.returnIsJumping());
	}

	/*
	 * Tests whether or not the velocity of the object is decreasing immediately
	 * after a jump.
	 */
	@Test
	public void velocityDecreasesTest() {
		// initialize the test object
		testObject.getPosition().x -= 70;
		// obtain a measurement of the initial velocity
		int init_v = testBM.getVelocity();
		// simulate a single space bar press and update once
		testBM.simulateKeyPress();
		testBM.update();
		// obtain a measurement of the final velocity after jump
		int final_v = testBM.getVelocity();
		boolean less = false;
		// determine if final is less than initial
		if (final_v < init_v) {
			less = true;
		}
		// true if the final velocity is less than initial
		// this makes sense since we wait it to slow down to reach peak of jump
		assertTrue(less);
	}

	/*
	 * Tests to make sure that the player cannot execute an additional jump when the
	 * object is already executing a jump
	 */
	@Test
	public void NoDoubleJumpTest() {
		// initialize the test object
		testObject.getPosition().x -= 70;
		// simulate a key press and update once
		testBM.simulateKeyPress();
		testBM.update();
		// simulate an additional key press while still jumping
		testBM.simulateKeyPress();
		// we should get a result that the key response was not acted upon
		assertFalse(testBM.keyReponse());
	}

	/*
	 * Tests to make sure the object is still in the cool down when it should be.
	 * This test uses 15 game loop cycles, where our cool-down length is set to 40
	 * cycles.
	 */
	@Test
	public void InCoolDownTest() {
		// initialize test object
		testObject.getPosition().x -= 70;

		// simulate one key press
		testBM.simulateKeyPress();
		for (int i = 0; i < 15; i++) {
			// simulate 15 cycles of game loop and update
			testBM.update();
		}
		// since 15 is less than 40, we expect it to still be in cool down
		assertTrue(testBM.returnInCoolDown());
	}

	/*
	 * Test to make sure that the cool down window is exiting at an appropriate time
	 * after a single space bar press
	 */
	@Test
	public void NotInCoolDownTest() {
		// initialize test object
		testObject.getPosition().x -= 70;

		testBM.simulateKeyPress();
		for (int i = 0; i < 50; i++) {
			// simulate 50 cycles of game loop and update
			testBM.update();
		}
		// since this is greater than cool-down time, we expect to have exited cool-down
		assertFalse(testBM.returnInCoolDown());
	}

	/*
	 * Tests whether the cool-down input works if someone is continuously mashing
	 * the space bar on every game cycle for cooldown_length loops
	 */
	@Test
	public void InCoolDownTestContinuousInput() {
		// initialize the test object
		testObject.getPosition().x -= 70;

		for (int i = 0; i < cooldown_length; i++) {
			// hit the space bar and update every cycle of game loop
			testBM.simulateKeyPress();
			testBM.update();
		}
		// since we are running the same number of game loops as the cool-down
		// timer, we expect to exit the cool down, and return false
		assertFalse(testBM.returnInCoolDown());
	}

	/*
	 * Tests whether the cool-down input works if someone is continuously mashing
	 * the space bar on each game cycle for cooldown_length + 1 loops
	 */
	@Test
	public void InCoolDownTestContinuousInputPlusOne() {
		// initialize test object
		testObject.getPosition().x -= 70;

		for (int i = 0; i < cooldown_length + 1; i++) {
			// hit the space bar and update every cycle of game loop
			testBM.simulateKeyPress();
			testBM.update();
		}
		// this is one less than exiting cool-down, so should still be true
		assertTrue(testBM.returnInCoolDown());
	}

	/*
	 * Tests whether the cool-down input works if someone is continuously mashing
	 * the space bar on each game cycle for cooldown_length - 1 loops
	 */
	@Test
	public void InCoolDownTestContinuousInputMinusOne() {
		// initialize test object
		testObject.getPosition().x -= 70;

		for (int i = 0; i < cooldown_length - 1; i++) {
			// hit the space bar and update every cycle of game loop
			testBM.simulateKeyPress();
			testBM.update();
		}
		// we just exited, and should have entered back in on the last press
		assertTrue(testBM.returnInCoolDown());
	}

}
