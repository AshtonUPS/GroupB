package com.groupb.lathe.entity.components;

import com.groupb.lathe.entity.GameObject;
import com.groupb.lathe.graphics.Mesh;
import com.groupb.lathe.graphics.Shader;
import com.groupb.lathe.graphics.Texture;
import com.groupb.lathe.math.Vector3f;

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

	public SpriteRenderer(GameObject parent,Texture texture) {
		super(parent);
		t = texture;
		Vector3f size = child.getSize();
		m = new Mesh(size.x, size.y);
	}

	@Override
	public void render() {
		super.render();
		s.enable();
		t.bind();
		s.setUniformMat4f("model_matrix", child.getMatrix());
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
		Vector3f size = child.getSize();
		m = new Mesh(size.x, size.x*ratio);
	}
}
