package com.mycompany.app.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by Vitalii_Oborskyi on 1/16/2015.
 */
public class LoginPage {
    private static WebElement element = null;
    public static WebElement login_button(WebDriver driver){

        element = driver.findElement(By.xpath(".//*[@id='logon']/div/form/div[3]/button"));

        return element;

    }

    public static WebElement select_UserName(WebDriver driver){

        element = driver.findElement(By.xpath(".//*[@id='UserName']"));

        return element;

    }
    public static WebElement select_Password(WebDriver driver){

        element = driver.findElement(By.xpath(".//*[@id='Password']"));

        return element;

    }
    public static void open_Login_page(WebDriver driver) {
    driver.get("http://dca2chup6web01.mscorp.com/CHUPTrunk/testalias/Administration/Account/LogOn?isExpired=true");

    }
}
