package org.tests.com;

import org.baseTest.BaseTest;
import org.projects.pages.HomePage;
import org.testng.annotations.Test;

public class InitiateSearchRoundTripTest extends BaseTest{

	@Test
	public void initiateSearchRoundTripTest() {
		new HomePage()
		.waitForHomePageLoad()
		.enterFrom("LAS")
		.enterTo("LAX");
		
	}
}
