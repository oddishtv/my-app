package com.mycompany.app.PageObjects;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;


/**
 * Created by odd on 2/12/2015.
 */
public class SignUp {

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("passwd");
    By loginButtonLocator = By.id("login");

    private final WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;

        if (!"ROZETKA — Регистрация".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the SignIn page");
        }
    }

    public SignUp typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public SignUp typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }




    public SignUp submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new SignUp(driver);
    }


}
