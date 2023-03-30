package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;

public class Level15_Login_Share_State_Part_I_Search extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Login - Step 01: Open Login Link At Home Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Input to Email textbox with value: " + Common_01_Register.emailAddress);
		loginPage.enterToEmailTextbox(Common_01_Register.emailAddress);

		log.info("Login - Step 03: Input to Email textbox with value: " + Common_01_Register.passwordTextbox);
		loginPage.enterToPasswordTextbox(Common_01_Register.passwordTextbox);

		log.info("Login - Step 04: Click to Login button at Login page");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify My Account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		homePage.sleepInsecond(1);
	}

	@Test
	public void TC01_Search() {
		homePage.sendkeyToElement(driver, "//input[@id='small-searchterms']", "SearchFunction");
		homePage.clickToElement(driver, "//button[@class='button-1 search-box-button']");
		
		homePage.sleepInsecond(2);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;

}
