package com.groupb.lathe.tests;

import com.groupb.lathe.engine.Engine;
import com.groupb.lathe.engine.IGameComponent;

public class GameLauncher {
	
	public static void main(String[] args) {
		IGameComponent test = new TestGame();
		new Engine("Test", 1280, 720, test).start();;
	}

}
