package com.groupb.lathe.tests;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;

import com.groupb.lathe.engine.IGameLogic;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.entity.components.SpriteRenderer;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;

public class TestGame implements IGameLogic {
	Camera c;
	GameObject g;

	@Override
	public void init() {

		glEnable(GL_TEXTURE_2D);

		Shader.loadAll();
		Matrix4f pr_matrix = Matrix4f.orthographic(-100f, 100f, -100f * 9f / 16f, 100f * 9f / 16f, -1f, 1f);
		Shader.BASIC.enable();
		Shader.BASIC.setUniformMat4f("pr_matrix", pr_matrix);
		Shader.BASIC.disable();

		c = new Camera(Shader.BASIC);

		g = new GameObject();
		g.addComponent(new SpriteRenderer());
		g.addComponent(new BasicMovement());

	}

	@Override
	public void input(Window w) {
		g.input(w);

	}

	@Override
	public void update() {
		g.update();
	}

	@Override
	public void render() {
		g.render();
	}

	@Override
	public void cleanup() {
	}

}
