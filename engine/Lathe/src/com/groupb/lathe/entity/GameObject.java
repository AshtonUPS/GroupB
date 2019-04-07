package com.groupb.lathe.entity;

import java.util.ArrayList;
import java.util.List;

import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.components.GameComponent;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

/**
 * The GameObject is any object that exists inside of a Game. Can have
 * components attached. Instantiated objects are added to the GAMEOBJECTS list,
 * and must be destroyed properly.
 * 
 * @author ashtonwalden
 *
 */
public class GameObject implements IGameObject {

	protected Vector3f position; // The objects position in the game world (z isn't used)
	protected Vector3f scale; //The objects scale (only x is used rn)
	protected Vector3f size; //The objects width(x) and height(y)

	protected Vector3f rotation; //Z rotation.

	public GameObject() {
		position = new Vector3f();
		scale = new Vector3f(1, 1, 0);
		size = new Vector3f(1,1,0);
		rotation = new Vector3f();
	}

	public GameObject(Vector3f position, float width, float height) {
		this.position = position;
		scale = new Vector3f(1, 1, 0);
		size = new Vector3f(width,height,0);
		rotation = new Vector3f();
	}

	public void input(Window w) {
		return;
	}

	public void update() {
		return;
	}

	public void render() {
		return;
	}

	public Matrix4f getMatrix() {
		return Matrix4f.rotate(rotation.z).multiply(Matrix4f.translate(position).multiply(Matrix4f.scale(scale.x)));
	}

	@Override
	public String getStructure() {
		return "Actor";
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
	public Vector3f getRotation() {
		return rotation;
	}

	@Override
	public Vector3f getPosition() {
		return position;
	}
}
