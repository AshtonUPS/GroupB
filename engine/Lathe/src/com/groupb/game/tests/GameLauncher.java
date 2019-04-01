package com.groupb.game.tests;

import com.groupb.lathe.engine.Engine;
import com.groupb.lathe.engine.IGameLogic;

public class GameLauncher {
	
	public static void main(String[] args) {
		//IGameLogic test = new TestGame();
		//new Engine("Test", 1280, 720, test).start();;
		
		//IGameLogic test2 = new TestGame2();
		//new Engine("anothertest", 1280, 720, test2).start();;
		
		IGameLogic test3 = new TestGame3();
		new Engine("anothertest", 1280, 720, test3).start();;
	}

}
