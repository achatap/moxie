package com.moxie.tastcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.moxie.pages.BaseClass;
import com.moxie.pages.BookingPage;
import com.moxie.pages.BookingPageAfterLogin;
import com.moxie.pages.DerivedPage;
import com.moxie.pages.HomePage;
import com.moxie.utilities.ConfigDataProvider;
import com.moxie.utilities.Helper;

public class MoxieChangeTime extends BaseClass {

	@Test(priority=1, enabled = true)
	public void checkTypeIsWorking(){
	
	HomePage home= new HomePage(driver);	
	home.selectFilter(config.getType());
	
	Assert.assertEquals(driver.getCurrentUrl().contains(config.getType()),true);
	}

	@Test(priority = 2, enabled = true)
	public void selectFirstFlexPay() {

		DerivedPage page= new DerivedPage(driver);
		
		page.clickOnFirstPayClass();
		Assert.assertEquals(page.flexPayOpionIsAvailable(),true);
	
	}
	
	@Test(priority = 3, enabled = true)
	public void loginForBookingPage() {
		
		BookingPage page= new BookingPage(driver);
		page.clickOnbookButton();
		page.EnterEmailid(config.getEmail());
		page.submitButton();
		page.enterPassword(config.getPassword());
		page.finalSubmitButton();
		
		Assert.assertEquals(page.emailPresentOnPage(), true);
		
	}
	
	@Test(priority = 4, enabled = true)
	public void changeTimeZone() {
		
		BookingPageAfterLogin page= new BookingPageAfterLogin(driver);
		page.selectTime();
		page.enterTimezone(config.getTimeZone());
		
		new Helper().captureScreenshot(driver);
		
		Assert.assertEquals(page.verifyTimeZone(config.getTimeZone()), true);
	}
}
