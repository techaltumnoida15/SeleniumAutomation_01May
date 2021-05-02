package org.projects.pages;

import org.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class HomePage extends BasePage{
	
	private static final String VALUE = "value";
	private final By idFromTextBox = By.id("from0");
	private final By idToTextBox = By.id("to0");
	
	public HomePage waitForHomePageLoad() {
		waitForPageLoad(10);
		waitForElementToBeVisible(idFromTextBox, 10);
		return this;
	}

	public HomePage enterFrom(String fromCity) {
		WebElement fromTxtbox = DriverManager.getDriver().findElement(idFromTextBox);

		if(fromTxtbox.getAttribute(VALUE) != null || !fromTxtbox.getAttribute(VALUE).isEmpty()) {
			click(By.xpath("(//a[@class='suggestion-box__clear icon'])[1]"));
		}

		sendkeys(idFromTextBox, fromCity);
		
		//Wait for suggestion List
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(d -> d.findElement(By.cssSelector("div[class*='suggestion-box__content']")).getAttribute("class").contains("visible"));

		fromTxtbox.sendKeys(Keys.TAB);

		return this;
	}
	
	public HomePage enterTo(String toCity) {
		WebElement toTxtbox = DriverManager.getDriver().findElement(idToTextBox);
		
		if(toTxtbox.getAttribute(VALUE) != null || !toTxtbox.getAttribute(VALUE).isEmpty()) {
			toTxtbox.clear();
		}

		toTxtbox.sendKeys(toCity);

		//Wait for suggestion List
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(d -> d.findElement(By.xpath("(//div[contains(@class, 'suggestion-box__content')])[2]")).getAttribute("class").contains("visible"));

		toTxtbox.sendKeys(Keys.TAB);

		return this;
	}
}
