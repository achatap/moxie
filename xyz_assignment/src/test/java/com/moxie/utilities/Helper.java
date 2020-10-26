package com.moxie.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public String captureScreenshot(WebDriver driver) 
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath= ".//Screenshot/"+ new ConfigDataProvider().getBrowser()+ "_"+getCurrentDateTime()+new ConfigDataProvider().getType()+ "_" +"moxie.png";
		try {
		
			FileHandler.copy(src, new File(screenshotpath));
				
			
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		return screenshotpath;
		
	}
	public String getCurrentDateTime()
	{
		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		return customformat.format(currentDate);
	}

}
