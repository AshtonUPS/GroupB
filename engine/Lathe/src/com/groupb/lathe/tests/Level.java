package com.groupb.lathe.tests;

import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.VertexArray;

public class Level {
	
	private VertexArray background;
	
	public Level() {
		float[] vertices = new float[] {
			-0.5f, -0.5f, 0f,
			-0.5f, 0.5f, 0f,
			0.5f, 0.5f, 0f,
			0.5f, -0.5f, 0f,
		};
		
		byte[] indices = new byte[] {
				0, 1, 2,
				2, 3, 0,
		};
		
		float[] tcs = new float[] {
			0, 1,
			0, 0,
			1, 0,
			1, 0,
		};
		
		background = new VertexArray(vertices, indices, tcs);
		
	}
	
	public void render() {
		Shader.BASIC.enable();
		background.render();
		Shader.BASIC.disable();
	}

}
