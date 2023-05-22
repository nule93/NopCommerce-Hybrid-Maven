package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.admin.AdminAddressPageObject;
import pageObjects.nopCommerce.admin.AdminCustomerPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class AdminCustomer extends BaseTest {
    private WebDriver driver;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private AdminCustomerPageObject adminCustomerPage;
    private AdminAddressPageObject adminAddressPage;
    private final String emailAddress = "admin@yourstore.com";
    private final String password = "admin";
    private String emailCreateCustomer = "automationfc" + randomNumber() + "@gmail.com";
    String updateEmail = "edit_automationfc" + randomNumber() + "@gmail.com";
    private String passwordCreateCustomer = "123456";
    private String firstName = "Automation";
    private String lastName = "FC";
    private String fullName = firstName + " " + lastName;
    private String gender = "Male";
    private String dateOfBirth = "1/1/2000";
    private String companyName = "Automation FC";
    private String customerRoles = "Guests";
    private String adminComment = "Add new Customer (Guest)";

    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeClass(String browserName, String env) {

        log.info("Open Nopcommerce page");
        driver = openMultipleBrowser(browserName, env);

        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Login an account with email and password" + emailAddress + password);
        adminDashboardPage = adminLoginPage.loginAsAdmin(emailAddress, password);

        Assert.assertTrue(adminDashboardPage.isTitleDisplayedAtAdmin("Dashboard"));
    }

    @Test
    public void Customer_01_CreateNewCustomer(Method method) {
        ExtentTestManager.startTest(method.getName(), "" +
                "Customer-Create New Customer");
        log.info("Customer_01 - Step 1: Open Customer page");
        adminDashboardPage.clickToSubMenuByNameAtAdmin("Customers", "Customers");

        adminCustomerPage = PageGeneratorManager.getAdminCustomerNopCommerce(driver);

        log.info("Customer_01 - Step 2: Verify 'Customers' title is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Customers"));

        log.info("Customer_01 - Step 3: Click to 'Add new' button");
        adminCustomerPage.clickToAddNewButton();

        log.info("Customer_01 - Step 4: Verify 'Add a new customer' screen is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Add a new customer"));

        log.info("Customer_01 - Step 5: Input customer's info with email, password, firstName, lastName, gender, dateOfBirth, companyName, customerRoles adminComment" + emailCreateCustomer + passwordCreateCustomer + firstName + lastName
                + gender + dateOfBirth + companyName + customerRoles + adminComment);
        adminCustomerPage.createAndEditCustomer(emailCreateCustomer, passwordCreateCustomer, firstName, lastName, gender, dateOfBirth, companyName, customerRoles, adminComment);

        log.info("Customer_01 - Step 6: Check to 'Active' checkbox");
        adminCustomerPage.checkToActiveCheckboxToCreateCustomer();

        log.info("Customer_01 - Step 7: Click to 'Save and Continue Edit' button");
        adminCustomerPage.clickToSaveAndContinueEdit();

        log.info("Customer_01 - Step 8: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_01 - Step 9: Verify created customer message is displayed ");
        Assert.assertEquals(adminCustomerPage.getCreatedCustomerSuccessMessage(), "The new customer has been added successfully.");

        log.info("Customer_01 - Step 10: Verify created customer info");
        adminCustomerPage.verifyCreatedCustomerInfo(emailCreateCustomer, "", firstName, lastName, gender, dateOfBirth, companyName, customerRoles, true, adminComment);

        log.info("Customer_01 - Step 11: Click to 'Back to Customer list' button");
        adminCustomerPage.clickToBackToCustomerListButton();

        log.info("Customer_01 - Step 12: Select 'Guests' at 'Customer Roles' dropdown");
        adminCustomerPage.selectToCustomerRolesDropdownToCreateAndSearchCustomer("Guests");

        log.info("Customer_01 - Step 13: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_01 - Step 14: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_01 - Step 15: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName, companyName" + fullName + companyName);
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", fullName, customerRoles, companyName, "actived");

    }

    @Test
    public void Customer_02_SearchCustomerWithEmail(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Search Customer With Email");

        log.info("Customer_02 - Step 1: Only input data for 'Email' text box and 'Customer Roles' dropdown " + emailCreateCustomer + customerRoles);
        adminCustomerPage.inputDataToSearchCustomer("", "", "", emailCreateCustomer, customerRoles, "");

        log.info("Customer_02 - Step 2: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_02 - Step 3: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_02 - Step 4: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName, companyName" + fullName + companyName);
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", fullName, customerRoles, companyName, "actived");
    }

    @Test
    public void Customer_03_SearchCustomerWithFirstNameAndLastName(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Search Customer With FirstName and LastName");

        log.info("Customer_03 - Step 1: Only input data for 'First name' text box, 'Last name' text box and 'Customer Roles' dropdown " + firstName + lastName + customerRoles);
        adminCustomerPage.inputDataToSearchCustomer(firstName, lastName, "", "", customerRoles, "");

        log.info("Customer_03 - Step 2: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_03 - Step 3: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_03 - Step 4: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName, companyName" + fullName + companyName);
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", fullName, customerRoles, companyName, "actived");

    }

    @Test
    public void Customer_04_SearchCustomerAndCompany(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Search Customer And Company");

        log.info("Customer_04 - Step 1: Only input data for 'Company name' text box and 'Customer Roles' dropdown " + companyName + customerRoles);
        adminCustomerPage.inputDataToSearchCustomer("", "", companyName, "", customerRoles, "");

        log.info("Customer_04 - Step 2: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_04 - Step 3: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_04 - Step 4: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName, companyName" + fullName + companyName);
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", fullName, customerRoles, companyName, "actived");

    }

    @Test
    public void Customer_05_SearchCustomerWithFullData(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Search Customer With FullData");

        log.info("Customer_05 - Step 1: Input full data to search the customer's information includes: firstName, lastName, companyName, email, customer roles and date of birth" + firstName + lastName + companyName + emailCreateCustomer + customerRoles
                + dateOfBirth);
        adminCustomerPage.inputDataToSearchCustomer(firstName, lastName, companyName, emailCreateCustomer, customerRoles, dateOfBirth);

        log.info("Customer_05 - Step 2: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_05 - Step 3: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_05 - Step 4: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName, companyName" + fullName + companyName);
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", fullName, customerRoles, companyName, "actived");

    }

    @Test
    public void Customer_06_Edit_Customer(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Edit Customer");

        log.info("Customer_06 - Step 1: Input full data to search customer including: firstName, lastName, companyName, email, customer roles and date of birth" + firstName + lastName + companyName + emailCreateCustomer + customerRoles
                + dateOfBirth);
        adminCustomerPage.inputDataToSearchCustomer(firstName, lastName, companyName, emailCreateCustomer, customerRoles, dateOfBirth);

        log.info("Customer_06 - Step 2: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_06 - Step 3: Click to 'Edit' button");
        adminCustomerPage.clickToEditButtonByCustomerName(fullName);

        log.info("Customer_06 - Step 4: Verify 'Edit customer details' screen is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Edit customer details"));

        log.info("Customer_06 - Step 5: Input data to edit customer");
        adminCustomerPage.createAndEditCustomer(updateEmail, "", "Edit Automation", "Edit FC", "", "2/2", "Edit Automation FC", "", "Edit Customer (Guest)");

        log.info("Customer_06 - Step 6: Click to 'Save' button");
        adminCustomerPage.clickToSaveButton();

        log.info("Customer_06 - Step 7: Verify updated customer message is displayed");
        Assert.assertEquals(adminCustomerPage.getCreatedCustomerSuccessMessage(), "The customer has been updated successfully.");

        log.info("Customer_06 - Step 8: Verify title 'Customers' is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Customers"));

        log.info("Customer_06 - Step 9: Input data to search includes: 'Edit Automation', 'Edit FC', 'Edit Automation FC', '2/2' and email, customer roles" + updateEmail + customerRoles);
        adminCustomerPage.inputDataToSearchCustomer("Edit Automation", "Edit FC", "Edit Automation FC", updateEmail, customerRoles, "2/2");

        log.info("Customer_06 - Step 10: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_06 - Step 11: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_06 - Step 12: Verify customer's information is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName 'Edit Automation Edit FC', companyName 'Edit Automation FC'");
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", "Edit Automation Edit FC", customerRoles, "Edit Automation FC", "actived");

    }

    @Test
    public void Customer_07_AddNewAddressInCustomerDetail(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Add New Address In Customer Detail");

        log.info("Customer_07 - Step 1: Input data to search includes: 'Edit Automation', 'Edit FC', 'Edit Automation FC', '2/2' and email, customer roles" + updateEmail + customerRoles);
        adminCustomerPage.inputDataToSearchCustomer("Edit Automation", "Edit FC", "Edit Automation FC", updateEmail, customerRoles, "2/2");

        log.info("Customer_07 - Step 2: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_07 - Step 3: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_07 - Step 4: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName 'Edit Automation Edit FC', companyName 'Edit Automation FC'");
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", "Edit Automation Edit FC", "Guests", "Edit Automation FC", "actived");

        log.info("Customer_07 - Step 5: Click to 'Edit' button");
        adminCustomerPage.clickToEditButtonByCustomerName("Edit Automation Edit FC");

        log.info("Customer_07 - Step 6: Verify 'Edit customer details' screen is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Edit customer details"));

        log.info("Customer_07 - Step 7: Click to 'Add New Address' button");
        adminCustomerPage.clickToAddNewAddress();

        adminAddressPage = PageGeneratorManager.getAdminAddressNopCommerce(driver);

        log.info("Customer_07 - Step 8: Verify 'Add new address' screen is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Add a new address"));

        log.info(
                "Customer_07 - Step 9: Input data to create a new address including: 'Automation', 'FC', 'automationfc@gmail.com', 'Automation FC', 'Viet Nam', 'Other', 'Ho Chi Minh', '743 Le Loi', '453 Le Lai', '650000', '0987654555', '+84987654555'");
        adminAddressPage.inputDataToCreateAddress("Automation", "FC", "automationfc@gmail.com", "Automation FC", "Viet Nam", "Other", "Ho Chi Minh", "743 Le Loi", "453 Le Lai", "650000", "0987654555", "+84987654555");

        log.info("Customer_07 - Step 10: Click to 'Save' button");
        adminAddressPage.clickToSaveButton();

        log.info("Customer_07 - Step 11: Verify added address message displays");
        Assert.assertEquals(adminAddressPage.getSuccessMessage(), "The new address has been added successfully.");

        log.info("Customer_07 - Step 12: Click to 'Back to Customer list' button");
        adminAddressPage.clickToBackToCustomerDetails();

        adminCustomerPage = PageGeneratorManager.getAdminCustomerNopCommerce(driver);

        log.info("Customer_07 - Step 13:  Verify address's info includes: 'Automation', 'FC', 'automationfc@gmail.com', '0987654555', '+84987654555', 'Automation FC, 743 Le Loi, 453 Le Lai, Ho Chi Minh,650000, Viet Nam");
        adminCustomerPage.verifyCreatedAddressInfo("Automation", "FC", "automationfc@gmail.com", "0987654555", "+84987654555", "Automation FC\n743 Le Loi\n453 Le Lai\nHo Chi Minh,650000\nViet Nam");
    }

    @Test
    public void Customer_08_EditAddressInCustomerDetail(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Edit Address In Customer Detail");

        log.info("Customer_08 - Step 1: Click to 'Back to Customer list' button");
        adminCustomerPage.clickToBackToCustomerListButton();

        log.info("Customer_08 - Step 2: Verify title 'Customers' is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Customers"));

        log.info("Customer_08 - Step 3: Input data to search includes: 'Edit Automation', 'Edit FC', 'Edit Automation FC', '2/2' and email, customer roles" + updateEmail + customerRoles);
        adminCustomerPage.inputDataToSearchCustomer("Edit Automation", "Edit FC", "Edit Automation FC", updateEmail, customerRoles, "2/2");

        log.info("Customer_08 - Step 4: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_08 - Step 5: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_08 - Step 6: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName 'Edit Automation Edit FC', companyName 'Edit Automation FC'");
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", "Edit Automation Edit FC", customerRoles, "Edit Automation FC", "actived");

        log.info("Customer_08 - Step 7: Click to 'Edit' button");
        adminCustomerPage.clickToEditButtonByCustomerName("Edit Automation Edit FC");

        log.info("Customer_08 - Step 8: Verify 'Edit customer details' screen is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Edit customer details"));

        log.info("Customer_08 - Step 9: Click to 'Edit' button at 'Address' table");
        adminCustomerPage.clickToEditButtonAtAddressByFirstName("Automation");

        adminAddressPage = PageGeneratorManager.getAdminAddressNopCommerce(driver);

        log.info("Customer_08 - Step 10: Verify 'Edit address' screen is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Edit address"));

        log.info(
                "Customer_08 - Step 11: Input data to edit address including: 'Edit Automation', 'Edit FC', 'automationfc@gmail.com', 'Edit Automation FC', 'United States', 'California', 'Albany', '123 PO Box', '356 Los Bancos', '986589', '0987654666','+441619998888'");
        adminAddressPage.inputDataToCreateAddress("Edit Automation", "Edit FC", "automationfc@gmail.com", "Edit Automation FC", "United States", "California", "Albany", "123 PO Box", "356 Los Bancos", "986589", "0987654666",
                "+441619998888");

        log.info("Customer_08 - Step 12: Click to 'Save' button");
        adminAddressPage.clickToSaveButton();

        log.info("Customer_08 - Step 13: Verify updated address message is displayed");
        Assert.assertEquals(adminAddressPage.getSuccessMessage(), "The address has been updated successfully.");

        log.info(
                "Customer_08 - Step 14: Verify address's info edit address including: 'Edit Automation', 'Edit FC', 'automationfc@gmail.com', 'Edit Automation FC', 'United States', 'California', 'Albany', '123 PO Box', '356 Los Bancos', '986589', '0987654666','+441619998888'");
        adminAddressPage.verifyAddressInfo("Edit Automation", "Edit FC", "automationfc@gmail.com", "Edit Automation FC", "United States", "California", "Albany", "123 PO Box", "356 Los Bancos", "986589", "0987654666", "+441619998888");

        log.info("Customer_09 - Step 15: Click to 'Back to Customer list' button");
        adminAddressPage.clickToBackToCustomerDetails();

        adminCustomerPage = PageGeneratorManager.getAdminCustomerNopCommerce(driver);

        log.info(
                "Customer_09 - Step 16: Verify address info including: 'Edit Automation', 'Edit FC', 'automationfc@gmail.com', '0987654666', '+441619998888', 'Edit Automation FC\n123 PO Box\n356 Los Bancos\nAlbany,California,986589\nUnited States'");
        adminCustomerPage.verifyCreatedAddressInfo("Edit Automation", "Edit FC", "automationfc@gmail.com", "0987654666", "+441619998888", "Edit Automation FC\n123 PO Box\n356 Los Bancos\nAlbany,California,986589\nUnited States");
    }

    @Test
    public void Customer_09_DeleteAddressInCustomerDetail(Method method) {

        ExtentTestManager.startTest(method.getName(), "Customer-Delete Address In Customer Detail");

        log.info("Customer_09 - Step 1: Click to 'Back to Customer list' button");
        adminCustomerPage.clickToBackToCustomerListButton();

        log.info("Customer_09 - Step 2: Verify title 'Customers' is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Customers"));

        log.info("Customer_09 - Step 3: Input data to search includes: 'Edit Automation', 'Edit FC', 'Edit Automation FC', '2/2' and email, customer roles" + updateEmail + customerRoles);
        adminCustomerPage.inputDataToSearchCustomer("Edit Automation", "Edit FC", "Edit Automation FC", updateEmail, customerRoles, "2/2");

        log.info("Customer_09 - Step 4: Click to 'Search' button");
        adminCustomerPage.clickToSearchButton();

        log.info("Customer_09 - Step 5: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_09 - Step 6: Verify customer's is displayed correctly with email 'Guest', customer roles 'Guests', active 'tick' and fullName 'Edit Automation Edit FC', companyName 'Edit Automation FC'");
        adminCustomerPage.verifyDisplayCustomerInfo("Guest", "Edit Automation Edit FC", customerRoles, "Edit Automation FC", "actived");

        log.info("Customer_09 - Step 7: Click to 'Edit' button");
        adminCustomerPage.clickToEditButtonByCustomerName("Edit Automation Edit FC");

        log.info("Customer_09 - Step 8: Verify 'Edit customer details' screen is displayed");
        Assert.assertTrue(adminCustomerPage.isTitleDisplayedAtAdmin("Edit customer details"));

        log.info("Customer_09 - Step 9: Click to 'Delete' button at 'Address' table");
        adminCustomerPage.clickToDeleteButtonAtAddressByFirstName("Edit Automation");

        log.info("Customer_09 - Step 10: Accept alert");
        adminCustomerPage.acceptAlert();

        log.info("Customer_09 - Step 11: Verify 'Loading' icon is not displayed");
        adminCustomerPage.verifyUndisplayedLoadingIcon();

        log.info("Customer_09 - Step 12: Verify no data is displayed");
        Assert.assertEquals(adminCustomerPage.getEmptyAddressMessage(), "No data available in table");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
