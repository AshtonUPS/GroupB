package com.groupb.lathe.entity;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

public interface IGameObject {
	
	public void input(Window w);
	
	public void update();
	
	public void render();

	public Matrix4f getMatrix();

	public String getStructure();

	public Vector3f getScale();

	public Vector3f getSize();

	public Vector3f getRotation();
	
}
