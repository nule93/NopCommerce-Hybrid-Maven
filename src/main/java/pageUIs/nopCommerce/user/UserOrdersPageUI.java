package pageUIs.nopCommerce.user;

public class UserOrdersPageUI {

	public static final String ORDERS_HEADER = "xpath=//div[@class='page-title']/h1[text()='My account - Orders']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-list']//div[@class='title']/strong";
	public static final String DETAILS_ORDER_BUTTON = "xpath=//strong[contains(text(),'%s')]/parent::div/following-sibling::div[@class='buttons']/button[text()='Details']";
	public static final String RE_ORDER_BUTTON = "XPATH=//div[@class='actions']/button[text()='Re-order']";
	public static final String ORDER_NUMBER_AT_ORDER_INFO = "XPATH=//div[@class='order-number']/strong";
	public static final String DYNAMIC_ORDER_OVERVIEW_BY_TEXT_LABEL = "XPATH=//ul[@class='order-overview-content']/li[@class='%s']";
	public static final String DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME = "XPATH=//div[@class='shipping-info']/ul[@class='info-list']/li[@class='%s']";
	public static final String SHIPPING_METHOD_TEXT = "xpath=//div[@class='shipping-method-info']//li[@class='shipping-method']";
	public static final String PAYMENT_METHOD_TEXT = "xpath=//div[@class='payment-method-info']//li[@class='payment-method']";
	public static final String DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME = "XPATH=//div[@class='billing-info']/ul[@class='info-list']/li[@class='%s']";
	public static final String DYNAMIC_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::td[@class='product']//a";
	public static final String DYNAMIC_INFO_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::td[@class='product']/parent::tr/td[@class='%s']/span";
	public static final String DYNAMIC_TOTAL_INFO_BY_LABEL_NAME = "xpath=//label[contains(text(),'%s')]/parent::td/following-sibling::td/span";
	public static final String SELECTED_CHECKOUT_ATTRIBUTES = "xpath=//div[@class='section options']/div[@class='selected-checkout-attributes']";
	public static final String DYNAMIC_TITLE_AT_CONFIRM_ORDER = "xpath=//strong[text()='%s']";
	public static final String ORDER_DATE = "CSS=li.order-date";;
}
