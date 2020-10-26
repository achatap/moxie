package com.moxie.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

import com.moxie.pages.BaseClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper{
	
	public String captureScreenshot(WebDriver driver) throws IOException 
	{
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath= System.getProperty("user.dir")+"\\Screenshot\\"+ getCurrentDateTime()+"_" +"_moxie.png";
		FileHandler.copy(src, new File(screenshotpath));
		return screenshotpath;
		
	}
	public String getCurrentDateTime()
	{
		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		return customformat.format(currentDate);
	}

}
