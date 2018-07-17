package com.ggar.dev.test.threadpoolexecutor;

import com.ggar.dev.threadpoolexecutor.Main;
import com.ggar.dev.threadpoolexecutor.properties.Properties;
import com.ggar.dev.threadpoolexecutor.properties.PropertiesReader;

public class EntryPoint {
	
	public static void main(String[] args) {
		try {
			Properties<String, String> properties = PropertiesReader.read(".\\config\\ThreadPoolExecutor.properties");
			
			String clazzName = properties.get("main");
			Main clazz = (Main) Class.forName(clazzName).newInstance();
			clazz.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
