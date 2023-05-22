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
import pageObjects.nopCommerce.user.UserComparisonPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRecentlyViewedProductsPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserViewProductDetailPageObject;
import pageObjects.nopCommerce.user.UserWishListPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class User_WishList_Compare_RecentView extends BaseTest {

	private WebDriver driver;
	private UserLoginPageObject loginPage;
	private UserHomePageObject homePage;
	private UserViewProductDetailPageObject userViewProductDetailPage;
	private UserWishListPageObject wishListPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserComparisonPageObject comparisionPage;
	private UserRecentlyViewedProductsPageObject recentlyViewedProducts;
	private String firstName = Common_01_Register_Cookie.firstName;
	private String lastName = Common_01_Register_Cookie.lastName;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.setCookie(Common_01_Register_Cookie.LoggedCookie);

		loginPage.refreshPage();

		loginPage.clickToCloseButtonOnNotifyBar();

		homePage = PageGeneratorManager.getUserHomePage(driver);

		verifyTrue(homePage.isMyAccountDisplayed());

	}

	@Test
	public void TC_01_Add_To_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "" +
				"Add to wishlist");
		ExtentTestManager.getTest().log(Status.INFO, "Open 'Computers>Desktops' page");

		homePage.clickToSubMenuByName("Computers", "Desktops");

		userViewProductDetailPage = homePage.clickToProductName("Digital Storm VANQUISH 3 Custom Performance PC");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Digital Storm VANQUISH 3 Custom Performance PC"));

		userViewProductDetailPage.clickToAddToWishListButton();

		verifyEquals(userViewProductDetailPage.getSuccessAddedToWishListMessage(), "The product has been added to your wishlist");

		userViewProductDetailPage.clickToCloseButtonOnNotifyBar();

		verifyEquals(userViewProductDetailPage.getIndexOfWishListLink(), 1);

		userViewProductDetailPage.clickToWishListLink();

		wishListPage = PageGeneratorManager.getWishListPage(driver);

		Assert.assertTrue(wishListPage.isProductNameDisplayed("Digital Storm VANQUISH 3 Custom Performance PC"));

		Assert.assertEquals(wishListPage.getQuantityOfProduct("Digital Storm VANQUISH 3 Custom Performance PC"), "1");

		wishListPage.clickToYourWishListURLForSharingLink();

		Assert.assertEquals(wishListPage.getTitleOfWishListPageAfterClickSharingLink(), "Wishlist of" + " " + firstName + " " + lastName);

		Assert.assertTrue(wishListPage.isProductNameDisplayed("Digital Storm VANQUISH 3 Custom Performance PC"));

		Assert.assertEquals(wishListPage.getQuantityOfProductAfterClickSharingLink("Digital Storm VANQUISH 3 Custom Performance PC"), "1");

	}

	@Test
	public void TC_02_Add_To_Cart_From_Wishlist_Page(Method method) {

		ExtentTestManager.startTest(method.getName(), "Add to cart from wishlist");
		ExtentTestManager.getTest().log(Status.INFO, "" +
				"click button back");

		wishListPage.backToPage();

		wishListPage.clickToCheckBoxByProductName("Digital Storm VANQUISH 3 Custom Performance PC");

		wishListPage.clickToAddToCartButton();

		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);

		Assert.assertTrue(shoppingCartPage.isShoppingCartTitleDisplayed());

		Assert.assertTrue(shoppingCartPage.isProductNameDisplayed("Digital Storm VANQUISH 3 Custom Performance PC"));

		Assert.assertEquals(shoppingCartPage.getQuantityOfProduct("Digital Storm VANQUISH 3 Custom Performance PC"), "1");

		Assert.assertEquals(shoppingCartPage.getIndexOfWishListLink(), 0);

		wishListPage = shoppingCartPage.clickToWishlistLink();

		Assert.assertEquals(wishListPage.getTextOfWishlistEmpty(), "The wishlist is empty!");

		Assert.assertTrue(wishListPage.isProductNameUnDisplayed("Digital Storm VANQUISH 3 Custom Performance PC"));
	}

	@Test
	public void TC_03_Remove_Product_In_Wishlist_Page(Method method) {

		ExtentTestManager.startTest(method.getName(), "Remove product in wishlist page");
		ExtentTestManager.getTest().log(Status.INFO, "Open 'Computers>Desktops' page");

		wishListPage.clickToSubMenuByName("Computers", "Desktops");

		homePage = PageGeneratorManager.getUserHomePage(driver);

		userViewProductDetailPage = homePage.clickToProductName("Digital Storm VANQUISH 3 Custom Performance PC");

		userViewProductDetailPage.clickToAddToWishListButton();

		Assert.assertEquals(userViewProductDetailPage.getSuccessAddedToWishListMessage(), "The product has been added to your wishlist");

		userViewProductDetailPage.clickToCloseButtonOnNotifyBar();

		Assert.assertEquals(userViewProductDetailPage.getIndexOfWishListLink(), 1);

		userViewProductDetailPage.clickToWishListLink();

		wishListPage = PageGeneratorManager.getWishListPage(driver);

		Assert.assertTrue(wishListPage.isProductNameDisplayed("Digital Storm VANQUISH 3 Custom Performance PC"));

		Assert.assertEquals(wishListPage.getQuantityOfProduct("Digital Storm VANQUISH 3 Custom Performance PC"), "1");

		wishListPage.clickToRemoveButtonByProductName("Digital Storm VANQUISH 3 Custom Performance PC");

		verifyEquals(wishListPage.getTextOfWishlistEmpty(), "The wishlist is empty!");

		verifyTrue(wishListPage.isProductNameUnDisplayed("Digital Storm VANQUISH 3 Custom Performance PC"));
	}

	@Test
	public void TC_04_Add_Product_To_Compare(Method method) {

		ExtentTestManager.startTest(method.getName(), "Add Product To Compare");
		ExtentTestManager.getTest().log(Status.INFO, "" +
				"Open 'Electronics > Camera &photo' page");
		wishListPage.clickToSubMenuByName("Electronics", "Camera & photo");

		homePage = PageGeneratorManager.getUserHomePage(driver);

		homePage.clickToAddToCompareListButtonByProductName("Nikon D5500 DSLR");

		verifyEquals(homePage.getAddedToCompareListSuccessMessage(), "The product has been added to your product comparison");

		homePage.clickToAddToCompareListButtonByProductName("Apple iCam");

		verifyEquals(homePage.getAddedToCompareListSuccessMessage(), "The product has been added to your product comparison");

		comparisionPage = homePage.clickToProductComparisonLink();

		verifyTrue(comparisionPage.isClearListButtonDisplayed());

		verifyTrue(comparisionPage.isRemoveButtonDisplayedByName("Nikon D5500 DSLR"));

		verifyTrue(comparisionPage.isRemoveButtonDisplayedByName("Apple iCam"));

		verifyEquals(comparisionPage.getProductPriceByProductName("Apple iCam"), "$1,300");

		Assert.assertEquals(comparisionPage.getProductPriceByProductName("Nikon D5500 DSLR"), "$630");

		comparisionPage.clickToClearListButton();

		Assert.assertEquals(comparisionPage.getDeletedProductMessage(), "You have no items to compare.");

		verifyTrue(comparisionPage.isProductNameUnDisplayed("Apple iCam"));

		verifyTrue(comparisionPage.isProductNameUnDisplayed("Nikon D5500 DSLR"));

	}

	@Test
	public void TC_05_Recently_Viewed_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "Recently Viewed Product");
		ExtentTestManager.getTest().log(Status.INFO, "Open 'Electronics>Camera&photo'");

		comparisionPage.clickToSubMenuByName("Electronics", "Camera & photo");

		homePage = PageGeneratorManager.getUserHomePage(driver);

		userViewProductDetailPage = homePage.clickToProductName("Nikon D5500 DSLR");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Nikon D5500 DSLR"));

		userViewProductDetailPage.clickToSubMenuByName("Electronics", "Camera & photo");

		userViewProductDetailPage = homePage.clickToProductName("Apple iCam");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Apple iCam"));

		userViewProductDetailPage.clickToSubMenuByName("Electronics", "Camera & photo");

		userViewProductDetailPage = homePage.clickToProductName("Leica T Mirrorless Digital Camera");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Leica T Mirrorless Digital Camera"));

		userViewProductDetailPage.clickToSubMenuByName("Apparel", "Shoes");

		userViewProductDetailPage = homePage.clickToProductName("adidas Consortium Campus 80s Running Shoes");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("adidas Consortium Campus 80s Running Shoes"));

		userViewProductDetailPage.clickToSubMenuByName("Apparel", "Shoes");

		userViewProductDetailPage = homePage.clickToProductName("Nike Floral Roshe Customized Running Shoes");

		verifyTrue(userViewProductDetailPage.isProductNameDisplayed("Nike Floral Roshe Customized Running Shoes"));

		userViewProductDetailPage.clickToRecentlyViewedProducts();

		recentlyViewedProducts = PageGeneratorManager.getRecentlyViewedProducts(driver);

		verifyTrue(recentlyViewedProducts.isProductNameDisplayed("Nike Floral Roshe Customized Running Shoes"));

		verifyTrue(recentlyViewedProducts.isProductNameDisplayed("adidas Consortium Campus 80s Running Shoes"));

		verifyTrue(recentlyViewedProducts.isProductNameDisplayed("Leica T Mirrorless Digital Camera"));

		verifyTrue(recentlyViewedProducts.isProductNameUnDisplayed("Apple iCam"));

		verifyTrue(recentlyViewedProducts.isProductNameUnDisplayed("Nikon D5500 DSLR"));

	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
