package pageUIs.nopCommerce;

public class BasePageUI {
	// Không có tham số - truyền cố định
	public static final String HOME_PAGE_IMG = "//img[@alt='nopCommerce demo store']";
	public static final String SHOPPING_CART_LINK = "//div[@class='footer']//a[text()='Shopping cart']";
	public static final String ABOUT_US_PAGE_LINK = "//div[@class='footer']//a[text()='About us']";
	public static final String NEWS_PAGE_LINK = "//div[@class='footer']//a[text()='News']";
	public static final String SITE_MAP_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	
	
	// Có 1 tham số - Dynamic Page name
	public static final String FOOTER_PAGE_LINK_NAME = "//div[@class='footer']//a[text()='%s']";
	
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "//span[@class='field-validation-error']//span[@id='%s-error']";

}
