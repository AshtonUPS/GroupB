package com.groupb.lathe.graphics;

/**
 * Handles creating rectangular vertex arrays.
 * 
 * @author ashtonwalden
 *
 */
public class Mesh {

	private VertexArray va;

	public Mesh(float width, float height) {

		float[] vertices = new float[] { -width / 2, -height / 2, 0, -width / 2, height / 2, 0, width / 2, height / 2,
				0, width / 2, -height / 2, 0, };

		byte[] indices = new byte[] { 0, 1, 2, 2, 3, 0, };

		float[] tcs = new float[] { 0, 1, 0, 0, 1, 0, 1, 1, };

		va = new VertexArray(vertices, indices, tcs);
	}

	public void render() {
		va.render();
	}

}
