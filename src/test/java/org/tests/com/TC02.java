package org.tests.com;

import org.baseTest.BaseTest;
import org.driver.DriverManager;
import org.testng.annotations.Test;

import com.project.reports.Logger;

public class TC02 extends BaseTest{

	@Test
	public void testCase02() {
		//ExtentReport.createTest("TC02");
		
		System.out.println(DriverManager.getDriver().getCurrentUrl());
		
		//DriverManager.getDriver().findElement(By.xpath("//a[text()='Gmail']")).click();
		
//		ExtentManager.getExtentTest().info("This is info - TC02");
//		ExtentManager.getExtentTest().log(Status.INFO, "This is log info - TC02");
//		ExtentManager.getExtentTest().pass("This is PASS - TC02");
//		ExtentManager.getExtentTest().fail("This is Fail - TC02");
		
		Logger.pass("PASS - TC02");
		
		Logger.info("This is info - TC02");
	}
}
