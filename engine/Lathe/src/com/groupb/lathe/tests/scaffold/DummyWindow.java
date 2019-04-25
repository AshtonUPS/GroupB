package com.groupb.lathe.tests.scaffold;

import java.util.HashMap;

import com.groupb.lathe.engine.Window;

public class DummyWindow extends Window{

	private HashMap<Integer, Boolean> keys;
	
	public DummyWindow() {
		super("Test", 256, 144);
		keys = new HashMap<Integer, Boolean>();
	}
	
	@Override
	public boolean isKeyPressed(int keyCode){
		if(!keys.containsKey(keyCode)) {
			return false;
		}
		return keys.get(keyCode);
	}

}
