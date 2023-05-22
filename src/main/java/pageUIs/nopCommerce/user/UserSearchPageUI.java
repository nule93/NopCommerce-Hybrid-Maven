package pageUIs.nopCommerce.user;

public class UserSearchPageUI {

	public static final String PRODUCT_NAME_TEXT = "XPATH=//div[@class='products-wrapper']//h2[@class='product-title']/a";
	public static final String USER_SEARCH_BUTTON = "xpath=//div[@class='search-input']//button[text()='Search']";
	public static final String ERROR_MESSAGE = "xpath=//div[@class='products-wrapper']/div";
	public static final String USER_SEARCH_KEYWORDS_TEXTBOX = "xpath=//label[contains(text(),'Search keyword')]/following-sibling::input";
	public static final String USER_ADVANCED_SEARCH_CHECKBOX = "xpath=//label[contains(text(),'Advanced search')]/preceding-sibling::input";
	public static final String USER_SELECT_CATEGORY_DROPDOWNLIST = "xpath=//label[contains(text(),'Category')]/following-sibling::select";
	public static final String USER_AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX = "xpath=//label[contains(text(),'Automatically search sub categories')]/preceding-sibling::input";
	public static final String USER_SELECT_MANUFACTURER_DROPDOWNLIST = "xpath=//label[contains(text(),'Manufacturer')]/following-sibling::select";

}
