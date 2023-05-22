package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserWishListPageObject extends BasePage {
	public UserWishListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private WebDriver driver;

	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible( UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayed(UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public boolean isProductNameUnDisplayed(String productName) {
		waitForElementInvisible(UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementUndisplayed(UserWishlistPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public String getQuantityOfProduct(String productName) {
		waitForElementVisible(UserWishlistPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME, productName);
		return getAttributeValue(UserWishlistPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME, "value", productName);
	}

	public String getQuantityOfProductAfterClickSharingLink(String productName) {
		waitForElementVisible(UserWishlistPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME_AFTER_SHARING_LINK, productName);
		return getTextElement(UserWishlistPageUI.DYNAMIC_QUANTITY_BY_PRODUCT_NAME_AFTER_SHARING_LINK, productName);
	}

	public void clickToYourWishListURLForSharingLink() {
		waitForElementClickable(UserWishlistPageUI.SHARING_LINK);
		clickToElement(UserWishlistPageUI.SHARING_LINK);

	}

	public String getTitleOfWishListPageAfterClickSharingLink() {
		waitForElementVisible(UserWishlistPageUI.TITLE_AFTER_CLICK_SHARING_LINK);
		return getTextElement(UserWishlistPageUI.TITLE_AFTER_CLICK_SHARING_LINK);

	}

	public void clickToCheckBoxByProductName(String productName) {
		waitForElementClickable(UserWishlistPageUI.DYNAMIC_CHECKBOX_BY_PRODUCT_NAME, productName);
		clickToElement(UserWishlistPageUI.DYNAMIC_CHECKBOX_BY_PRODUCT_NAME, productName);

	}

	public void clickToAddToCartButton() {
		waitForElementClickable(UserWishlistPageUI.DYNAMIC_BUTTON, "Add to cart");
		clickToElement(UserWishlistPageUI.DYNAMIC_BUTTON, "Add to cart");

	}

	public void clickToRemoveButtonByProductName(String productName) {
		waitForElementClickable(UserWishlistPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(UserWishlistPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);

	}

	public String getTextOfWishlistEmpty() {
		waitForElementVisible(UserWishlistPageUI.WISHLIST_EMPTY_TEXT);
		return getTextElement(UserWishlistPageUI.WISHLIST_EMPTY_TEXT);
	}

}
