package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserViewProductDetailPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class User_Order extends BaseTest {
	private WebDriver driver;
	UserLoginPageObject loginPage;
	private UserHomePageObject homePage;
	private UserViewProductDetailPageObject userViewProductDetailPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserCheckoutPageObject checkoutPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrdersPageObject orderPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = openMultipleBrowser(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.setCookie(Common_01_Register_Cookie.LoggedCookie);

		loginPage.refreshPage();

		homePage = PageGeneratorManager.getUserHomePage(driver);

		homePage.clickToCloseButtonOnNotifyBar();

		Assert.assertTrue(homePage.isMyAccountDisplayed());

	}

	@Test
	public void Order_01_AddProductToCart(Method method) {

		ExtentTestManager.startTest(method.getName(), "Order-Add Product To Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Order - Add Product To Cart - Step 01: Navigate to 'Computers>Desktop' page");

		homePage.clickToSubMenuByName("Computers", "Desktops");

		userViewProductDetailPage = homePage.clickToProductName("Build your own computer");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Build your own computer"));

		userViewProductDetailPage.chooseProcessorDropdown("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		userViewProductDetailPage.chooseRamDropdown("8GB [+$60.00]");

		userViewProductDetailPage.chooseHDDRadioButton("400 GB [+$100.00]");

		userViewProductDetailPage.chooseOSRadionButton("Vista Home [+$50.00]");

		userViewProductDetailPage.checkToSoftware("Microsoft Office [+$50.00]");
		userViewProductDetailPage.checkToSoftware("Acrobat Reader [+$10.00]");
		userViewProductDetailPage.checkToSoftware("Total Commander [+$5.00]");

		userViewProductDetailPage.clickToAddToCart();

		verifyEquals(userViewProductDetailPage.getSuccessAddedToCartMessage(), "The product has been added to your shopping cart");

		userViewProductDetailPage.clickToCloseButtonOnNotifyBar();

		verifyEquals(userViewProductDetailPage.getIndexOfShoppingCart(), "1");

		userViewProductDetailPage.hoverMouseToShoppingCartIcon();

		verifyEquals(userViewProductDetailPage.getTextAboutProductQuantityInShoppingCartIcon(), "There are 1 item(s) in your cart.");

		verifyTrue(userViewProductDetailPage.isProductNameDiplayedAtShoppingCartIcon("Build your own computer"));

		Assert.assertEquals(userViewProductDetailPage.getAttributeByProductNameAtShoppingCartIcon("Build your own computer"),
				"Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\nRAM: 8GB [+$60.00]\nHDD: 400 GB [+$100.00]\nOS: Vista Home [+$50.00]\nSoftware: Microsoft Office [+$50.00]\nSoftware: Acrobat Reader [+$10.00]\nSoftware: Total Commander [+$5.00]");

		verifyEquals(userViewProductDetailPage.getProductPriceByProductNameAtShoppingCartIcon("Build your own computer"), "$1,490");

		verifyEquals(userViewProductDetailPage.getProductQuantityByProductNameAtShoppingCartIcon("Build your own computer"), "1");

		Assert.assertEquals(userViewProductDetailPage.getSubTotalAtShoppingCartIcon(), "$1,490");
	}

	@Test
	public void Order_02_EditProductInShoppingCart(Method method) {

		ExtentTestManager.startTest(method.getName(), "Order-Edit Product In Shopping Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Order - Add Product To Cart - Step 01: Click 'Cart'");

		userViewProductDetailPage.clickToGoToCartButtonAtShoppingCartIcon();

		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		userViewProductDetailPage = shoppingCartPage.clickToEditButtonByProductName("Build your own computer");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Build your own computer"));

		userViewProductDetailPage.chooseProcessorDropdown("2.2 GHz Intel Pentium Dual-Core E2200");

		userViewProductDetailPage.chooseRamDropdown("4GB [+$20.00]");

		userViewProductDetailPage.chooseHDDRadioButton("320 GB");

		userViewProductDetailPage.chooseOSRadionButton("Vista Home [+$50.00]");

		userViewProductDetailPage.checkToSoftware("Microsoft Office [+$50.00]");
		userViewProductDetailPage.unCheckToSoftware("Acrobat Reader [+$10.00]");
		userViewProductDetailPage.unCheckToSoftware("Total Commander [+$5.00]");

		userViewProductDetailPage.inputToProductQuantity("2");

		userViewProductDetailPage.sleepInSecond(3);

		verifyEquals(userViewProductDetailPage.getProductPrice(), "$1,320");

		userViewProductDetailPage.clickToUpdateButton();

		verifyEquals(userViewProductDetailPage.getSuccessAddedToCartMessage(), "The product has been added to your shopping cart");

		userViewProductDetailPage.clickToCloseButtonOnNotifyBar();

		userViewProductDetailPage.hoverMouseToShoppingCartIcon();

		verifyEquals(userViewProductDetailPage.getIndexOfShoppingCart(), "2");

		verifyEquals(userViewProductDetailPage.getTextAboutProductQuantityInShoppingCartIcon(), "There are 2 item(s) in your cart.");

		verifyTrue(userViewProductDetailPage.isProductNameDiplayedAtShoppingCartIcon("Build your own computer"));

		verifyEquals(userViewProductDetailPage.getAttributeByProductNameAtShoppingCartIcon("Build your own computer"),
				"Processor: 2.2 GHz Intel Pentium Dual-Core E2200\nRAM: 4GB [+$20.00]\nHDD: 320 GB\nOS: Vista Home [+$50.00]\nSoftware: Microsoft Office [+$50.00]");

		verifyEquals(userViewProductDetailPage.getProductPriceByProductNameAtShoppingCartIcon("Build your own computer"), "$1,320");

		verifyEquals(userViewProductDetailPage.getProductQuantityByProductNameAtShoppingCartIcon("Build your own computer"), "2");

		verifyEquals(userViewProductDetailPage.getSubTotalAtShoppingCartIcon(), "$2,640");

		userViewProductDetailPage.clickToGoToCartButtonAtShoppingCartIcon();

		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		verifyEquals(shoppingCartPage.getQuantityOfProduct("Build your own computer"), "2");

		verifyEquals(shoppingCartPage.getTotalByProductName("Build your own computer"), "$2,640");

		verifyEquals(shoppingCartPage.getAttributeByProductNameAtShoppingCart("Build your own computer"),
				"Processor: 2.2 GHz Intel Pentium Dual-Core E2200\nRAM: 4GB [+$20.00]\nHDD: 320 GB\nOS: Vista Home [+$50.00]\nSoftware: Microsoft Office [+$50.00]");

	}

	@Test
	public void Order_03_RemoveFromCart(Method method) {

		ExtentTestManager.startTest(method.getName(), "Order-Remove Product From Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Click button 'Remove'");
		shoppingCartPage.clickToRemoveButtonByProductName("Build your own computer");

		verifyEquals(shoppingCartPage.getTextOfShoppingCartEmpty(), "Your Shopping Cart is empty!");

		verifyTrue(shoppingCartPage.isProductNameUndisplayed("Build your own computer"));
	}

	@Test
	public void Order_04_UpdateShoppingCart(Method method) {

		ExtentTestManager.startTest(method.getName(), "Order-Update Shopping Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Order - Add Product To Cart - Step 01: Navigate to 'Computers>Desktop' page");

		homePage.clickToSubMenuByName("Computers", "Desktops");

		userViewProductDetailPage = homePage.clickToProductName("Lenovo IdeaCentre 600 All-in-One PC");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));

		userViewProductDetailPage.clickToAddToCart();

		verifyEquals(userViewProductDetailPage.getSuccessAddedToCartMessage(), "The product has been added to your shopping cart");

		userViewProductDetailPage.clickToCloseButtonOnNotifyBar();

		userViewProductDetailPage.clickToShoppingCartIcon();

		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		verifyEquals(shoppingCartPage.getQuantityOfProduct("Lenovo IdeaCentre 600 All-in-One PC"), "1");

		shoppingCartPage.inputToQuantityByProductName("Lenovo IdeaCentre 600 All-in-One PC", "5");

		shoppingCartPage.clickToUpdateShoppingCartButton();

		verifyEquals(shoppingCartPage.getTotalByProductName("Lenovo IdeaCentre 600 All-in-One PC"), "$2,500");

	}

	@Test
	public void Order_05_CheckoutByChequePaymentMethod(Method method) {

		ExtentTestManager.startTest(method.getName(), "Order-Checkout By Cheque Payment Method");
		ExtentTestManager.getTest().log(Status.INFO, "Order - " +
				"Remove product 'Lenovo IdeaCentre 600 All-in-One PC '");

		shoppingCartPage.clickToRemoveButtonByProductName("Lenovo IdeaCentre 600 All-in-One PC");

		verifyEquals(shoppingCartPage.getTextOfShoppingCartEmpty(), "Your Shopping Cart is empty!");

		verifyTrue(shoppingCartPage.isProductNameUndisplayed("Lenovo IdeaCentre 600 All-in-One PC"));

		homePage.clickToSubMenuByName("Computers", "Notebooks");

		userViewProductDetailPage = homePage.clickToProductName("Apple MacBook Pro 13-inch");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Apple MacBook Pro 13-inch"));

		userViewProductDetailPage.clickToAddToCart();

		verifyEquals(userViewProductDetailPage.getSuccessAddedToCartMessage(), "The product has been added to your shopping cart");

		userViewProductDetailPage.clickToCloseButtonOnNotifyBar();

		userViewProductDetailPage.clickToShoppingCartIcon();

		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		shoppingCartPage.checkToAgreeTearmOfServiceCheckbox();

		shoppingCartPage.clickToCheckoutButton();

		checkoutPage = PageGeneratorManager.getCheckoutPage(driver);

		checkoutPage.inputToValidInfoForBillingAddress("Tester", "Automation", "test1234@mail.net", "Viet Nam", "", "Ha Noi", "123/37 Hoang Ngan", "550000", "0987654321");

		checkoutPage.clickToContinueButtonAtBillingAddress();

		checkoutPage.chooseShippingMethodRadionButton("Ground ($0.00)");

		checkoutPage.clickToContinueButtonAtShippingMethod();

		checkoutPage.chooseToPaymentMethodRadioButton("Check / Money Order");

		checkoutPage.clickToContinueButtonAtPaymentMethod();

		verifyTrue(checkoutPage.getPaymentInformationText().contains("Mail Personal or Business Check"));

		checkoutPage.clickToContinueButtonAtPaymentInfo();

		checkoutPage.verifyBillingAddressAtConfirmOrder("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		checkoutPage.verifyShippingAddressAtConfirmOrder("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		checkoutPage.verifyShipping("Shipping Method: Ground");

		checkoutPage.verifyPaymentMethodAtConfirmOrder("Payment Method: Check / Money Order");

		checkoutPage.verifyProductInfo("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800", "2", "$3,600");

		Assert.assertEquals(checkoutPage.getSelectedCheckoutAttributeText(), "Gift wrapping: No");

		Assert.assertEquals(checkoutPage.getSubTotal(), "$3,600");
		Assert.assertEquals(checkoutPage.getShippingCost(), "$0");
		Assert.assertEquals(checkoutPage.getTax(), "$0");
		Assert.assertEquals(checkoutPage.getTotal(), "$3,600");

		checkoutPage.clickToConfirmButtonAtConfirmOrder();

		verifyEquals(checkoutPage.getTitleOfThankYouPage(), "Thank you");
		verifyEquals(checkoutPage.getSuccessCreatedOrderMessage(), "Your order has been successfully processed!");

		verifyTrue(checkoutPage.getOrderNumberText().contains("ORDER NUMBER"));

		String orderNumber = checkoutPage.getOrderNumber();

		customerInfoPage = checkoutPage.clickToMyAccountLink();

		orderPage = (UserOrdersPageObject) customerInfoPage.openPageMyAccountByName(driver, "Orders");

		Assert.assertEquals(orderPage.getOrderNumberAtOrderPage(), orderNumber);

		orderPage.clickToDetailOrderByOrderNumber(orderNumber);

		orderPage.verifyOrderNumber(orderNumber);
		orderPage.verifyOrderDate();
		orderPage.verifyOrderStatus("Pending");
		orderPage.verifyOrderTotal("$3,600");

		orderPage.verifyShippingAddressAtOrderPage("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		orderPage.verifyBillingAddressAtOrderPage("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		orderPage.verifyShippingAtOrderaPage("Shipping Method: Ground");

		orderPage.verifyPaymentMethodAtOrderPage("Payment Method: Check / Money Order");

		orderPage.verifyProductInfoAtOrderPage("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800", "2", "$3,600");

		Assert.assertEquals(orderPage.getSelectedCheckoutAttributeText(), "Gift wrapping: No");

		Assert.assertEquals(orderPage.getSubTotal(), "$3,600");
		Assert.assertEquals(orderPage.getShipping(), "$0");
		Assert.assertEquals(orderPage.getTax(), "$0");
		Assert.assertEquals(orderPage.getTotal(), "$3,600");

	}

	@Test
	public void Order_06_CheckoutOrderByCardPaymentMethod(Method method) {

		ExtentTestManager.startTest(method.getName(), "Order-Checkout Order By Card Payment Method");
		ExtentTestManager.getTest().log(Status.INFO, "Order - Add Product To Cart - Step 01: Navigate to 'Computers>Notebooks' page");

		homePage.clickToSubMenuByName("Computers", "Notebooks");

		userViewProductDetailPage = homePage.clickToProductName("Apple MacBook Pro 13-inch");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Apple MacBook Pro 13-inch"));

		userViewProductDetailPage.clickToAddToCart();

		verifyEquals(userViewProductDetailPage.getSuccessAddedToCartMessage(), "The product has been added to your shopping cart");

		userViewProductDetailPage.clickToCloseButtonOnNotifyBar();

		userViewProductDetailPage.sleepInSecond(3);

		userViewProductDetailPage.clickToShoppingCartIcon();

		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		shoppingCartPage.checkToAgreeTearmOfServiceCheckbox();

		shoppingCartPage.clickToCheckoutButton();

		checkoutPage = PageGeneratorManager.getCheckoutPage(driver);

		checkoutPage.sleepInSecond(3);

		checkoutPage.clickToContinueButtonAtBillingAddress();

		checkoutPage.sleepInSecond(3);

		checkoutPage.clickToContinueButtonAtShippingMethod();

		checkoutPage.sleepInSecond(3);

		checkoutPage.chooseToPaymentMethodRadioButton("Credit Card");

		checkoutPage.clickToContinueButtonAtCreditCard();

		checkoutPage.inputToCardInformation("Visa", "NGUYEN VAN AN", "4263982640269299", "02/2026", "887");

		checkoutPage.clickToContinueButtonAtPaymentInfo();

		checkoutPage.verifyBillingAddressAtConfirmOrder("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		checkoutPage.verifyShippingAddressAtConfirmOrder("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		checkoutPage.verifyShipping("Shipping Method: Ground");

		checkoutPage.verifyPaymentMethodAtConfirmOrder("Payment Method: Credit Card");

		checkoutPage.verifyProductInfo("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800", "2", "$3,600");

		Assert.assertEquals(checkoutPage.getSelectedCheckoutAttributeText(), "Gift wrapping: No");

		Assert.assertEquals(checkoutPage.getSubTotal(), "$3,600");
		Assert.assertEquals(checkoutPage.getShippingCost(), "$0");
		Assert.assertEquals(checkoutPage.getTax(), "$0");
		Assert.assertEquals(checkoutPage.getTotal(), "$3,600");

		checkoutPage.sleepInSecond(10);

		checkoutPage.clickToConfirmButtonAtConfirmOrder();

		verifyEquals(checkoutPage.getTitleOfThankYouPage(), "Thank you");
		verifyEquals(checkoutPage.getSuccessCreatedOrderMessage(), "Your order has been successfully processed!");

		verifyTrue(checkoutPage.getOrderNumberText().contains("ORDER NUMBER"));

		String orderNumber = checkoutPage.getOrderNumber();

		customerInfoPage = checkoutPage.clickToMyAccountLink();

		orderPage = (UserOrdersPageObject) customerInfoPage.openPageMyAccountByName(driver, "Orders");

		Assert.assertEquals(orderPage.getOrderNumberAtOrderPage(), orderNumber);

		orderPage.clickToDetailOrderByOrderNumber(orderNumber);

		orderPage.verifyOrderNumber(orderNumber);
		orderPage.verifyOrderDate();
		orderPage.verifyOrderStatus("Pending");
		orderPage.verifyOrderTotal("$3,600");

		orderPage.verifyBillingAddressAtOrderPage("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		orderPage.verifyShippingAddressAtOrderPage("Tester Automation", "test1234@mail.net", "0987654321", "", "123/37 Hoang Ngan", "Ha Noi,550000", "Viet Nam");

		orderPage.verifyShippingAtOrderaPage("Shipping Method: Ground");

		orderPage.verifyPaymentMethodAtOrderPage("Payment Method: Credit Card");

		orderPage.verifyProductInfoAtOrderPage("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800", "2", "$3,600");

		Assert.assertEquals(orderPage.getSelectedCheckoutAttributeText(), "Gift wrapping: No");

		Assert.assertEquals(orderPage.getSubTotal(), "$3,600");
		Assert.assertEquals(orderPage.getShipping(), "$0");
		Assert.assertEquals(orderPage.getTax(), "$0");
		Assert.assertEquals(orderPage.getTotal(), "$3,600");

	}

	@Test
	public void Order_07_ReOrder(Method method) {

		ExtentTestManager.startTest(method.getName(), "Reorder");
		ExtentTestManager.getTest().log(Status.INFO, "Reorder - Step 01: Click to 'Order' button");
		orderPage.clickToReOrderButton();

		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		shoppingCartPage.inputToQuantityByProductName("Apple MacBook Pro 13-inch", "5");

		shoppingCartPage.sleepInSecond(3);

		shoppingCartPage.clickToUpdateShoppingCartButton();

		shoppingCartPage.checkToAgreeTearmOfServiceCheckbox();

		shoppingCartPage.sleepInSecond(3);

		shoppingCartPage.clickToCheckoutButton();

		checkoutPage = PageGeneratorManager.getCheckoutPage(driver);

		shoppingCartPage.sleepInSecond(3);

		checkoutPage.clickToEditButtonAtBillingAddress();

		checkoutPage.inputToValidInfoForBillingAddress("John", "Kennedy", "johnkennedy1234@mail.net", "United States", "Washington", "California", "123/37 Bill Streets", "550000", "0987654321");

		checkoutPage.clickToSaveButtonAtBillingAddress();

		checkoutPage.sleepInSecond(2);

		checkoutPage.clickToContinueButtonAtBillingAddress();

		checkoutPage.chooseShippingMethodRadionButton("Next Day Air ($0.00)");

		shoppingCartPage.sleepInSecond(3);

		checkoutPage.clickToContinueButtonAtShippingMethod();

		shoppingCartPage.sleepInSecond(3);

		checkoutPage.clickToContinueButtonAtPaymentMethod();

		shoppingCartPage.sleepInSecond(3);

		checkoutPage.clickToContinueButtonAtPaymentInfo();

		checkoutPage.verifyBillingAddressAtConfirmOrder("John Kennedy", "johnkennedy1234@mail.net", "0987654321", "", "123/37 Bill Streets", "California,Washington,550000", "United States");

		checkoutPage.verifyShippingAddressAtConfirmOrder("John Kennedy", "johnkennedy1234@mail.net", "0987654321", "", "123/37 Bill Streets", "California,Washington,550000", "United States");

		checkoutPage.verifyShipping("Shipping Method: Next Day Air");

		checkoutPage.verifyPaymentMethodAtConfirmOrder("Payment Method: Check / Money Order");

		checkoutPage.verifyProductInfo("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800", "5", "$9,000");

		Assert.assertEquals(checkoutPage.getSelectedCheckoutAttributeText(), "Gift wrapping: No");

		Assert.assertEquals(checkoutPage.getSubTotal(), "$9,000");
		Assert.assertEquals(checkoutPage.getShippingCost(), "$0");
		Assert.assertEquals(checkoutPage.getTax(), "$0");
		Assert.assertEquals(checkoutPage.getTotal(), "$9,000");

		shoppingCartPage.sleepInSecond(3);

		checkoutPage.clickToConfirmButtonAtConfirmOrder();

		verifyEquals(checkoutPage.getTitleOfThankYouPage(), "Thank you");
		verifyEquals(checkoutPage.getSuccessCreatedOrderMessage(), "Your order has been successfully processed!");

		verifyTrue(checkoutPage.getOrderNumberText().contains("ORDER NUMBER"));

		String orderNumber = checkoutPage.getOrderNumber();

		customerInfoPage = checkoutPage.clickToMyAccountLink();

		orderPage = (UserOrdersPageObject) customerInfoPage.openPageMyAccountByName(driver, "Orders");

		Assert.assertEquals(orderPage.getOrderNumberAtOrderPage(), orderNumber);

		orderPage.clickToDetailOrderByOrderNumber(orderNumber);

		orderPage.verifyOrderNumber(orderNumber);
		orderPage.verifyOrderDate();
		orderPage.verifyOrderStatus("Pending");
		orderPage.verifyOrderTotal("$9,000");

		orderPage.verifyBillingAddressAtOrderPage("John Kennedy", "johnkennedy1234@mail.net", "0987654321", "", "123/37 Bill Streets", "California,Washington,550000", "United States");

		orderPage.verifyShippingAddressAtOrderPage("John Kennedy", "johnkennedy1234@mail.net", "0987654321", "", "123/37 Bill Streets", "California,Washington,550000", "United States");

		orderPage.verifyShippingAtOrderaPage("Shipping Method: Next Day Air");

		orderPage.verifyPaymentMethodAtOrderPage("Payment Method: Check / Money Order");

		orderPage.verifyProductInfoAtOrderPage("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800", "5", "$9,000");

		Assert.assertEquals(orderPage.getSelectedCheckoutAttributeText(), "Gift wrapping: No");

		Assert.assertEquals(orderPage.getSubTotal(), "$9,000");
		Assert.assertEquals(orderPage.getShipping(), "$0");
		Assert.assertEquals(orderPage.getTax(), "$0");
		Assert.assertEquals(orderPage.getTotal(), "$9,000");

	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
