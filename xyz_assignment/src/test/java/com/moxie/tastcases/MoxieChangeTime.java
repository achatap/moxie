package com.moxie.tastcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.moxie.pages.BaseClass;
import com.moxie.pages.BookingPage;
import com.moxie.pages.BookingPageAfterLogin;
import com.moxie.pages.DerivedPage;
import com.moxie.pages.HomePage;

public class MoxieChangeTime extends BaseClass {

	@Test(priority=1, enabled = true)

	public void checkTypeIsWorking(){

		Reporter.log("Running first test for Type check");
		logger= report.createTest("Testing working of Type filter on Homepage");

		HomePage home= new HomePage(driver);

		home.selectFilter(excel.getType(rowNumber));
		logger.info("Selecting Type on homepage");

		Assert.assertEquals(driver.getCurrentUrl().contains(excel.getType(rowNumber)),true);
		logger.pass("Type filer is working properly");
	}

	@Test(priority = 2, enabled = true)
	public void selectFirstFlexPay() {


		Reporter.log("Running second test for finding first class with Flex pay option");
		logger= report.createTest("Testing first class with Flex pay option from Dereived list");

		DerivedPage page= new DerivedPage(driver);	
		page.clickOnFirstPayClass();
		logger.info("Selecting First class with Flex Pay option available");

		Assert.assertEquals(page.flexPayOpionIsAvailable(),true);
		logger.pass("Derieved list generated properly and Flex Pay option found");

	}

	@Test(priority = 3, enabled = true)
	public void loginForBookingPage() {

		Reporter.log("Running third test for successful login");

		logger= report.createTest("Testing Successful login afer clicking on Book button on Booking page");

		BookingPage page= new BookingPage(driver);
		page.clickOnbookButton();
		logger.info("Clicked on Book button");

		page.EnterEmailid(excel.getEmail(rowNumber));
		logger.info("Email id enteted on the page");

		page.submitButton();
		logger.info("Clicked on Submit button");

		page.enterPassword(excel.getPassword(rowNumber));
		logger.info("Password enteted on the page");

		page.finalSubmitButton();
		logger.info("Clicked on Submit button");

		Assert.assertEquals(page.emailPresentOnPage(), true);
		logger.pass("After clicking on Book button, login is successful");
	}

	@Test(priority = 4, enabled = true)
	public void changeTimeZone() {

		Reporter.log("Running fourth test for changing timezone");

		logger= report.createTest("Testing the successful modification of timezone");

		BookingPageAfterLogin page= new BookingPageAfterLogin(driver);

		page.selectTime();
		logger.info("Clicking on timezone change");

		page.enterTimezone(excel.getTimeZone(rowNumber));
		logger.info("Entering the new Timezone");

		Assert.assertEquals(page.verifyTimeZone(excel.getTimeZone(rowNumber)), true);
		logger.pass("Timezone is successfully modified ");
		
		System.out.println("Modified time : "+ page.getModifiedTime());

	}
}
