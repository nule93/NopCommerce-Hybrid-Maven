package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminAddressPageObject;
import pageObjects.nopCommerce.admin.AdminCustomerPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductPageObject;
public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPageObject(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserOrdersPageObject getUserOrdersPageObject(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}

	public static UserAddressesPageObject getUserAddressesPageObject(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static UserMyProductReviewsPageObject getUserMyProductReviewsPageObject(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPageObject(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserReviewProductPageObject getUserReviewProductPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserReviewProductPageObject(driver);
	}

	public static UserViewProductDetailPageObject getUserViewProductDetailPage(WebDriver driver) {
		return new UserViewProductDetailPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}


	
	public static UserWishListPageObject getWishListPage(WebDriver driver) {
		return new UserWishListPageObject(driver);
	}
	
	public static UserShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}
	
	public static UserComparisonPageObject getComparisonPage(WebDriver driver) {
		return new UserComparisonPageObject(driver);
	}
	
	public static UserRecentlyViewedProductsPageObject getRecentlyViewedProducts(WebDriver driver) {
		return new UserRecentlyViewedProductsPageObject(driver);
	}
	
	public static UserCheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}
	
	public static AdminProductPageObject getProductPage(WebDriver driver) {
		return new AdminProductPageObject(driver);
	}
	
	public static AdminCustomerPageObject getAdminCustomerNopCommerce(WebDriver driver) {
		return new AdminCustomerPageObject(driver);
	}

	public static AdminAddressPageObject getAdminAddressNopCommerce(WebDriver driver) {
		return new AdminAddressPageObject(driver);
	}
}
