package com.hiberus.university.cecilia.maven.first.pages;

//import io.cucumber.core.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeoutException;

public class LoginPage extends AbstractPage{
    public static final String PAGE_URL = "https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    private WebElement  usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return loginButton;
    }

    public void clickLogin(){
        /*log.info("Logging in...");
        try{
            loginButton.click();
        } catch(TimeoutException timeoutException){
            log.info("Timeout clicking login: " + timeoutException.getClass().getSimpleName());

        }*/


    }

}
