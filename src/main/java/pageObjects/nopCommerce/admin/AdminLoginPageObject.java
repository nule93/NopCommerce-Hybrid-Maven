package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	public AdminLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public AdminDashboardPageObject loginAsAdmin(String emailAdmin, String passwordAdmin) {
		inputToUsernameTextbox(emailAdmin);
		inputToPasswordTextbox(passwordAdmin);
		return clickToLoginButton();

	}

	public void inputToUsernameTextbox(String username) {
		waitForElementVisible(AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.USERNAME_TEXTBOX, username);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible( AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

}
