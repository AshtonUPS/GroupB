package com.groupb.lathe.entity.components;

import com.groupb.lathe.graphics.Mesh;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.Texture;

/**
 * Component that handles rendering Sprites.
 * 
 * @author ashtonwalden
 *
 */
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

	/**
	 * Sets the component's texture
	 * 
	 * @param t New Texture
	 */
	public void setTexture(Texture t) {
		this.t = t;
	}
	
	public void setResolution(int width, int height) {
		float ratio = (float) height/width;
		m = new Mesh(10, 10*ratio);
	}

}
