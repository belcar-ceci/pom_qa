package com.hiberus.university.cecilia.maven.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CommandsBrowser {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        //Thread.sleep(5000);
        driver.quit();

    }

}
