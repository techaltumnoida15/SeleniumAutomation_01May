package org.tests.com;

import org.baseTest.BaseTest;
import org.testng.annotations.Test;

import com.project.reports.Logger;

public class TC03 extends BaseTest{

	@Test
	public void testCase03() {
		//ExtentReport.createTest("TC03");

		//DriverManager.getDriver().findElement(By.xpath("//a[text()='Images']")).click();

		/*
		 * ExtentManager.getExtentTest().info("This is info - TC03");
		 * ExtentManager.getExtentTest().log(Status.PASS,
		 * "This is log info PASS - TC03");
		 * ExtentManager.getExtentTest().log(Status.FAIL,
		 * "This is log info FAIL - TC03");
		 * ExtentManager.getExtentTest().pass("This is PASS - TC03");
		 * ExtentManager.getExtentTest().fail("This is Fail - TC03");
		 */

		Logger.pass("PASS - TC03");

		Logger.info("This is info - TC03");
	}
}
