package pageObjectFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	public RegisterPageObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstnameTextbox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastnameTextbox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//a[@class='button-1 register-continue-button']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
	private WebElement registeredSuccessMessage;

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstnameTextbox);
		sendkeyToElement(driver, firstnameTextbox, firstName);		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastnameTextbox);
		sendkeyToElement(driver, lastnameTextbox, lastName);
		
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);	
	}

	public void enterToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, password);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);	
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, registeredSuccessMessage);
		return isElementDisplayed(driver, registeredSuccessMessage);	
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);		
	}

	
}
