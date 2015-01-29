package com.mycompany.app.PHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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


}
