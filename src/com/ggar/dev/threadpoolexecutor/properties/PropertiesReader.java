package com.ggar.dev.threadpoolexecutor.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PropertiesReader {
	
	public static Properties read(String url) throws IOException {
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		Properties props = new Properties();
		
		try {
			String line;
			f = new File(url);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while ( (line = br.readLine()) != null ) {
				String[] temp = line.split("=");
				props.set(temp[0].trim(), temp[1].trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) br.close();
			if (fr != null) fr.close();
		}
		return props;
	}
}
