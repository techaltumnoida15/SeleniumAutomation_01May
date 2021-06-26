package com.project.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import org.project.constants.FrameworkConstants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	private static ExtentReports extent;

	private ExtentReport() {}

	public static void initReport() throws Exception {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());

			extent.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("UIAutomation Report");
			spark.config().setReportName("Selenium Automation");
		}
	}
	
	public static void tearDownReport() throws Exception {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI());
	}
	
	public static void createTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		ExtentManager.setExtentTest(test);
	}
}
