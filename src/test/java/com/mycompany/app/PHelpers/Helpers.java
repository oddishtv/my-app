package com.mycompany.app.PHelpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by odd on 1/25/2015.
 */
public class Helpers {

    public static void move_mouse_on(WebDriver driver, WebElement el){

//        WebElement el = driver.findElement(By.xpath("//td[1]/div/a[@class = \"m-main-title\" and @name=\"active-elem\"]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(el);
        builder.perform();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

    }

    public static void new_tab(WebDriver driver){

//        WebElement el = driver.findElement(By.xpath("//td[1]/div/a[@class = \"m-main-title\" and @name=\"active-elem\"]"));
        Set<String> tabs = driver.getWindowHandles();
        Set<String> tabs2 = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.CONTROL + "t");
        builder.perform();
        do {
            tabs2 = driver.getWindowHandles();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        } while (tabs2.size() == tabs.size());

        /*ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));*/
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    }

    public static void close_tab(WebDriver driver){

//        WebElement el = driver.findElement(By.xpath("//td[1]/div/a[@class = \"m-main-title\" and @name=\"active-elem\"]"));
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.CONTROL + "w");
        builder.perform();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);


    }

}
