package pageObject.sauceDemo;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}

}
