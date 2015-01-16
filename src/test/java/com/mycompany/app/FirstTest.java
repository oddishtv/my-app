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
import org.junit.rules.MethodRule;
import org.junit.runners.model.Statement;
import org.junit.runners.model.FrameworkMethod;
import java.io.File;
import java.io.FileOutputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Unit test for simple App.
 */



public class FirstTest
{



    private static WebDriver driver;
    private static Selenium selenium;

    class ScreenshotTestRule implements MethodRule {
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
                        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                        out.close();
                    } catch (Exception e) {
                        // No need to crash the tests if the screenshot fails
                    }
                }
            };
        }
    }

    @Rule
    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();


    @BeforeClass
    public static void beforeClass() {
        driver = new FirefoxDriver();
    }


/*    @AfterClass
    public static void afterClass() {
    driver.quit();
    }
*/
/*    @Test
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
*/
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
        assertTrue("passed", driver.getTitle().startsWith("Sashboard"));
    }
}
