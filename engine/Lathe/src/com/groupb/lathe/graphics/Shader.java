package com.groupb.lathe.graphics;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glUseProgram;

import java.util.HashMap;
import java.util.Map;

import com.groupb.lathe.math.Matrix4f;
import com.groupb.lathe.math.Vector3f;
import com.groupb.lathe.util.ShaderUtils;

public class Shader {
	
	private int ID;
	private Map<String, Integer> locations = new HashMap<String, Integer>();
	
	public static Shader BASIC;
	
	private Shader(String vertex, String fragment) {
		ID = ShaderUtils.load(vertex, fragment);
	}
	
	public static void loadAll() {
		BASIC = new Shader("shaders/shader.vert", "shaders/shader.frag");
	}
	
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
	
	public void enable() {
		glUseProgram(ID);
	}
	
	public void disable() {
		glUseProgram(0);
	}

}
