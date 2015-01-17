package com.mycompany.app.automationFramework;


//import com.thoughtworks.selenium.Selenium;
//import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
//import org.junit.rules.MethodRule;
//import org.junit.runners.model.Statement;
//import org.junit.runners.model.FrameworkMethod;
//import java.io.File;
//import java.io.FileOutputStream;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import com.mycompany.app.PageObjects.*;
//import com.mycompany.app.automationFramework.*;

/**
 * Unit test for simple App.
 */



public class FirstTest
{




    public static WebDriver driver;

/*    class ScreenshotTestRule implements MethodRule {
        private WebDriver myDriver;
        ScreenshotTestRule(WebDriver dr){
        myDriver = dr;
        }
        public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        statement.evaluate();
                    } catch (Throwable t) {
                        captureScreenshot(frameworkMethod.getName());
                        throw t; // rethrow to allow the failure to be reported to JUnit
                    }
                }

                public void captureScreenshot(String fileName) {
                    try {
                        new File("D:/reports/").mkdirs(); // Insure directory is there
                        FileOutputStream out = new FileOutputStream("D:/reports/screenshot-" + fileName + ".png");
                        out.write(((TakesScreenshot) myDriver).getScreenshotAs(OutputType.BYTES));
                        out.close();
                    } catch (Exception e) {
                        // No need to crash the tests if the screenshot fails
                    }
                }
            };
        }
    }*/

    @Rule
    public ScreenShotRule screenshotTestRule = new ScreenShotRule(driver);


    @BeforeClass
    public static void beforeClass() {
        driver = new FirefoxDriver();
    }


    @AfterClass
    public static void afterClass() {
    driver.quit();
    }

/*    @Test
    public void driverIsKing()
    {
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        WebElement login = driver.findElementByXPath("./*//*[@id='UserName']");
        login.click();
        login.sendKeys("111");
        WebElement password = driver.findElementByXPath("./*//*[@id='Password']");
        password.click();
        password.sendKeys("111");
        WebElement loginClick = driver.findElementByXPath("./*//*[@id='logon']/div/form/div[3]/button");
        loginClick.click();

        //driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue("passed", driver.getTitle().contains("Dashboard"));

       // assertTrue("failed on atempt to read page Title-Selenium Ximplified-", driver.getTitle().startsWith("Selenium Ximplified"));
       // driver.quit();
    }*/

    /*@Test
    public void FirefoxIsSupported()
    {
        driver.get("111");
        WebElement login = driver.findElement(By.xpath("./*//*[@id='UserName']"));
        login.click();
        login.sendKeys("111");
        WebElement password = driver.findElement(By.xpath("./*//*[@id='Password']"));
        password.click();
        password.sendKeys("111");
        WebElement loginClick = driver.findElement(By.xpath("./*//*[@id='logon']/div/form/div[3]/button"));
        loginClick.click();

        //driver.get("http://www.compe121312ndiumdev.co.uk/selenium");
        assertTrue("passed", driver.getTitle().startsWith("Dashboard"));
    }
*/

    @Test
    public void FirefoxwithPageObject()
    {
        //driver.get("111");
        LoginPage.open_Login_page(driver);
        LoginPage.select_UserName(driver).sendKeys("111");
        LoginPage.select_Password(driver).sendKeys("111");
        LoginPage.login_button(driver).click();

        //driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue("passed", driver.getTitle().startsWith("Sashboard"));
    }

}



