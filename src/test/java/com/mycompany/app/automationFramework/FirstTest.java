package com.mycompany.app.automationFramework;


//import com.thoughtworks.selenium.Selenium;
//import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
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

import javax.xml.xpath.XPath;
import java.util.List;
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

/*
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
*/
    //Find Перчатки охотничьи Gamo Canada Brown M (458094227M)
    @Test
    public void SearchWithXPath()
    {
        String textToLookup = "Перчатки охотничьи Gamo Canada Brown M (458094227M)";
        MainPage.open(driver);
        MainPage.xpath_search_field(driver).click();

        MainPage.xpath_search_field(driver).sendKeys(textToLookup);
        MainPage.xpath_search_button_click(driver);
        String foundtext = driver.findElement(By.xpath("//div/div/div[3]/div/div[2]/div[1]/a")).getText().toString();
        assertTrue("search counter is correct", driver.findElement(By.xpath("//p[@class='search-result-count']")).getText().toString().equals("Найдено 1 товар"));
        assertTrue("Found gloves", foundtext.equals(textToLookup));

    }

    //Find Перчатки охотничьи Gamo Canada Brown M (458094227M) using CSS

    @Test
    public void SearchWithCSS()
    {
        String textToLookup = "Перчатки охотничьи Gamo Canada Brown M (458094227M)";
        MainPage.open(driver);
        MainPage.css_search_field(driver).click();

        MainPage.css_search_field(driver).sendKeys(textToLookup);
        MainPage.css_search_button_click(driver);
        String foundtext = driver.findElement(By.cssSelector("div.g-i-list-right-part div.g-i-list-title a")).getText().toString();
        assertTrue("passed", foundtext.equals(textToLookup));



    }

    //Find Перчатки охотничьи Gamo. Check that 8 counted as a search  result and that actually 8 returned.
    @Test
    public void Search8WithXPath()
    {
        String textToLookup = "Перчатки охотничьи Gamo";
        MainPage.open(driver);
        MainPage.xpath_search_field(driver).click();

        MainPage.xpath_search_field(driver).sendKeys(textToLookup);
        MainPage.xpath_search_button_click(driver);
        List<WebElement> numberFound = driver.findElements(By.xpath("//div[2]/div[1]/a[@onclick]"));
        numberFound.size();
        assertTrue("search counter is correct and = 8", driver.findElement(By.xpath("//p[@class='search-result-count']")).getText().toString().equals("Найдено 8 товаров"));
        assertTrue("Found gloves", numberFound.size() == 8);

    }

}



