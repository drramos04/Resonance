package com.resonance.traveltests;

import static com.resonance.utility.Keyword.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.resonance.config.BaseFramework;
import com.resonance.constants.LocatorType;

public class Travel extends BaseFramework {

	@Test
	public void verifyErrorOnSelectingSameCitiesAsSourceAndDestination() throws AWTException {
		Robot rb = new Robot();
		
		launchUrl("https:\\www.redbus.com");
		waitFor(500);
		click(LocatorType.css, "input#src");
		waitFor(500);
		enterText(LocatorType.css, "input#src", "Warje, Pune");
		waitFor(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		waitFor(500);
		enterText(LocatorType.css, "input#dest", "Warje, Pune");
		waitFor(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		waitFor(500);
		
		//Assert.assertEquals(actual, expected, "Source and Destination cannot be same city");
	}
}
