package pageUIs.nopCommerce.user;

public class UserWishlistPageUI {

	public static final String DYNAMIC_PRODUCT_NAME = "XPATH=//a[@class='product-name' and text()='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td/preceding-sibling::td[@class='add-to-cart']/input[@type='checkbox']";
	public static final String DYNAMIC_QUANTITY_BY_PRODUCT_NAME = "xpath=//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td[@class='quantity']/input";
	public static final String SHARING_LINK = "CSS=a.share-link";
	public static final String DYNAMIC_BUTTON = "xpath=//button[@type='submit' and text()='%s']";
	public static final String TITLE_AFTER_CLICK_SHARING_LINK = "xpath=//div[@class='page-title']/h1";
	public static final String REMOVE_BUTTON_BY_PRODUCT_NAME = "XPATH=//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
	public static final String WISHLIST_EMPTY_TEXT = "xpath=//div[contains(@class,'wishlist-page')]/div[@class='page-body']";
	public static final String DYNAMIC_QUANTITY_BY_PRODUCT_NAME_AFTER_SHARING_LINK = "XPATH=//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td[@class='quantity']/span";

}
