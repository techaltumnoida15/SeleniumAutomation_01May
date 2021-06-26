package org.baseTest;

import org.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	@BeforeMethod
	public void setup() throws Exception {
		Driver.initDriver();
	}
	
	@AfterMethod
	public void quit() {
		Driver.quitDriver();
	}
}
