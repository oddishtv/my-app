package com.mycompany.app;


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
    @Test
    public void driverIsKing()
    {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue("failed on atempt to read page Title-Selenium Ximplified-", driver.getTitle().startsWith("Selenium Ximplified"));
    }
}
