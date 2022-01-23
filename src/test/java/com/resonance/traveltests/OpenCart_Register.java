package com.resonance.traveltests;

import com.resonance.config.BaseFramework;
import static com.resonance.utility.Keyword.*;
import static com.resonance.constants.Locator.*;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class OpenCart_Register extends BaseFramework{
	private static final Logger LOG = Logger.getLogger(OpenCart_Register.class);
	
	@Test
	public void validateRegisteringAnAccountByProvidingOnlyTheMandatoryFields() {
		launchUrl("https://demo.opencart.com/");
		waitFor(5000);
		LOG.info("url opened");
		click(homePage_MyAccount);
		LOG.info("Clicked on My Account on Home Page");
		click(homePage_MyAccount_Register);
		LOG.info("Clicked on Register in My Account on Home Page");
		waitFor(3000);
	}

}
