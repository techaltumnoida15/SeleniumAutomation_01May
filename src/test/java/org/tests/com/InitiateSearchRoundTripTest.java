package org.tests.com;

import org.baseTest.BaseTest;
import org.projects.pages.HomePage;
import org.testng.annotations.Test;

public class InitiateSearchRoundTripTest extends BaseTest{

	@Test
	public void testCase01() {
		new HomePage()
		.waitForHomePageLoad()
		.enterFrom("LAS")
		.enterTo("LAX");
	}
}
