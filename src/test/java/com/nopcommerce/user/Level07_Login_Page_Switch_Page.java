package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Level07_Login_Page_Switch_Page extends BaseTest{
	WebDriver driver;
	
	
	
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
	
	@Test
	public void TC04_Switch_Page_Object() {
		// Dùng cho 2 hay nhiều page có tính chất 2 chiều: Common page (TC trước ko có tính chất 2 chiều)
		// Common Page (bỏ tất cả các hàm chuyển Page vào BasePage)
		// Chuyển tất cả UI dùng chung vào 1 fake BasePageUI
		
		// (7) myAccount page --> Site map
		siteMapPage = myAccountPage.clickToSiteMapLink(driver);
		
		// (8) Site map --> News
		newsPage = siteMapPage.clickToNewsLink(driver);
		
		// (9) News --> Shopping cart
		shoppingCartPage = newsPage.clickToShoppingCartLink(driver);
		
		// (10) Shopping cart --> About Us
		aboutUsPage = shoppingCartPage.clickToAboutUsLink(driver);
		
		// (11) About us --> Home Page
		homePage = aboutUsPage.clickToHomePageLink(driver);
		
		//Khai báo hàm vs UI vào Class chung - Gọi ra theo tuần tự
		newsPage = homePage.clickToNewsLink(driver);
		siteMapPage = newsPage.clickToSiteMapLink(driver);
		shoppingCartPage = siteMapPage.clickToShoppingCartLink(driver);
		homePage = shoppingCartPage.clickToHomePageLink(driver);
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
