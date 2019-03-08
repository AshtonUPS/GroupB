package com.groupb.lathe.entity.components;

import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;

public class CameraComponent extends GameComponent {

	private Shader shader;
	
	Matrix4f pr_matrix;
	
	public CameraComponent(Shader s) {
		shader = s;
		pr_matrix = Matrix4f.orthographic(-100f, 100f, -100f * 9f / 16f, 100f * 9f / 16f, -1f, 1f);
	}
	
	public void enable() {
		shader.enable();
		shader.setUniformMat4f("pr_matrix", pr_matrix);
		shader.setUniformMat4f("vw_matrix", gameObject.getMatrix());
		shader.disable();
	}
	
	public void update() {
		gameObject.setScale(gameObject.getScale() + 0.001f);
	}
	
	public void render() {
		shader.enable();
		shader.setUniformMat4f("vw_matrix", gameObject.getMatrix());
		shader.disable();
	}
}
