package com.groupb.lathe.util;

import static org.lwjgl.opengl.GL20.*;

/**
 * Helper methods for working with shaders
 * 
 * @author ashtonwalden
 *
 */
public class ShaderUtils {

	private ShaderUtils() {

	}

	/**
	 * Creates a shader program from file paths
	 * 
	 * @param vertPath Path to vertex shader
	 * @param fragPath Path to fragment shader
	 * @return ID of shader program
	 */
	public static int load(String vertPath, String fragPath) {
		String vert = FileUtils.loadAsString(vertPath);
		String frag = FileUtils.loadAsString(fragPath);

		return create(vert, frag);
	}

	/**
	 * Creates a shader program from glsl strings.
	 * 
	 * @param vert Vertex shader string
	 * @param frag Fragment shader string
	 * @return ID of shader program
	 */
	public static int create(String vert, String frag) {
		int program = glCreateProgram();
		int vertID = glCreateShader(GL_VERTEX_SHADER);
		int fragID = glCreateShader(GL_FRAGMENT_SHADER);

		glShaderSource(vertID, vert);
		glShaderSource(fragID, frag);

		glCompileShader(vertID);

		if (glGetShaderi(vertID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to Compile vertex shader");
			System.err.println(glGetShaderInfoLog(vertID, 2048));
		}

		glCompileShader(fragID);

		if (glGetShaderi(fragID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to Compile fragment shader");
			System.err.println(glGetShaderInfoLog(fragID, 2048));
		}

		glAttachShader(program, vertID);
		glAttachShader(program, fragID);

		glLinkProgram(program);

		glValidateProgram(program);

		return program;
	}

}
