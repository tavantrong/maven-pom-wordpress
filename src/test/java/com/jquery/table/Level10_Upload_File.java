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

public class Level10_Upload_File extends BaseTest{
	WebDriver driver;
		
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	@Test
	public void TC01_Upload_One_File_Per_Time() {
		String[] fileName = {"building.jpg"};
		
		homePage.uploadMultipleFiles(driver, fileName);
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileName));
		
		homePage.clickToStartUploadButton();
		Assert.assertTrue(homePage.areFileUploadSuccess(fileName));
	}
	
	@Test
	public void TC02_Upload_MultiPle_File_Per_Time() {
		homePage.refreshPage(driver);
		String[] fileNames = {"building.jpg", "church.jpg", "landscape.jpg"};
		
		homePage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));
		
		homePage.clickToStartUploadButton();
		Assert.assertTrue(homePage.areFileUploadSuccess(fileNames));
	}
		

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private HomePageObject homePage;
}
