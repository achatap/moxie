package com.moxie.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPageAfterLogin {
	
	WebDriver driver;
	public BookingPageAfterLogin(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(className = "filter-option-inner") WebElement selectTime;
	@FindBy(xpath = "//input[@type='search' and @class='form-control']") WebElement enterTimeZone;
	

	public void selectTime() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(selectTime));
		selectTime.click();
	}
	
	public void enterTimezone(String timezone){
		enterTimeZone.sendKeys(timezone);
		enterTimeZone.sendKeys(Keys.RETURN);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(selectTime));
	}
	
	public boolean verifyTimeZone(String timezone) {
		if(selectTime.getText().contains(timezone)) {
			return true;
		}
		return false;
	}
	
	public String getModifiedTime() {
		return selectTime.getText();
	}
	

}
