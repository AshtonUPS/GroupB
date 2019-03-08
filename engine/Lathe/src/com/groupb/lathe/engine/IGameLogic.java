package com.groupb.lathe.engine;

/**
 * Interface for game components.
 * 
 * @author ashtonwalden
 *
 */
public interface IGameLogic {

	void init();

	void input(Window window);

	void update();

	void render();

	void cleanup();

}
