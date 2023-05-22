package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
	WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputToValidInfoForBillingAddress(String firstName, String lastName, String emailAddress, String country, String state, String city, String address, String zipCode, String phoneNumber) {
		inputFirstNameTextbox(firstName);

		inputLastNameTextbox(lastName);

		inputEmailAddressTextbox(emailAddress);

		selectToCountryDropdown(country);

		inputCityTextbox(city);

		inputAddressTextbox(address);

		inputzipCodeTextbox(zipCode);

		inputPhoneNumber(phoneNumber);

		if (!state.equals("")) {
			selectToStateDropdown(state);
		}

	}

	private void selectToStateDropdown(String state) {
		scrollToElement(UserCheckoutPageUI.DYNAMIC_DROPDOWN_BY_LABEL_NAME, "State / province:");
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_DROPDOWN_BY_LABEL_NAME, "State / province:");

		selectItemInDefaultDropdown(UserCheckoutPageUI.DYNAMIC_DROPDOWN_BY_LABEL_NAME, state, "State / province:");
		Assert.assertEquals(getSelectedItemInDropdown( UserCheckoutPageUI.DYNAMIC_DROPDOWN_BY_LABEL_NAME, "State / province:").getText(), state);

	}

	private void inputPhoneNumber(String phoneNumber) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Phone number");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, phoneNumber, "Phone number");

	}

	private void inputzipCodeTextbox(String zipCode) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Zip / postal code");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, zipCode, "Zip / postal code");

	}

	private void inputAddressTextbox(String address) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Address 1:");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, address, "Address 1:");

	}

	private void inputCityTextbox(String city) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "City:");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, city, "City:");

	}

	private void selectToCountryDropdown(String country) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_DROPDOWN_BY_LABEL_NAME, "Country");
		selectItemInDefaultDropdown(UserCheckoutPageUI.DYNAMIC_DROPDOWN_BY_LABEL_NAME, country, "Country");
		Assert.assertEquals(getSelectedItemInDropdown(UserCheckoutPageUI.DYNAMIC_DROPDOWN_BY_LABEL_NAME, "Country").getText(), country);
	}

	private void inputEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Email:");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, emailAddress, "Email:");

	}

	private void inputLastNameTextbox(String lastName) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Last name:");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, lastName, "Last name:");

	}

	private void inputFirstNameTextbox(String firstName) {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "First name");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, firstName, "First name");

	}

	public void chooseShippingMethodRadionButton(String shippingMethod) {
		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, shippingMethod);
		checkTheCheckboxOrRadio(UserCheckoutPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, shippingMethod);

	}

	public void chooseToPaymentMethodRadioButton(String paymentMethod) {
		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, paymentMethod);
		checkTheCheckboxOrRadio(UserCheckoutPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, paymentMethod);

	}

	public void clickToContinueButton(String blockName) {
		scrollToElement(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, blockName, "Continue");
		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, blockName, "Continue");
		clickToElement(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, blockName, "Continue");

	}

	public String getPaymentInformationText() {
		waitForElementVisible(UserCheckoutPageUI.PAYMENT_INFORMATION_TEXT);
		return getTextElement(UserCheckoutPageUI.PAYMENT_INFORMATION_TEXT);

	}

	public void verifyBillingAddressAtConfirmOrder(String fullName, String email, String phone, String fax, String address, String cityAndZipCode, String contry) {

		Assert.assertTrue(isElementDisplayed(UserCheckoutPageUI.DYNAMIC_TITLE_AT_CONFIRM_ORDER, "Billing Address"));

		Assert.assertEquals(getFullNameAtBillingAddress(), fullName);

		Assert.assertEquals(getEmailAtBillingAddress(), email);

		Assert.assertEquals(getPhoneNumberAtBillingAddress(), phone);

		Assert.assertEquals(getFaxAtBillingAddress(), fax);

		Assert.assertEquals(getAddressAtBillingAddress(), address);

		Assert.assertEquals(getCityAndZipCodeAtBillingAddress(), cityAndZipCode);

		Assert.assertEquals(getCountryAtBillingAddress(), contry);

	}

	public String getFullNameAtBillingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "name");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "name");

	}

	public String getEmailAtBillingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "email");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "email").replace("Email:", "").replace(" ", "");
	}

	public String getPhoneNumberAtBillingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "phone");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "phone").replace("Phone:", "").replace(" ", "");
	}

	public String getFaxAtBillingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "fax");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "fax").replace("Fax:", "").replace(" ", "");
	}

	public String getAddressAtBillingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "address1");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "address1");
	}

	public String getCityAndZipCodeAtBillingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
	}

	public String getCountryAtBillingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "country");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_BILLING_ADDRESS_BY_FIELD_NAME, "country");
	}

	public void verifyShippingAddressAtConfirmOrder(String fullName, String email, String phone, String fax, String address, String cityAndZipCode, String contry) {

		Assert.assertTrue(isElementDisplayed(UserCheckoutPageUI.DYNAMIC_TITLE_AT_CONFIRM_ORDER, "Shipping Address"));

		Assert.assertEquals(getFullNameAtShippingAddress(), fullName);

		Assert.assertEquals(getEmailAtShippingAddress(), email);

		Assert.assertEquals(getPhoneNumberAtShippingAddress(), phone);

		Assert.assertEquals(getFaxAtBillingAddress(), fax);

		Assert.assertEquals(getAddressAtShippingAddress(), address);

		Assert.assertEquals(getCityAndZipCodeAtShippingAddress(), cityAndZipCode);

		Assert.assertEquals(getCountryAtShippingAddress(), contry);

	}

	public String getFullNameAtShippingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "name");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "name");

	}

	public String getEmailAtShippingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "email");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "email").replace("Email:", "").replace(" ", "");
	}

	public String getPhoneNumberAtShippingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "phone");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "phone").replace("Phone:", "").replace(" ", "");
	}

	public String getFaxAtShippingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "fax");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "fax").replace("Fax:", "").replace(" ", "");
	}

	public String getAddressAtShippingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "address1");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "address1");
	}

	public String getCityAndZipCodeAtShippingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "city-state-zip");
	}

	public String getCountryAtShippingAddress() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "country");
		return getTextElement(UserCheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_BY_FIELD_NAME, "country");
	}

	public void verifyShipping(String shipping) {

		Assert.assertEquals(getTextElement(UserCheckoutPageUI.SHIPPING_METHOD_TEXT), shipping);

	}

	public void verifyPaymentMethodAtConfirmOrder(String paymentMethod) {

		Assert.assertEquals(getTextElement(UserCheckoutPageUI.PAYMENT_METHOD_TEXT), paymentMethod);

	}

	public void verifyProductInfo(String sku, String productName, String price, String quantity, String total) {
		String getSKu = getTextElement(UserCheckoutPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "sku");
		String getPrice = getTextElement(UserCheckoutPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "unit-price").replace(".00", "");
		String getQuantity = getTextElement(UserCheckoutPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "quantity");
		String getSubTotal = getTextElement(UserCheckoutPageUI.DYNAMIC_INFO_BY_PRODUCT_NAME, productName, "subtotal").replace(".00", "");
		String getProduct = getTextElement(UserCheckoutPageUI.DYNAMIC_PRODUCT_NAME, productName);

		Assert.assertEquals(getSKu, sku);
		Assert.assertEquals(getPrice, price);
		Assert.assertEquals(getQuantity, quantity);
		Assert.assertEquals(getSubTotal, total);
		Assert.assertEquals(getProduct, productName);

	}

	public void clickToConfirmButtonAtConfirmOrder() {
		scrollToElement(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Confirm order", "Confirm");
		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Confirm order", "Confirm");
		clickToElementByJS(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Confirm order", "Confirm");

	}

	public String getSelectedCheckoutAttributeText() {
		waitForElementVisible(UserCheckoutPageUI.SELECTED_CHECKOUT_ATTRIBUTES);
		return getTextElement(UserCheckoutPageUI.SELECTED_CHECKOUT_ATTRIBUTES);
	}

	public String getSubTotal() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "order-subtotal");
		String subTotal = getTextElement(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "order-subtotal").replace(".00", "").replace(" ", "");
		return subTotal;
	}

	public String getShippingCost() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "shipping-cost");
		String shippingCost = getTextElement(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "shipping-cost").replace(".00", "").replace(" ", "");
		return shippingCost;

	}

	public String getTax() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "tax-value");
		String tax = getTextElement(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "tax-value").replace(".00", "").replace(" ", "");
		return tax;

	}

	public String getTotal() {
		waitForElementVisible(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "order-total");
		String total = getTextElement(UserCheckoutPageUI.DYNAMIC_TOTAL_INFO, "order-total").replace(".00", "").replace(" ", "");
		return total;

	}

	public String getSuccessCreatedOrderMessage() {
		waitForElementVisible(UserCheckoutPageUI.SUCCESS_CREATED_ORDER_MESSAGE);
		return getTextElement(UserCheckoutPageUI.SUCCESS_CREATED_ORDER_MESSAGE);
	}

	public String getTitleOfThankYouPage() {
		waitForElementVisible(UserCheckoutPageUI.THANK_YOU_PAGE_TITLE);
		return getTextElement(UserCheckoutPageUI.THANK_YOU_PAGE_TITLE);
	}

	public String getOrderNumber() {
		waitForElementVisible(UserCheckoutPageUI.ORDER_NUMBER);
		String orderNumber = getTextElement(UserCheckoutPageUI.ORDER_NUMBER).replace("ORDER NUMBER:", "").replace(" ", "");
		return orderNumber;
	}

	public String getOrderNumberText() {
		waitForElementVisible(UserCheckoutPageUI.ORDER_NUMBER);
		return getTextElement(UserCheckoutPageUI.ORDER_NUMBER);

	}

	public void clickToContinueButtonAtBillingAddress() {
		clickToContinueButton("Billing address");

	}

	public void clickToContinueButtonAtShippingMethod() {
		clickToContinueButton("Shipping method");

	}

	public void clickToContinueButtonAtCreditCard() {
		clickToContinueButton("Payment method");

	}

	public void inputToCardInformation(String creditCard, String cardHolderName, String cardNumber, String expirationDate, String cardCode) {
		selectToCreditCardTypeDropdown(creditCard);
		inputToCardHolderNameTextbox(cardHolderName);
		inputToCardNumberTextbox(cardNumber);
		inputToCardCodeTextbox(cardCode);
		selectToExpirationDateDropdown(expirationDate);

	}

	private void selectToExpirationDateDropdown(String expiratioDate) {
		String[] date = expiratioDate.split("/");
		selectItemInDefaultDropdown(UserCheckoutPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID_AT_CARD_INFO, date[0], "ExpireMonth");
		selectItemInDefaultDropdown(UserCheckoutPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID_AT_CARD_INFO, date[1], "ExpireYear");

	}

	private void inputToCardCodeTextbox(String cardCode) {
		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID_AT_CARD_INFO, "CardCode");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID_AT_CARD_INFO, cardCode, "CardCode");

	}

	private void inputToCardNumberTextbox(String cardNumber) {

		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID_AT_CARD_INFO, "CardNumber");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID_AT_CARD_INFO, cardNumber, "CardNumber");

	}

	private void inputToCardHolderNameTextbox(String cardHolderName) {

		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID_AT_CARD_INFO, "CardholderName");
		sendkeyToElement(UserCheckoutPageUI.DYNAMIC_TEXTBOX_BY_ID_AT_CARD_INFO, cardHolderName, "CardholderName");

	}

	private void selectToCreditCardTypeDropdown(String creditCard) {

		selectItemInDefaultDropdown(UserCheckoutPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID_AT_CARD_INFO, creditCard, "CreditCardType");

	}

	public void clickToContinueButtonAtPaymentMethod() {
		clickToContinueButton("Payment method");

	}

	public void clickToContinueButtonAtPaymentInfo() {

		clickToContinueButton("Payment information");

	}

	public void clickToEditButtonAtBillingAddress() {
		scrollToElement(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Billing address", "Edit");
		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Billing address", "Edit");
		clickToElementByJS(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Billing address", "Edit");

	}

	public void clickToSaveButtonAtBillingAddress() {
		scrollToElement(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Billing address", "Save");
		waitForElementClickable(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Billing address", "Save");
		clickToElementByJS(UserCheckoutPageUI.DYNAMIC_BUTTON_BY_BLOCK_NAME, "Billing address", "Save");
		
	}

}
