package pageObjectFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".ico-register")
	private WebElement registerLink;
	
	@FindBy(css = ".ico-login")
	private WebElement loginLink;
	
	@FindBy(css = ".ico-account")
	@CacheLookup //Lưu vào cache lần sau ko cần phải tìm lại nữa
	private WebElement myAccountLink;
	
	
	public void ClickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);		
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);	
	}
}
