package com.rakuten.ui.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Logger logger;
    public WebDriver driver;
    public int implicitwait = 20;
    public int pageLoadTimeout = 30;

    @BeforeSuite
    public void setLogger() {
        logger = Logger.getLogger("SeleniumUIAssignmentRakuten"); // added logger
        PropertyConfigurator.configure("Log4j.properties");
        logger.setLevel(Level.DEBUG);
    }

    @BeforeClass
    @Parameters({"testUrl", "browser"})
    public void Driversetup(String testUrl, String browser) {

        createBrowseObject(browser);
        driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.get(testUrl);
        logger.info("Started " +browser+ "driver on OS " + System.getProperty("os.name"));
        driver.manage().window().maximize();
        checkConsentPrompt();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public void checkConsentPrompt() {
        if (!driver.findElements(By.id("consent_prompt_submit")).isEmpty()) ;
        {
            driver.findElement(By.id("consent_prompt_submit")).click();
        }
    }

    public void createBrowseObject(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.geckodriver", "geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }
}
