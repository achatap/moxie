package com.moxie.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//span[text()='TYPE']") WebElement typeAndDoneButton;
	
	public void selectFilter(String type) {
		typeAndDoneButton.click();
		driver.findElement(By.xpath("//span[text()='"+ type + "']")).click();
		typeAndDoneButton.click();
		
	}

}
