package com.groupb.lathe.entity;

import com.groupb.lathe.entity.components.CameraComponent;
import com.groupb.lathe.graphics.Shader;

public class Camera extends GameObject {

	CameraComponent cam;

	public Camera() {
		cam = new CameraComponent(this, Shader.BASIC);
		updateAll();
	}

	public void enable() {
		cam.enable();
	}

	public void disable() {
		cam.disable();
	}

}
