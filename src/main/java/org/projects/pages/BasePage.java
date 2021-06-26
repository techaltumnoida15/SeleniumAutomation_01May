package org.projects.pages;

import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.reports.Logger;

public class BasePage {

	protected void click(By by, String elementName) {
		DriverManager.getDriver().findElement(by).click();
		Logger.info("Click on '" + elementName + "'.");
	}
	
	protected void sendkeys(By by, String value, String elementName) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
		Logger.info("Value '" + value + "' is entered in '" + elementName + "'.");
	}
	
	protected void waitForPageLoad(int timeoutInSeconds) {
		new WebDriverWait(DriverManager.getDriver(), timeoutInSeconds)
		.until(d -> ((JavascriptExecutor)DriverManager.getDriver()).executeScript("return document.readyState").equals("complete"));
		Logger.info("Home page is loaded.");
	}
	
	protected void waitForElementToBeVisible(By by, int timeoutInSeconds, String elementName) {
		new WebDriverWait(DriverManager.getDriver(), timeoutInSeconds)
		.until(ExpectedConditions.visibilityOfElementLocated(by));
		Logger.info(elementName + " is visible.");
	}
	
}
