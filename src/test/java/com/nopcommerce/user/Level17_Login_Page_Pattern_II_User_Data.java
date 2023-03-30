package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import pageObject.nopCommerce.AboutUsPageObject;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.MyAccountPageObject;
import pageObject.nopCommerce.NewsPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;
import pageObject.nopCommerce.ShoppingCartPageObject;
import pageObject.nopCommerce.SiteMapPageObject;

public class Level17_Login_Page_Pattern_II_User_Data extends BaseTest {
	WebDriver driver;
	int randomNumber = getRandomNumber();

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}
	
	@Test
	public void TC01_Validate_At_Register_Form() {
		log.info("Validate - Step 01: Open Register Link at Home Page");
		registerPage = homePage.ClickToRegisterLink();
		
		log.info("Validate - Step 02: Click to Register button");
		registerPage.clickToButtonByValue(driver, "Register");
		
		log.info("Validate - Step 03: Validate error message at First name textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByID(driver, "FirstName"),"First name is required.");
		
		log.info("Validate - Step 04: Validate error message at Last name textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByID(driver, "LastName"),"Last name is required.");
		
		log.info("Validate - Step 05: Validate error message at Email textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByID(driver, "Email"),"Email is required.");
		
		log.info("Validate - Step 06: Validate error message at Password textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByID(driver, "Password"),"Password is required.");
		
		log.info("Validate - Step 07: Validate error message at Confirm Password textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryFieldByID(driver, "ConfirmPassword"),"Password is required.");
		
	}

	@Test
	public void TC02_Register_To_System() {
		log.info("Register - Step 01: Refresh the Register page");
		registerPage.refreshPage(driver);
		
		log.info("Register - Step 02: click to Radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		

		log.info("Register - Step 03: Input to FirstName with value" + UserData.Register.FIRST_NAME);
		registerPage.inputToTextboxByID(driver, "FirstName", UserData.Register.FIRST_NAME);

		log.info("Register - Step 04: Input to LastName with value" + UserData.Register.LAST_NAME);
		registerPage.inputToTextboxByID(driver, "LastName", UserData.Register.LAST_NAME);

		log.info("Register - Step 05: Select dropdown with value: " + UserData.Register.DATE);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", UserData.Register.DATE);
		
		log.info("Register - Step 06: Select dropdown with value: " + UserData.Register.MONTH);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", UserData.Register.MONTH);
		
		log.info("Register - Step 07: Select dropdown with value: " + UserData.Register.YEAR);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", UserData.Register.YEAR);
		
		log.info("Register - Step 08: Input to Email with value" + UserData.Register.EMAIL_PREFIX + randomNumber + UserData.Register.EMAIL_POSTFIX);
		registerPage.inputToTextboxByID(driver, "Email", UserData.Register.EMAIL_PREFIX + randomNumber + UserData.Register.EMAIL_POSTFIX);

		log.info("Register - Step 09: Input to Password Textbox with value: " + UserData.Register.PASSWORD);
		registerPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", UserData.Register.PASSWORD);
	
		log.info("Register - Step 10: Click to Register button at Register page");
		registerPage.clickToButtonByValue(driver, "Register");

		log.info("Register - Step 11: Verify Success message displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		log.info("Register - Step 12: Click to Continue button at Register page and navigate to Home page");
		registerPage.clickToElement(driver, "//a[text()='Continue']");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC03_Login_To_System() {
		log.info("Login - Step 01: Open Login Link At Home Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Input to Email textbox with value: " + UserData.Register.EMAIL_PREFIX + randomNumber + UserData.Login.EMAIL_POSTFIX);
		loginPage.inputToTextboxByID(driver, "Email", UserData.Register.EMAIL_PREFIX + randomNumber + UserData.Login.EMAIL_POSTFIX);

		log.info("Login - Step 03: Input to Email textbox with value: " + UserData.Login.PASSWORD);
		loginPage.inputToTextboxByID(driver, "Password", UserData.Login.PASSWORD);

		log.info("Login - Step 04: Click to Login button at Login page");
		homePage.clickToButtonByValue(driver, "Log in");

		log.info("Login - Step 05: Verify My Account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	AboutUsPageObject aboutUsPage;
	NewsPageObject newsPage;
	ShoppingCartPageObject shoppingCartPage;
	SiteMapPageObject siteMapPage;

}
