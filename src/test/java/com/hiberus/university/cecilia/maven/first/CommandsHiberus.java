package com.hiberus.university.cecilia.maven.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommandsHiberus {
    public static void main(String[] args) {

        //String url = "https://www.hiberus.com/";

        // PASO 1
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        //PASO 2
        driver.get("https://www.hiberus.com/");

        //PASO 3

        WebElement consultoriaLink = driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']"));
        consultoriaLink.click();

        //PASO 8
        driver.quit();

    }
}
