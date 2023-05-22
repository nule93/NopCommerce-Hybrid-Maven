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
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import reportConfig.ExtentTestManager;
import ultilities.DataHelper;

import java.lang.reflect.Method;

public class UserSearch_AdvancedSearch extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private UserSearchPageObject userSearchPage;
    private DataHelper dataHelper = new DataHelper();
    private String emailAddress = dataHelper.getEmailAddress();
    private String password = dataHelper.getPassword();
    private String lastName = dataHelper.getLastName();
    private String firstName = dataHelper.getFirstName();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openMultipleBrowser(browserName);

        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        System.out.println("PRE-CONDITION: REGISTER AND LOGIN AN ACCOUNT");

        userRegisterPage = userHomePage.clickToRegisterLink();

        userHomePage = userRegisterPage.registerAnAccount(firstName, lastName, emailAddress, password);

        Assert.assertEquals(userRegisterPage.getSuccessRegisterMessage(), "Your registration completed");

        userLoginPage = userHomePage.clickToLoginLink();
        userLoginPage.loginAsUser(emailAddress, password);

        Assert.assertTrue(userHomePage.isMyAccountDisplayed());

        userSearchPage = userHomePage.clickToSearchLinkUnderFooter();

        Assert.assertTrue(userSearchPage.isSearchTitleDisplay());

    }

    @Test
    public void Search_01_Empty_data(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Search: Empty data");
        ExtentTestManager.getTest().log(Status.INFO, "Input empty data in the textbox");

        userSearchPage.inputToSearchTextbox("");

        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getErrorMessage(), "Search term minimum length is 3 characters");

    }

    @Test
    public void Search_02_Data_Not_Exist(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Data Not Exist");


        userSearchPage.inputToSearchTextbox("Macbook Pro 2050");
        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getErrorMessage(), "No products were found that matched your criteria.");

    }

    @Test
    public void Search_03_Relative_Product_Name(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Relative Product Name");


        userSearchPage.inputToSearchTextbox("Lenovo");

        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getDisplayedProductQuantity(), 2);

        Assert.assertEquals(userSearchPage.getProductNameDisplayed("Lenovo IdeaCentre 600 All-in-One PC"), "Lenovo IdeaCentre 600 All-in-One PC");

        Assert.assertEquals(userSearchPage.getProductNameDisplayed("Lenovo Thinkpad X1 Carbon Laptop"), "Lenovo Thinkpad X1 Carbon Laptop");

    }

    @Test
    public void Search_04_Absolute_Product_Name(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Search: Absolute Product Name");

        userSearchPage.inputToSearchTextbox("ThinkPad X1 Carbon");

        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getDisplayedProductQuantity(), 1);

        Assert.assertEquals(userSearchPage.getProductNameDisplayed("Lenovo Thinkpad X1 Carbon Laptop"), "Lenovo Thinkpad X1 Carbon Laptop");

    }

    @Test
    public void Search_05_Advanced_Parent_Categories(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Search: Advanced Parent Categories");

        userSearchPage.inputToSearchTextbox("Apple MacBook Pro");

        userSearchPage.clickToAdvancedSearchCheckbox();

        userSearchPage.selectToCategory("Computers");

        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getErrorMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_06_Advanced_Sub_Categories(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Search Advanced Sub Categories");

        userSearchPage.inputToSearchTextbox("Apple MacBook Pro");
        userSearchPage.clickToAdvancedSearchCheckbox();
        userSearchPage.selectToCategory("Computers");
        userSearchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getDisplayedProductQuantity(), 1);

        Assert.assertEquals(userSearchPage.getProductNameDisplayed("Apple MacBook Pro 13-inch"), "Apple MacBook Pro 13-inch");

    }

    @Test
    public void Search_07_Advanced_Search_Incorrect_Manufacturer(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Advanced Search Incorrect Manufacturer");

        userSearchPage.inputToSearchTextbox("Apple MacBook Pro");
        userSearchPage.clickToAdvancedSearchCheckbox();
        userSearchPage.selectToCategory("Computers");
        userSearchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
        userSearchPage.selectToManufacterer("HP");

        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getErrorMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_08_Advanced_Search_Correct_Manufacturer(Method method) {

        ExtentTestManager.startTest(method.getName(), "" +
                "Advanced Search Correct Manufacturer");

        userSearchPage.inputToSearchTextbox("Apple MacBook Pro");
        userSearchPage.clickToAdvancedSearchCheckbox();
        userSearchPage.selectToCategory("Computers");
        userSearchPage.clickToAutomaticallySearchSubCategoriesCheckbox();
        userSearchPage.selectToManufacterer("Apple");

        userSearchPage.clickToSearchButton();

        Assert.assertEquals(userSearchPage.getDisplayedProductQuantity(), 1);

        Assert.assertEquals(userSearchPage.getProductNameDisplayed("Apple MacBook Pro 13-inch"), "Apple MacBook Pro 13-inch");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
