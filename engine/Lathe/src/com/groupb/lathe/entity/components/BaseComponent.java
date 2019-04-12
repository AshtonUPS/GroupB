package com.groupb.lathe.entity.components;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

public class BaseComponent extends GameComponent {

	protected Vector3f position;
	protected Vector3f scale;
	protected Vector3f size;
	protected Vector3f rotation;

	public BaseComponent(GameObject parent, Vector3f position, float width, float height) {
		super(parent);
		this.position = position;
		scale = new Vector3f(1, 1, 0);
		size = new Vector3f(width, height, 0);
		rotation = new Vector3f();
	}

	public BaseComponent(GameObject parent) {
		this(parent, new Vector3f(), 10f, 10f);
	}

	@Override
	public void input(Window w) {
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
	}

	@Override
	public Vector3f getRotation() {
		return rotation;
	}

	@Override
	public Vector3f getPosition() {
		return position;
	}

	@Override
	public Vector3f getScale() {
		return scale;
	}
	
	@Override
	public Vector3f getSize() {
		return size;
	}
	
	@Override
	public Matrix4f getMatrix() {
		return Matrix4f.rotate(getRotation().z).multiply(Matrix4f.translate(getPosition()).multiply(Matrix4f.scale(getScale().x)));
	}

	@Override
	public String getStructure() {
		return "Base";
	}

}
