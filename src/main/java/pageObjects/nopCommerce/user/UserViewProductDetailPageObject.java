package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserViewProductDetailPageUI;

public class UserViewProductDetailPageObject extends BasePage {
	public UserViewProductDetailPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public UserReviewProductPageObject clickToAddYourReviewLink() {
		waitForElementVisible(UserViewProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(UserViewProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getUserReviewProductPage(driver);
	}

	public void clickToAddToWishListButton() {
		waitForElementClickable(UserViewProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON, "Add to wishlist");
		clickToElement(UserViewProductDetailPageUI.DYNAMIC_OVERVIEW_BUTTON, "Add to wishlist");

	}

	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible(UserViewProductDetailPageUI.DYNAMIC_PRODUCT_NAME_TITLE, productName);
		return isElementDisplayed(UserViewProductDetailPageUI.DYNAMIC_PRODUCT_NAME_TITLE, productName);
	}

	public String getSuccessAddedToWishListMessage() {
		waitForElementVisible(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
		return getTextElement(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
	}

	public void clickToWishListLink() {
		waitForElementClickable(BasePageUI.WISHLIST_LINK);
		clickToElement(BasePageUI.WISHLIST_LINK);

	}

	public void clickToRecentlyViewedProducts() {
		waitForElementClickable(BasePageUI.USER_DYNAMIC_PAGE_FOOTER, "Recently viewed products");
		clickToElement(BasePageUI.USER_DYNAMIC_PAGE_FOOTER, "Recently viewed products");

	}

	public void chooseProcessorDropdown(String processorName) {

		scrollToElement(UserViewProductDetailPageUI.DYNAMIC_LABEL_NAME, "Processor");

		String index = indexOfDropdownByLabelName("Processor");

		selectItemInDefaultDropdown(UserViewProductDetailPageUI.DYNAMIC_DROPDOWN, processorName, index);

	}

	public String indexOfDropdownByLabelName(String labelName) {
		int size = getElementsSize(UserViewProductDetailPageUI.DYNAMIC_PRECEDING_SIBLING_OF_LABEL_TEXT_IN_DROPDOWN_RADIO_BUTTON, labelName) + 1;
		return String.valueOf(size);
	}

	public void chooseRamDropdown(String ramName) {

		String index = indexOfDropdownByLabelName("RAM");

		scrollToElement(UserViewProductDetailPageUI.DYNAMIC_LABEL_NAME, "RAM");

		selectItemInDefaultDropdown(UserViewProductDetailPageUI.DYNAMIC_DROPDOWN, ramName, index);

	}

	public void chooseHDDRadioButton(String HDDName) {
		String index = indexOfDropdownByLabelName("HDD");
		scrollToElement(UserViewProductDetailPageUI.DYNAMIC_LABEL_NAME, "HDD");
		clickToElement(UserViewProductDetailPageUI.DYNAMIC_CHECKBOX_RADIO_BUTTON_BY_LABEL_NAME, index, HDDName);
	}

	public void chooseOSRadionButton(String OSName) {
		String index = indexOfDropdownByLabelName("OS");
		scrollToElement(UserViewProductDetailPageUI.DYNAMIC_LABEL_NAME, "OS");
		clickToElement(UserViewProductDetailPageUI.DYNAMIC_CHECKBOX_RADIO_BUTTON_BY_LABEL_NAME, index, OSName);

	}

	public void checkToSoftware(String softwareName) {
		String index = indexOfDropdownByLabelName("Software");
		scrollToElement(UserViewProductDetailPageUI.DYNAMIC_LABEL_NAME, "Software");
		if (!isElementSelected(UserViewProductDetailPageUI.DYNAMIC_CHECKBOX_RADIO_BUTTON_BY_LABEL_NAME, index, softwareName)) {
			clickToElement(UserViewProductDetailPageUI.DYNAMIC_CHECKBOX_RADIO_BUTTON_BY_LABEL_NAME, index, softwareName);
		}
	}

	public void clickToAddToCart() {
		scrollToElement(UserViewProductDetailPageUI.DYNAMIC_BUTTON, "Add to cart");
		waitForElementClickable(UserViewProductDetailPageUI.DYNAMIC_BUTTON, "Add to cart");

		clickToElement(UserViewProductDetailPageUI.DYNAMIC_BUTTON, "Add to cart");

	}

	public String getSuccessAddedToCartMessage() {
		waitForElementVisible(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);
		return getTextElement(BasePageUI.DYNAMIC_SUCCESSFUL_NOTIFY_MESSAGE);

	}

	public String getIndexOfShoppingCart() {
		String index = getTextElement(BasePageUI.SHOPPING_CART_ICON).replace("Shopping cart", "").replace("(", "").replace(")", "").replace(" ", "");
		return index;
	}

	public boolean isProductNameDiplayedAtShoppingCartIcon(String productName) {
		waitForElementVisible(BasePageUI.PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName);
		return isElementDisplayed(BasePageUI.PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName);

	}

	public String getTextAboutProductQuantityInShoppingCartIcon() {
		waitForElementVisible(BasePageUI.PRODUCT_NUMBER_IN_SHOPPING_CART_ICON);
		return getTextElement(BasePageUI.PRODUCT_NUMBER_IN_SHOPPING_CART_ICON);
	}

	public String getAttributeByProductNameAtShoppingCartIcon(String productName) {
		waitForElementVisible(BasePageUI.DYNAMIC_FIELD_BY_PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName, "attributes");
		return getTextElement(BasePageUI.DYNAMIC_FIELD_BY_PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName, "attributes");
	}

	public String getProductPriceByProductNameAtShoppingCartIcon(String productName) {
		waitForElementVisible(BasePageUI.DYNAMIC_FIELD_BY_PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName, "price");
		return getTextElement(BasePageUI.DYNAMIC_FIELD_BY_PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName, "price").replace("Unit price: ", "").replace(".00", "").replace(" ", "");

	}

	public String getProductQuantityByProductNameAtShoppingCartIcon(String productName) {
		waitForElementVisible(BasePageUI.DYNAMIC_FIELD_BY_PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName, "quantity");
		return getTextElement(BasePageUI.DYNAMIC_FIELD_BY_PRODUCT_NAME_IN_SHOPPING_CART_ICON, productName, "quantity").replace("Quantity: ", "").replace(".00", "").replace(" ", "");

	}

	public String getSubTotalAtShoppingCartIcon() {
		waitForElementVisible(BasePageUI.SUB_TOTAL_IN_SHOPPING_CART_ICON);
		return getTextElement(BasePageUI.SUB_TOTAL_IN_SHOPPING_CART_ICON).replace("Sub-Total: ", "").replace(" ", "").replace(".00", "");
	}

	public void clickToGoToCartButtonAtShoppingCartIcon() {
		waitForElementClickable(BasePageUI.GO_TO_CART_BUTTON_IN_SHOPPING_CART_ICON);
		clickToElement(BasePageUI.GO_TO_CART_BUTTON_IN_SHOPPING_CART_ICON);

	}

	public void unCheckToSoftware(String softwareName) {
		String index = indexOfDropdownByLabelName("Software");
		if (isElementSelected(UserViewProductDetailPageUI.DYNAMIC_CHECKBOX_RADIO_BUTTON_BY_LABEL_NAME, index, softwareName)) {
			clickToElement(UserViewProductDetailPageUI.DYNAMIC_CHECKBOX_RADIO_BUTTON_BY_LABEL_NAME, index, softwareName);
		}

	}

	public String getProductPrice() {
		waitForElementVisible(UserViewProductDetailPageUI.PRODUCT_PRICE);
		return getTextElement(UserViewProductDetailPageUI.PRODUCT_PRICE).replace(".00", "").replace(" ", "");
	}

	public void inputToProductQuantity(String quantity) {
		waitForElementVisible(UserViewProductDetailPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(UserViewProductDetailPageUI.QUANTITY_TEXTBOX, quantity);

	}

	public void clickToUpdateButton() {
		waitForElementClickable(UserViewProductDetailPageUI.DYNAMIC_BUTTON, "Update");
		clickToElement(UserViewProductDetailPageUI.DYNAMIC_BUTTON, "Update");

	}

	public void hoverMouseToShoppingCartIcon() {
		scrollToElement(BasePageUI.SHOPPING_CART_ICON);
		hoverMouseToElement(BasePageUI.SHOPPING_CART_ICON);

	}

}
