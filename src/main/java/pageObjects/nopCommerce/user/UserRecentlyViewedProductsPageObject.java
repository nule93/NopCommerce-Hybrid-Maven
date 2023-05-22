package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.RecentlyViewedProductsPageUI;

public class UserRecentlyViewedProductsPageObject extends BasePage {
	public UserRecentlyViewedProductsPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible(RecentlyViewedProductsPageUI.DYNAMICPRODUCT_NAME, productName);
		return isElementDisplayed(RecentlyViewedProductsPageUI.DYNAMICPRODUCT_NAME, productName);
	}

	public boolean isProductNameUnDisplayed(String productName) {

		waitForElementInvisible(RecentlyViewedProductsPageUI.DYNAMICPRODUCT_NAME, productName);
		return isElementUndisplayed(RecentlyViewedProductsPageUI.DYNAMICPRODUCT_NAME, productName);

	}
}
