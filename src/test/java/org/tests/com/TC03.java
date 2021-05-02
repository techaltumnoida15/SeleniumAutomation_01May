package org.tests.com;

import org.baseTest.BaseTest;
import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC03 extends BaseTest{

	@Test
	public void testCase02() {
		DriverManager.getDriver().findElement(By.xpath("//a[text()='Images']")).click();
	}
}
