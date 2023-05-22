package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {

	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(UserHomePageUI.REGISTER_LINK);
		clickToElement(UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(UserHomePageUI.LOGIN_LINK);
		clickToElementByJS(UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountDisplayed() {
		waitForElementVisible(UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public UserViewProductDetailPageObject clickToProductName(String productName) {
		waitForElementVisible(UserHomePageUI.PRODUCT_NAME_DYNAMIC_LINK, productName);
		clickToElement(UserHomePageUI.PRODUCT_NAME_DYNAMIC_LINK, productName);
		return PageGeneratorManager.getUserViewProductDetailPage(driver);
	}

	public boolean isCategoryTitleDisplayed(String categoryName) {
		waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_HEADER, categoryName);
		return isElementDisplayed(BasePageUI.USER_DYNAMIC_PAGE_HEADER, categoryName);
	}

	public void selectToSortBy(String condition) {
		waitForElementVisible(UserHomePageUI.SORT_BY_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserHomePageUI.SORT_BY_DROPDOWNLIST, condition);

	}

	public void verifyProductsSortedBy(String condition) {

		waitForElementPresence(UserHomePageUI.AJAX_LOADING);

		waitForAllElementsVisible(UserHomePageUI.PRODUCT_NAME_LIST);

		List<WebElement> productNameList = getElements(UserHomePageUI.PRODUCT_NAME_LIST);

		ArrayList<String> productNameArrayList = new ArrayList<String>();

		for (WebElement element : productNameList) {
			productNameArrayList.add(element.getText());
		}

		ArrayList<String> sortProductNameList = new ArrayList<String>();
		for (String name : productNameArrayList) {
			sortProductNameList.add(name);
		}

		ArrayList<Float> priceArrayList = new ArrayList<Float>();
		List<WebElement> priceList = getElements(UserHomePageUI.PRODUC_PRICE_LIST);
		for (WebElement element : priceList) {
			priceArrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
		}
		System.out.println(priceArrayList);
		ArrayList<Float> sortPriceList = new ArrayList<Float>();
		for (Float price : priceArrayList) {
			sortPriceList.add(price);
		}

		switch (condition) {
		case "Name: A to Z":
			Collections.sort(sortProductNameList);

			Assert.assertTrue(sortProductNameList.equals(productNameArrayList));
			break;

		case "Name: Z to A":
			Collections.sort(sortProductNameList);
			Collections.reverse(sortProductNameList);
			Assert.assertTrue(sortProductNameList.equals(productNameArrayList));
			break;
		case "Price: Low to High":
			Collections.sort(sortPriceList);
			Assert.assertTrue(sortPriceList.equals(priceArrayList));
			break;

		case "Price: High to Low":
			Collections.sort(sortPriceList);
			Collections.reverse(sortPriceList);
			Assert.assertTrue(sortPriceList.equals(priceArrayList));
			break;
		}
	}

	public void selectToDisplayPerPage(String quantity) {
		waitForElementVisible(UserHomePageUI.USER_PER_PAGE_DROPDOWNLIST);
		selectItemInDefaultDropdown(UserHomePageUI.USER_PER_PAGE_DROPDOWNLIST, quantity);
		waitForElementPresence(UserHomePageUI.AJAX_LOADING);

	}

	public void verifyPerPage(int quantityPerPage) {
		if (getElementsSize(UserHomePageUI.PER_PAGE) > 0) {

			Assert.assertTrue(isElementDisplayed(UserHomePageUI.NEXT_PAGE_BUTTON));
			clickToElement(UserHomePageUI.NEXT_PAGE_BUTTON);
			waitForElementPresence(UserHomePageUI.AJAX_LOADING);
			if (getElementsSize(UserHomePageUI.PRODUCT_NAME_LIST) > quantityPerPage) {
				Assert.assertTrue(false);
			}
			Assert.assertTrue(isElementDisplayed(UserHomePageUI.PREVIOUS_PAGE_BUTTON));



		} else {
			int productQuantity = getElementsSize(UserHomePageUI.PRODUCT_NAME_LIST);
			if (productQuantity > quantityPerPage) {
				Assert.assertTrue(false);
			}

		}

	}

	public void clickToAddToCompareListButtonByProductName(String productName) {
		waitForElementClickable(UserHomePageUI.DYNAMIC_BUTTON_BY_PRODUCT_NAME, productName, "Add to compare list");
		clickToElement(UserHomePageUI.DYNAMIC_BUTTON_BY_PRODUCT_NAME, productName, "Add to compare list");

	}

	public String getAddedToCompareListSuccessMessage() {
		waitForElementVisible(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
		return getTextElement(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);

	}

	public UserComparisonPageObject clickToProductComparisonLink() {
		waitForElementClickable(UserHomePageUI.COMPARE_LINK);
		clickToElement(UserHomePageUI.COMPARE_LINK);
		return PageGeneratorManager.getComparisonPage(driver);
	}

}
