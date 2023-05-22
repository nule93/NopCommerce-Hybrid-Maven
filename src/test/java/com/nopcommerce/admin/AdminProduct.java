package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;

public class AdminProduct extends BaseTest {
	private WebDriver driver;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminProductPageObject adminProductPage;
	private String emailAddress = "admin@yourstore.com";
	private String password = "admin";

	@Parameters({ "browser", "env" })
	@BeforeClass
	public void beforeClass(String browserName, String env) {

		log.info("Open Admin page of NopCommerce");
		driver = openMultipleBrowser(browserName, env);

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Login an account with email and password:" + emailAddress + password);
		adminDashboardPage = adminLoginPage.loginAsAdmin(emailAddress, password);

		log.info("Verify 'Dashboard' title is displayed");
		Assert.assertTrue(adminDashboardPage.isTitleDisplayedAtAdmin("Dashboard"));
	}

	@Test
	public void Product_01_SearchWithProductName() {

		log.info("Product 01 - Step 1: Click to submenu 'Product' at menu 'Category'");
		adminDashboardPage.clickToSubMenuByNameAtAdmin("Catalog", "Products");

		adminProductPage = PageGeneratorManager.getProductPage(driver);

		log.info("Product 01 - Step 2: Verify 'Products' title is displayed");
		Assert.assertTrue(adminProductPage.isTitleDisplayedAtAdmin("Products"));

		log.info("Product 01 - Step 3: Input data for 'Product name' textbox");
		adminProductPage.enterToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Product 01 - Step 4: Click to 'Search' button");
		adminProductPage.clickToSearchButton();

		adminProductPage.verifyUndisplayedLoadingIcon();

		log.info("Product 01 - Step 5: Verify quantity of items is displayed");
		Assert.assertEquals(adminProductPage.getItemQuantityDisplayed(), 1);

		log.info("Product 01 - Step 6: Verify information of product");
		adminProductPage.verifyProductDiplayedWith("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500", "10000", "published");

	}

	@Test
	public void Product_02_SearchWithProductNameAndParentCategoryAndUncheck() {

		log.info("Product 02 - Step 1: Enter data for 'Product name' textbox");
		adminProductPage.enterToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Product 02 - Step 2: Select category 'Computers'");
		adminProductPage.selectToCategoryDropdown("Computers");

		log.info("Product 02 - Step 3: Uncheck 'Search Subcategories' checkbox");
		adminProductPage.unCheckToSearchSubCategoriesCheckbox();

		log.info("Product 02 - Step 4: Click to 'Search' button");
		adminProductPage.clickToSearchButton();

		adminProductPage.verifyUndisplayedLoadingIcon();

		log.info("Product 02 - Step 5: Verify not data is displayed");
		Assert.assertEquals(adminProductPage.getEmptyDataTableMessage(), "No data available in table");
	}

	@Test
	public void Product_03_SearchWithProductNameAndParentCategoryAndCheck() {

		log.info("Product 03 - Step 1: Input data for 'Product name' textbox");
		adminProductPage.enterToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Product 03 - Step 2: Select dropdown 'Category'");
		adminProductPage.selectToCategoryDropdown("Computers");

		log.info("Product 03 - Step 3: Check to 'Search Subcategories' checkbox");
		adminProductPage.checkToSearchSubCategoriesCheckbox();

		log.info("Product 03 - Step 4: Click to 'Search' button");
		adminProductPage.clickToSearchButton();

		adminProductPage.verifyUndisplayedLoadingIcon();

		log.info("Product 03 - Step 5: Verify quantity of items is displayed");
		Assert.assertEquals(adminProductPage.getItemQuantityDisplayed(), 1);

		log.info("Product 03 - Step 6: Verify information of product is displayed");
		adminProductPage.verifyProductDiplayedWith("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500", "10000", "published");

	}

	@Test
	public void Product_04_SearchWithProductNameAndChildCategory() {

		log.info("Product 04 - Step 1: Input data 'Lenovo IdeaCentre 600 All-in-One PC' for 'Product name' textbox");
		adminProductPage.enterToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Product 04 - Step 2: select category 'Computers >> Desktops' in dropdown ");
		adminProductPage.selectToCategoryDropdown("Computers >> Desktops");

		log.info("Product 04 - Step 3: check to 'Search Subcategories' checkbox");
		adminProductPage.checkToSearchSubCategoriesCheckbox();

		log.info("Product 04 - Step 4: Click to 'Search' button");
		adminProductPage.clickToSearchButton();

		adminProductPage.verifyUndisplayedLoadingIcon();

		log.info("Product 04 - Step 5: Verify product's quantity");
		Assert.assertEquals(adminProductPage.getItemQuantityDisplayed(), 1);

		log.info("Product 04 - Step 6: Verify product's info");
		adminProductPage.verifyProductDiplayedWith("Lenovo IdeaCentre 600 All-in-One PC", "LE_IC_600", "500", "10000", "published");

	}

	@Test
	public void Product_05_SearchWithProductNameAndManufacturer() {

		log.info("Product 05 - Step 1: input data 'Lenovo IdeaCentre 600 All-in-One PC' for 'Product name' textbox");
		adminProductPage.enterToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Product 05 - Step 2: select 'All' at Category dropdown");
		adminProductPage.selectToCategoryDropdown("All");

		log.info("Product 05 - Step 3: Uncheck for 'Search Subcategories' checkbox");
		adminProductPage.unCheckToSearchSubCategoriesCheckbox();

		log.info("Product 05 - Step 4: Select 'Manufacturer' dropdown with data 'Apple'");
		adminProductPage.selectToManufacturerDropdown("Apple");

		log.info("Product 05 - Step 5: Click to 'Search' button");
		adminProductPage.clickToSearchButton();

		adminProductPage.verifyUndisplayedLoadingIcon();

		log.info("Product 05 - Step 6: Verify no data is displayed");
		Assert.assertEquals(adminProductPage.getEmptyDataTableMessage(), "No data available in table");

	}

	@Test
	public void Product_06_GoDirectlyToProductSKU() {

		log.info("Product 06 - Step 1: input data for 'Go directly to product SKU'");
		adminProductPage.inputToGoDirectlyToProductAndClickToGoButton("LE_IC_600");

		log.info("Product 06 - Step 2: Verify 'Edit product' screen is displayed");
		Assert.assertTrue(adminProductPage.isTitleDisplayedAtAdmin("Edit product details - Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("Product 06 - Step 3: Verify product name is displayed correctly in the 'Edit product' screen");
		Assert.assertTrue(adminProductPage.isProductNameDisplayedAtEditProductScreen("Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("Product 06 - Step 4: Verify SKU is displayed correctly in the 'Edit product' screen");
		Assert.assertTrue(adminProductPage.isSKUDisplayedAtEditProductScreen("LE_IC_600"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
