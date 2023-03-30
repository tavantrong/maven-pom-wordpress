package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level02_Login_BasePage_03 extends BasePage {
	WebDriver driver;
	String projectLocator = System.getProperty("user.dir");

	String usernameTextbox = "//input[@id='usernameOrEmail']";
	String passwordTextbox = "//input[@id='password']";
	String continueButton = "//button[text()='Continue']";
	String loginButton = "//button[text()='Log In']";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocator + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@BeforeMethod // Lặp lại bước này cho all testcase
	public void beforeMethod() {
		openUrl(driver, "https://wordpress.com/log-in");
	}

	@Test
	public void TC01_Empty_Email_Username() {
		//Buộc sử dụng Xpath
		sendkeyToElement(driver, usernameTextbox, "");
		clickToElement(driver, continueButton);
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Please enter a username or email address.']"))
				.isDisplayed());
	}

	@Test
	public void TC02_Invalid_Email() {
		sendkeyToElement(driver, usernameTextbox, "automation" + getRandomNumber() + "@aaaa");
		clickToElement(driver, continueButton);
		sleepInSecond(2);

		// Cách 1: Element nested text lồng nhiều phần khác nhau
		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//span[contains(string(),'User does not exist. Would you like to create a new account?')]"))
				.isDisplayed());
		// Cách 2: Gộp lại .getText() - Cắt khoảng trống đầu và cuối .trim()
		String userNotExitsMessage = driver.findElement(By.xpath("//div[@class='form-input-validation is-error']"))
				.getText().trim();
		Assert.assertEquals(userNotExitsMessage, "User does not exist. Would you like to create a new account?");

	}

	@Test
	public void TC03_Username_Not_Exits() {
		sendkeyToElement(driver, usernameTextbox, "automationkfc" + getRandomNumber() + "@gmail.com");
		clickToElement(driver, continueButton);
		sleepInSecond(2);
		
		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//span[contains(string(),'User does not exist. Would you like to create a new account?')]"))
				.isDisplayed());
	}

	@Test
	public void TC04_Empty_Password() {
		sendkeyToElement(driver, usernameTextbox, "automationtvt@gmail.com");
		clickToElement(driver, continueButton);
		sleepInSecond(2);
		clickToElement(driver, loginButton);
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Don't forget to enter your password.\"]")).isDisplayed());

	}

	@Test
	public void TC05_Invalid_Password() {
		sendkeyToElement(driver, usernameTextbox, "automationtvt@gmail.com");
		clickToElement(driver, continueButton);
		sleepInSecond(2);
		sendkeyToElement(driver, passwordTextbox, "123");
		clickToElement(driver, loginButton);
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]")).isDisplayed());

	}


	@Test
	public void TC06_Valid_Email_Password() {
		sendkeyToElement(driver, usernameTextbox, "automationtvt@gmail.com");
		clickToElement(driver, continueButton);
		sleepInSecond(2);
		sendkeyToElement(driver, passwordTextbox, "123456?Aa");
		clickToElement(driver, loginButton);
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Chào mừng tới Đọc']")).isDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
