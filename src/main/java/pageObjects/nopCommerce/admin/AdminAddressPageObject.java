package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminAddressPageUI;

public class AdminAddressPageObject extends BasePage {
	public AdminAddressPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public void inputDataToCreateAddress(String firstName, String lastName, String email, String company, String country, String state, String city, String address1, String address2, String zipCode, String phoneNumber, String faxNumber) {

		inputToFirstNameTextbox(firstName);

		inputToLastNameTextbox(lastName);

		inputToEmailTextbox(email);

		inputToCompanyTextbox(company);

		selectToCountryDropdown(country);

		selectToStateDropdown(state);

		inputToCityTextbox(city);

		inputToAddress1Textbox(address1);

		inputToAddress2Textbox(address2);

		inputToZipCodeTextbox(zipCode);

		inputToPhoneNumberTextbox(phoneNumber);

		inputToFaxNumberTextbox(faxNumber);

	}

	private void inputToFaxNumberTextbox(String faxNumber) {

		scrollToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Fax number");
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Fax number");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, faxNumber, "Fax number");

	}

	private void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Phone number");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, phoneNumber, "Phone number");
	}

	private void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Zip / postal code");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, zipCode, "Zip / postal code");

	}

	private void inputToAddress2Textbox(String address2) {
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Address 2");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, address2, "Address 2");
	}

	private void inputToAddress1Textbox(String address1) {
		waitForElementVisible( AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Address 1");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, address1, "Address 1");

	}

	private void inputToCityTextbox(String city) {
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "City");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, city, "City");

	}

	private void selectToStateDropdown(String state) {
		waitForElementVisible( AdminAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL_NAME, "State / province");
		selectItemInDefaultDropdown(AdminAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL_NAME, state, "State / province");
	}

	private void selectToCountryDropdown(String country) {
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL_NAME, "Country");
		selectItemInDefaultDropdown(AdminAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL_NAME, country, "Country");
	}

	private void inputToCompanyTextbox(String company) {
		waitForElementVisible( AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Company");
		sendkeyToElement( AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, company, "Company");
	}

	private void inputToEmailTextbox(String email) {
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Email");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, email, "Email");
	}

	private void inputToLastNameTextbox(String lastName) {

		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Last name");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, lastName, "Last name");

	}

	private void inputToFirstNameTextbox(String firstName) {

		waitForElementVisible(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "First name");
		sendkeyToElement(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, firstName, "First name");

	}

	public void clickToSaveButton() {
		scrollToElement(AdminAddressPageUI.SAVE_BUTTON);
		waitForElementClickable(AdminAddressPageUI.SAVE_BUTTON);
		clickToElement(AdminAddressPageUI.SAVE_BUTTON);
	}

	public String getSuccessMessage() {
		waitForElementVisible(AdminAddressPageUI.DYNAMIC_CONTENT_MESSAGE);
		return getTextElement(AdminAddressPageUI.DYNAMIC_CONTENT_MESSAGE).replace("×\n", "");
	}

	public void clickToBackToCustomerDetails() {
		waitForElementClickable(AdminAddressPageUI.BACK_TO_CUSTOMER_DETAILS_BUTTON);
		clickToElement(AdminAddressPageUI.BACK_TO_CUSTOMER_DETAILS_BUTTON);
	}

	public void verifyAddressInfo(String firstName, String lastName, String email, String company, String country, String state, String city, String address1, String address2, String zipCode, String phoneNumber, String faxNumber) {
		String actualFirstName = getAttributeValue(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "First name");
		Assert.assertEquals(actualFirstName, firstName);

		String actualLastName = getAttributeValue(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Last name");
		Assert.assertEquals(actualLastName, lastName);

		String actualEmail = getAttributeValue(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Email");
		Assert.assertEquals(actualEmail, email);

		String actualCompany = getAttributeValue(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Company");
		Assert.assertEquals(actualCompany, company);

		String actualCity = getAttributeValue(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "City");
		Assert.assertEquals(actualCity, city);

		String actualPhoneNumber = getAttributeValue(AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Phone number");
		Assert.assertEquals(actualPhoneNumber, phoneNumber);

		String actualFaxNumber = getAttributeValue(
				AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Fax number");
		Assert.assertEquals(actualFaxNumber, faxNumber);

		String actualAddress1 = getAttributeValue(
				AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Address 1");
		Assert.assertEquals(actualAddress1, address1);

		String actualAddress2 = getAttributeValue(
				AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Address 2");
		Assert.assertEquals(actualAddress2, address2);

		String actualZipCode = getAttributeValue(
				AdminAddressPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Zip / postal code");
		Assert.assertEquals(actualZipCode, zipCode);

		Assert.assertEquals(getSelectedItemInDropdown( AdminAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL_NAME, "Country").getText(), country);

		Assert.assertEquals(getSelectedItemInDropdown(
				AdminAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_LABEL_NAME, "State / province").getText(), state);

	}
}
