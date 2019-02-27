package com.groupb.lathe.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * Custom buffer utils. LWJGL has one, but this one is a lightweight version.
 * 
 * @author ashtonwalden
 *
 */
public class BufferUtils {

	private BufferUtils() {

	}

	/**
	 * Creates a byte buffer
	 * 
	 * @param array Array to dervice byte buffer
	 * @return byte buffer
	 */
	public static ByteBuffer createByteBuffer(byte[] array) {
		ByteBuffer result = ByteBuffer.allocateDirect(array.length).order(ByteOrder.nativeOrder());
		result.put(array).flip();
		return result;
	}

	/**
	 * Creates a float buffer
	 * 
	 * @param array Array to dervice float buffer
	 * @return float buffer
	 */
	public static FloatBuffer createFloatBuffer(float[] array) {
		FloatBuffer result = ByteBuffer.allocateDirect(array.length << 2).order(ByteOrder.nativeOrder())
				.asFloatBuffer();
		result.put(array).flip();
		return result;
	}

	/**
	 * Creates a int buffer
	 * 
	 * @param array Array to dervice int buffer
	 * @return int buffer
	 */
	public static IntBuffer createIntBuffer(int[] array) {
		IntBuffer result = ByteBuffer.allocateDirect(array.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
		result.put(array).flip();
		return result;
	}

}
