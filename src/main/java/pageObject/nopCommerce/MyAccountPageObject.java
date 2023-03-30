package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage{
	WebDriver driver;
	
	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameTextBoxValue() {
		waitForElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
	}

	public String getLastNameTextBoxValue() {
		waitForElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
	}

	public String getEmailTextBoxValue() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX);
	}



	
}
