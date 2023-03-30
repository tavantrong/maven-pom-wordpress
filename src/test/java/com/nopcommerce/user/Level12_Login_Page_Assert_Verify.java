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

public class Level12_Login_Page_Assert_Verify extends BaseTest{
	WebDriver driver;
	
	
	
	String emailAddress = "automationkfc" + getRandomNumber() + "@testing.com";
	String passwordTextbox = "123456?Aa";
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC01_Verify_Failed_Register_To_System() {

		registerPage = homePage.ClickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("Phong");
		registerPage.enterToLastNameTextbox("Trần");
		
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(passwordTextbox);
		registerPage.enterToConfirmPasswordTextbox(passwordTextbox);
		registerPage.clickToRegisterButton();
		
		verifyTrue(registerPage.isSuccessMessageDisplayed());;
		// Failed - Skip và chạy tiếp
		verifyFalse(registerPage.isSuccessMessageDisplayed());
		verifyEquals(registerPage.isSuccessMessageDisplayed(), "");
		
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC02_Verify_Passed_Login_To_System() {
				
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(passwordTextbox);
		//Passed
		homePage = loginPage.clickToLoginButton();
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
