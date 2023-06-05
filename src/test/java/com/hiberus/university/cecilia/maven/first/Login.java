package com.hiberus.university.cecilia.maven.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Login {

    WebDriver driver;

    String url = "https://www.saucedemo.com/";

    @Before
    public void SetUp(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get(url);
    }

    @Test
    public void validationLoginCorrect(){

    }

    @Test
    public void validationLoginError(){

    }

    @After
    public void TearDown(){
        driver.close();

    }
}
