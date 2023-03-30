package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

public class Level13_Login_Page_Log_Report_HTML extends BaseTest {
	WebDriver driver;

	String emailAddress = "automationkfc" + getRandomNumber() + "@testing.com";
	String passwordText = "123456?Aa";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC01_Register_To_System() {
		log.info("Register - Step 01: Open Register Link at Home Page");
		registerPage = homePage.ClickToRegisterLink();

		log.info("Register - Step 02: Input to FirstName with value");
		registerPage.enterToFirstNameTextbox("Phong");

		log.info("Register - Step 03: Input to LastName with value");
		registerPage.enterToLastNameTextbox("Trần");

		log.info("Register - Step 04: Input to Email Textbox with value: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);

		log.info("Register - Step 05: Input to Password Textbox with value: " + passwordText);
		registerPage.enterToPasswordTextbox(passwordText);
		registerPage.enterToConfirmPasswordTextbox(passwordText);

		log.info("Register - Step 06: Click to Register button at Register page");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 07: Verify Success message displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		log.info("Register - Step 08: Verify Failed message displayed");
		verifyFalse(registerPage.isSuccessMessageDisplayed());
		verifyEquals(registerPage.isSuccessMessageDisplayed(), "");

		log.info("Register - Step 09: Click to Continue button at Register page and navigate to Home page");
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void TC02_Login_To_System() {
		log.info("Login - Step 01: Open Login Link At Home Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Input to Email textbox with value: " + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);

		log.info("Login - Step 03: Input to Email textbox with value: " + passwordText);
		loginPage.enterToPasswordTextbox(passwordText);

		log.info("Login - Step 04: Click to Login button at Login page");
		homePage = loginPage.clickToLoginButton();

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
