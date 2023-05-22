package pageObjects.nopCommerce.user;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserOrdersPageUI;

public class UserOrdersPageObject extends BasePage {
	public UserOrdersPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isOrdersPageDisplayed() {
		waitForAllElementsVisible(UserOrdersPageUI.ORDERS_HEADER);
		return isElementDisplayed(UserOrdersPageUI.ORDERS_HEADER);
	}

	public UserAddressesPageObject openAddressesPage() {
		clickToAddressesPageAtUserPage();
		return PageGeneratorManager.getUserAddressesPageObject(driver);
	}

	public String getOrderNumberAtOrderPage() {
		waitForElementVisible(UserOrdersPageUI.ORDER_NUMBER);
		String orderNumber = getTextElement(UserOrdersPageUI.ORDER_NUMBER).replace("Order Number: ", "").replace(" ", "");
		return orderNumber;
	}

	public void clickToDetailOrderByOrderNumber(String orderNumber) {
		waitForElementClickable(UserOrdersPageUI.DETAILS_ORDER_BUTTON, orderNumber);
		clickToElement(UserOrdersPageUI.DETAILS_ORDER_BUTTON, orderNumber);

	}

	public String getTotal() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Order Total");
		String total = getTextElement(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Order Total").replace("Order Total:", "").replace(" ", "").replace(".00", "");
		return total;
	}

	public String getTax() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Tax:");
		String total = getTextElement(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Tax:").replace("Tax:", "").replace(" ", "").replace(".00", "");
		return total;
	}

	public String getShipping() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Shipping:");
		String total = getTextElement(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Shipping:").replace("Shipping:", "").replace(" ", "").replace(".00", "");
		return total;
	}

