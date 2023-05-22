package pageUIs.nopCommerce.user;

public class UserComparisonPageUI {

	public static final String DYNAMIC_PRODUCT_NAME = "xpath=//table[@class='compare-products-table']//tr[@class='product-name']//a[text()='%s']";
	public static final String CLEAR_LIST_BUTTON = "css=a.clear-list";
	public static final String DYNAMIC_INDEX_BY_PRODUCT_NAME = "XPATH=//tr[@class='product-name']//a[text()='%s']/parent::td/preceding-sibling::td";
	public static final String DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME = "XPATH=//tr[@class='product-price']/td[%s]";
	public static final String DYNAMIC_REMOVE_BUTTON = "XPATH=//tr[@class='remove-product']/td[%s]";
	public static final String DELETED_ALL_PRODUCTS_TEXT = "XPATH=//div[contains(@class,'compare-products-page')]/div[@class='page-body']";
}
