package org.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	private Driver() {}

	private String broweserName = "";
	public static void initDriver() throws Exception {
		if(DriverManager.getDriver() == null) {
			//if(broweserName.)
			
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			DriverManager.setWebDriver(driver);

			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		}
	}

	public static void quitDriver() {
		if(DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
