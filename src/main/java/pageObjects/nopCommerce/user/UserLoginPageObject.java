package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {

	public UserLoginPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	private WebDriver driver;

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(UserLoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(UserLoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getUnsuccessfulErrorMessage() {
		waitForElementVisible(UserLoginPageUI.UNSUCCESS_LOGIN_ERRO_MESSAGE);
		return getTextElement(UserLoginPageUI.UNSUCCESS_LOGIN_ERRO_MESSAGE);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

	public void checkToSwitchToLoginPage(String email, String password) {
		try {
			loginAsUser(email, password);
/*			 shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
			 shoppingCartPage.checkToAgreeTearmOfServiceCheckbox();
			 checkoutPage = shoppingCartPage.clickToCheckoutButton();*/

		}catch(Exception e) {
			throw new RuntimeException("Don't display Login screen.");
		}
		
	}

}
