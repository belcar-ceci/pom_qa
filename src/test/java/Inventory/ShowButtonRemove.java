package Inventory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShowButtonRemove {
    public static void main(String[] args) {
        /*
        1. Ir a la página https://www.saucedemo.com
        2. Escribir el username standard_user
        3. Escribir el password secret_sauce
        4. Pulsar en el botón del Login.
        5. Agregar al carrito el producto Sauce Labs Onesie
        //Xpath //button[@id='add-to-cart-sauce-labs-onesie']
        6. Validamos que, al agregar el producto, se visualiza el botón REMOVE*/

        //Initial step
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        //Step 1
        driver.get("https://www.saucedemo.com/");

        //Step 2
        WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
        username.sendKeys("standard_user");

        //Step 3
        WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("secret_sauce");

        // Step 4
        WebElement loginEnter = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginEnter.click();

        //Step 5
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
        addToCartButton.click();

       // Step 6
        try {
            WebElement showRemoveButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']"));
            if (showRemoveButton.isDisplayed()) {
                System.out.println("The REMOVE button is displayed correctly.");
            } else {
                System.out.println("Error: The REMOVE button is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Failed to display REMOVE button,there is an exception: " + e.getMessage());
        }

        // Closed Step
        driver.quit();

    }
}
