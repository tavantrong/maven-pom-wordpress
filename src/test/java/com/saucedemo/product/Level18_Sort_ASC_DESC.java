package com.saucedemo.product;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.sauceDemo.PageGeneratorManager;
import pageObject.sauceDemo.ProductPageObject;

public class Level18_Sort_ASC_DESC extends BaseTest{
	WebDriver driver;
	ProductPageObject productPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		productPage = PageGeneratorManager.getProductPage(driver);
		
		productPage.inputToUsernameTextbox("standard_user");
		productPage.inputToPasswordTextbox("secret_sauce");
		productPage.sleepInsecond(2);
		productPage.clickToLoginButton();
	}

	@Test
	public void TC01_Sort_Product_Name() {
		productPage.selectItemInProductSortDropDown("Name (A to Z)");
		productPage.sleepInsecond(3);
		verifyTrue(productPage.areProductNameSortedByAscending());
		
		
		productPage.selectItemInProductSortDropDown("Name (Z to A)");
		productPage.sleepInsecond(3);
		verifyTrue(productPage.areProductNameSortedByDescending());
	}

	@Test
	public void TC02_Sort_Product_Price() {
		productPage.selectItemInProductSortDropDown("Price (low to high)");
		productPage.sleepInsecond(3);
		verifyTrue(productPage.areProductPriceSortedByAscending());
		
		
		productPage.selectItemInProductSortDropDown("Price (high to low)");
		productPage.sleepInsecond(3);
		verifyTrue(productPage.areProductPriceSortedByDescending());
	}
	
		
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
