package pageObject.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.HOME_PAGE_NUMBER, pageNumber);

	}

	public boolean isPageActivebyNumber(String pageName) {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageName);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageName);
	}

	public void inputToHeaderTextboxByLabel(String labelName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, labelName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, value, labelName);
		pressKeyboardToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.ENTER, labelName);
	}

	public boolean areRowRecordDisplay(String females, String country, String males, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_ALL_FIELD, females, country, males, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_ALL_FIELD, females, country, males, total);
	}

	public void clickToActionIconByContryName(String countryName, String actionName) {
		waitForElementClickable(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionName);

	}

	public void inputToTextboxByColumnNameAtRowNumber(String columnName, String rowIndex, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName);
		// X - Column index
		int columnIndex = getElementNumber(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName) + 1;
		// Y - Row index
		sendkeyToElement(driver, HomePageUI.TEXTBOX_AT_COLUMN_AND_ROW_INDEX, value, rowIndex,
				String.valueOf(columnIndex));
	}

	public boolean areFilenameLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String file : fileNames) {
			if (isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, file)) {
				status = true;
			} else {
				return status;
			}
		}
		return status;
	}

	public boolean areFileUploadSuccess(String[] fileNames) {
		boolean status = false;
		for (String file : fileNames) {
			if (isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME, file)) {
				status = true;
			} else {
				return status;
			}
		}
		return status;
	}

	public void clickToStartUploadButton() {
		List<WebElement> uploadButtons = getListWebElement(driver, HomePageUI.START_UPLOAD_BUTTON);
		for (WebElement uploadBtn : uploadButtons) {
			uploadBtn.click();
			sleepInsecond(2);
		}

	}

}
