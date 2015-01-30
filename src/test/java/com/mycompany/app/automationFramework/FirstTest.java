package com.mycompany.app.automationFramework;


import com.mycompany.app.PHelpers.ScreenShotRule;
import com.mycompany.app.PageObjects.MainPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.mycompany.app.PHelpers.Helpers.move_mouse_on;
import static junit.framework.Assert.assertTrue;


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
    public void SearchNumberWithXPath()
    {
        String textToLookup = "Перчатки охотничьи Gamo";

        MainPage.open(driver);
        MainPage.xpath_search_field(driver).click();

        MainPage.xpath_search_field(driver).sendKeys(textToLookup);
        MainPage.xpath_search_button_click(driver);

        List<WebElement> numberFound = driver.findElements(By.xpath("//div[2]/div[1]/a[@onclick]"));
        String counterAndText = driver.findElement(By.xpath("//p[@class='search-result-count']")).getText().toString();
        int counterDigitsOnly = Integer.parseInt(counterAndText.replaceAll("[^0-9]", ""));

        assertTrue("search counter is correct and equal to " + counterDigitsOnly, driver.findElement(By.xpath("//p[@class='search-result-count']")).getText().toString().equals("Найдено " + counterDigitsOnly + " товаров"));
        assertTrue("Found gloves", numberFound.size() == counterDigitsOnly);

    }

    //Move mouse on Notebooks tab
    @Test
    public void MoveMouseOnNotebooksWithXPath()
    {

        MainPage.open(driver);
        move_mouse_on(driver, MainPage.xpath_tab_notebooks(driver));
        driver.findElement(By.xpath("//a[contains(., 'Подставки для ноутбуков')]")).click();
        //boolean flag = driver.findElement(By.xpath("//td[1]/div/div[@class=\"popup-css popup-css-green m-main-fat m-main-fat1\" and @name=\"drop-elem\"]")).isDisplayed();
       assertTrue("Is opened appropriate section?", driver.getTitle().contains("Подставки и столики"));
    }


    //Enable checkbox and then check hat it's enabled
    @Test
    public void CheckboxCheckGetEnabled()
    {

        MainPage.open(driver);
        move_mouse_on(driver, MainPage.xpath_tab_notebooks(driver));
        driver.findElement(By.xpath("//a[contains(., 'Подставки для ноутбуков')]")).click();
        ////label/input[@onclick="window.location='http://rozetka.com.ua/notebook_stands/arctic-cooling/c183690/v509/'"]
        String urlToCheck = driver.findElement(By.xpath("//div[1]/ul/li[1]/label/input[@onclick]")).getAttribute("onclick");
        String urlToCheck1 = urlToCheck.substring(urlToCheck.indexOf("='"),urlToCheck.indexOf("'\""));
        //urlToCheck = urlToCheck.replace("input type=\"checkbox\" onclick=\"window.location='", "");
        urlToCheck1 = urlToCheck1.replaceAll("\"", "");
        urlToCheck1 = urlToCheck1.replaceAll("'", "");
        urlToCheck = urlToCheck;
        driver.findElement(By.xpath("//label/input[@onclick=\"window.location='http://rozetka.com.ua/notebook_stands/arctic-cooling/c183690/v509/'\"]")).click();
       String link = driver.getCurrentUrl();
        link = link;
        String checkbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[3]/div[1]/div/div/div/div[3]/form/div[1]/ul/li[1]/label/input")).toString();
        checkbox = checkbox;
     //   assertTrue("Is enabled?", driver.findElement(By.xpath("//label/input[@onclick=\"window.location='http://rozetka.com.ua/notebook_stands/arctic-cooling/c183690/v509/'\"]")).isEnabled());
    }

}



