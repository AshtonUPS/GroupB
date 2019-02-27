package com.groupb.lathe.tests;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;

import java.util.ArrayList;

import com.groupb.lathe.engine.IGameComponent;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;

public class TestGame implements IGameComponent {

	int vao;
	ArrayList<GameObject> gos;

	@Override
	public void init() {

		glEnable(GL_TEXTURE_2D);

		Shader.loadAll();
		Matrix4f pr_matrix = Matrix4f.orthographic(-10f, 10f, -10f * 9f / 16f, 10f * 9f / 16f, -1f, 1f);
		Shader.BASIC.enable();
		Shader.BASIC.setUniformMat4f("pr_matrix", pr_matrix);
		Shader.BASIC.disable();

		gos = new ArrayList<GameObject>();

		for (int i = 0; i < 10; i++) {
			gos.add(new GameObject(1, 1, 1, 0));
		}

	}

	@Override
	public void input() {

	}

	@Override
	public void update() {
		for (GameObject g : gos) {
			g.update();
		}
	}

	@Override
	public void render() {
		for (GameObject g : gos) {
			g.render();
		}
	}

	@Override
	public void cleanup() {
		for (GameObject g : gos) {
			g.cleanup();
		}
	}

}
