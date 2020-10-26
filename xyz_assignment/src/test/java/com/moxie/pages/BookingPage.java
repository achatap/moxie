package com.moxie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.moxie.utilities.ConfigDataProvider;


public class BookingPage {

	WebDriver driver;
	WebDriverWait wait ;

	public BookingPage(WebDriver driver) {

		this.driver= driver;
		PageFactory.initElements(driver, this);

		wait = new WebDriverWait(driver,  Integer.parseInt(new ConfigDataProvider().getExplicitTime()));
	}

	@FindBy(xpath = "//button[contains(text(),'BOOK')]") WebElement bookButton;
	@FindBy(name = "email") WebElement emailid;
	@FindBy(xpath = "//button[@type='submit']") WebElement submitButton;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement finalSubmitButton;
	@FindBy(xpath= "//div[contains(text(),'achatapnew@gmail.com')]") WebElement emailVerify;


	public void clickOnbookButton() {
		bookButton.click();
	}

	public void EnterEmailid(String email) {
		driver.get(driver.getCurrentUrl());
		emailid.sendKeys(email);
	}

	public void submitButton() {
		submitButton.click();
	}

	public void enterPassword(String userPassword) {
		
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(userPassword);
	}

	public void finalSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		finalSubmitButton.click();
	}

	public boolean emailPresentOnPage() {
		wait.until(ExpectedConditions.elementToBeClickable(emailVerify));
		driver.navigate().refresh();
		if(emailVerify.getText().contains(new ConfigDataProvider().getEmail())){
			return true;
		}
		return false;
	}
}
