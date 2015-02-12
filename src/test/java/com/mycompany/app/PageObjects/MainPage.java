package com.mycompany.app.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by odd on 1/23/2015.
 */
public class MainPage {
    private static WebElement element = null;

    public static void open(WebDriver driver) {
        driver.get("http://rozetka.com.ua/");

    }


    public static WebElement xpath_search_field(WebDriver driver){

        element = driver.findElement(By.xpath("//div[2]/form/div[2]/div[1]/input[@class = 'header-search-input-text']"));

        return element;

    }

    public static WebElement css_search_field(WebDriver driver){

        element = driver.findElement(By.cssSelector("input.header-search-input-text"));

        return element;

    }

    public static void xpath_search_button_click(WebDriver driver){

        driver.findElement(By.xpath("//div[2]/form/div[1]/span/button[@type = 'submit']")).click();

    }
    public static void css_search_button_click(WebDriver driver){

        driver.findElement(By.cssSelector("span.btn-link.btn-link-green.header-search-submit button.btn-link-i")).click();

    }

    //driver.findElement(By.xpath("//td[1]/div/a[@class = \"m-main-title\" and @name=\"active-elem\"]"));

    public static WebElement xpath_tab_notebooks(WebDriver driver){

       element = driver.findElement(By.xpath("//td[1]/div/a[@class = \"m-main-title\" and @name=\"active-elem\"]"));

        return element;

    }
}
