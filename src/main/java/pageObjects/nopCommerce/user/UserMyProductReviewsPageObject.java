package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserMyProductReviewsPageUI;

public class UserMyProductReviewsPageObject extends BasePage {
	public UserMyProductReviewsPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isMyProductReviewTitleDisplayed() {
		waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - My product reviews");
		return isElementDisplayed(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "My account - My product reviews");
	}

	public String getReviewTitleText() {
		waitForElementVisible(UserMyProductReviewsPageUI.REVIEW_TITLE_TEXT);
		return getTextElement(UserMyProductReviewsPageUI.REVIEW_TITLE_TEXT);
	}

	public String getReviewBodyText() {
		waitForElementVisible(UserMyProductReviewsPageUI.REVIEW_BODY_TEXT);
		return getTextElement(UserMyProductReviewsPageUI.REVIEW_BODY_TEXT);
	}

	public String getActualRating() {
		waitForElementVisible(UserMyProductReviewsPageUI.RATING_STYLE);
		return getAttributeValue(UserMyProductReviewsPageUI.RATING_STYLE, "style");
	}

	public String getReviewedProductName() {
		waitForElementVisible(UserMyProductReviewsPageUI.REVIEW_PRODUCT_NAME_TEXT);
		return getTextElement(UserMyProductReviewsPageUI.REVIEW_PRODUCT_NAME_TEXT);
	}

}
