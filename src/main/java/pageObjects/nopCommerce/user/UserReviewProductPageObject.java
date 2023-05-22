package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserReviewProductPageUI;

public class UserReviewProductPageObject extends BasePage {

	public UserReviewProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public String getReviewTitle() {
		waitForElementVisible(UserReviewProductPageUI.PAGE_TITLE_TEXT);
		return getTextElement(UserReviewProductPageUI.PAGE_TITLE_TEXT);

	}

	public void inputToReviewTitleTextbox(String title) {
		waitForElementVisible(UserReviewProductPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(UserReviewProductPageUI.REVIEW_TITLE_TEXTBOX, title);

	}

	public void inputToReviewBodyTextArea(String body) {
		waitForElementVisible(UserReviewProductPageUI.REVIEW_BODY_TEXTAREA);
		sendkeyToElement(UserReviewProductPageUI.REVIEW_BODY_TEXTAREA, body);

	}

	public void selectToRatingRadio(int rating) {
		waitForElementVisible(UserReviewProductPageUI.REVIEW_RATING_RADIO, String.valueOf(rating));
		clickToElement(UserReviewProductPageUI.REVIEW_RATING_RADIO, String.valueOf(rating));
	}

	public void clickToSubmitReviewButton() {
		waitForElementVisible(UserReviewProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(UserReviewProductPageUI.SUBMIT_REVIEW_BUTTON);

	}

	public String getSuccessfulReviewedMessage() {
		waitForElementVisible(UserReviewProductPageUI.SUBMIT_RESULT_TEXT);
		return getTextElement(UserReviewProductPageUI.SUBMIT_RESULT_TEXT);
	}

	public String getReviewTitleText() {
		waitForElementVisible(UserReviewProductPageUI.REVIEW_TITLE_TEXT);
		return getTextElement(UserReviewProductPageUI.REVIEW_TITLE_TEXT);
	}

	public String getReviewBodyText() {
		waitForElementVisible(UserReviewProductPageUI.REVIEW_BODY_TEXT);
		return getTextElement(UserReviewProductPageUI.REVIEW_BODY_TEXT);
	}

	public String getActualRating() {
		waitForElementVisible(UserReviewProductPageUI.RATING_SUBMITED);
		return getAttributeValue(UserReviewProductPageUI.RATING_SUBMITED, "style");
	}

	public String getExpectedRating(int ratingNumber) {
		String styleRating = null;
		switch (ratingNumber) {
		case 1:
			styleRating = "width: 20%;";
			break;
		case 2:
			styleRating = "width: 40%;";
			break;
		case 3:
			styleRating = "width: 60%;";
			break;
		case 4:
			styleRating = "width: 80%;";
			break;
		case 5:
			styleRating = "width: 100%;";
			break;
		}
		return styleRating;

	}
}
