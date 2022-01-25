package com.resonance.homepage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.resonance.config.BaseFramework;
import com.resonance.pages.HomePage;
import com.resonance.pages.JoinMeetingPage;
import com.resonance.utility.Keyword;

public class HomePageTests extends BaseFramework {

	@Test
	private void verifyOnClickOfJoinMeetingUserLandsOnQuickJoinMeetingPage() {
		HomePage home = new HomePage();//PageFactory.initElements(driver, HomePage.class);
		home.clickOnJoinMeetingBtn();
		Keyword.waitFor(5000);
		JoinMeetingPage joinMeeting = new JoinMeetingPage();//PageFactory.initElements(driver, JoinMeetingPage.class);
		String actualHeading = joinMeeting.getPageHeading();
		Assert.assertEquals(actualHeading, "Quick Join a Meeting");
		
		
		
	}

	
	public void m2(){
		System.out.println("m2 updates done: ");
	}
}
