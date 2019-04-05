package com.groupb.lathe.entity.components;

import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;

/**
 * CameraComponent handles settings the ShaderViewMatrix.
 * 
 * @author ashtonwalden
 *
 */
public class CameraComponent extends GameComponent {

	private boolean enabled;

	private Shader shader;

	Matrix4f pr_matrix;

	/**
	 * Create a camera for a given shader
	 * 
	 * @param s Shader for the camera
	 */
	public CameraComponent(Shader s) {
		shader = s;
		pr_matrix = Matrix4f.orthographic(-100f, 100f, -100f * 9f / 16f, 100f * 9f / 16f, -1f, 1f);
	}

	/**
	 * Enables this camera.
	 */
	public void enable() {
		enabled = true;
		shader.enable();
		shader.setUniformMat4f("pr_matrix", pr_matrix);
		shader.setUniformMat4f("vw_matrix", gameObject.getMatrix());
		shader.disable();
	}

	/**
	 * Disables the camera.
	 */
	public void disable() {
		enabled = false;
	}

	@Override
	public void update() {
		if (!enabled)
			return;
		gameObject.setScale(gameObject.getScale() + 0.01f);
	}

	@Override
	public void render() {
		if (!enabled)
			return;
		shader.enable();
		shader.setUniformMat4f("vw_matrix", gameObject.getMatrix());
		shader.disable();
	}
}
