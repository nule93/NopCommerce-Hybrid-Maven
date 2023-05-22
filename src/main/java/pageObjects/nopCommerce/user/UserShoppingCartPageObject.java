package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	public UserShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isShoppingCartTitleDisplayed() {
		waitForElementVisible(UserShoppingCartPageUI.SHOPPING_CART_TITLE);
		return isElementDisplayed(UserShoppingCartPageUI.SHOPPING_CART_TITLE);
	}

	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible(UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayed(UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public String getQuantityOfProduct(String productName) {
		waitForElementVisible(UserShoppingCartPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME, productName);
		return getAttributeValue(UserShoppingCartPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME, "value", productName);
	}

	public UserWishListPageObject clickToWishlistLink() {
		waitForElementClickable(BasePageUI.WISHLIST_LINK);
		clickToElement(BasePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishListPage(driver);
	}

	public UserViewProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitForElementClickable(UserShoppingCartPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(UserShoppingCartPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getUserViewProductDetailPage(driver);

	}

	public String getTotalByProductName(String productName) {
		waitForElementVisible(UserShoppingCartPageUI.DYNAMIC_LABEL_TEXT_BY_PRODUCT_NAME, productName, "subtotal");
		return getTextElement(UserShoppingCartPageUI.DYNAMIC_LABEL_TEXT_BY_PRODUCT_NAME, productName, "subtotal").replace(".00", "");

	}

	public String getAttributeByProductNameAtShoppingCart(String productName) {
		waitForElementVisible(UserShoppingCartPageUI.ATTRIBUTES_BY_PRODUCT_NAME, productName);
		return getTextElement(UserShoppingCartPageUI.ATTRIBUTES_BY_PRODUCT_NAME, productName);
	}

	public void clickToRemoveButtonByProductName(String productName) {
		waitForElementClickable(UserShoppingCartPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(UserShoppingCartPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);

	}

	public String getTextOfShoppingCartEmpty() {
		waitForElementVisible(UserShoppingCartPageUI.CART_EMPTY_MESSAGE);
		return getTextElement(UserShoppingCartPageUI.CART_EMPTY_MESSAGE);
	}

	public boolean isProductNameUndisplayed(String productName) {
		waitForElementInvisible(UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementUndisplayed(UserShoppingCartPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public void inputToQuantityByProductName(String productName, String quantity) {
		waitForElementClickable(UserShoppingCartPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME, productName);
		sendkeyToElement(UserShoppingCartPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME, quantity, productName);

	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(UserShoppingCartPageUI.DYNAMIC_BUTTON, "Update shopping cart");
		clickToElement(UserShoppingCartPageUI.DYNAMIC_BUTTON, "Update shopping cart");

	}

	public void checkToAgreeTearmOfServiceCheckbox() {
		scrollToElement(UserShoppingCartPageUI.TERMS_SERVICE_CHECKBOX);
		waitForElementClickable(UserShoppingCartPageUI.TERMS_SERVICE_CHECKBOX);
		clickToElement(UserShoppingCartPageUI.TERMS_SERVICE_CHECKBOX);

	}

	public UserCheckoutPageObject clickToCheckoutButton() {
		
		scrollToElement(UserShoppingCartPageUI.DYNAMIC_BUTTON, "Checkout");
		waitForElementClickable(UserShoppingCartPageUI.DYNAMIC_BUTTON, "Checkout");
		clickToElement(UserShoppingCartPageUI.DYNAMIC_BUTTON, "Checkout");
		return PageGeneratorManager.getCheckoutPage(driver);

	}

}
