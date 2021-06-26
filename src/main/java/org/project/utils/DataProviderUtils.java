package org.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {

	private DataProviderUtils() {}
	
	private static List<Map<String, String>> excelData = new ArrayList<>();
	
	@DataProvider
	public static Object[] getData() throws Exception{
		
		if(excelData.isEmpty()) {
			List<Map<String, String>> excelData = ExcelUtility.getTestDetails(1);
		}
		return null;
	}
}
