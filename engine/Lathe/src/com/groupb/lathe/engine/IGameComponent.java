package com.groupb.lathe.engine;

/**
 * Interface for game components.
 * 
 * @author ashtonwalden
 *
 */
public interface IGameComponent {

	void init();

	void input();

	void update();

	void render();

	void cleanup();

}
