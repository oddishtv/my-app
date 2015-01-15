package com.mycompany.app;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


/**
 * Unit test for simple App.
 */



public class FirstTest
{



    private static WebDriver driver;
    private static Selenium selenium;

    @Rule
    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();


    @BeforeClass
    public static void beforeClass() {
        driver = new FirefoxDriver();
        selenium = new WebDriverBackedSelenium(driver,"http://www.compendiumdev.co.uk/selenium");
    }


    @AfterClass
    public static void afterClass() {
    driver.quit();
    }

    @Test
    public void driverIsKing()
    {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue("failed on atempt to read page Title-Selenium Ximplified-", driver.getTitle().startsWith("Selenium Ximplified"));
        driver.quit();
    }

    @Test
    public void FirefoxIsSupported()
    {
        driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue("failed on atempt to read page Title-Selenium Ximplified-", driver.getTitle().startsWith("Selenium Simplified"));
    }
}
