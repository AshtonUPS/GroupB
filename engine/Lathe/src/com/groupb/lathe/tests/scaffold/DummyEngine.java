package com.groupb.lathe.tests.scaffold;

import com.groupb.lathe.engine.Engine;
import com.groupb.lathe.engine.IGameLogic;

public class DummyEngine extends Engine {

	public DummyEngine(IGameLogic gameLogic) {
		super("Test", 256, 144, gameLogic);
	}
	
	
}
