package com.groupb.lathe.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.stb.STBImage.stbi_image_free;
import static org.lwjgl.stb.STBImage.stbi_load_from_memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.BufferUtils;

/**
 * Handles loading textures.
 * 
 * @author ashtonwalden
 *
 */
public class Texture {

	private int width, height, id;

	private static Map<String, Texture> textures = new HashMap<String, Texture>();

	/**
	 * To prevent loading duplicate textures. All textures are stored in a HashMap.
	 * This method will return existing textures, or instantiate them if they don't
	 * exist.
	 * 
	 * @param path Path to the texture
	 * @return The texture object
	 */
	public static Texture getByPath(String path) {
		if (textures.containsKey(path)) {
			return textures.get(path);
		} else {
			Texture t = new Texture(path);
			textures.put(path, t);
			return t;
		}
	}

	private Texture(String path) {
		id = load(path);
	}

	private int load(String path) {
		System.out.println("Loading Texture: " + path);

		IntBuffer width = BufferUtils.createIntBuffer(1);
		IntBuffer height = BufferUtils.createIntBuffer(1);
		IntBuffer components = BufferUtils.createIntBuffer(1);
		ByteBuffer data = null;
		try {
			data = stbi_load_from_memory(ioResourceToByteBuffer(path, 1024), width, height, components, 4);
			System.out.println("Loaded");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int id = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, id);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width.get(), height.get(), 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
		stbi_image_free(data);
		return id;
	}

	/**
	 * Binds the texture
	 */
	public void bind() {
		glBindTexture(GL_TEXTURE_2D, id);
	}

	/**
	 * Unbinds the texture
	 */
	public void unbind() {
		glBindTexture(GL_TEXTURE_2D, 0);
	}

	/**
	 * Returns the width
	 * 
	 * @return Texture width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns the height
	 * 
	 * @return Texture height
	 */
	public int getHeight() {
		return this.height;
	}

	public int getID() {
		return this.id;
	}

	private ByteBuffer ioResourceToByteBuffer(String resource, int bufferSize) throws IOException {
		ByteBuffer buffer;
		File file = new File(resource);
		FileInputStream fis = new FileInputStream(file);
		FileChannel fc = fis.getChannel();
		buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		fc.close();
		fis.close();

		return buffer;
	}
}
