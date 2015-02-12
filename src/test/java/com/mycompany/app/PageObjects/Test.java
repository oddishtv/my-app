package com.mycompany.app.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by odd on 2/12/2015.
 */
public class Test {
    private static WebElement element = null;


    public static void open(WebDriver driver) {
        driver.get("file:///D:/test.html");
    }

}
