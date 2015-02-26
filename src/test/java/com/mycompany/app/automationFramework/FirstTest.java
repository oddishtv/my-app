package com.mycompany.app.automationFramework;


import com.mycompany.app.PHelpers.ScreenShotRule;
import com.mycompany.app.PageObjects.MainPage;
import com.mycompany.app.PageObjects.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.mycompany.app.PHelpers.Helpers.close_tab;
import static com.mycompany.app.PHelpers.Helpers.move_mouse_on;
import static com.mycompany.app.PHelpers.Helpers.new_tab;
import static junit.framework.Assert.assertTrue;

import com.mycompany.app.PHelpers.*;


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
        driver.manage().window().maximize();
    }


    @AfterClass
    public static void afterClass() {
 //   driver.quit();
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
        String urlToCheck = driver.findElement(By.xpath("//div[1]/ul/li[1]/label/input[@onclick]")).getAttribute("onclick");
        String urlToCheckCrop = urlToCheck.substring(urlToCheck.indexOf("'") + 1,urlToCheck.lastIndexOf("'"));
        driver.findElement(By.xpath("//div[1]/ul/li[1]/label/input[@onclick]")).click();
        String link = driver.getCurrentUrl();
        String labelOfCheckbox = driver.findElement(By.xpath("//div[1]/ul/li[1]/label/a/span")).getText().toString();
        String labelOfUnchecker = driver.findElement(By.xpath("//a[@class='filter-active-i-link']")).getText().toString();

        assertTrue("When Checkbox clicked is appropriate page opens?", link.equals(urlToCheckCrop));
        assertTrue("Is checkbox enabled now?", driver.findElement(By.xpath("//input[@checked]")).isEnabled());
        assertTrue("Is label for unckecker the same as checkbox have?", labelOfCheckbox.equals(labelOfUnchecker));

    }
    // поработать с dropdowns

    @Test
    public void workWithDropDowns()
    {



    }

    // поработать с алертами



    // поработать с окнами
    @Test
    public void workWithWindows()
    {
        MainPage.open(driver);
        String handle = driver.getWindowHandle();
        new_tab(driver);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        MainPage.open(driver);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        //close_tab(driver);



    }

    // поработать с фреймами


    // поработать с радиобаттонами
    //параметризация в джюнит и ддт
    //page object and page element
    //add properties file
    //add to pageobject return for a page and checks that needed page opens
}



