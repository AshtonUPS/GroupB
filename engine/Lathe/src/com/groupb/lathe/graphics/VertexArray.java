package com.groupb.lathe.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import com.groupb.lathe.util.BufferUtils;

/**
 * Handles VertexArrays
 * 
 * @author ashtonwalden
 *
 */
public class VertexArray {

	private int count, vao, vbo, ibo, tco;

	/**
	 * Creates a vertex array
	 * 
	 * @param vertices  Array of Vertices
	 * @param indices   Array of indices
	 * @param texCoords Array of texCoords
	 */
	public VertexArray(float[] vertices, byte[] indices, float[] texCoords) {
		count = indices.length;

		vao = glGenVertexArrays();
		glBindVertexArray(vao);

		// Vertices
		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);

		// Texture
		tco = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, tco);
		glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(texCoords), GL_STATIC_DRAW);
		glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(1);

		// Indices
		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, BufferUtils.createByteBuffer(indices), GL_STATIC_DRAW);

		// Cleanup
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}

	/**
	 * Binds the vertex array
	 */
	public void bind() {
		glBindVertexArray(vao);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
	}
	
	
	/**
	 * Unbinds the vertex array
	 */
	public void unbind() {
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindVertexArray(0);

	}

	/**
	 * Draws the elements in the vertex array
	 */
	public void draw() {
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_BYTE, 0);
	}

	/**
	 * Helper method that binds, renders, then unbinds the vertex array
	 */
	public void render() {
		bind();
		draw();
		unbind();
	}

}
