package pageUIs.nopCommerce.user;

public class BasePageUI {
	
	public static final String USER_ORDERS_MENU = "xpath=//li[contains(@class,'customer-orders')]/a";
	public static final String USER_ADDRESSES_MENU = "xpath=//li[contains(@class,'customer-addresses')]/a";
	public static final String USER_CUSTOMER_INFO_MENU = "xpath=//li[contains(@class,'customer-info')]/a";
	public static final String USER_LOGOUT_LINK = "xpath=//a[text()='Log out']";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
	public static final String USER_DYNAMIC_PAGE_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'%s')]//a[text()='%s']";
	public static final String USER_DYNAMIC_PAGE_HEADER = "xpath=//div[@class='page-title']/h1[text()='%s']";
	public static final String USER_DYNAMIC_PAGE_FOOTER = "xpath=//div[@class='footer-upper']//a[text()='%s']";
	public static final String CLOSE_BUTTON = "xpath=//span[@class='close']";
	public static final String DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE = "xpath=//div[@id='bar-notification']//p";
	public static final String USER_SEARCH_LINK = "xpath=//div[@class='footer']//a[text()='Search']";
	public static final String WISHLIST_LINK = "xpath=//div[@class='header-links-wrapper']//a[@class='ico-wishlist']"; 
	public static final String UPLOAD_LINK = "xpath=//input[@type='file']";
	public static final String SHOPPING_CART_ICON = "css=a.ico-cart";
	public static final String PRODUCT_NUMBER_IN_SHOPPING_CART_ICON = "CSS=div.mini-shopping-cart>div.count";
	public static final String PRODUCT_NAME_IN_SHOPPING_CART_ICON = "xpath=//div[@class='name']/a[text()='%s']";
	public static final String DYNAMIC_FIELD_BY_PRODUCT_NAME_IN_SHOPPING_CART_ICON ="xpath=//a[text()='%s']/parent::div/following-sibling::div[@class='%s']";
	public static final String SUB_TOTAL_IN_SHOPPING_CART_ICON = "xpath=//div[@class='totals']";
	public static final String GO_TO_CART_BUTTON_IN_SHOPPING_CART_ICON = "xpath=//button[@type='button' and text()='Go to cart']";
	public static final String TITLE_PAGE_AT_ADMIN = "xpath=//div[contains(@class,'content-header')]/h1[contains(text(),'%s')]";
	public static final String ADMIN_DYNAMIC_MENU = "xpath=//li[contains(@class,'nav-item has-treeview')]/a/p[contains(text(),'%s')]";
	public static final String ADMIN_DYNAMIC_SUBMENU = "xpath=//li[contains(@class,'menu-open')]/ul//p[contains(text(),'%s')]"; 
	public static final String LOADING_ICON = "XPATH=//div[@id='ajaxBusy']/span";
	public static final String BANK_GURU_DYNAMIC_MENU_BY_NAME = "XPATH=//a[text()='%s']";
	public static final String BANK_GURU_CLOSE_ADVERTISE_POPUP = "xpath=//div[@id='dismiss-button']/div/svg";
	public static final String BANK_GURU_DYNAMIC_BUTTON_BY_ATTRIBUTE_VALUE = "xpath=//input[@value='%s']";
	public static final String DYNAMIC_TITLE_BY_CONTENT_TITLE = "XPATH=//p[@class='heading3' and text()='%s']";

}
