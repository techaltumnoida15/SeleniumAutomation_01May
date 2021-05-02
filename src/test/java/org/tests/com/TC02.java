package org.tests.com;

import org.baseTest.BaseTest;
import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC02 extends BaseTest{

	@Test
	public void testCase02() {
		System.out.println(DriverManager.getDriver().getCurrentUrl());
		
		DriverManager.getDriver().findElement(By.xpath("//a[text()='Gmail']")).click();
	}
}
