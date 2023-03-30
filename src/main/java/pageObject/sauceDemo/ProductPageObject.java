package pageObject.sauceDemo;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauceDemo.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropDown(String valueItem) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN);
		selectItemInDropdown(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN, valueItem);
	}

	public boolean areProductNameSortedByAscending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedAscending(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductNameSortedByDescending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedDescending(driver, ProductPageUI.ALL_PRODUCT_NAME);
	}

	public void inputToUsernameTextbox(String userName) {
		waitForElementVisible(driver, ProductPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.USERNAME_TEXTBOX, userName);
		}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, ProductPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, ProductPageUI.LOGIN_BUTTON);
		clickToElement(driver, ProductPageUI.LOGIN_BUTTON);
	}

	public boolean areProductPriceSortedByAscending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatSortedAscending(driver, ProductPageUI.ALL_PRODUCT_PRICE);
	}

	public boolean areProductPriceSortedByDescending() {
		waitForListElementVisible(driver, ProductPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatSortedDescending(driver, ProductPageUI.ALL_PRODUCT_PRICE);
	}

	

	

}
