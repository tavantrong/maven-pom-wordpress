package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.MyAccountPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;

public class Level06_Login_Page_Ganerator_Part_III extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	
	
	
	String emailAddress = "automationkfc" + getRandomNumber() + "@testing.com";
	String passwordTextbox = "123456?Aa";
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		// Che dấu all new instances
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC01_Register_To_System() {

		registerPage = homePage.ClickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("Phong");
		registerPage.enterToLastNameTextbox("Trần");
		
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(passwordTextbox);
		registerPage.enterToConfirmPasswordTextbox(passwordTextbox);
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());;
		
		
		//(3) - Về Home
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC02_Login_To_System() {
		
		
		//(4) - Qua Login Page
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(passwordTextbox);
		
		
		//(5) - Về Home
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	
	@Test
	public void TC03_MyAccount_Info() {
		
		
		//(6) - Qua MyAccount Page
		myAccountPage = homePage.clickToMyAccountLink();
		myAccountPage.sleepInsecond(2);
		Assert.assertEquals(myAccountPage.getFirstNameTextBoxValue(), "Phong");
		Assert.assertEquals(myAccountPage.getLastNameTextBoxValue(), "Trần");
		Assert.assertEquals(myAccountPage.getEmailTextBoxValue(), emailAddress);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
