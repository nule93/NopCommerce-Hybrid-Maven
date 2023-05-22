package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class BasePage {
    private static WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected static BasePage getBasePage() {
        return new BasePage(driver);
    }

    protected void openUrlPage(String urlPage) {
        driver.get(urlPage);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getPageSource() {
        return driver.getPageSource();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    protected void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    protected Alert waitAlertPresence() {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitAlertPresence().accept();
    }

    protected void cancelAlert() {
        waitAlertPresence().dismiss();
    }

    protected String getTextAlert() {
        return waitAlertPresence().getText();
    }

    protected void sendKeysToAlert(String text) {
        waitAlertPresence().sendKeys(text);
    }

    protected String getWindowHandle() {
        return driver.getWindowHandle();
    }

    protected void switchWindowByID(String currentWindowID) {
        Set<String> windowList = driver.getWindowHandles();

        for (String runWindow : windowList) {
            if (!runWindow.equals(currentWindowID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }

    }

    protected void switchWindowByTitle(String windowTitle) {

        Set<String> allWindows = driver.getWindowHandles();

        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            String title = driver.getTitle();
            if (title.equals(windowTitle)) {
                break;
            }
        }
    }

    protected void closeAllWindowsWithoutParent(String parentWindowID) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String runWindow : allWindows) {

            if (!runWindow.equals(parentWindowID)) {
                driver.switchTo().window(runWindow);
                sleepInSecond(1);
                driver.close();

            }
        }
        driver.switchTo().window(parentWindowID);
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id") || locatorType.startsWith("ID") || locatorType.startsWith("Id")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class") || locatorType.startsWith("CLASS") || locatorType.startsWith("Class")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name") || locatorType.startsWith("NAME") || locatorType.startsWith("Name")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css") || locatorType.startsWith("CSS") || locatorType.startsWith("Css")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath")) {
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Please input valid locator type");
        }
        return by;
    }

    private String getByDynamicXpath(String locatorType, String... values) {
        if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath")) {
            locatorType = String.format(locatorType, (Object[]) values);
        }
        return locatorType;
    }

    protected WebElement getElement(String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    protected WebElement getElement(String locatorType, String... dynamicValues) {
        locatorType = String.format(locatorType, (Object[]) dynamicValues);
        return driver.findElement(getByLocator(locatorType));
    }

    protected List<WebElement> getElements(String locatorType) {
        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = driver.findElements(getByLocator(locatorType));
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);
        return elements;
    }

    protected List<WebElement> getElements(String locatorType, String... dynamicValues) {
        locatorType = String.format(locatorType, (Object[]) dynamicValues);
        return driver.findElements(getByLocator(locatorType));
    }

    protected void clickToElement(String locatorType) {
        getElement(locatorType).click();

    }

    protected void clickToElement(String locatorType, String... dynamicValues) {
        getElement(getByDynamicXpath(locatorType, dynamicValues)).click();
    }

    protected void sendkeyToElement(String locatorType, String text) {
        getElement(locatorType).clear();
        getElement(locatorType).sendKeys(text);
    }

    protected void sendkeyToElement(String locatorType, String textValue, String... dynamicValues) {
        getElement(getByDynamicXpath(locatorType, dynamicValues)).clear();
        getElement(getByDynamicXpath(locatorType, dynamicValues)).sendKeys(textValue);
    }

    protected void selectItemInDefaultDropdown(String locatorType, String text) {
        Select select = new Select(getElement(locatorType));

        select.selectByVisibleText(text);
    }

    protected void selectItemInDefaultDropdown(String locatorType, String text, String... dynamicValues) {
        Select select = new Select(getElement(getByDynamicXpath(locatorType, dynamicValues)));
        select.selectByVisibleText(text);
    }

    protected WebElement getSelectedItemInDropdown(String locatorType) {
        Select select = new Select(getElement(locatorType));
        return select.getFirstSelectedOption();
    }

    protected WebElement getSelectedItemInDropdown(String locatorType, String... dynamicValues) {
        Select select = new Select(getElement(getByDynamicXpath(locatorType, dynamicValues)));
        return select.getFirstSelectedOption();
    }

    protected boolean isDropdownMultipe(WebDriver driver, String locatorType) {
        Select select = new Select(getElement(locatorType));
        return select.isMultiple();

    }

    protected void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {

        getElement(parentLocator).click();
        sleepInSecond(2);

        WebDriverWait explicitWait;
        explicitWait = new WebDriverWait(driver, time);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {

                jsExecutor.executeScript("arguments[0].scrollIntoIfNeeded;", item);
                sleepInSecond(2);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    protected String getAttributeValue(String locatorType, String attributeName) {

        return getElement(locatorType).getAttribute(attributeName);

    }

    protected String getAttributeValue(String locatorType, String attributeName, String... dynamicValues) {

        return getElement(getByDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);

    }

    protected String getTextElement(String locatorType) {

        return getElement(locatorType).getText();

    }

    protected String getTextElement(String locatorType, String... dynamicValues) {

        return getElement(getByDynamicXpath(locatorType, dynamicValues)).getText();

    }

    protected String getCSSValue(String locatorType, String propertyName) {
        return getElement(locatorType).getCssValue(propertyName);
    }

    protected String getHexaColorFromRGBA(String rgba) {
        return Color.fromString(rgba).asHex();
    }

    protected int getElementsSize(String locatorType) {
        return getElements(locatorType).size();
    }

    protected int getElementsSize(String locatorType, String... dynamicValues) {
        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        int size = getElements(getByDynamicXpath(locatorType, dynamicValues)).size();
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);
        return size;
    }

    protected void checkTheCheckboxOrRadio(String locatorType) {
        WebElement element = getElement(locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void checkTheCheckboxOrRadio(String locatorType, String... values) {

        WebElement element = getElement(getByDynamicXpath(locatorType, values));
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void checkTheCheckboxOrRadioByJS(String locatorType, String... values) {

        WebElement element = getElement(getByDynamicXpath(locatorType, values));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (!element.isSelected()) {
            js.executeScript("arguments[0].click();", element);
        }
    }

    protected void uncheckTheCheckbox(String locatorType) {
        WebElement element = getElement(locatorType);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckTheCheckbox(String locatorType, String... values) {
        WebElement element = getElement(getByDynamicXpath(locatorType, values));
        if (element.isSelected()) {
            element.click();
        }
    }

    protected boolean isElementDisplayed(String locatorType) {
        return getElement(locatorType).isDisplayed();
    }

    protected boolean isElementDisplayed(String locatorType, String... dynamicValues) {
        return getElement(getByDynamicXpath(locatorType, dynamicValues)).isDisplayed();
    }

    protected boolean isElementSelected(String locatorType) {
        return getElement(locatorType).isSelected();
    }

    protected boolean isElementSelected(String locatorType, String... dynamicValues) {
        return getElement(getByDynamicXpath(locatorType, dynamicValues)).isSelected();
    }

    protected boolean isElementEnabled(String locatorType) {
        return getElement(locatorType).isEnabled();
    }

    protected boolean isElementEnabled(String locatorType, String... dynamicValues) {
        return getElement(getByDynamicXpath(locatorType, dynamicValues)).isEnabled();
    }

    protected void switchToFrameIframe(String locatorType) {
        driver.switchTo().frame(getElement(locatorType));
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void hoverMouseToElement(String locatorType) {
        Actions action = new Actions(driver);
        action.moveToElement(getElement(locatorType)).perform();
    }

    protected void hoverMouseToElement(String locatorType, String... values) {
        Actions action = new Actions(driver);
        action.moveToElement(getElement(getByDynamicXpath(locatorType, values))).perform();
    }

    protected void pressKeyToElement(String locatorType, Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(getElement(locatorType), key).perform();
    }

    protected void pressKeyToElement(String locatorType, Keys key, String... dynamicValues) {
        Actions action = new Actions(driver);
        action.sendKeys(getElement(getByDynamicXpath(locatorType, dynamicValues)), key).perform();
    }

    protected String getInnerText() {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    protected boolean areExpectedTextInInnerText(String textExpected) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    protected void scrollToBottomPage() {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void navigateToUrlByJS(String url) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    protected void highlightElement(String locatorType) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(locatorType);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    protected void clickToElementByJS(String locatorType) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(locatorType));
    }

    protected void clickToElementByJS(String locatorType, String... dynamicValues) {
        locatorType = String.format(locatorType, (Object[]) dynamicValues);
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(locatorType));
    }

    protected void scrollToElement(String locatorType) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locatorType));
    }

    protected void scrollToElement(String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(getByDynamicXpath(locatorType, dynamicValues)));
    }

    protected void sendkeyToElementByJS(String locatorType, String value) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locatorType));
    }

    protected void sendkeyToElementByJS(String locatorType, String value, String... dynamicValues) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(getByDynamicXpath(locatorType, dynamicValues)));
    }

    protected void removeAttributeInDOM(String locatorType, String attributeRemove) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locatorType));
    }

    protected void removeAttributeInDOM(String locatorType, String attributeRemove, String... dynamicValues) {
        locatorType = String.format(locatorType, (Object[]) dynamicValues);
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locatorType));
    }

    protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait;
        explicitWait = new WebDriverWait(driver, time);
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    protected String getElementValidationMessage(String locatorType) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locatorType));
    }

    protected boolean isImageLoaded(String locatorType) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(locatorType));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    protected void waitForElementVisible(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
        } catch (Exception e) {
            System.out.println("The element doesn't display");
        }
    }

    protected void waitForElementVisible(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getByDynamicXpath(locatorType, dynamicValues))));
        } catch (Exception e) {
            System.out.println("The element doesn't display");
        }
    }

    protected void overrideGlobalTimeout(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    protected void waitForElementInvisible(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);
    }

    protected boolean isElementUndisplayed(String locatorType) {
        boolean status = true;

        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getElements(locatorType);
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) {
            return status;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return status;
        } else {
            status = false;
        }
        return status;
    }

    protected boolean isElementUndisplayed(String locatorType, String... dynamicValues) {
        boolean status = true;

        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getElements(getByDynamicXpath(locatorType, dynamicValues));
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);

        if (elements.size() == 0) {
            return status;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return status;
        } else {
            status = false;
        }
        return status;
    }

    protected void waitForElementPresence(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(locatorType)));
    }

    protected void waitForElementStaleness(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);

        explicitWait.until(ExpectedConditions.stalenessOf(getElement(locatorType)));
    }

    protected void waitForElementInvisible(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getByDynamicXpath(locatorType, dynamicValues))));
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);
    }

    protected void waitForElementClickable(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);

        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    protected void waitForElementClickable(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getByDynamicXpath(locatorType, dynamicValues))));
    }

    protected void waitForAllElementsVisible(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);

        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
    }

    protected void waitForAllElementsVisible(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, time);

        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getByDynamicXpath(locatorType, dynamicValues))));
    }

    protected void waitForAllElementsInvisible(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(locatorType)));
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);
    }

    protected void waitForAllElementsInvisible(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(getByDynamicXpath(locatorType, dynamicValues))));
        explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        overrideGlobalTimeout(GlobalConstants.LONG_TIMEOUT);
    }

    protected void clickToOrdersPageAtUserPage() {
        waitForElementClickable(BasePageUI.USER_ORDERS_MENU);
        clickToElement(BasePageUI.USER_ORDERS_MENU);
    }

    protected void clickToAddressesPageAtUserPage() {
        waitForElementClickable(BasePageUI.USER_ADDRESSES_MENU);
        clickToElement(BasePageUI.USER_ADDRESSES_MENU);
    }

    protected void clickToCustomerInfoPageAtUserPage() {
        waitForElementClickable(BasePageUI.USER_CUSTOMER_INFO_MENU);
        clickToElement(BasePageUI.USER_CUSTOMER_INFO_MENU);
    }

    public UserHomePageObject clickToLogoutLinkAtUserPage() {
        waitForElementVisible(BasePageUI.USER_LOGOUT_LINK);
        waitForElementClickable(BasePageUI.USER_LOGOUT_LINK);
        clickToElementByJS(BasePageUI.USER_LOGOUT_LINK);
//		clickToElement(driver, BasePageUI.USER_LOGOUT_LINK);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public AdminLoginPageObject clickToLogoutLinkAtAdminPage() {
        waitForElementClickable(BasePageUI.ADMIN_LOGOUT_LINK);
        clickToElement(BasePageUI.ADMIN_LOGOUT_LINK);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

    public BasePage openPageMyAccountByName(WebDriver driver, String pageName) {
        waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_MY_ACCOUNT_AREA, "block-account-navigation", pageName);
        clickToElement(BasePageUI.USER_DYNAMIC_PAGE_MY_ACCOUNT_AREA, "block-account-navigation", pageName);
        switch (pageName) {
            case "Customer info":
                return PageGeneratorManager.getUserCustomerInfoPageObject(driver);
            case "Addresses":
                return PageGeneratorManager.getUserAddressesPageObject(driver);
            case "Orders":
                return PageGeneratorManager.getUserOrdersPageObject(driver);
            case "My product reviews":
                return PageGeneratorManager.getUserMyProductReviewsPageObject(driver);
            case "Change password":
                return PageGeneratorManager.getUserChangePasswordPageObject(driver);

            default:
                throw new RuntimeException("Invalid page name at My account area.");
        }
    }

    public void openPageMyAccountByPageName(String pageName) {
        waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_MY_ACCOUNT_AREA, "block-account-navigation", pageName);
        clickToElement(BasePageUI.USER_DYNAMIC_PAGE_MY_ACCOUNT_AREA, "block-account-navigation", pageName);
    }

    public void clickToHeaderLinkByName(WebDriver driver, String headerName) {
        waitForElementVisible(BasePageUI.USER_DYNAMIC_PAGE_MY_ACCOUNT_AREA, "header-links", headerName);
        clickToElement(BasePageUI.USER_DYNAMIC_PAGE_MY_ACCOUNT_AREA, "header-links", headerName);

    }

    public void clickToCloseButtonOnNotifyBar() {
        waitForElementVisible(BasePageUI.CLOSE_BUTTON);
        clickToElement(BasePageUI.CLOSE_BUTTON);
        sleepInSecond(2);
    }

    public UserSearchPageObject clickToSearchLinkUnderFooter() {
        waitForElementVisible(BasePageUI.USER_SEARCH_LINK);
        clickToElement(BasePageUI.USER_SEARCH_LINK);
        return PageGeneratorManager.getUserSearchPage(driver);
    }

    protected void uploadMultipleFiles(String... files) {
        String fileFullName = "";
        String filePath = GlobalConstants.UPLOAD_PATH;

        for (String file : files) {
            fileFullName = fileFullName + filePath + file + "\n";
        }
        fileFullName = fileFullName.trim();
        System.out.println(fileFullName);
        getElement(BasePageUI.UPLOAD_LINK).sendKeys(fileFullName);

    }

    protected boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                System.out.println(" -------------------------- PASSED -------------------------- ");
            } else {
                System.out.println(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                System.out.println(" -------------------------- PASSED -------------------------- ");
            } else {
                System.out.println(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            System.out.println(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            System.out.println(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    public void setCookie(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(3);
    }

    public Set<Cookie> getAllCookie(WebDriver driver) {
        return driver.manage().getCookies();

    }

    public void clickToSubMenuByName(String menu, String submenu) {
        scrollToElement(UserHomePageUI.CATEGORY_DYNAMIC_LINK, menu);
        waitForElementVisible(UserHomePageUI.CATEGORY_DYNAMIC_LINK, menu);
        hoverMouseToElement(UserHomePageUI.CATEGORY_DYNAMIC_LINK, menu);
        waitForElementClickable(UserHomePageUI.SUB_MENU_DYNAMIC_LINK, submenu);
        clickToElement(UserHomePageUI.SUB_MENU_DYNAMIC_LINK, submenu);

    }

    public int getIndexOfWishListLink() {
        waitForAllElementsVisible(BasePageUI.WISHLIST_LINK);
        int index = Integer.parseInt(getTextElement(BasePageUI.WISHLIST_LINK).replace("Wishlist (", "").replace(")", ""));
        return index;
    }

    public UserCustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserCustomerInfoPageObject(driver);
    }

    public void clickToShoppingCartIcon() {
        waitForElementClickable(BasePageUI.SHOPPING_CART_ICON);
        clickToElement(BasePageUI.SHOPPING_CART_ICON);

    }

    public boolean isTitleDisplayedAtAdmin(String titleName) {
        waitForElementVisible(BasePageUI.TITLE_PAGE_AT_ADMIN, titleName);
        return isElementDisplayed(BasePageUI.TITLE_PAGE_AT_ADMIN, titleName);
    }

    public void clickToSubMenuByNameAtAdmin(String menu, String submenu) {
        waitForElementClickable(BasePageUI.ADMIN_DYNAMIC_MENU, menu);
        clickToElement(BasePageUI.ADMIN_DYNAMIC_MENU, menu);

        sleepInSecond(1);

        waitForElementClickable(BasePageUI.ADMIN_DYNAMIC_SUBMENU, submenu);
        clickToElement(BasePageUI.ADMIN_DYNAMIC_SUBMENU, submenu);

    }

    public void verifyUndisplayedLoadingIcon() {
        waitForElementInvisible(BasePageUI.LOADING_ICON);
        Assert.assertFalse(isElementDisplayed(BasePageUI.LOADING_ICON));

    }

    public void clickToMenu(String menuName) {
        waitForElementVisible(BasePageUI.BANK_GURU_DYNAMIC_MENU_BY_NAME, menuName);
        clickToElement(BasePageUI.BANK_GURU_DYNAMIC_MENU_BY_NAME, menuName);

    }

    public void closeAdvertisePopupAtBankGuru() {
        if (getElementsSize(BasePageUI.BANK_GURU_CLOSE_ADVERTISE_POPUP) > 0) {
            waitForElementClickable(BasePageUI.BANK_GURU_CLOSE_ADVERTISE_POPUP);
            clickToElementByJS(BasePageUI.BANK_GURU_CLOSE_ADVERTISE_POPUP);
        }
    }

    public void clickToButtonByAttributeValue(String value) {
        scrollToElement(BasePageUI.BANK_GURU_DYNAMIC_BUTTON_BY_ATTRIBUTE_VALUE, value);

        waitForElementClickable(BasePageUI.BANK_GURU_DYNAMIC_BUTTON_BY_ATTRIBUTE_VALUE, value);
        clickToElement(BasePageUI.BANK_GURU_DYNAMIC_BUTTON_BY_ATTRIBUTE_VALUE, value);

    }

    public void verifyTitleDisplayed(String title) {
        waitForElementVisible(BasePageUI.DYNAMIC_TITLE_BY_CONTENT_TITLE, title);
        Assert.assertTrue(isElementDisplayed(BasePageUI.DYNAMIC_TITLE_BY_CONTENT_TITLE, title));

    }

    protected String getCurrentDay() {
        DateTime nowUTC = new DateTime(DateTimeZone.UTC);
        int day = nowUTC.getDayOfMonth();
        return day + "";
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        int month = now.getMonthOfYear();
        return month + "";
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        return now.getYear() + "";
    }

    protected String getToday() {
        return getCurrentMonth() + "/" + getCurrentDay() + "/" + getCurrentYear();
    }


    private long time = 30;
}
