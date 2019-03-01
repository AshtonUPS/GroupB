package com.groupb.lathe.tests;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

import com.groupb.lathe.engine.IGameComponent;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

public class TestGame implements IGameComponent {
	Camera c;

	Box b1, b2;
	
	Level l;

	@Override
	public void init() {

		glEnable(GL_TEXTURE_2D);

		Shader.loadAll();
		Matrix4f pr_matrix = Matrix4f.orthographic(-100f, 100f, -100f * 9f / 16f, 100f * 9f / 16f, -1f, 1f);
		Shader.BASIC.enable();
		Shader.BASIC.setUniformMat4f("pr_matrix", pr_matrix);
		Shader.BASIC.disable();

		c = new Camera(Shader.BASIC);
		b1 = new Box(0f, 0f, 10, 10, 0f);
		b2 = new Box(20, 0, 10, 10, 0);
		
		l = new Level(0,-15,10,10,0f);
		
		b1.setVelocity(new Vector3f(0.5f, 0f, 0f));

	}

	@Override
	public void input(Window w) {
		float x = 0f;
		float y = 0f;
		float speed = 1f;

		if(w.isKeyPressed(GLFW_KEY_W)) {
			y += speed;;
		}
		if(w.isKeyPressed(GLFW_KEY_S)) {
			y -= speed;;
		}
		if(w.isKeyPressed(GLFW_KEY_A)) {
			x -= speed;;
		}
		if(w.isKeyPressed(GLFW_KEY_D)) {
			x += speed;;
		}
		
		b1.setVelocity(new Vector3f(x,y,0));
		
	}

	@Override
	public void update() {
		b1.update();
		b2.update();
		l.update();
		
		if(b1.collides(b2)) {
			b1.handleCollision(b2);
		}
		
	}

	@Override
	public void render() {
		l.render();
		b1.render();
		b2.render();
	}

	@Override
	public void cleanup() {
		b1.cleanup();
		b2.cleanup();
		l.cleanup();
	}

}
