package org.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.project.enums.Browser;
import org.project.utils.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	private Driver() {}

	private static WebDriver driver;
	
	public static void initDriver() throws Exception {
		String browserName = PropertyFile.get("browserName");
		
		if(DriverManager.getDriver() == null) {
			
			if(browserName.equalsIgnoreCase(Browser.CHROME.name())) {
				WebDriverManager.chromedriver().setup();
				
				if(PropertyFile.get("headless").equalsIgnoreCase("yes")) {
					ChromeOptions chromeOption = new ChromeOptions();
					chromeOption.setHeadless(true);
					driver = new ChromeDriver(chromeOption);
				}
				else
					driver = new ChromeDriver();
			}
			
			else if(browserName.equalsIgnoreCase(Browser.FIREFOX.name())) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
			else if(browserName.equalsIgnoreCase(Browser.IE.name())) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			
			else if(browserName.equalsIgnoreCase(Browser.EDGE.name())) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			else {
				throw new Exception("Browser name '" + browserName + "' is not correct. Pls check options in config file.");
			}

			DriverManager.setWebDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyFile.get("url"));
		}
	}

	public static void quitDriver() {
		if(DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
