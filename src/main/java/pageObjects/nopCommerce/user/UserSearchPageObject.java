package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	public UserSearchPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isSearchTitleDisplay() {
		waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "Search");
		return isElementDisplayed(BasePageUI.USER_DYNAMIC_PAGE_HEADER, "Search");

	}

	public void inputToSearchTextbox(String keywords) {
		waitForElementVisible(UserSearchPageUI.USER_SEARCH_KEYWORDS_TEXTBOX);
		sendkeyToElement(UserSearchPageUI.USER_SEARCH_KEYWORDS_TEXTBOX, keywords);

	}

	public String getErrorMessage() {
		waitForElementVisible(UserSearchPageUI.ERROR_MESSAGE);
		return getTextElement(UserSearchPageUI.ERROR_MESSAGE);
	}

	public void clickToSearchButton() {
		waitForElementVisible(UserSearchPageUI.USER_SEARCH_BUTTON);
		clickToElement(UserSearchPageUI.USER_SEARCH_BUTTON);

	}

	public int getDisplayedProductQuantity() {
		waitForElementVisible(UserSearchPageUI.PRODUCT_NAME_TEXT);
		return getElementsSize(UserSearchPageUI.PRODUCT_NAME_TEXT);
	}

	public String getProductNameDisplayed(String productName) {
		waitForAllElementsVisible(UserSearchPageUI.PRODUCT_NAME_TEXT);
		List<WebElement> list = getElements(UserSearchPageUI.PRODUCT_NAME_TEXT);
        String product = null;
		for (WebElement element : list) {
			if (element.getText().equals(productName)) {
				product = productName;
				break;
			}
		}
		return product;
	}
	


	public void clickToAdvancedSearchCheckbox() {
		waitForElementVisible(UserSearchPageUI.USER_ADVANCED_SEARCH_CHECKBOX);
		checkTheCheckboxOrRadio(UserSearchPageUI.USER_ADVANCED_SEARCH_CHECKBOX);

	}

	public void selectToCategory(String category) {
		waitForElementVisible(UserSearchPageUI.USER_SELECT_CATEGORY_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserSearchPageUI.USER_SELECT_CATEGORY_DROPDOWNLIST, category);
		Assert.assertEquals(getSelectedItemInDropdown(UserSearchPageUI.USER_SELECT_CATEGORY_DROPDOWNLIST).getText(), category);
	}

	public void clickToAutomaticallySearchSubCategoriesCheckbox() {
		waitForElementVisible(UserSearchPageUI.USER_AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
		checkTheCheckboxOrRadio(UserSearchPageUI.USER_AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);

	}

	public void selectToManufacterer(String category) {
		waitForElementVisible(UserSearchPageUI.USER_SELECT_MANUFACTURER_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserSearchPageUI.USER_SELECT_MANUFACTURER_DROPDOWNLIST, category);
		Assert.assertEquals(getSelectedItemInDropdown(UserSearchPageUI.USER_SELECT_MANUFACTURER_DROPDOWNLIST).getText(), category);

	}

}
