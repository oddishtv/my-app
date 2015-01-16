package com.mycompany.app;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

//    @Rule
//    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();


    @BeforeClass
    public static void beforeClass() {
        driver = new FirefoxDriver();
    }


    @AfterClass
    public static void afterClass() {
    driver.quit();
    }

    @Test
    public void driverIsKing()
    {
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        WebElement login = driver.findElementByXPath(".//*[@id='UserName']");
        login.click();
        login.sendKeys("Voborskyi");
        WebElement password = driver.findElementByXPath(".//*[@id='Password']");
        password.click();
        password.sendKeys("Kaway74+00");
        WebElement loginClick = driver.findElementByXPath(".//*[@id='logon']/div/form/div[3]/button");
        loginClick.click();

        //driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue("passed", driver.getTitle().contains("Dashboard"));

       // assertTrue("failed on atempt to read page Title-Selenium Ximplified-", driver.getTitle().startsWith("Selenium Ximplified"));
       // driver.quit();
    }

    @Test
    public void FirefoxIsSupported()
    {
        driver.get("http://dca2chup6web01.mscorp.com/CHUPTrunk/testalias/Administration/Account/LogOn");
        WebElement login = driver.findElement(By.xpath(".//*[@id='UserName']"));
        login.click();
        login.sendKeys("Voborskyi");
        WebElement password = driver.findElement(By.xpath(".//*[@id='Password']"));
        password.click();
        password.sendKeys("Kaway74+00");
        WebElement loginClick = driver.findElement(By.xpath(".//*[@id='logon']/div/form/div[3]/button"));
        loginClick.click();

        //driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue("passed", driver.getTitle().startsWith("Dashboard"));
    }
}
