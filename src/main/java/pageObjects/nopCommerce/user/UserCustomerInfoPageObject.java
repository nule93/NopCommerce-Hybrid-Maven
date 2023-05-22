package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {

	public UserCustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isCustomerInfoDisplayed() {

		waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - Customer info");
		return isElementDisplayed(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - Customer info");
	}

	public UserOrdersPageObject openOrdersPage() {
		clickToOrdersPageAtUserPage();
		return PageGeneratorManager.getUserOrdersPageObject(driver);
	}

	public void selectToGender(String gender) {
		waitForElementVisible(UserCustomerInfoPageUI.FEMALE_RADIO);
		waitForElementVisible(UserCustomerInfoPageUI.MALE_RADIO);
		if (gender.equalsIgnoreCase("Male")) {
			clickToElement(UserCustomerInfoPageUI.MALE_RADIO);
		} else {
			clickToElement(UserCustomerInfoPageUI.FEMALE_RADIO);

		}

	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void selectToDayOfBirth(String day) {
		waitForElementVisible(UserCustomerInfoPageUI.DAY_OF_BIRTH_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserCustomerInfoPageUI.DAY_OF_BIRTH_DROPDOWNLIST, day);

	}

	public void selectToMonthOfBirth(String month) {
		waitForElementVisible(UserCustomerInfoPageUI.MONTH_OF_BIRTH_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserCustomerInfoPageUI.MONTH_OF_BIRTH_DROPDOWNLIST, month);

	}

	public void selectToYearOfBirth(String year) {
		waitForElementVisible(UserCustomerInfoPageUI.YEAR_OF_BIRTH_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserCustomerInfoPageUI.YEAR_OF_BIRTH_DROPDOWNLIST, year);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(UserCustomerInfoPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(UserCustomerInfoPageUI.COMPANY_TEXTBOX, company);

	}

	public void clickToSaveButton() {
		waitForElementVisible(UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(UserCustomerInfoPageUI.SAVE_BUTTON);

	}

	public String getUpdateSuccessfulMessage() {
		waitForElementVisible(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
		return getTextElement( BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
	}

	public String getCompany() {
		return getAttributeValue(UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getEmail() {
		return getAttributeValue(UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getYearOfBirth() {
		return getAttributeValue(UserCustomerInfoPageUI.YEAR_OF_BIRTH_DROPDOWNLIST, "value");
	}

	public String getMonthOfBirth() {

		String month = getAttributeValue(UserCustomerInfoPageUI.MONTH_OF_BIRTH_DROPDOWNLIST, "value");
		switch (month) {
		case "1":
			month = "January";
			break;
		case "2":
			month = "Febrary";
			break;
		case "3":
			month = "March";
			break;
		case "4":
			month = "April";
			break;
		case "5":
			month = "May";
			break;
		case "6":
			month = "June";
			break;
		case "7":
			month = "July";
			break;
		case "8":
			month = "August";
			break;
		case "9":
			month = "September";
			break;
		case "10":
			month = "October";
			break;
		case "11":
			month = "November";
		case "12":
			month = "December";
		default:
			System.out.println("Please choose a valid month");
		}
		return month;

	}

	public String getDayOfBirth() {
		return getAttributeValue(UserCustomerInfoPageUI.DAY_OF_BIRTH_DROPDOWNLIST, "value");

	}

	public String getLastName() {

		return getAttributeValue(UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getFirstName() {
		return getAttributeValue(UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");

	}

	public boolean isSelected(String gender) {
		if (gender.equalsIgnoreCase("Male")) {
			return isElementSelected(UserCustomerInfoPageUI.MALE_RADIO);

		} else {
			return isElementSelected( UserCustomerInfoPageUI.FEMALE_RADIO);
		}
	}

	public boolean isCloseButtonDisplay() {
		waitForElementInvisible(UserCustomerInfoPageUI.CLOSE_BUTTON);
		return isElementDisplayed(UserCustomerInfoPageUI.CLOSE_BUTTON);
	}

}