	public String getSubTotal() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Sub-Total:");
		String total = getTextElement(UserOrdersPageUI.DYNAMIC_TOTAL_INFO_BY_LABEL_NAME, "Sub-Total:").replace("Sub-Total:", "").replace(" ", "").replace(".00", "");
		return total;
	}

	public String getSelectedCheckoutAttributeText() {
		waitForElementVisible(UserOrdersPageUI.SELECTED_CHECKOUT_ATTRIBUTES);
		return getTextElement(UserOrdersPageUI.SELECTED_CHECKOUT_ATTRIBUTES);

	}

	public void verifyOrderTotal(String orderTotal) {

		waitForElementVisible(UserOrdersPageUI.DYNAMIC_ORDER_OVERVIEW_BY_TEXT_LABEL, "order-total");
		String total = getTextElement(UserOrdersPageUI.DYNAMIC_ORDER_OVERVIEW_BY_TEXT_LABEL, "order-total").replace("Order Status:", "").replace("Order Total: ", "").replace(" ", "").replace(".00", "");
		Assert.assertEquals(total, orderTotal);

	}

	public void verifyOrderStatus(String orderStatus) {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_ORDER_OVERVIEW_BY_TEXT_LABEL, "order-status");
		String status = getTextElement(UserOrdersPageUI.DYNAMIC_ORDER_OVERVIEW_BY_TEXT_LABEL, "order-status").replace("Order Status:", "").replace(" ", "");
		Assert.assertEquals(status, orderStatus);
	}

	public String getOrderDate() {
		String getDateOnOrderPage = getTextElement(UserOrdersPageUI.ORDER_DATE);
		String[] day = getDateOnOrderPage.split(",");
		return day[1].trim() + "," + day[2];
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		switch (month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "Octorber";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Month is invalid";
		}

	}

	public void verifyOrderDate() {
		String today = getToday();
		String orderDate = getOrderDate();
		Assert.assertEquals(today, orderDate);

	}


	protected String getToday() {
		return getCurrentMonth() + " " + getCurrentDay() + ", " + getCurrentYear();
	}

	public void verifyOrderNumber(String orderNumber) {
		String orderNumberAtOrderPage = getTextElement(UserOrdersPageUI.ORDER_NUMBER_AT_ORDER_INFO).replace("ORDER", "").replace(" ", "").replace("#", "");
		Assert.assertEquals(orderNumberAtOrderPage, orderNumber);
	}

	public void verifyBillingAddressAtOrderPage(String fullName, String email, String phone, String fax, String address, String cityAndZipCode, String country) {
		Assert.assertTrue(isElementDisplayed(UserOrdersPageUI.DYNAMIC_TITLE_AT_CONFIRM_ORDER, "Billing Address"));

		Assert.assertEquals(getFullNameAtBillingAddress(), fullName);

		Assert.assertEquals(getEmailAtBillingAddress(), email);

		Assert.assertEquals(getPhoneNumberAtBillingAddress(), phone);

		Assert.assertEquals(getFaxAtBillingAddress(), fax);

		Assert.assertEquals(getAddressAtBillingAddress(), address);

		Assert.assertEquals(getCityAndZipCodeAtBillingAddress(), cityAndZipCode);

		Assert.assertEquals(getCountryAtBillingAddress(), country);

	}

	public void verifyShippingAddressAtOrderPage(String fullName, String email, String phone, String fax, String address, String cityAndZipCode, String country) {
		Assert.assertTrue(isElementDisplayed(UserOrdersPageUI.DYNAMIC_TITLE_AT_CONFIRM_ORDER, "Shipping Address"));

		Assert.assertEquals(getFullNameAtShippingAddress(), fullName);

		Assert.assertEquals(getEmailAtShippingAddress(), email);

		Assert.assertEquals(getPhoneNumberAtShippingAddress(), phone);

		Assert.assertEquals(getFaxAtBillingAddress(), fax);

		Assert.assertEquals(getAddressAtShippingAddress(), address);

		Assert.assertEquals(getCityAndZipCodeAtShippingAddress(), cityAndZipCode);

		Assert.assertEquals(getCountryAtShippingAddress(), country);
	}

	public void verifyShippingAtOrderaPage(String shipping) {

		Assert.assertEquals(getTextElement(UserOrdersPageUI.SHIPPING_METHOD_TEXT), shipping);

	}

	public void verifyProductInfoAtOrderPage(String sku, String productName, String price, String quantity, String total) {
		String getSKu = getTextElement(UserOrdersPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "sku");
		String getPrice = getTextElement(UserOrdersPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "unit-price").replace(".00", "");
		String getQuantity = getTextElement(UserOrdersPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "quantity");
		String getSubTotal = getTextElement(UserOrdersPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "total").replace(".00", "");
		String getProduct = getTextElement(UserOrdersPageUI.DYNAMIC_PRODUCT_NAME, productName);

		Assert.assertEquals(getSKu, sku);
		Assert.assertEquals(getPrice, price);
		Assert.assertEquals(getQuantity, quantity);
		Assert.assertEquals(getSubTotal, total);
		Assert.assertEquals(getProduct, productName);

	}

	public void clickToReOrderButton() {
		waitForElementClickable(UserOrdersPageUI.RE_ORDER_BUTTON);
		clickToElement(UserOrdersPageUI.RE_ORDER_BUTTON);

	}

	public String getFullNameAtShippingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "name");
		return getTextElement(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "name");

	}

	public String getEmailAtShippingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "email");
		return getTextElement(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "email").replace("Email:", "").replace(" ", "");
	}

	public String getPhoneNumberAtShippingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "phone");
		return getTextElement(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "phone").replace("Phone:", "").replace(" ", "");
	}

	public String getFaxAtShippingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "fax");
		return getTextElement(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "fax").replace("Fax:", "").replace(" ", "");
	}

	public String getAddressAtShippingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "address1");
		return getTextElement(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "address1");
	}

	public String getCityAndZipCodeAtShippingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
		return getTextElement(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
	}

	public String getCountryAtShippingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "country");
		return getTextElement(UserOrdersPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "country");
	}

	public void verifyPaymentMethodAtOrderPage(String paymentMethod) {

		Assert.assertEquals(getTextElement(UserOrdersPageUI.PAYMENT_METHOD_TEXT), paymentMethod);

	}

	public String getFullNameAtBillingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "name");
		return getTextElement(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "name");

	}

	public String getEmailAtBillingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "email");
		return getTextElement(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "email").replace("Email:", "").replace(" ", "");
	}

	public String getPhoneNumberAtBillingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "phone");
		return getTextElement(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "phone").replace("Phone:", "").replace(" ", "");
	}

	public String getFaxAtBillingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "fax");
		return getTextElement(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "fax").replace("Fax:", "").replace(" ", "");
	}

	public String getAddressAtBillingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "address1");
		return getTextElement(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "address1");
	}

	public String getCityAndZipCodeAtBillingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
		return getTextElement(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
	}

	public String getCountryAtBillingAddress() {
		waitForElementVisible(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "country");
		return getTextElement(UserOrdersPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "country");
	}

}
