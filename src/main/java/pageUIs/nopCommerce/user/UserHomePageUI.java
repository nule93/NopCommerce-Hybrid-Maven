package pageUIs.nopCommerce.user;

public class UserHomePageUI {

	public static final String REGISTER_LINK = "class=ico-register";
	public static final String LOGIN_LINK = "class=ico-login";
	public static final String MY_ACCOUNT_LINK = "class=ico-account";
	public static final String PRODUCT_NAME_DYNAMIC_LINK = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String CATEGORY_DYNAMIC_LINK = "XPATH=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String SUB_MENU_DYNAMIC_LINK = "XPATH=//ul[@class='sublist first-level']//a[contains(text(),'%s')]";
	public static final String SORT_BY_DROPDOWNLIST = "xpath=//div[@class='product-sorting']/select[@id='products-orderby']";
	public static final String PRODUCT_NAME_LIST = "XPATH=//h2[@class='product-title']/a";
	public static final String PRODUC_PRICE_LIST = "xpath=//div[@class='prices']/span";
	public static final String AJAX_LOADING = "XPATH=//div[@class='ajax-products-busy' and @style='display: none;']";
	public static final String USER_PER_PAGE_DROPDOWNLIST = "xpath=//div[@class='product-page-size']/select[@id='products-pagesize']";
	public static final String PER_PAGE = "XPATH=//div[@class='pager']";
	public static final String NEXT_PAGE_BUTTON = "XPATH=//li[@class='next-page']/a";
	public static final String PREVIOUS_PAGE_BUTTON = "XPATH=//li[@class='previous-page']/a";
	public static final String COMPARE_LINK = "xpath=//a[text()='product comparison']";
	public static final String DYNAMIC_BUTTON_BY_PRODUCT_NAME = "XPATH=//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[text()='%s']";
}
