package com.groupb.lathe.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	 * Loads a file into a string
	 * 
	 * @param file Path to the file
	 * @return The file's contents as a string
	 */
	public static String loadAsString(String file) {
		String result = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";

			while ((line = reader.readLine()) != null) {
				result += line + "\n";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Loaded File String: " + file);
		return result;
	}

}
