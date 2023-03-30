package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	//PageGeneratorManager pageGenerator;
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
		//pageGenerator = PageGeneratorManager.getPageGenerator();
	}
	
	@Step("Click to Register link at Home page")
	public RegisterPageObject ClickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINKTEXT);
		clickToElement(driver, HomePageUI.REGISTER_LINKTEXT);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	@Step("Verify My Account link displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINKTEXT);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINKTEXT);
	}

	@Step("Click to Login link at Home page")
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINKTEXT);
		clickToElement(driver, HomePageUI.LOGIN_LINKTEXT);
		return PageGeneratorManager.getLoginPage(driver);
	}

	@Step("Click to My Account link at Home page")
	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINKTEXT);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINKTEXT);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	@Step("Verify Register link undisplayed")
	public void isRegisterLinkUndisplayed() {
		waitForElementInvisible(driver, HomePageUI.REGISTER_LINKTEXT);
		isElementUndisplayed(driver, HomePageUI.REGISTER_LINKTEXT);
	}

	@Step("Verify Login link undisplayed")
	public void isLoginLinkUndisplayed() {
		waitForElementInvisible(driver, HomePageUI.LOGIN_LINKTEXT);
		isElementUndisplayed(driver, HomePageUI.LOGIN_LINKTEXT);	
	}

	@Step("Verify Shopping Cart No Item Tooltop undisplayed")
	public void isShoppingCartNoItemTooltopUndisplayed() {
		waitForElementInvisible(driver, HomePageUI.SHOPPING_CART_NOITEM_TOOLTIP);
		isElementUndisplayed(driver, HomePageUI.SHOPPING_CART_NOITEM_TOOLTIP);
		
	}
}
