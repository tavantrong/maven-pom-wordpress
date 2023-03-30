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

public class Level08_Login_Page_Dynamic_Locator extends BaseTest{
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
	public void TC04_Dynamic_Page_Locator() {
		// 18 page = 18 hàm mở page - ép kiểu tường minh
		//siteMapPage = myAccountPage.clickToSiteMapLink(driver);
		siteMapPage = (SiteMapPageObject) myAccountPage.openFooterPageByName(driver, "Sitemap");
		
		newsPage = (NewsPageObject) siteMapPage.openFooterPageByName(driver, "News");
		
		shoppingCartPage = (ShoppingCartPageObject) newsPage.openFooterPageByName(driver, "Shopping cart");
		
		aboutUsPage = (AboutUsPageObject) shoppingCartPage.openFooterPageByName(driver, "About us");
		
		homePage = aboutUsPage.clickToHomePageLink(driver);
		
		newsPage = (NewsPageObject) homePage.openFooterPageByName(driver, "News");
		siteMapPage = (SiteMapPageObject) newsPage.openFooterPageByName(driver, "Sitemap");
		shoppingCartPage = (ShoppingCartPageObject) siteMapPage.openFooterPageByName(driver, "Shopping cart");
		
		homePage = shoppingCartPage.clickToHomePageLink(driver);
	}
	
	@Test
	public void TC04_Dynamic_Page_Locator_II() {
		myAccountPage.openFooterPageByName(driver, "Sitemap");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);
		
		siteMapPage.openFooterPageByName(driver, "News");
		newsPage = PageGeneratorManager.getNewsPage(driver);
		
		newsPage.openFooterPageByName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		shoppingCartPage.openFooterPageByName(driver, "About us");
		aboutUsPage = PageGeneratorManager.getAboutUsPage(driver);
		
		//Home link: KO phải là dynamic locator nên dùng cách thường
		homePage = aboutUsPage.clickToHomePageLink(driver);
		

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
