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

	public double  getStringData(int sheetIndex,int row , int column) {

		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
	}

	public String getNumericData(String sheetName,int row , int column)	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
}
