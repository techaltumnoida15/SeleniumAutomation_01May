package com.project.listeners;

import org.project.constants.FrameworkConstants;
import org.project.utils.PropertyFile;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.project.reports.Logger;

public class ReTryListiner implements IRetryAnalyzer{

	int count = 0;

	@Override
	public boolean retry(ITestResult result) {
		/*
		try {
			int maxRetryCount = Integer.parseInt(PropertyFile.get("maxRetryCount"));
			if(count < maxRetryCount) {
				count++; 
				return true; 
			} 
			else { 
				return false; 
			}

		} catch (Exception e) {
			Logger.fail("Some issue while getting maxRetryCount. " + e.toString());
			return false;
		}
		*/
		
		if(count < FrameworkConstants.getMaxretryCount()) {
			count++;
			return true;
		}
		else
			return false;
	}
}
