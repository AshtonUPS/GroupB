package com.groupb.experiments;

import com.groupb.lathe.engine.Engine;
import com.groupb.lathe.engine.IGameLogic;

public class Launcher {

	public static void main(String[] args) {
		IGameLogic blocky = new GameLogic();
		new Engine("Blocky", 1280, 720, blocky).start();
	}

}
