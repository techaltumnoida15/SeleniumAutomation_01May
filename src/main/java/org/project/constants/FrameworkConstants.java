package org.project.constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.project.utils.PropertyFile;

public final class FrameworkConstants {
	private FrameworkConstants() {}

	private static final String USERDIR = System.getProperty("user.dir");
	private static final String PROPFILEPATH = USERDIR + "\\resources\\config.properties";
	private static final String EXTENTREPORTPATH = USERDIR + "\\extent-output\\";
	private static final String PASSEDTESTSCREENSHOTPATH = USERDIR + "\\screenshots\\passedTests\\";
	private static final String FAILEDTESTSCREENSHOTPATH = USERDIR + "\\screenshots\\failedTests\\";
	private static final String EXCELPATH = USERDIR + "\\data\\Data.xlsx";
	private  static final int MAXRETRYCOUNT = 2;
	
	public static int getMaxretryCount() {
		return MAXRETRYCOUNT;
	}

	public static String getPassedtestscreenshotpath() {
		return PASSEDTESTSCREENSHOTPATH;
	}

	public static String getFailedtestscreenshotpath() {
		return FAILEDTESTSCREENSHOTPATH;
	}

	public static String getExtentreportpath() throws Exception {
		if(PropertyFile.get("overrideReport").equals("yes"))
			return EXTENTREPORTPATH + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".html";
		else
			return EXTENTREPORTPATH + "index.html";
	}

	public static String getPropfilepath() {
		return PROPFILEPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}
}
