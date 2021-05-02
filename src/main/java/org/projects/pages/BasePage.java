package org.projects.pages;

import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected void click(By by) {
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void sendkeys(By by, String value) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected void waitForPageLoad(int timeoutInSeconds) {
		new WebDriverWait(DriverManager.getDriver(), timeoutInSeconds)
		.until(d -> ((JavascriptExecutor)DriverManager.getDriver()).executeScript("return document.readyState").equals("complete"));
	}
	
	protected void waitForElementToBeVisible(By by, int timeoutInSeconds) {
		new WebDriverWait(DriverManager.getDriver(), timeoutInSeconds)
		.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
}
