package com.groupb.lathe.tests;

import com.groupb.lathe.engine.IGameComponent;
import com.groupb.lathe.engine.Window;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.Texture;
import com.groupb.lathe.graphics.VertexArray;
import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;

public class Box implements IGameComponent {

	private VertexArray va;

	Shader shader = Shader.BASIC;

	Texture texture;

	float x, y, width, height, rotation, scale;

	float vx, vy, ay;

	public Box(float x, float y, int width, int height, float depth) {

		float[] vertices = new float[] { -width / 2, -height / 2, depth, -width / 2, height / 2, depth, width / 2,
				height / 2, depth, width / 2, -height / 2, depth, };

		byte[] indices = new byte[] { 0, 1, 2, 2, 3, 0, };

		float[] tcs = new float[] { 0, 1, 0, 0, 1, 0, 1, 1, };

		va = new VertexArray(vertices, indices, tcs);

		texture = Texture.getByPath("resources/default.png");

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rotation = 0f;
		this.scale = 1f;

		this.ay = -0.05f;
		this.vy = 0f;
		this.vx = 0f;

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void input(Window w) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		x += vx;
		y += vy;
	}

	@Override
	public void render() {
		shader.enable();
		texture.bind();
		shader.setUniformMat4f("model_matrix", Matrix4f.translate(new Vector3f(x, y, 0))
				.multiply(Matrix4f.rotate(rotation)).multiply(Matrix4f.scale(scale)));
		va.render();
		texture.unbind();
		shader.disable();
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

	public void setVelocity(Vector3f vel) {
		vx = vel.x;
		vy = vel.y;
	}


	public boolean collides(Box b2) {
		Vector3f b2c = b2.getPosition();
		Vector3f b1c = getPosition();
		Vector3f b2t = new Vector3f(b2c.x - width / 2, b2c.y + height / 2, 0);
		Vector3f b2b = new Vector3f(b2c.x + width / 2, b2c.y - height / 2, 0);

		Vector3f b1t = new Vector3f(b1c.x - width / 2, b1c.y + height / 2, 0);
		Vector3f b1b = new Vector3f(b1c.x + width / 2, b1c.y - height / 2, 0);

		return rangeIntersect(b2t.x, b2b.x, b1t.x, b1b.x) && rangeIntersect(b2t.y, b2b.y, b1t.y, b1b.y);
	}

	public Vector3f getPosition() {
		return new Vector3f(x, y, 0f);
	}

	public void handleCollision(Box b2) {
		Vector3f b2c = b2.getPosition();
		Vector3f b1c = getPosition();
		Vector3f b2t = new Vector3f(b2c.x - width / 2, b2c.y + height / 2, 0);
		Vector3f b2b = new Vector3f(b2c.x + width / 2, b2c.y - height / 2, 0);

		Vector3f b1t = new Vector3f(b1c.x - width / 2, b1c.y + height / 2, 0);
		Vector3f b1b = new Vector3f(b1c.x + width / 2, b1c.y - height / 2, 0);
		
		
		
	}

	private boolean rangeIntersect(float min0, float max0, float min1, float max1) {
		return Math.max(min0, max0) >= Math.min(min1, max1) && Math.min(min0, max0) <= Math.max(min1, max1);
	}

}
