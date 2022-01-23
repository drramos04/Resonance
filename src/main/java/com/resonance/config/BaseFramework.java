package com.resonance.config;

import static com.resonance.utility.Keyword.*;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseFramework {
	public static RemoteWebDriver driver;
	@BeforeMethod
	public void setup() {
		Config conf = new Config(); 
		this.driver = openBrowser(conf.getBrowserName());
		launchUrl(conf.getAppUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
