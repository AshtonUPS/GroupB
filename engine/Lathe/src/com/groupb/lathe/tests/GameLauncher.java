package com.groupb.lathe.tests;

import com.groupb.lathe.engine.Engine;
import com.groupb.lathe.engine.IGameLogic;

public class GameLauncher {
	
	public static void main(String[] args) {
		IGameLogic test = new TestGame();
		new Engine("Test", 1280, 720, test).start();;
	}

}
