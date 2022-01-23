package com.resonance.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {
	private static final Logger LOG = Logger.getLogger(HomePage.class);

	@FindBy(css = "a[href^='https://ijmeet.com/app']")
	WebElement joinMeetingBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnJoinMeetingBtn() {
		joinMeetingBtn.click();
		LOG.info("Clicked On Join Meeting Button");
	}
	
	

}
