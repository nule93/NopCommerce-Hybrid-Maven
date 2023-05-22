package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminProductPageUI;

public class AdminProductPageObject extends BasePage {
	public AdminProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);

	}

	public void clickToSearchButton() {
		waitForElementClickable(AdminProductPageUI.SEARCH_BUTTON);
		highlightElement(AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(AdminProductPageUI.SEARCH_BUTTON);

	}

	public void verifyProductDiplayedWith(String productName, String SKU, String price, String stockQuantity, String published) {

		String actualProductName = getProductNameInProductListTableAtRow("1");
		Assert.assertEquals(actualProductName, productName);

		String actualSKU = getSKUInProductListTableAtRow("1");
		Assert.assertEquals(actualSKU, SKU);

		String actualPrice = getPriceInProductListTableAtRow("1");
		Assert.assertEquals(actualPrice, price);

		String actualStockQuantity = getStockQuantityInProductListTableAtRow("1");
		Assert.assertEquals(actualStockQuantity, stockQuantity);

		String actualPublished = getStatusPublishedOfProductInProductListTableAtRow("1");
		Assert.assertEquals(actualPublished, published);

	}

	public String getProductNameInProductListTableAtRow(String indexRow) {
		String indexProductName = indexByLabelNameInRow("Product name");
		String actualProductName = getTextElement(AdminProductPageUI.DYNAMIC_VALUE_BY_INDEX_ROW_AND_INDEX_COLUMN, indexRow, indexProductName);
		return actualProductName;
	}

	public String indexByLabelNameInRow(String labelName) {
		int index = getElementsSize(AdminProductPageUI.DYNAMIC_PRECEDING_SIBLING_BY_LABEL_NAME, labelName) + 1;
		return String.valueOf(index);
	}

	public String getSKUInProductListTableAtRow(String indexRow) {

		String indexSKU = indexByLabelNameInRow("SKU");
		String actualSKU = getTextElement(AdminProductPageUI.DYNAMIC_VALUE_BY_INDEX_ROW_AND_INDEX_COLUMN, indexRow, indexSKU);
		return actualSKU;
	}

	public String getPriceInProductListTableAtRow(String indexRow) {
		String indexPrice = indexByLabelNameInRow("Price");
		String actuaPrice = getTextElement(AdminProductPageUI.DYNAMIC_VALUE_BY_INDEX_ROW_AND_INDEX_COLUMN, indexRow, indexPrice);
		return actuaPrice;
	}

	public String getStockQuantityInProductListTableAtRow(String indexRow) {
		String indexStockQuantity = indexByLabelNameInRow("Stock quantity");
		String actualStockQuantity = getTextElement(AdminProductPageUI.DYNAMIC_VALUE_BY_INDEX_ROW_AND_INDEX_COLUMN, indexRow, indexStockQuantity);
		return actualStockQuantity;
	}

	public String getStatusPublishedOfProductInProductListTableAtRow(String indexRow) {
		String indexPublished = indexByLabelNameInRow("Published");
		String xpathPublishedByIndexRow = String.format(AdminProductPageUI.DYNAMIC_VALUE_BY_INDEX_ROW_AND_INDEX_COLUMN, indexRow, indexPublished) + "/i";
		String actualActive = getAttributeValue(xpathPublishedByIndexRow, "nop-value");
		if (actualActive.equals("true")) {
			actualActive = "published";
		}
		return actualActive;
	}

	public int getItemQuantityDisplayed() {
		waitForAllElementsVisible(AdminProductPageUI.QUANTITY_PRODUCT_IN_TABLE);
		return getElementsSize(AdminProductPageUI.QUANTITY_PRODUCT_IN_TABLE);
	}

	public void selectToCategoryDropdown(String categoryName) {
		waitForElementVisible(AdminProductPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(AdminProductPageUI.CATEGORY_DROPDOWN, categoryName);

	}

	public void unCheckToSearchSubCategoriesCheckbox() {
		waitForElementClickable(AdminProductPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
		uncheckTheCheckbox(AdminProductPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);

	}

	public String getEmptyDataTableMessage() {
		waitForElementVisible(AdminProductPageUI.EMPTY_DATA_MESSAGE);
		return getTextElement(AdminProductPageUI.EMPTY_DATA_MESSAGE);
	}

	public void checkToSearchSubCategoriesCheckbox() {
		waitForElementClickable(AdminProductPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
		checkTheCheckboxOrRadio(AdminProductPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);

	}

	public void selectToManufacturerDropdown(String manufacturerName) {
		waitForElementVisible(AdminProductPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdown(AdminProductPageUI.MANUFACTURER_DROPDOWN, manufacturerName);

	}

	public void inputToGoDirectlyToProductAndClickToGoButton(String goDirectlyToProductName) {
		waitForElementVisible(AdminProductPageUI.GO_DIRECTLY_TO_PRODUCT_TEXTBOX);
		sendkeyToElement(AdminProductPageUI.GO_DIRECTLY_TO_PRODUCT_TEXTBOX, goDirectlyToProductName);

		waitForElementClickable(AdminProductPageUI.GO_BUTTON);
		clickToElement(AdminProductPageUI.GO_BUTTON);
	}

	public boolean isProductNameDisplayedAtEditProductScreen(String productName) {
		if (!isElementDisplayed(AdminProductPageUI.PRODUCT_NAME_IN_EDIT_PRODUCT_SCREEN, productName)) {
			clickToElement(AdminProductPageUI.PRODUCT_INFO_BLOCK_IN_EDIT_PRODUCT_SCREEN);
		}

		return isElementDisplayed(AdminProductPageUI.PRODUCT_NAME_IN_EDIT_PRODUCT_SCREEN, productName);

	}

	public boolean isSKUDisplayedAtEditProductScreen(String sku) {

		return isElementDisplayed(AdminProductPageUI.SKU_IN_EDIT_PRODUCT_SCREEN, sku);
	}


}
