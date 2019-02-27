package com.groupb.lathe.graphics;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glUseProgram;

import java.util.HashMap;
import java.util.Map;

import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;
import com.groupb.lathe.util.ShaderUtils;

/**
 * This class handles loading and interfacing with our shaders.
 * 
 * @author ashtonwalden
 *
 */
public class Shader {

	private int ID;
	private Map<String, Integer> locations = new HashMap<String, Integer>();

	public static Shader BASIC;

	/**
	 * @param vertex   Path to the vertex shader
	 * @param fragment Path to the fragment shader
	 */
	private Shader(String vertex, String fragment) {
		ID = ShaderUtils.load(vertex, fragment);
	}

	/**
	 * In order to not have duplicate shaders, they are all loaded once in this
	 * method.
	 */
	public static void loadAll() {
		BASIC = new Shader("shaders/shader.vert", "shaders/shader.frag");
	}

	/**
	 * Returns the uniform variable inside of the shader program given a name.
	 * 
	 * @param name Name of the uniform variable
	 * @return The id of the uniform variable
	 */
	public int getUniform(String name) {
		if (locations.containsKey(name)) {
			return locations.get(name);
		}
		int result = glGetUniformLocation(ID, name);

		if (result == -1) {
			System.err.println("Couldn't find uniform :" + name);
		} else {
			locations.put(name, result);
		}
		return result;
	}

	public void setUniform1i(String name, int value) {
		glUniform1i(getUniform(name), value);
	}

	public void setUniform3f(String name, Vector3f vector) {
		glUniform3f(getUniform(name), vector.x, vector.y, vector.z);
	}

	public void setUniformMat4f(String name, Matrix4f matrix) {
		glUniformMatrix4fv(getUniform(name), false, matrix.toFloatBuffer());
	}

	/**
	 * Enables the shader program
	 */
	public void enable() {
		glUseProgram(ID);
	}

	/**
	 * Disables the shader program
	 */
	public void disable() {
		glUseProgram(0);
	}

}
