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

public class Level01_Login_Repeat_Yourself {
	WebDriver driver;
	String projectLocator = System.getProperty("user.dir");

	By usernameTextboxBy = By.xpath("//input[@id='usernameOrEmail']");
	By passwordTextboxBy = By.xpath("//input[@id='password']");
	By continueButton = By.xpath("//button[text()='Continue']");
	By loginButtonBy = By.xpath("//button[text()='Log In']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocator + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@BeforeMethod // Lặp lại bước này cho all testcase
	public void beforeMethod() {
		driver.get("https://wordpress.com/log-in");
	}

	@Test
	public void TC01_Empty_Email_Username() {
		driver.findElement(usernameTextboxBy).sendKeys("");
		driver.findElement(continueButton).click();
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Please enter a username or email address.']"))
				.isDisplayed());
	}

	@Test
	public void TC02_Invalid_Email() {
		driver.findElement(usernameTextboxBy).sendKeys("automation" + getRandomNumber() + "@aaaa");
		driver.findElement(continueButton).click();
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
		driver.findElement(usernameTextboxBy).sendKeys("automationkfc" + getRandomNumber() + "@gmail.com");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		
		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//span[contains(string(),'User does not exist. Would you like to create a new account?')]"))
				.isDisplayed());
	}

	@Test
	public void TC04_Empty_Password() {
		driver.findElement(usernameTextboxBy).sendKeys("automationtvt@gmail.com");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		driver.findElement(loginButtonBy).click();
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Don't forget to enter your password.\"]")).isDisplayed());

	}

	@Test
	public void TC05_Invalid_Password() {
		driver.findElement(usernameTextboxBy).sendKeys("automationtvt@gmail.com");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		driver.findElement(passwordTextboxBy).sendKeys("123");
		driver.findElement(loginButtonBy).click();
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]")).isDisplayed());

	}


	@Test
	public void TC06_Valid_Email_Password() {
		driver.findElement(usernameTextboxBy).sendKeys("automationtvt@gmail.com");
		driver.findElement(continueButton).click();
		sleepInSecond(2);
		driver.findElement(passwordTextboxBy).sendKeys("123456?Aa");
		driver.findElement(loginButtonBy).click();
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
