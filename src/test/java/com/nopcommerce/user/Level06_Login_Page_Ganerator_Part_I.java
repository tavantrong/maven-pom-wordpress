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
import pageObject.nopCommerce.RegisterPageObject;

public class Level06_Login_Page_Ganerator_Part_I extends BaseTest{
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
		
		// (1) - Màn hình đầu tiên khi mở app (HomePage)
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC01_Register_To_System() {
		homePage.ClickToRegisterLink();
		// (2) - Chuyển sang Register page
		registerPage = new RegisterPageObject(driver);
		
		registerPage.enterToFirstNameTextbox("Phong");
		registerPage.enterToLastNameTextbox("Trần");
		
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(passwordTextbox);
		registerPage.enterToConfirmPasswordTextbox(passwordTextbox);
		registerPage.clickToRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());;
		registerPage.clickToContinueButton();
		
		//(3) - Về Home
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC02_Login_To_System() {
		homePage.clickToLoginLink();
		
		//(4) - Qua Login Page
		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(passwordTextbox);
		loginPage.clickToLoginButton();
		
		//(5) - Về Home
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	
	@Test
	public void TC03_MyAccount_Info() {
		homePage.clickToMyAccountLink();
		
		//(6) - Qua MyAccount Page
		myAccountPage = new MyAccountPageObject(driver);
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
