package com.groupb.lathe.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Handles loading files
 * 
 * @author ashtonwalden
 *
 */
public class FileUtils {

	private FileUtils() {

	}

	/**
	 * Loads a file into a string.
	 * 
	 * Help from
	 * https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
	 * 
	 * @param file Path to the file
	 * @return The file's contents as a string
	 */
	public static String loadAsString(String file) {
		try {
			InputStream istream = FileUtils.class.getClassLoader().getResourceAsStream(file);
			BufferedInputStream bis = new BufferedInputStream(istream);
			ByteArrayOutputStream buf = new ByteArrayOutputStream();
			int result = bis.read();
			while (result != -1) {
				byte b = (byte) result;
				buf.write(b);
				result = bis.read();
			}
			System.out.println("Loaded File String: " + file);
			return buf.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Empty File String: " + file);
		return "";
	}

}
