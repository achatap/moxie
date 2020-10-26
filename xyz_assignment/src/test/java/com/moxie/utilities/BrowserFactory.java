package com.moxie.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public WebDriver startApplication(WebDriver driver, String browserName, String siteurl) {

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", ".//Drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Sorry browser not supported");
		}
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(siteurl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}

	public void quitBrowser(WebDriver driver) {

		driver.quit();

	}

}
