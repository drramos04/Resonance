package com.resonance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinMeetingPage extends PageBase{
	@FindBy(css = "h2.m-txt")
	WebElement quickJoinMeetingTxt;
/**
 * This page will retun "Quick Join a Meeting" if Join Meeting page loads successfully
 * @return
 */
	public JoinMeetingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeading() {
		return quickJoinMeetingTxt.getText();
	}
}
