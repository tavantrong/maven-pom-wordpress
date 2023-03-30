package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_02_Cookie;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;

public class Level15_Login_Share_State_Part_II_Cookie extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
			
		log.info("Login - Step 01: Get Cookie From Share State Class");

		for (Cookie cookie : Common_02_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		driver.navigate().refresh();

		log.info("Login - Step 02: Verify My Account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC01_Get_Cookie() {
		
		homePage.sleepInsecond(3);

	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	
}
