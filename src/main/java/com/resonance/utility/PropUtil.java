package com.resonance.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class can be utilized for reading and writing .properties files
 * 
 * @author Ram
 *
 */
public class PropUtil {
	public String getValue(String filePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(fis);
			value=prop.getProperty(key);
			//prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	public String[] getLocator(String key) {
		String dir = System.getProperty("user.dir")+("\\src\\main\\resonance.OR.properties");
		String locator= getValue(dir, key);
		String[] parts= locator.split("##");
		return parts;
	}
}
