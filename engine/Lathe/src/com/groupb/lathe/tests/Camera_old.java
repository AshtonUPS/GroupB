package com.groupb.lathe.tests;

import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

public class Camera_old {

	private Vector3f position;
	
	private Matrix4f cam;
	
	private Shader shader;

	public Camera_old(Shader s) {
		position = new Vector3f();
		cam = Matrix4f.identity();
		shader = s;
		update();
	}
	
	public void moveTo(Vector3f location) {
		this.position = location;
		cam = Matrix4f.translate(location);
	}
	
	public void moveBy(Vector3f offset) {
		position.add(offset);
		cam = cam.multiply(Matrix4f.translate(offset));
	}
	
	public void update() {
		shader.enable();
		shader.setUniformMat4f("vw_matrix", cam);
		shader.disable();
	}
	
	public float getX() {
		return position.x;
	}

	public void zoom(float f) {
		cam = cam.multiply(Matrix4f.scale(f));
	}
}
