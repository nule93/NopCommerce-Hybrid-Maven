package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	public AdminDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isDashboardPageDisplayed() {
		waitForElementVisible(AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(AdminDashboardPageUI.DASHBOARD_HEADER);
	}


	
	
	

}
