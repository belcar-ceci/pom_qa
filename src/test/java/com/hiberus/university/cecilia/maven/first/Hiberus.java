package com.hiberus.university.cecilia.maven.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hiberus {

    public static void main(String[] args) {
        String url = "https://www.hiberus.com/";
        /*
        * 1. Inicie un nuevo navegador Chrome
        2. Abra el sitio web "https://www.hiberus.com/"
        3. Haga click en el enlace de Consultoria y Estrategia usando "driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click()"
        4. Vuelva a la pagina de inicio(utilice el comando .back()
        5. Vuelva  nuevamente a la páina de Consultoria y Estrategia (use el comando .forward())
        6. Vuelva nuevamente a la pagina de inicio (use el comando.to())
        7. Actualizar el navegador(comando .refresh()).
        8. Cierra el navegador
        */


        //Initial Step
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Step 2
        driver.get(url);

        //Step 3
        driver.findElement(By.xpath("//a[@href='/consultoria-y-estrategia-de-negocio']")).click();

        //Step 4
        driver.navigate().back();

        //Step 5
        driver.navigate().forward();

        //Step 6
        driver.navigate().to(url);

        //Step 7
        driver.navigate().refresh();

        //Step 8
        driver.quit();


    }


}
