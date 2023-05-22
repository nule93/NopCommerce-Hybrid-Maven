package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isChangePasswordTitleDisplayed() {
		waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - Change password");
		return isElementDisplayed(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - Change password");
	}

	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisible( UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);

	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);

	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);

	}

	public void clickToChangePasswordButton() {

		waitForElementClickable(UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getSuccessfulChangedPasswordMessage() {
		waitForElementVisible(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
		return getTextElement(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
	}

	

}
