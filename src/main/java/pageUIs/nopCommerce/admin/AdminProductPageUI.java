package pageUIs.nopCommerce.admin;

public class AdminProductPageUI {

	public static final String PRODUCT_NAME_TEXTBOX = "css=input[id='SearchProductName']";
	public static final String SEARCH_BUTTON = "XPATH=//button[@id='search-products']";
	public static final String QUANTITY_PRODUCT_IN_TABLE = "XPATH=//tbody/tr";
	public static final String CATEGORY_DROPDOWN = "css=select[id='SearchCategoryId']";
	public static final String SEARCH_SUB_CATEGORIES_CHECKBOX = "css=input[id='SearchIncludeSubCategories']";
	public static final String EMPTY_DATA_MESSAGE = "xpath=//td[@class='dataTables_empty']";
	public static final String MANUFACTURER_DROPDOWN = "xpath=//select[@id='SearchManufacturerId']";
	public static final String GO_DIRECTLY_TO_PRODUCT_TEXTBOX = "xpath=//input[@id='GoDirectlyToSku']";
	public static final String GO_BUTTON = "xpath=//button[@id='go-to-product-by-sku']";
	public static final String PRODUCT_INFO_BLOCK_IN_EDIT_PRODUCT_SCREEN = "xpath=//div[@data-card-name='product-info']//div[@class='card-title']";
	public static final String PRODUCT_NAME_IN_EDIT_PRODUCT_SCREEN = "xpath=//input[@id='Name' and @value='%s']";
	public static final String SKU_IN_EDIT_PRODUCT_SCREEN = "xpath=//input[@id='Sku' and @value='%s']";
	public static final String DYNAMIC_PRECEDING_SIBLING_BY_LABEL_NAME = "XPATH=//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_VALUE_BY_INDEX_ROW_AND_INDEX_COLUMN = "xpath=//tbody//tr[%s]/td[%s]";

}
