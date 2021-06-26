package org.project.utils;

import java.io.File;

import org.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {}
	
	public static File takeScreenshot() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	}
	
	public static String takeScreenshotBase64() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
