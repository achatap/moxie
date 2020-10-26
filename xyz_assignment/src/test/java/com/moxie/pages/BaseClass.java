package com.moxie.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.moxie.utilities.BrowserFactory;
import com.moxie.utilities.ConfigDataProvider;
import com.moxie.utilities.ExcelDataProvider;
import com.moxie.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;
	public ConfigDataProvider config;
	public int rowNumber;
	

	@Parameters({"browser","rowNumber"})
	@BeforeClass
	public void setup(String browser, String rowNum) {
		
		excel = new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(".//Report/"+browser+ "_"+new Helper().getCurrentDateTime() +"_Moxie_XYZ.html"));
		report = new ExtentReports();
		report.attachReporter(extent);

		rowNumber = Integer.parseInt(rowNum);
		
		driver= new BrowserFactory().startApplication(driver, browser, excel.getURL(rowNumber));

	}
	@AfterClass
	public void tearDown(){ 
		new BrowserFactory().quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(new Helper().captureScreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(new Helper().captureScreenshot(driver)).build());
		}
	
		report.flush();
		
	}
}
