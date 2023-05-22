package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserComparisonPageUI;

public class UserComparisonPageObject extends BasePage {
	public UserComparisonPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isClearListButtonDisplayed() {
		waitForElementClickable(UserComparisonPageUI.CLEAR_LIST_BUTTON);
		return isElementDisplayed(UserComparisonPageUI.CLEAR_LIST_BUTTON);

	}

	public boolean isRemoveButtonDisplayedByName(String productName) {
		int productIndex = getElementsSize(UserComparisonPageUI.DYNAMIC_INDEX_BY_PRODUCT_NAME, productName) + 1;
		waitForElementClickable(UserComparisonPageUI.DYNAMIC_REMOVE_BUTTON, String.valueOf(productIndex));
		return isElementDisplayed(UserComparisonPageUI.DYNAMIC_REMOVE_BUTTON, String.valueOf(productIndex));
	
	}



	public String getProductPriceByProductName(String productName) {
		int productIndex = getElementsSize(UserComparisonPageUI.DYNAMIC_INDEX_BY_PRODUCT_NAME, productName) + 1;
		String productPrice = getTextElement(UserComparisonPageUI.DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME, String.valueOf(productIndex)).replace("From", "").replace(".00", "").replace(" ", "");
		return productPrice;
	}

	public void clickToClearListButton() {
		waitForElementClickable(UserComparisonPageUI.CLEAR_LIST_BUTTON);
		clickToElement(UserComparisonPageUI.CLEAR_LIST_BUTTON);
		sleepInSecond(1);

	}

	public String getDeletedProductMessage() {
		waitForElementVisible(UserComparisonPageUI.DELETED_ALL_PRODUCTS_TEXT);
		return getTextElement(UserComparisonPageUI.DELETED_ALL_PRODUCTS_TEXT);
	
	}

	public boolean isProductNameUnDisplayed(String productName) {
		waitForElementInvisible(UserComparisonPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isElementUndisplayed(UserComparisonPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

}
