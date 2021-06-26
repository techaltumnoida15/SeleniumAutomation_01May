package org.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.project.constants.FrameworkConstants;

public final class ExcelUtility {
	private ExcelUtility() {}
	
	private static XSSFSheet sheet;
	private static XSSFWorkbook workbook = null;
	private static List<Map<String, String>> testDetails;
	
	public static List<Map<String, String>> getTestDetails(Object sheetNameOrindex) throws Exception {
		try (FileInputStream fip = new FileInputStream(new File(FrameworkConstants.getExcelpath()))){
			workbook = new XSSFWorkbook(fip);
			if(sheetNameOrindex.getClass().getName().contains("Integer")) {
				sheet = workbook.getSheetAt((Integer)sheetNameOrindex);
			}
			else {
				sheet = workbook.getSheet(sheetNameOrindex.toString());
			}
			
			int xRows = sheet.getLastRowNum() + 1;
			int xCols = sheet.getRow(0).getLastCellNum();
			Map<String, String> excelData = null;
			testDetails = new ArrayList<>();
			
			for(int i = 1; i<xRows; i++) {
				excelData = new HashMap<>();
				
				for(int j = 0; j<xCols; j++) {
					String key = getStringCellValue(sheet.getRow(0).getCell(j));
					String value = getStringCellValue(sheet.getRow(i).getCell(j));
					excelData.put(key, value);
				}
				testDetails.add(excelData);
			}
		}
		return testDetails; 
	}
	
	private static String getStringCellValue(XSSFCell cell) throws Exception {
		String cellValue = null;
		if(cell.getCellType().name().equals(CellType.BLANK.name())) {
			cellValue = "";
		}
		else if(cell.getCellType().name().equals(CellType.FORMULA.name())) {
			throw new Exception("Formula in cell");
		}
		else if(cell.getCellType().name().equals(CellType.NUMERIC.name())) {
			cellValue = String.valueOf(cell.getNumericCellValue());
		}
		else {
			cellValue = cell.getStringCellValue();
		}
		return cellValue;
	}
}
