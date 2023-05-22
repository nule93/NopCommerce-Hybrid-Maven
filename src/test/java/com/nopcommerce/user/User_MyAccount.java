package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserReviewProductPageObject;
import pageObjects.nopCommerce.user.UserViewProductDetailPageObject;
import reportConfig.ExtentTestManager;
import ultilities.DataHelper;

import java.lang.reflect.Method;

public class User_MyAccount extends BaseTest {
    private WebDriver driver;
    UserRegisterPageObject userRegisterPage;
    UserLoginPageObject userLoginPage;
    UserHomePageObject userHomePage;
    UserCustomerInfoPageObject userCustomerInforPage;

    private DataHelper dataHelper;
    UserAddressesPageObject userAddressesPage;
    UserChangePasswordPageObject userChangePasswordPage;
    UserViewProductDetailPageObject userViewProductDetailPage;
    UserReviewProductPageObject userReviewPage;
    UserMyProductReviewsPageObject userMyProductReviewsPage;
    String emailAddress = "John" + randomNumber() + "@mail.net";
    String password = "123456";

    String firstname = dataHelper.getFirstName();
    String lastname = dataHelper.getLastName();
    String updatedEmail = "Auto" + randomNumber() + ".vn@gmail.com";
    String updatedFirstName = "Automation";
    String updatedLastName = "FC";
    String updatedCompany = updatedFirstName + " " + updatedLastName;
    String country = "Viet Nam";
    String city = "Hai Phong";
    String address1 = "123/04 Le Lai";
    String address2 = "234/05 Hai Phong";
    String zipCode = "555000";
    String phoneNumber = "0123456789";
    String faxNumber = "0987654321";
    String newPassword = "654321";
    String reviewTitle = "Review a good product";
    String reviewBody = "This is a good product. You should buy it.";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openMultipleBrowser(browserName);

        System.out.println("PRE-CONDITION: REGISTER AN ACCOUNT");
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userRegisterPage = userHomePage.clickToRegisterLink();
        userHomePage = userRegisterPage.registerAnAccount(firstname, lastname, emailAddress, password);
        Assert.assertEquals(userRegisterPage.getSuccessRegisterMessage(), "Your registration completed");

        userLoginPage = userHomePage.clickToLoginLink();
        userLoginPage.loginAsUser(emailAddress, password);

