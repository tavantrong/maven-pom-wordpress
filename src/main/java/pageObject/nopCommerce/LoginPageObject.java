package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
		WebDriver driver;
		//PageGeneratorManager pageGenerator;
		
		public LoginPageObject (WebDriver driver) {
			this.driver = driver;
			//pageGenerator = PageGeneratorManager.getPageGenerator();
		}


		public void enterToEmailTextbox(String emailTextbox) {
			waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
			sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailTextbox);
			
		}

		public void enterToPasswordTextbox(String password) {
			waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
			sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
			
		}

		public HomePageObject clickToLoginButton() {
			waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
			clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
			return PageGeneratorManager.getHomePage(driver);
			
		}
	}

