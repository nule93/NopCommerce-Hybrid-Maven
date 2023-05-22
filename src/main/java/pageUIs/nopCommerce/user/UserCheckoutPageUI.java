package pageUIs.nopCommerce.user;

public class UserCheckoutPageUI {

	public static final String DYNAMIC_BUTTON_BY_BLOCK_NAME = "XPATH=//h2[text()='%s']/parent::div/following-sibling::div//button[text()='%s']";
	public static final String DYNAMIC_TOTAL_INFO = "xpath=//tr[@class='%s']//span[@class='value-summary']";
    public static final String DYNAMIC_TEXTBOX_BY_LABEL_NAME= "xpath=//label[contains(text(),'%s')]/parent::div/input";
	public static final String DYNAMIC_DROPDOWN_BY_LABEL_NAME = "xpath=//label[contains(text(),'%s')]/following-sibling::select";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME = "XPATH=//ul[@class='method-list']//label[text()='%s']/preceding-sibling::input";
	public static final String PAYMENT_INFORMATION_TEXT = "XPATH=//div[@class='section payment-info']";
	public static final String DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME = "XPATH=//div[@class='billing-info']/ul[@class='info-list']/li[@class='%s']";
	public static final String DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME = "XPATH=//div[@class='shipping-info']/ul[@class='info-list']/li[@class='%s']";
	public static final String DYNAMIC_TITLE_AT_CONFIRM_ORDER = "xpath=//strong[text()='%s']";
	public static final String SHIPPING_METHOD_TEXT = "xpath=//div[@class='shipping-method-info']//li[@class='shipping-method']";
	public static final String PAYMENT_METHOD_TEXT = "xpath=//div[@class='payment-method-info']//li[@class='payment-method']";
	public static final String DYNAMIC_INFO_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::td[@class='product']/parent::tr/td[@class='%s']/span";
	public static final String DYNAMIC_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td[@class='product']/a";
	public static final String SELECTED_CHECKOUT_ATTRIBUTES = "xpath=//div[@class='cart-options']/div[@class='selected-checkout-attributes']";
	public static final String SUCCESS_CREATED_ORDER_MESSAGE = "xpath=//div[@class='section order-completed']//div[@class='title']";
	public static final String THANK_YOU_PAGE_TITLE = "xpath=//div[contains(@class,'order-completed-page')]//h1";
	public static final String ORDER_NUMBER = "xpath=//div[@class='section order-completed']//div[@class='order-number']/strong";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_ID_AT_CARD_INFO = "XPATH=//select[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID_AT_CARD_INFO = "XPATH=//input[@id='%s']";
}
