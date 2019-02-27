package com.groupb.lathe.engine;

import com.groupb.lathe.tests.TestGame;

public class GameLauncher {
	
	public static void main(String[] args) {
		IGameComponent test = new TestGame();
		new Engine("Test", 1280, 720, test).start();;
	}

}
