package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage {

	public UserAddressesPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;
	public String getCompany;

	public boolean isAddressesPageDisplayed() {

		waitForAllElementsVisible(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - Addresses");
		return isElementDisplayed(UserAddressesPageUI.ADDRESSES_HEADER, "My account - Addresses");

	}

	public UserCustomerInfoPageObject openCustomerInfo() {
		clickToCustomerInfoPageAtUserPage();
		return PageGeneratorManager.getUserCustomerInfoPageObject(driver);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(UserAddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(UserAddressesPageUI.ADD_NEW_BUTTON);

	}

	public boolean isAddNewAddressTitleDisplayed() {
		waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - Add new address");
		return isElementDisplayed(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - Add new address");
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(UserAddressesPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(UserAddressesPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void inputToEmailTextbox(String updatedEmail) {
		waitForElementVisible(UserAddressesPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.EMAIL_TEXTBOX, updatedEmail);

	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(UserAddressesPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.COMPANY_TEXTBOX, company);

	}

	public void selectToCountry(String country) {
		waitForElementVisible(UserAddressesPageUI.COUNTRY_DROPDOWLIST);
		selectItemInDefaultDropdown(UserAddressesPageUI.COUNTRY_DROPDOWLIST, country);

	}

	public void selectToState(String state) {
		waitForElementVisible(UserAddressesPageUI.STATE_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserAddressesPageUI.STATE_DROPDOWNLIST, state);

	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(UserAddressesPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.ADDRESS1_TEXTBOX, address1);

	}

	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(UserAddressesPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.ADDRESS2_TEXTBOX, address2);

	}

	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(UserAddressesPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.ZIPCODE_TEXTBOX, zipCode);

	}

	public void inputToPhoneNumberTextbox(String phone) {
		waitForElementVisible(UserAddressesPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.PHONE_NUMBER_TEXTBOX, phone);

	}

	public void inputToFaxNumberTextbox(String fax) {
		waitForElementVisible(UserAddressesPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.FAX_NUMBER_TEXTBOX, fax);

	}

	public void clickToSaveButton() {
		waitForElementVisible(UserAddressesPageUI.SAVE_BUTTON);
		clickToElement(UserAddressesPageUI.SAVE_BUTTON);

	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(UserAddressesPageUI.CITY_TEXTBOX);
		sendkeyToElement(UserAddressesPageUI.CITY_TEXTBOX, city);

	}

	public String getSuccessCreatedAddressMessage() {
		waitForElementVisible(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
		return getTextElement(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
	}

	public String getName() {
		waitForElementVisible(UserAddressesPageUI.ADDRESS_NAME_TEXT);
		return getTextElement(UserAddressesPageUI.ADDRESS_NAME_TEXT);
	}

	public String getCompany() {
		waitForElementVisible(UserAddressesPageUI.COMPANY_TEXT);
		return getTextElement(UserAddressesPageUI.COMPANY_TEXT);
	}

	public String getAddress2() {
		waitForElementVisible(UserAddressesPageUI.ADDRESS2_TEXT);
		return getTextElement(UserAddressesPageUI.ADDRESS2_TEXT);
	}

	public String getCityAndZipCode() {
		waitForElementVisible(UserAddressesPageUI.CITY_ZIP_CODE_TEXT);
		return getTextElement(UserAddressesPageUI.CITY_ZIP_CODE_TEXT);
	}

	public String getCountry() {
		waitForElementVisible(UserAddressesPageUI.COUNTRY_TEXT);
		return getTextElement(UserAddressesPageUI.COUNTRY_TEXT);
	}

	public String getAddress1() {
		waitForElementVisible(UserAddressesPageUI.ADDRESS1_TEXT);
		return getTextElement(UserAddressesPageUI.ADDRESS1_TEXT);
	}

	public String getEmail() {
		waitForElementVisible(UserAddressesPageUI.EMAIL_TEXT);
		return getTextElement(UserAddressesPageUI.EMAIL_TEXT);
	}

	public String getPhoneNumber() {
		waitForElementVisible(UserAddressesPageUI.PHONE_TEXT);
		return getTextElement(UserAddressesPageUI.PHONE_TEXT);
	}

	public String getFaxNumber() {
		waitForElementVisible(UserAddressesPageUI.FAX_TEXT);
		return getTextElement(UserAddressesPageUI.FAX_TEXT);
	}
}
