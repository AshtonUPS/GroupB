package com.groupb.lathe.engine;

public interface IGameComponent {

	void init();
	
	void input();
	
	void update();
	
	void render();
	
	void cleanup();
	
}
