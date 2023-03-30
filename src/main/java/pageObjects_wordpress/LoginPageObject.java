package pageObjects_wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.LoginPageUI;

public class LoginPageObject extends BasePage {
	// Biến trung gian chỉ class này mới sử dụng
	// Hứng lấy driver máp từ Class Testcase qua
	WebDriver driver;
	
	// Hàm khởi tạo
	// Trùng tên vs Class
	// Không có kiểu trả về
	// Sẽ được chạy đầu tiên khi khởi tạo class lên
	// Nếu ko viết rõ hàm khởi tạo thì:
	// - Trong quá trình chạy JVM auto tạo 1 hàm khởi tạo ko tham số 
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	// Trong 1 class có teh63 có 1 or nhiều hàm khởi tạo nhưng:
	 // - Phải khác kiểu dữ liệu (cùng số lượng tham số)
	 // - Cùng kiểu dữ liệu thì phải khác số lượng tham số
	public LoginPageObject (WebDriver driver, String string) {
		
	}
	
	public LoginPageObject (String locator) {
	
	}

	public void inputToUsernameTextbox(String usernameOrEmail) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX, usernameOrEmail);
		
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
		
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
		return getTextElement(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public boolean isEmptyPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
	}

	public boolean isInvalidPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
	}

	// action / Object:
	// Input to Username / Email
	// Click to Continue button
	// Input to password
	// Get error message
	// Check display
}
