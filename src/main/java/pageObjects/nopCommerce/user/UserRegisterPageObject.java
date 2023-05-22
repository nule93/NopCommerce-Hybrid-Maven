package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {

	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserHomePageObject clickToRegisterButton() {
		waitForElementClickable(UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(UserRegisterPageUI.REGISTER_LINK);
		clickToElement(UserRegisterPageUI.REGISTER_LINK);

	}


	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}


	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}


	public void inputToEmailTextbox(String email) {
		waitForElementVisible(UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(UserRegisterPageUI.EMAIL_TEXTBOX, email);

	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(UserRegisterPageUI.PASSWORD_TEXTBOX, password);

	}


	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);

	}


	public String getSuccessRegisterMessage() {
		waitForElementVisible(UserRegisterPageUI.SUCCESS_REGISTER_MESSAGE);
		return getTextElement(UserRegisterPageUI.SUCCESS_REGISTER_MESSAGE);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getFirstConfirmPasswordErrorMessage() {
		waitForElementVisible(UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextElement(UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getTextElement(UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextElement(UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(UserRegisterPageUI.LOGOUT_LINK);
	}

	public String getExistEmailErrorMessage() {
		waitForElementVisible(UserRegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
		return getTextElement(UserRegisterPageUI.EXIST_EMAIL_ERROR_MESSAGE);
	}

	public UserHomePageObject registerAnAccount(String firstname, String lastname, String emailAddress, String password) {
		inputToFirstNameTextbox(firstname);
		inputToLastNameTextbox(lastname);
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		inputToConfirmPasswordTextbox(password);
		return clickToRegisterButton();
	}

}