        Assert.assertTrue(userHomePage.isMyAccountDisplayed());

    }

    @Test
    public void MyAccount_01_Update_Customer_Information(Method method) {
        ExtentTestManager.startTest(method.getName(), "Update Customer Information");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'My Account' page");
        userCustomerInforPage = userHomePage.clickToMyAccountLink();
        Assert.assertTrue(userCustomerInforPage.isCustomerInfoDisplayed());

        userCustomerInforPage.selectToGender("Female");

        userCustomerInforPage.inputToFirstNameTextbox(updatedFirstName);

        userCustomerInforPage.inputToLastNameTextbox(updatedLastName);

        userCustomerInforPage.selectToDayOfBirth("1");

        userCustomerInforPage.selectToMonthOfBirth("January");

        userCustomerInforPage.selectToYearOfBirth("1999");

        userCustomerInforPage.inputToEmailTextbox(updatedEmail);

        userCustomerInforPage.inputToCompanyTextbox(updatedCompany);

        userCustomerInforPage.clickToSaveButton();

        Assert.assertEquals(userCustomerInforPage.getUpdateSuccessfulMessage(), "The customer info has been updated successfully.");

        Assert.assertTrue(userCustomerInforPage.isSelected("Female"));

        Assert.assertEquals(userCustomerInforPage.getFirstName(), updatedFirstName);

        Assert.assertEquals(userCustomerInforPage.getLastName(), updatedLastName);

        Assert.assertEquals(userCustomerInforPage.getDayOfBirth(), "1");

        Assert.assertEquals(userCustomerInforPage.getMonthOfBirth(), "January");

        Assert.assertEquals(userCustomerInforPage.getYearOfBirth(), "1999");

        Assert.assertEquals(userCustomerInforPage.getEmail(), updatedEmail);

        Assert.assertEquals(userCustomerInforPage.getCompany(), updatedCompany);

        userCustomerInforPage.clickToCloseButtonOnNotifyBar();

        userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage();

        userLoginPage = userHomePage.clickToLoginLink();

        userHomePage = userLoginPage.loginAsUser(updatedEmail, "123456");

        Assert.assertTrue(userHomePage.isMyAccountDisplayed());

    }

    @Test
    public void My_Account_02_Add_Address(Method method) {
        ExtentTestManager.startTest(method.getName(), "My Account: Add Address");
        ExtentTestManager.getTest().log(Status.INFO, "Add Address - Step 01: Navigate to 'My Account' page");
        userCustomerInforPage = userHomePage.clickToMyAccountLink();
        Assert.assertTrue(userCustomerInforPage.isCustomerInfoDisplayed());
        userAddressesPage = (UserAddressesPageObject) userCustomerInforPage.openPageMyAccountByName(driver, "Addresses");
        Assert.assertTrue(userAddressesPage.isAddressesPageDisplayed());

        userAddressesPage.clickToAddNewButton();

        Assert.assertTrue(userAddressesPage.isAddNewAddressTitleDisplayed());

        userAddressesPage.inputToFirstNameTextbox(updatedFirstName);

        userAddressesPage.inputToLastNameTextbox(updatedLastName);

        userAddressesPage.inputToEmailTextbox(updatedEmail);

        userAddressesPage.inputToCompanyTextbox(updatedCompany);

        userAddressesPage.selectToCountry(country);

        userAddressesPage.selectToState("Other");

        userAddressesPage.inputToCityTextbox(city);

        userAddressesPage.inputToAddress1Textbox(address1);

        userAddressesPage.inputToAddress2Textbox(address2);

        userAddressesPage.inputToZipCodeTextbox(zipCode);

        userAddressesPage.inputToPhoneNumberTextbox(phoneNumber);

        userAddressesPage.inputToFaxNumberTextbox(faxNumber);

        userAddressesPage.clickToSaveButton();

        Assert.assertEquals(userAddressesPage.getSuccessCreatedAddressMessage(), "The new address has been added successfully.");

        Assert.assertEquals(userAddressesPage.getName(), updatedFirstName + " " + updatedLastName);

        Assert.assertEquals(userAddressesPage.getEmail(), "Email: " + updatedEmail);

        Assert.assertEquals(userAddressesPage.getPhoneNumber(), "Phone number: " + phoneNumber);

        Assert.assertEquals(userAddressesPage.getFaxNumber(), "Fax number: " + faxNumber);

        Assert.assertEquals(userAddressesPage.getCompany(), updatedCompany);

        Assert.assertEquals(userAddressesPage.getAddress1(), address1);

        Assert.assertEquals(userAddressesPage.getAddress2(), address2);

        Assert.assertEquals(userAddressesPage.getCityAndZipCode(), city + ", " + zipCode);

        Assert.assertEquals(userAddressesPage.getCountry(), country);

    }

    @Test
    public void My_Account_03_Change_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "My Account: Change Password");
        ExtentTestManager.getTest().log(Status.INFO, "Open 'Change password' page");
        userChangePasswordPage = (UserChangePasswordPageObject) userAddressesPage.openPageMyAccountByName(driver, "Change password");
        Assert.assertTrue(userChangePasswordPage.isChangePasswordTitleDisplayed());

        userChangePasswordPage.inputToOldPasswordTextbox(password);
        userChangePasswordPage.inputToNewPasswordTextbox(newPassword);
        userChangePasswordPage.inputToConfirmPasswordTextbox(newPassword);

        userChangePasswordPage.clickToChangePasswordButton();

        Assert.assertEquals(userChangePasswordPage.getSuccessfulChangedPasswordMessage(), "Password was changed");

        userChangePasswordPage.clickToCloseButtonOnNotifyBar();

        userHomePage = userChangePasswordPage.clickToLogoutLinkAtUserPage();

        userLoginPage = userHomePage.clickToLoginLink();

        userHomePage = userLoginPage.loginAsUser(updatedEmail, newPassword);

        Assert.assertTrue(userHomePage.isMyAccountDisplayed());

    }

    @Test
    public void My_Account_04_Add_Review(Method method) {
        ExtentTestManager.startTest(method.getName(), "My Account: Add Review");
        ExtentTestManager.getTest().log(Status.INFO, "" +
                "My Account: Open submenu 'Apparel>Clothing'");

        userHomePage.clickToSubMenuByName("Apparel", "Clothing");

        userViewProductDetailPage = userHomePage.clickToProductName("Custom T-Shirt");

        userReviewPage = userViewProductDetailPage.clickToAddYourReviewLink();

        Assert.assertEquals(userReviewPage.getReviewTitle(), "Product reviews for Custom T-Shirt");

        userReviewPage.inputToReviewTitleTextbox(reviewTitle);

        userReviewPage.inputToReviewBodyTextArea(reviewBody);

        userReviewPage.selectToRatingRadio(4);

        userReviewPage.clickToSubmitReviewButton();

        Assert.assertEquals(userReviewPage.getSuccessfulReviewedMessage(), "Product review is successfully added.");

        Assert.assertEquals(userReviewPage.getReviewTitleText(), reviewTitle);

        Assert.assertEquals(userReviewPage.getReviewBodyText(), reviewBody);

        Assert.assertEquals(userReviewPage.getActualRating(), userReviewPage.getExpectedRating(4));

        userReviewPage.clickToHeaderLinkByName(driver, "My account");

        userCustomerInforPage = PageGeneratorManager.getUserCustomerInfoPageObject(driver);

        Assert.assertTrue(userCustomerInforPage.isCustomerInfoDisplayed());

        userMyProductReviewsPage = (UserMyProductReviewsPageObject) userCustomerInforPage.openPageMyAccountByName(driver, "My product reviews");

        Assert.assertTrue(userMyProductReviewsPage.isMyProductReviewTitleDisplayed());

        Assert.assertEquals(userMyProductReviewsPage.getReviewTitleText(), reviewTitle);
        Assert.assertEquals(userMyProductReviewsPage.getReviewBodyText(), reviewBody);
        Assert.assertEquals(userMyProductReviewsPage.getActualRating(), userReviewPage.getExpectedRating(4));
        Assert.assertEquals(userMyProductReviewsPage.getReviewedProductName(), "Product review for: Custom T-Shirt");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
