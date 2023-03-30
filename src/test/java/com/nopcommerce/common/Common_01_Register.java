package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;

public class Common_01_Register extends BaseTest {
	WebDriver driver;

	String firstName = "Trong";
	String lastName = "Ta Van";
	public static String emailAddress, passwordTextbox;
	
	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		emailAddress = "automationkfc" + getRandomNumber() + "@testting.com";
		passwordTextbox = "123456?Aa";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Register - Step 01: Open Register Link at Home Page");
		registerPage = homePage.ClickToRegisterLink();

		log.info("Register - Step 02: Input to FirstName with value");
		registerPage.enterToFirstNameTextbox(firstName);

		log.info("Register - Step 03: Input to LastName with value");
		registerPage.enterToLastNameTextbox(lastName);

		log.info("Register - Step 04: Input to Email Textbox with value: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);

		log.info("Register - Step 05: Input to Password Textbox with value: " + passwordTextbox);
		registerPage.enterToPasswordTextbox(passwordTextbox);
		registerPage.enterToConfirmPasswordTextbox(passwordTextbox);

		log.info("Register - Step 06: Click to Register button at Register page");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 07: Verify Success message displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		log.info("Register - Step 09: Click to Continue button at Register page and navigate to Home page");
		homePage = registerPage.clickToContinueButton();
		
		log.info("Register - Step 10: Close the browser");
		driver.quit();
	}
	
	
	

	
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
}
