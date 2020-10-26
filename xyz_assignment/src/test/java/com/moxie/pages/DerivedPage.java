package com.moxie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DerivedPage {
	
	WebDriver driver;

	public DerivedPage(WebDriver ldriver)	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//div[contains(text(),'FLEX')]") WebElement firstFlexPayClass;
	@FindBy(xpath = "//div[text()='FLEX PAY']") WebElement flexPayAvailable;
	
	public void clickOnFirstPayClass(){
		driver.navigate().refresh();
		firstFlexPayClass.click();
	}
	
	public boolean flexPayOpionIsAvailable() {
		if(flexPayAvailable.isDisplayed()){
			return true;
		}
		return false;
	}

}
