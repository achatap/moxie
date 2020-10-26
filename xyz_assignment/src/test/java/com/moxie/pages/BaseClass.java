package com.moxie.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.moxie.utilities.BrowserFactory;
import com.moxie.utilities.ConfigDataProvider;
import com.moxie.utilities.ExcelDataProvider;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;
	public ConfigDataProvider config;

	@BeforeClass
	public void setup() {

		config = new ConfigDataProvider();
		driver= new BrowserFactory().startApplication(driver, config.getBrowser(), config.getURL());

	}

	@AfterClass

	public void tearDown(){ 
		new BrowserFactory().quitBrowser(driver);
	}


}
