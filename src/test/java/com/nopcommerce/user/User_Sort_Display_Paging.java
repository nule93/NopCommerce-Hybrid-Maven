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
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class User_Sort_Display_Paging extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userHomePage.clickToSubMenuByName("Computers", "Notebooks");
		Assert.assertTrue(userHomePage.isCategoryTitleDisplayed("Notebooks"));
	}

	@Test
	public void Sort_01_Name_From_A_To_Z(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort Name From A To Z");
		ExtentTestManager.getTest().log(Status.INFO, "Select 'Name: A to Z' ");

		userHomePage.selectToSortBy("Name: A to Z");

		userHomePage.verifyProductsSortedBy("Name: A to Z");
		
		log.info("-------------------------------------------");

	}
	@Test
	public void Sort_02_Name_From_Z_To_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort Name From Z To A");
		ExtentTestManager.getTest().log(Status.INFO, "Select 'Name: Z to A'");

		userHomePage.selectToSortBy("Name: Z to A");

		userHomePage.verifyProductsSortedBy("Name: Z to A");

		log.info("-------------------------------------------");
	}

	@Test
	public void Sort_03_Price_Low_To_High(Method method) {

		ExtentTestManager.startTest(method.getName(), "Sort Price Low To High");
		ExtentTestManager.getTest().log(Status.INFO, "Select 'Price: Low To High'");

		userHomePage.selectToSortBy("Price: Low to High");

		userHomePage.verifyProductsSortedBy("Price: Low to High");
		
		log.info("-------------------------------------------");
	}

	@Test
	public void Sort_04_Price_High_To_Low(Method method) {

		ExtentTestManager.startTest(method.getName(), "Sort: Price High To Low");
		ExtentTestManager.getTest().log(Status.INFO, "Select: Price High to Low");

		userHomePage.selectToSortBy("Price: High to Low");

		userHomePage.verifyProductsSortedBy("Price: High to Low");
		
		log.info("-------------------------------------------");
	}

	@Test
	public void Sort_05_Display_3_Products_Per_Page(Method method) {

		ExtentTestManager.startTest(method.getName(), "Display Product Per Page: 3 products per page");
		ExtentTestManager.getTest().log(Status.INFO, "" +
				"Select number 3");

		userHomePage.selectToDisplayPerPage("3");

		userHomePage.verifyPerPage(3);
		
		log.info("-------------------------------------------");
	}

	@Test
	public void Sort_06_Display_6_Products_Per_Page(Method method) {

		ExtentTestManager.startTest(method.getName(), "Display Product Per Page: 6 products per page");
		ExtentTestManager.getTest().log(Status.INFO, "" +
				"Select number 6");

		userHomePage.selectToDisplayPerPage("6");

		userHomePage.verifyPerPage(6);
		
		log.info("-------------------------------------------");
	}

	@Test
	public void Sort_07_Display_9_product_Per_Page(Method method) {

		ExtentTestManager.startTest(method.getName(), "Display Product Per Page: 9 products per page");
		ExtentTestManager.getTest().log(Status.INFO, "Select number 9");
		userHomePage.selectToDisplayPerPage("9");

		userHomePage.verifyPerPage(9);
		
		log.info("-------------------------------------------");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
