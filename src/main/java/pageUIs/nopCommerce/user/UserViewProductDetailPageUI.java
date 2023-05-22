package pageUIs.nopCommerce.user;

public class UserViewProductDetailPageUI {
	
	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//div[@class='product-review-links']/a[text()='Add your review']";
	public static final String DYNAMIC_PRODUCT_NAME_TITLE = "xpath=//div[@class='product-name']/h1[text()='%s']";
	public static final String DYNAMIC_OVERVIEW_BUTTON = "XPATH=//div[@class='overview-buttons']//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN = "XPATH=//dd[%s]/select";
	public static final String DYNAMIC_PRECEDING_SIBLING_OF_LABEL_TEXT_IN_DROPDOWN_RADIO_BUTTON = "XPATH=//label[contains(text(),'%s')]/parent::dt/preceding-sibling::dt";
	public static final String DYNAMIC_CHECKBOX_RADIO_BUTTON_BY_LABEL_NAME = "XPATH=//dd[%s]//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_BUTTON = "xpath=//button[@type='button' and text()='%s']";
	public static final String PRODUCT_PRICE = "css=div.product-price>span";
	public static final String QUANTITY_TEXTBOX = "CSS=input.qty-input";
	public static final String DYNAMIC_LABEL_NAME = "xpath=//label[contains(text(),'%s')]";

}
