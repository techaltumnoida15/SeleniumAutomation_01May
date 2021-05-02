package org.projects.pages;

public class ListingPage extends BasePage{

	public ListingPage waitForHomePageLoad() {
		waitForPageLoad(10);
		return this;
	}
}
