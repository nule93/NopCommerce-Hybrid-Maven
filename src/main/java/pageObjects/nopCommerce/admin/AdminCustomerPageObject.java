package pageObjects.nopCommerce.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminCustomerPageUI;

public class AdminCustomerPageObject extends BasePage {
	public AdminCustomerPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public void clickToAddNewButton() {
		waitForElementClickable(AdminCustomerPageUI.ADD_NEW_BUTTON);
		clickToElementByJS(AdminCustomerPageUI.ADD_NEW_BUTTON);

	}

	public void inputToEmailTextboxToCreateAndSearchCustomer(String emailCreateCustomer) {
		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Email");
		sendkeyToElement(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, emailCreateCustomer, "Email");

	}

	public void inputToPasswordTextboxToCreateCustomer(String passwordCreateCustomer) {

		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Password");
		sendkeyToElement(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, passwordCreateCustomer, "Password");

	}

	public void inputToFirstNameTextboxToCreateAndEditAndSearchCustomer(String firstName) {

		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "First name");
		sendkeyToElement( AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, firstName, "First name");

	}

	public void inputToLastNameTextboxToCreateAndEditAndSearchCustomer(String lastName) {

		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Last name");
		sendkeyToElement( AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, lastName, "Last name");

	}

	public void chooseToGenderRadioButtonToCreateCustomer(String gender) {
		waitForElementVisible(AdminCustomerPageUI.GENDER_RADIO_BUTTON, gender);
		checkTheCheckboxOrRadio(AdminCustomerPageUI.GENDER_RADIO_BUTTON, gender);

	}

	public void inputToDateOfBirthTextboxToCreateCustomer(String dateOfBirth) {

		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Date of birth");
		sendkeyToElement(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, dateOfBirth, "Date of birth");

	}

	public void inputToCompanyNameTextboxToCreateCustomer(String companyName) {

		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Company name");

		sendkeyToElement( AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, companyName, "Company name");

	}

	public void selectToCustomerRolesDropdownToCreateAndSearchCustomer(String customerRoles) {
		scrollToElement(AdminCustomerPageUI.CUSTOMER_ROLES_PARENT_DROPDOWN);

		clickToElementByJS(AdminCustomerPageUI.CLEAR_ALL_CUSTOMER_ROLES);

		selectItemInCustomDropdown(AdminCustomerPageUI.CUSTOMER_ROLES_PARENT_DROPDOWN, AdminCustomerPageUI.CUSTOMER_ROLES_CHILD_DROPDOWN, customerRoles);

		Assert.assertEquals(getTextElement( AdminCustomerPageUI.CUSTOMER_ROLES_PARENT_DROPDOWN).replace("\n*", ""), customerRoles);
	}

	public void checkToActiveCheckboxToCreateCustomer() {
		scrollToElement(AdminCustomerPageUI.ACTIVE_CHECKBOX);
		checkTheCheckboxOrRadio(AdminCustomerPageUI.ACTIVE_CHECKBOX);
	}

	public void inputToAdminCommentTextAreaToCreateCustomer(String adminComment) {

		waitForElementVisible(AdminCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
		sendkeyToElement( AdminCustomerPageUI.ADMIN_COMMENT_TEXTAREA, adminComment);

	}

	public void clickToSaveAndContinueEdit() {
		scrollToElement(AdminCustomerPageUI.DYNAMIC_BUTTON_BY_ATTRIBUTE_NAME, "save-continue");
		waitForElementClickable(AdminCustomerPageUI.DYNAMIC_BUTTON_BY_ATTRIBUTE_NAME, "save-continue");
		clickToElement( AdminCustomerPageUI.DYNAMIC_BUTTON_BY_ATTRIBUTE_NAME, "save-continue");

	}

	public String getCreatedCustomerSuccessMessage() {
		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_CONTENT_MESSAGE);
		return getTextElement(AdminCustomerPageUI.DYNAMIC_CONTENT_MESSAGE).replace("×\n", "");
	}

	public void verifyCreatedCustomerInfo(String email, String password, String firstName, String lastName, String gender, String dateOfBirth, String companyName, String customerRoles, boolean active, String adminComment) {
		String actualEmail = getAttributeValue(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Email");
		Assert.assertEquals(actualEmail, email);

		String actualPassword = getAttributeValue(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Password");
		Assert.assertEquals(actualPassword, password);

		String actualFirstName = getAttributeValue(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "First name");
		Assert.assertEquals(actualFirstName, firstName);

		String actualLastName = getAttributeValue(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Last name");
		Assert.assertEquals(actualLastName, lastName);

		String actualDateOfBirth = getAttributeValue(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Date of birth");
		Assert.assertEquals(actualDateOfBirth, dateOfBirth);

		String actualCompanyName = getAttributeValue(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "value", "Company name");
		Assert.assertEquals(actualCompanyName, companyName);

		Assert.assertTrue(isElementSelected(AdminCustomerPageUI.GENDER_RADIO_BUTTON, gender));

		Assert.assertEquals(getTextElement(AdminCustomerPageUI.CUSTOMER_ROLES_PARENT_DROPDOWN).replace("\n*", ""), customerRoles);

		String actualAdminComment = getTextElement(AdminCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
		Assert.assertEquals(actualAdminComment, adminComment);

		Assert.assertEquals(isElementSelected(AdminCustomerPageUI.ACTIVE_CHECKBOX), active);
	}

	public void clickToBackToCustomerListButton() {
		waitForElementClickable(AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST_BUTTON);
		clickToElement(AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST_BUTTON);

	}

	public void clickToSearchButton() {
		waitForElementClickable(AdminCustomerPageUI.DYNAMIC_BUTTON_AT_CUSTOMER_LIST_SCREEN, "Search");
		clickToElement(AdminCustomerPageUI.DYNAMIC_BUTTON_AT_CUSTOMER_LIST_SCREEN, "Search");

	}

	public void verifyDisplayCustomerInfo(String email, String fullName, String customerRoles, String companyName, String active) {

		if (customerRoles.equals("Guests")) {

			String indexEmail = indexByLabelNameInRow("Email");
			List<WebElement> listEmails = getElements(AdminCustomerPageUI.DATA_LIST_OF_COLUMN_BY_DYNAMIC_LABEL_NAME, indexEmail);
			for (WebElement element : listEmails) {
				if (!element.getText().equals(email)) {
					Assert.assertTrue(false);
				}
			}

			String indexCustomerRoles = indexByLabelNameInRow("Customer roles");
			List<WebElement> listCustomerRoles = getElements(AdminCustomerPageUI.DATA_LIST_OF_COLUMN_BY_DYNAMIC_LABEL_NAME, indexCustomerRoles);
			for (WebElement element : listCustomerRoles) {
				if (!element.getText().equals("Guests")) {
					Assert.assertTrue(false);
				}
			}

			String indexName = indexByLabelNameInRow("Name");

			String indexCompany = indexByLabelNameInRow("Company name");

			List<WebElement> listCompanies = getElements(AdminCustomerPageUI.DATA_LIST_OF_COLUMN_BY_DYNAMIC_LABEL_NAME, indexCompany);

			List<WebElement> listNames = getElements(AdminCustomerPageUI.DATA_LIST_OF_COLUMN_BY_DYNAMIC_LABEL_NAME, indexName);

			boolean check = false;

			for (int i = 0; i < listNames.size(); i++) {

				if (listNames.get(i).getText().equals(fullName) && listCompanies.get(i).getText().equals(companyName)) {
					check = true;

					String statusActive = getStatusActiveOfCustomerInCustomerListTableAtRow(String.valueOf(i + 1));
					Assert.assertEquals(statusActive, active);
					break;
				}
			}
			Assert.assertTrue(check);
		}

		else {

			String actualEmail = getEmailInCustomerListTableAtRow("1");
			Assert.assertEquals(actualEmail, email);

			String actualName = getNameInCustomerListTableAtRow("1");
			Assert.assertEquals(actualName, fullName);

			String actualCustomerRoles = getCustomerRolesInCustomerListTableAtRow("1");
			Assert.assertEquals(actualCustomerRoles, customerRoles);

			String actualCompanyName = getCompanyNameInCustomerListTableAtRow("1");
			Assert.assertEquals(actualCompanyName, companyName);

			String actualActive = getStatusActiveOfCustomerInCustomerListTableAtRow("1");
			Assert.assertEquals(actualActive, active);

		}
	}

	public String getStatusActiveOfCustomerInCustomerListTableAtRow(String indexRow) {
		String indexActive = indexByLabelNameInRow("Active");
		String xpathActiveByIndexRow = String.format(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Learn more about", indexRow, indexActive) + "/i";
		String actualActive = getAttributeValue(xpathActiveByIndexRow, "nop-value");
		if (actualActive.equals("true")) {
			actualActive = "actived";
		}
		return actualActive;
	}

	public String getCompanyNameInCustomerListTableAtRow(String indexRow) {

		String indexCompanyName = indexByLabelNameInRow("Company name");
		String actualCompanyName = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Learn more about", indexRow, indexCompanyName);
		return actualCompanyName;
	}

	public String getCustomerRolesInCustomerListTableAtRow(String indexRow) {
		String indexCustomerRoles = indexByLabelNameInRow("Customer roles");
		String actualCustomerRoles = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Learn more about", indexRow, indexCustomerRoles);
		return actualCustomerRoles;
	}

	public String getEmailInCustomerListTableAtRow(String indexRow) {
		String indexEmail = indexByLabelNameInRow("Email");
		String actualEmail = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Learn more about", indexRow, indexEmail);
		return actualEmail;
	}

	public String getNameInCustomerListTableAtRow(String indexRow) {
		String indexName = indexByLabelNameInRow("Name");
		String actualName = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Learn more about", indexRow, indexName);
		return actualName;
	}

	public String indexByLabelNameInRow(String labelName) {
		int index = getElementsSize( AdminCustomerPageUI.DYNAMIC_PRECEDING_SIBLING_BY_LABEL_NAME, labelName) + 1;
		return String.valueOf(index);
	}

	public void inputCompanyTextboxToSearchCustomer(String companyName) {
		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, "Company");

		sendkeyToElement(AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_LABEL_NAME, companyName, "Company");

	}

	public void inputDateOfBirthToSearchCustomer(String dateOfBirth) {
		String[] date = dateOfBirth.split("/");
		if (Integer.parseInt(date[0]) > 12) {
			selectItemInDefaultDropdown(AdminCustomerPageUI.DYNAMIC_DATE_OF_BIRTH_BY_ID_ATTRIBUTE_TO_SEARCH, date[0], "SearchDayOfBirth");
			selectItemInDefaultDropdown(AdminCustomerPageUI.DYNAMIC_DATE_OF_BIRTH_BY_ID_ATTRIBUTE_TO_SEARCH, date[1], "SearchMonthOfBirth");

		} else {
			selectItemInDefaultDropdown(AdminCustomerPageUI.DYNAMIC_DATE_OF_BIRTH_BY_ID_ATTRIBUTE_TO_SEARCH, date[0], "SearchDayOfBirth");
			selectItemInDefaultDropdown(AdminCustomerPageUI.DYNAMIC_DATE_OF_BIRTH_BY_ID_ATTRIBUTE_TO_SEARCH, date[1], "SearchMonthOfBirth");
		}
	}

	public void clickToEditButtonByCustomerName(String customerName) {
		waitForElementClickable(AdminCustomerPageUI.DYNAMIC_EDIT_BY_CUSTOMER_NAME, customerName);
		clickToElement(AdminCustomerPageUI.DYNAMIC_EDIT_BY_CUSTOMER_NAME, customerName);

	}

	public void clickToSaveButton() {
		waitForElementClickable(AdminCustomerPageUI.DYNAMIC_BUTTON_BY_ATTRIBUTE_NAME, "save");
		clickToElement(AdminCustomerPageUI.DYNAMIC_BUTTON_BY_ATTRIBUTE_NAME, "save");

	}

	public void clickToAddNewAddress() {

		scrollToElement(AdminCustomerPageUI.ADDRESSES_BLOCK);
		if (!isElementDisplayed(AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON)) {
			clickToElement(AdminCustomerPageUI.ADDRESSES_BLOCK);
		}

		waitForElementClickable(AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElementByJS(AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);

	}

	public void verifyCreatedAddressInfo(String firstName, String lastName, String email, String phoneNumber, String faxNumber, String Address) {

		String actualFirstName = getFirstNameInAddressListTableAtRow("1");
		Assert.assertEquals(actualFirstName, firstName);

		String actualLastName = getLastNameInAddressesListTableAtRow("1");
		Assert.assertEquals(actualLastName, lastName);

		String actualEmail = getEmailInAddressListTableAtRow("1");
		Assert.assertEquals(actualEmail, email);

		String actualPhoneNumber = getPhoneNumberInAddressListTableAtRow("1");
		Assert.assertEquals(actualPhoneNumber, phoneNumber);

		String actualAddress = getAddressInAddressListTableAtRow("1");
		Assert.assertEquals(actualAddress, Address);

		String actualFaxNumber = getFaxNumberInAddressListTableAtRow("1");
		Assert.assertEquals(actualFaxNumber, faxNumber);

	}

	public String getFaxNumberInAddressListTableAtRow(String indexRow) {

		String indexFaxName = indexByLabelNameInRow("Fax number");
		String actualFaxNumber = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Addresses", indexRow, indexFaxName);
		return actualFaxNumber;
	}

	public String getFirstNameInAddressListTableAtRow(String indexRow) {

		String indexFirstName = indexByLabelNameInRow("First name");
		String actualFirstName = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Addresses", indexRow, indexFirstName);
		return actualFirstName;
	}

	public String getLastNameInAddressesListTableAtRow(String indexRow) {
		String indexLastName = indexByLabelNameInRow("Last name");
		String actualLastName = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Addresses", indexRow, indexLastName);
		return actualLastName;
	}

	public String getEmailInAddressListTableAtRow(String indexRow) {
		String indexEmail = indexByLabelNameInRow("Email");
		String actualEmail = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Addresses", indexRow, indexEmail);
		return actualEmail;
	}

	public String getPhoneNumberInAddressListTableAtRow(String indexRow) {
		String indexPhoneNumber = indexByLabelNameInRow("Phone number");
		String actualPhoneNumber = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Addresses", indexRow, indexPhoneNumber);
		return actualPhoneNumber;
	}

	public String getAddressInAddressListTableAtRow(String indexRow) {
		String indexAddress = indexByLabelNameInRow("Address");
		String actualAddress = getTextElement(AdminCustomerPageUI.DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME, "Addresses", indexRow, indexAddress);
		return actualAddress;
	}

	public void clickToEditButtonAtAddressByFirstName(String firstName) {
		scrollToElement( AdminCustomerPageUI.DYNAMIC_BUTTON_AT_ADDRESS_TABLE_BY_FIRST_NAME, firstName, "Edit");
		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_BUTTON_AT_ADDRESS_TABLE_BY_FIRST_NAME, firstName, "Edit");
		clickToElement(AdminCustomerPageUI.DYNAMIC_BUTTON_AT_ADDRESS_TABLE_BY_FIRST_NAME, firstName, "Edit");

	}

	public void clickToDeleteButtonAtAddressByFirstName(String firstName) {

		scrollToElement( AdminCustomerPageUI.DYNAMIC_BUTTON_AT_ADDRESS_TABLE_BY_FIRST_NAME, firstName, "Delete");
		waitForElementVisible(AdminCustomerPageUI.DYNAMIC_BUTTON_AT_ADDRESS_TABLE_BY_FIRST_NAME, firstName, "Delete");
		clickToElement( AdminCustomerPageUI.DYNAMIC_BUTTON_AT_ADDRESS_TABLE_BY_FIRST_NAME, firstName, "Delete");

	}

	public String getEmptyAddressMessage() {
		waitForElementVisible(AdminCustomerPageUI.EMPTY_TABLE_BY_DYNAMIC_BLOCK_NAME, "Address");
		return getTextElement(AdminCustomerPageUI.EMPTY_TABLE_BY_DYNAMIC_BLOCK_NAME, "Address");
	}

	public void createAndEditCustomer(String email, String password, String firstName, String lastName, String gender, String dateOfBirth, String companyName, String customerRoles, String adminComment) {

		if (!email.isEmpty()) {
			inputToEmailTextboxToCreateAndSearchCustomer(email);

		}
		if (!password.isEmpty()) {
			inputToPasswordTextboxToCreateCustomer(password);

		}
		if (!firstName.isEmpty()) {
			inputToFirstNameTextboxToCreateAndEditAndSearchCustomer(firstName);

		}
		if (!lastName.isEmpty()) {
			inputToLastNameTextboxToCreateAndEditAndSearchCustomer(lastName);

		}
		if (!gender.isEmpty()) {
			chooseToGenderRadioButtonToCreateCustomer(gender);

		}
		if (!dateOfBirth.isEmpty()) {
			inputToDateOfBirthTextboxToCreateCustomer(dateOfBirth);

		}
		if (!companyName.isEmpty()) {
			inputToCompanyNameTextboxToCreateCustomer(companyName);

		}
		if (!customerRoles.isEmpty()) {
			selectToCustomerRolesDropdownToCreateAndSearchCustomer(customerRoles);

		}
		if (!adminComment.isEmpty()) {
			inputToAdminCommentTextAreaToCreateCustomer(adminComment);

		}

	}

	public void inputDataToSearchCustomer(String firstName, String lastName, String companyName, String email, String customerRoles, String dateOfBirth) {
		if (!firstName.isEmpty()) {
			inputToFirstNameTextboxToCreateAndEditAndSearchCustomer(firstName);

		}
		if (!lastName.isEmpty()) {
			inputToLastNameTextboxToCreateAndEditAndSearchCustomer(lastName);

		}
		if (!companyName.isEmpty()) {
			inputCompanyTextboxToSearchCustomer(companyName);

		}
		if (!email.isEmpty()) {
			inputToEmailTextboxToCreateAndSearchCustomer(email);

		}
		if (!customerRoles.isEmpty()) {
			selectToCustomerRolesDropdownToCreateAndSearchCustomer(customerRoles);

		}
		if (!dateOfBirth.isEmpty()) {
			inputDateOfBirthToSearchCustomer(dateOfBirth);

		}

	}

}
