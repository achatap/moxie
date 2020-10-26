package com.moxie.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src= new File(".//TestData//Testdata.xlsx");

		try { 
			FileInputStream  fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to read excel file"+e.getMessage());
		}}

	public String  getURL(int row) {

		return wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
	}

	public String  getType(int row) {

		return wb.getSheetAt(0).getRow(row).getCell(1).getStringCellValue();
	}
	
	public String  getEmail(int row) {
		
		return wb.getSheetAt(0).getRow(row).getCell(2).getStringCellValue();
	}
	
	public String  getPassword(int row) {

		return wb.getSheetAt(0).getRow(row).getCell(3).getStringCellValue();
	}
	
	public int getExplicitTime(int row) {

		return (int)wb.getSheetAt(0).getRow(row).getCell(4).getNumericCellValue();
	}
	
	public String  getTimeZone(int row) {

		return wb.getSheetAt(0).getRow(row).getCell(5).getStringCellValue();
	}
	
	
	
}

