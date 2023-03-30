package pageUIs.jQuery;

public class HomePageUI {
	public static final String HOME_PAGE_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String HOME_PAGE_ACTIVE_BY_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL_NAME = "//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_VALUE_ALL_FIELD = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ACTION_ICON_BY_NAME = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String HEADER_NAME_PRECEDING = "//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_AT_COLUMN_AND_ROW_INDEX = "//tr[%s]/td[%s]/input";
	
	public static final String UPLOAD_FILE_TYPE = "//input[@name='files[]']";
	public static final String LOADED_FILE_NAME = "//p[@class='name' and text()='%s']";
	public static final String UPLOADED_FILE_NAME = "//p[@class='name']/a[text()='%s']";
	public static final String START_UPLOAD_BUTTON = "//table//button[contains(@class,'start')]";
			
}
