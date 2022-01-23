package com.resonance.utility;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {

	public static RemoteWebDriver driver;
	private static WebDriverWait wait;
	private static final Logger LOG = Logger.getLogger(Keyword.class); 
	
	/**
	 * This method will launch browser in maximized mode
	 * @param browserName must be one of the following:
	 * <ul>
	 * <li> chrome </li>
	 * <li> firefox </li>
	 * <li> edge </li>
	 * </ul>
	 * @author RamDesai
	 */
	public static RemoteWebDriver openBrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase(null)){
			System.out.println("Key is Null");
		}
		else {
			LOG.error("Invalid Browser Name");
		}
		System.out.println(browserName+" is opened successfully");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return driver;
	}
	
	/**
	 * This Method will launch specified url in currently openened browser window
	 * @param url
	 */
	public static void launchUrl(String url) {
		driver.get(url);
		LOG.info(url+" is launched successfully");
	}
	
	/**
	 * This method will perform click operation on {@code WebElement} described by {@code locatorType} and {@code locatorValue} 
	 * @param locatorType must be one of the following:
	 * <ul>
	 * <li> xpath </li>
	 * <li> css</li>
	 * <li> id</li>
	 * <li> class</li>
	 * <li> name</li>
	 * </ul>
	 * @param locatorValue
	 */
	@Deprecated
	public static void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public static void click(By by) {
		driver.findElement(by).click();
	}
	
	public static void click(String locator) {
		String parts[] = locator.split("##");
		getWebElement(parts[0], parts[1]).click();
	}
	@Deprecated
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	
	public static void enterText(String locator, String textToEnter) {
		String parts[]=locator.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
	}
	
	public static void captureText(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).getText();
		}
	
	private static WebElement getWebElement(String locatorType, String locatorValue) {
		if(locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if(locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		}else if(locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		}else if(locatorType.equalsIgnoreCase("class")) {
			return driver.findElement(By.className(locatorValue));
		}else if(locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		}else {
			LOG.error("Invalid Locator Type:"+ locatorType);
			return null;
		}
	}
	
	public static void waitFor(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			LOG.error("wait is inturrupted");
			e.printStackTrace();
		}
	}
	
	
}
