package com.groupb.lathe.entity;

import java.util.Random;

import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.Texture;
import com.groupb.lathe.graphics.VertexArray;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

/**
 * A game object is an object that exists within the game world. This is an
 * abstract class and shouldn't be instantiated directly.
 * 
 *
 * 
 * @author ashtonwalden
 *
 */
public class GameObject {

	private VertexArray va;

	Matrix4f model_matrix;

	Texture texture;

	Shader shader = Shader.BASIC;

	float x = 0f, y = 0f, c = 0f, rotation = 0f;

	public GameObject(float width, float height, float scale, float depth, Texture texture) {
		//TODO finish this class
		this.texture = texture;

		float[] vertices = new float[] { -width / 2, -height / 2, depth, -width / 2, height / 2, depth, width / 2,
				height / 2, depth, width / 2, -height / 2, depth, };

		byte[] indices = new byte[] { 0, 1, 2, 2, 3, 0, };

		float[] tcs = new float[] { 0, 1, 0, 0, 1, 0, 1, 1, };

		va = new VertexArray(vertices, indices, tcs);

		model_matrix = Matrix4f.identity();

		Random r = new Random();

		c = 2000 * r.nextFloat();
	}

	public GameObject(float width, float height, float scale, float depth) {
		this(width, height, scale, depth, Texture.getByPath("resources/default.png"));
	}

	public void update() {
		c++;
		rotation = c;
		x = 3 * (float) Math.sin(c * 0.01);
		y = 3 * (float) Math.cos(c * 0.01);

	}

	public void setX(float x) {
		this.x = x;
	}

	public void bind() {
		shader.enable();
		texture.bind();
	}

	public void unbind() {
		texture.unbind();
		shader.disable();
	}

	public void render() {
		bind();
		Shader.BASIC.setUniformMat4f("model_matrix",
				model_matrix.multiply(Matrix4f.translate(new Vector3f(x, y, 0))).multiply(Matrix4f.rotate(rotation)));
		va.render();
		unbind();
	}

	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
