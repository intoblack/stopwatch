package com.intoblack.stopwatch.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileUtils {

	private FileUtils() {

	}

	
	/**
	 * 根据
	 * 
	 * 
	 * @param file
	 * @param contens
	 * @throws IOException
	 */
	public static void writerFile(File file, Collection<String> contens)
			throws IOException {

		
		if(file == null)
		{
			throw new IllegalArgumentException("文件对象为空 : fill is null") ;
		}
		FileWriter writer = new FileWriter(file);
		for (String line : contens) {
			if (line.endsWith("\n")) {
				writer.write(line);
			} else {

				writer.write(String.format("%s\n", line));
			}
		}
		writer.close(); 
	}

}
