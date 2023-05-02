package com.hiberus.university.cecilia.maven.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommandsBrowser {

    public static void main(String[] args) {

        String url = "https://www.saucedemo.com/";

        // PASO 1
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        //PASO 2
        driver.get("https://www.saucedemo.com/");

        //PASO 3
        String title = driver.getTitle();
        int largoTitle = title.length();

        //PASO 4
        System.out.println("El título de la página es: " + title);
        System.out.println("La longitud del título es: " + largoTitle);

        //PASO 5


        String urlActual = driver.getCurrentUrl();
        if(urlActual.equals(url)) {
            System.out.println("The URL is correct.");
        } else {
            System.out.println("The URL is not correct.");
        }


        //PASO 6
        String codeFont = driver.getPageSource();
        int lengthFont = codeFont.length();

        //PASO 7
        System.out.println("The length of the page source is: " + lengthFont);

        //Thread.sleep(5000);
        driver.quit();

    }

}
