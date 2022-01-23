package com.resonance.config;

import com.resonance.utility.PropUtil;

public class Config {
	
/**
 * This method will return url mentioned in application.properties file
 */
public String getAppUrl() {
	return getProperty("app.url");
}

public String getBrowserName() {
	return getProperty("app.browsername");
}

private String getProperty(String property) {
	PropUtil prop = new PropUtil();
	String dir= System.getProperty("user.dir");
	return prop.getValue(dir+"\\src\\main\\resources\\application.properties", property);
}
}
 