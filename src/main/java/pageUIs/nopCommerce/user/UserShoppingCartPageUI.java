package pageUIs.nopCommerce.user;

public class UserShoppingCartPageUI {

	public static final String SHOPPING_CART_TITLE = "xpath=//div[@class='page-title']/h1[text()='Shopping cart']";
	public static final String DYNAMIC_PRODUCT_NAME = "xpath=//td[@class='product']/a[text()='%s']";
	public static final String DYNAMIC_QUANTITY_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::tr/td[@class='quantity']/input";
	public static final String WISHLIST_LINK = "";
	public static final String DYNAMIC_LABEL_TEXT_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::tr/td[@class='%s']";
	public static final String ATTRIBUTES_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/following-sibling::div[@class='attributes']";
	public static final String REMOVE_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']";
	public static final String TERMS_SERVICE_CHECKBOX = "CSS=div.terms-of-service>input";
	public static final String DYNAMIC_BUTTON = "XPATH=//button[contains(text(),'%s')]";
	public static final String CART_EMPTY_MESSAGE = "css=div.order-summary-content>div";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/following-sibling::div[@class='edit-item']/a";
}
