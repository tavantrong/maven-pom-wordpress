package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level09_Data_Table extends BaseTest{
	WebDriver driver;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}


	public void TC01_Paging() {
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActivebyNumber("15"));
		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageActivebyNumber("20"));
		homePage.openPageByNumber("7");
		Assert.assertTrue(homePage.isPageActivebyNumber("7"));

	}
	
	public void TC02_Search() {
		homePage.inputToHeaderTextboxByLabel("Females", "276880");
		Assert.assertTrue(homePage.areRowRecordDisplay("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderTextboxByLabel("Country", "Angola");
		Assert.assertTrue(homePage.areRowRecordDisplay("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderTextboxByLabel("Males", "276472");
		Assert.assertTrue(homePage.areRowRecordDisplay("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
		
		homePage.inputToHeaderTextboxByLabel("Total", "553353");
		Assert.assertTrue(homePage.areRowRecordDisplay("276880", "Angola", "276472", "553353"));
		
	}
	
	public void TC03_Edit_Remove() {
		//Delete
		homePage.clickToActionIconByContryName("Argentina", "remove");
		homePage.clickToActionIconByContryName("Algeria", "remove");
		
		//Edit
		homePage.refreshPage(driver);
		homePage.clickToActionIconByContryName("Argentina", "edit");
		homePage.refreshPage(driver);
		homePage.clickToActionIconByContryName("Algeria", "edit");
		homePage.refreshPage(driver);
	}
	
	@Test
	public void TC04_Edit_Remove() {
		homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.inputToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Column3Row1");
		homePage.sleepInsecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Company", "2", "Column2Row2");
		homePage.sleepInsecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Order Placed", "3", "Column6Row3");
		homePage.sleepInsecond(2);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private HomePageObject homePage;
}
