package com.groupb.lathe.math;

/**
 * Simple vector data structure
 * 
 * @author ashtonwalden
 *
 */
public class Vector3f {

	public float x, y, z;

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f() {
		this.x = 0f;
		this.y = 0f;
		this.z = 0f;
	}

	public void add(Vector3f v2) {
		this.x += v2.x;
		this.y += v2.y;
		this.z += v2.z;
	}

	public float distance(Vector3f v2) {
		float a = v2.x - x;
		float b = v2.y - y;
		return (float) Math.sqrt(a * a + b * b);
	}

}
