package com.groupb.lathe.math;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.nio.FloatBuffer;

import com.groupb.lathe.util.BufferUtils;

/**
 * Handles matrix math for us. We do have joml as a dependency, but this takes
 * out some overhead.
 * 
 * All methods assume Column Major ordering because OpenGL expects this format.
 * 
 * @author ashtonwalden
 *
 */
public class Matrix4f {

	public float[] matrix = new float[4 * 4];

	/**
	 * Creates an identity matrix
	 * 
	 * @return An identity matrix
	 */
	public static Matrix4f identity() {
		Matrix4f result = new Matrix4f();

		for (int i = 0; i < 4 * 4; i++) {
			result.matrix[i] = 0.0f;
		}

		result.matrix[0 + 0 * 4] = 1.0f;
		result.matrix[1 + 1 * 4] = 1.0f;
		result.matrix[2 + 2 * 4] = 1.0f;
		result.matrix[3 + 3 * 4] = 1.0f;

		return result;

	}

	/**
	 * Multiplies by the given matrix
	 * 
	 * @param matrix Matrix to multiply by
	 * @return The newly multiplied matrix
	 */
	public Matrix4f multiply(Matrix4f matrix) {
		Matrix4f result = new Matrix4f();

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				float sum = 0.0f;
				for (int e = 0; e < 4; e++) {
					sum += this.matrix[e + y * 4] * matrix.matrix[x + e * 4];
				}
				result.matrix[x + y * 4] = sum;
			}
		}
		return result;

	}

	/**
	 * Translates by the given vector
	 * 
	 * @param vector Vector to translate by
	 * @return The translated matrix
	 */
	public static Matrix4f translate(Vector3f vector) {
		Matrix4f result = identity();

		result.matrix[0 + 3 * 4] = vector.x;
		result.matrix[1 + 3 * 4] = vector.y;
		result.matrix[2 + 3 * 4] = vector.z;

		return result;

	}

	/**
	 * Rotates around the z axis
	 * 
	 * @param angle Angle in degrees
	 * @return Rotated matrix
	 */
	public static Matrix4f rotate(float angle) {
		Matrix4f result = identity();
		float r = (float) toRadians(angle);
		float cos = (float) cos(r);
		float sin = (float) sin(r);

		result.matrix[0 + 0 * 4] = cos;
		result.matrix[1 + 0 * 4] = sin;

		result.matrix[0 + 1 * 4] = -sin;
		result.matrix[1 + 1 * 4] = cos;

		return result;

	}

	/**
	 * Scales the matrix by a float
	 * 
	 * @param scale The scale
	 * @return Scaled matrix
	 */
	public static Matrix4f scale(float scale) {
		Matrix4f result = identity();

		result.matrix[0 + 0 * 4] = scale;
		result.matrix[1 + 1 * 4] = scale;

		return result;

	}

	/**
	 * Creates an orthographic matrix
	 * 
	 * @param left   Left clipping
	 * @param right  Right clipping
	 * @param bottom Bottom clipping
	 * @param top    Top clipping
	 * @param near   near clipping
	 * @param far    far clipping
	 * @return the orthographic matrix
	 */
	public static Matrix4f orthographic(float left, float right, float bottom, float top, float near, float far) {
		Matrix4f result = identity();

		result.matrix[0 + 0 * 4] = 2 / (right - left);
		result.matrix[1 + 1 * 4] = 2 / (top - bottom);
		result.matrix[2 + 2 * 4] = 2 / (near - far);

		result.matrix[0 + 3 * 4] = (left + right) / (left - right);
		result.matrix[1 + 3 * 4] = (bottom + top) / (bottom - top);
		result.matrix[2 + 3 * 4] = (near + far) / (near - far);

		return result;
	}

	/**
	 * Easily converts the matrix to a float buffer. OpenGL only recognizes float
	 * buffers.
	 * 
	 * @return The matrix as a float buffer
	 */
	public FloatBuffer toFloatBuffer() {
		return BufferUtils.createFloatBuffer(matrix);
	}

}
