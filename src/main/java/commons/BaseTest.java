package commons;


import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Nu Le
 */

public class BaseTest {
    public BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    private WebDriver driver;
    protected final Log log;

    public WebDriver getDriverInstance() {
        return this.driver;
    }


    protected WebDriver openMultipleBrowser(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser) {
            case FIREFOX:
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case FHEADLESS:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("window-size=1920x1080");
                driver = WebDriverManager.firefoxdriver().capabilities(firefoxOptions).create();
            case CHEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920x1080");
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
                break;
            case OPERA:
                driver = WebDriverManager.operadriver().create();
                break;
            case IE:
                driver = WebDriverManager.iedriver().create();
                break;
            case COCCOC:
                WebDriverManager.chromedriver().driverVersion("111.0.5563.154").setup();
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
                driver = new ChromeDriver(options);
                driver = WebDriverManager.chromedriver().browserVersion("111.0.5563.154").create();
                break;
            default:
                throw new RuntimeException("Browser name invalid.");
        }

        driver.get(GlobalConstants.USER_PAGE_URL);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        return driver;
    }

    protected WebDriver openMultipleBrowser(String browserName, String env) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser) {
            case FIREFOX:
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case FHEADLESS:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-headless");
                firefoxOptions.addArguments("window-size=1920x1080");
                driver = WebDriverManager.firefoxdriver().capabilities(firefoxOptions).create();
            case CHEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("-headless");
                chromeOptions.addArguments("window-size=1920x1080");
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
                break;
            case OPERA:
                driver = WebDriverManager.operadriver().create();
                break;
            case IE:
                driver = WebDriverManager.iedriver().create();
                break;
            case COCCOC:
                WebDriverManager.chromedriver().driverVersion("111.0.5563.154").setup();
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
                driver = new ChromeDriver(options);
                driver = WebDriverManager.chromedriver().browserVersion("111.0.5563.154").create();
                break;
            default:
                throw new RuntimeException("Browser name is invalid.");
        }

        driver.get(getEnvironment(env));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        return driver;
    }

    private String getEnvironment(String envName) {
        String envUrl = null;
        EnvironmentList environment = EnvironmentList.valueOf(envName.toUpperCase());
        switch (environment) {
            case DEV:
                envUrl = "https://demo.nopcommerce.com/";
                break;
            case TESTING:
                envUrl = "https://admin-demo.nopcommerce.com/";
                break;
            case STAGING:
                envUrl = "http://demo.guru99.com/v1";
                break;
            case PRODUCTION:
                envUrl = "http://demo.guru99.com/v2";
                break;
            default:
                log.info("Please input valid environment");
                break;
        }
        return envUrl;
    }


    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {

            Assert.assertTrue(condition);

            log.info(" -------------------------- PASSED -------------------------- ");

        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);

        }


        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {

            Assert.assertFalse(condition);

            log.info(" -------------------------- PASSED -------------------------- ");

        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);

        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public static int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }


    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME;
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("Windows")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
