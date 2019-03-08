package com.groupb.lathe.entity.components;

import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.graphics.Mesh;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.Texture;
import com.groupb.lathe.math.Matrix4f;

public class SpriteRenderer extends GameComponent {

	private Texture t;
	private Mesh m;
	private Shader s = Shader.BASIC;

	public SpriteRenderer() {
		t = Texture.getByPath("resources/default.png");
		m = new Mesh(10, 10);
	}

	@Override
	public void render() {
		s.enable();
		t.bind();
		s.setUniformMat4f("model_matrix", gameObject.getMatrix());
		m.render();
		t.unbind();
		s.disable();
	}

}
