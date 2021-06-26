package org.tests.com;

import org.baseTest.BaseTest;
import org.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.reports.Logger;

public class AA extends BaseTest{

	@Test
	public void aaTestCase() {
		//ExtentReport.createTest("TC02");
		
		System.out.println(DriverManager.getDriver().getCurrentUrl());
		
		//DriverManager.getDriver().findElement(By.xpath("//a[text()='Gmail']")).click();
		
//		ExtentManager.getExtentTest().info("This is info - TC02");
//		ExtentManager.getExtentTest().log(Status.INFO, "This is log info - TC02");
//		ExtentManager.getExtentTest().pass("This is PASS - TC02");
//		ExtentManager.getExtentTest().fail("This is Fail - TC02");
		
		Logger.pass("PASS - AA");
		
		Logger.info("This is info - AA");
		
		Assert.assertTrue(false);
	}
}
