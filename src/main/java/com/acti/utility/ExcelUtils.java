package com.acti.utility;  //VIDEO 41

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
XSSFWorkbook excel;
	
	public ExcelUtils(String xlPath) {
		
		//File file = new File(xlPath);
		//FileInputStream fis = new FileInputStream(file);
		//XSSFWorkbook excel = new XSSFWorkbook(fis);
		
	//Select all 3 lines above and right click surround with try catch.. then you will get the below code
		
		try 
		{
			File file = new File(xlPath);
			FileInputStream fis = new FileInputStream(file);
			excel = new XSSFWorkbook(fis);
		} 
		catch (Exception e)  //type exception e
		{
			
			System.out.println("No Excel Sheet found at this path "+e.getMessage());
		} 
		
	}
	
	
	// Method to read the last row... get row count
	
	public int getRowCount(int sheetNum)
	{
		
		int count=excel.getSheetAt(sheetNum).getLastRowNum()+1;
		return count;		
		
	}
	
	public String getCellData(int sheetNum, int row, int col)
	{
		String data = excel.getSheetAt(sheetNum).getRow(row).getCell(col).toString();
		return data;
	}


}
