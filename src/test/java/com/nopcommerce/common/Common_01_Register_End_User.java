package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;

	public static String emailAddress, password;
	private String firstName, lastName;

	private UserHomePageObject homePage;

	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test ")
	public void Register(String browserName) {

		driver = openMultipleBrowser(browserName);

		emailAddress = "Auto" + randomNumber() + "@mail.net";

		System.out.println(emailAddress);

		password = "123456";

		firstName = "Automation";

		lastName = "FC";

		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("PRE-CONDITION - STEP 1: Click to Register Link");

		registerPage = homePage.clickToRegisterLink();

		log.info("PRE-CONDITION - STEP 2: Input valid data for Firstname textbox");

		registerPage.inputToFirstNameTextbox(firstName);

		log.info("PRE-CONDITION - STEP 3: Input valid data for Lastname textbox");

		registerPage.inputToLastNameTextbox(lastName);

		log.info("PRE-CONDITION - STEP 4: Input valid data for Email Address textbox '" + emailAddress + "'");

		registerPage.inputToEmailTextbox(emailAddress);

		log.info("PRE-CONDITION - STEP 5: Input valid data for Password textbox");

		registerPage.inputToPasswordTextbox(password);

		log.info("PRE-CONDITION - STEP 6: Input valid data for Confirm Password textbox");

		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("PRE-CONDITION - STEP 7: Click to Register button");

		registerPage.clickToRegisterButton();

		log.info("PRE-CONDITION - STEP 8: Verify successful register message is displayed.");

		verifyEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");

		driver.quit();

	}

}
