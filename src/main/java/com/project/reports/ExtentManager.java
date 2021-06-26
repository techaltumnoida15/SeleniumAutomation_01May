package com.project.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	private ExtentManager() {}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	public static ExtentTest getExtentTest() {
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	static void unload() {
		extTest.remove();
	}

}
