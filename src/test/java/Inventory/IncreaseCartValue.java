package Inventory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.List;

public class IncreaseCartValue {
    public static void main(String[] args) {
        /*
        1. Ir a la página https://www.saucedemo.com
        2. Escribir el username standard_user
        3. Escribir el password secret_sauce
        4. Pulsar en el botón del Login.
        5. Validar que el número de productos mostrados es igual a 6.
        * */

        //Initial Step
        WebDriver driver;
        WebDriverManager. chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        // Step 1
        driver.get("https://www.saucedemo.com/");

        //Step 2
        WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
        username.sendKeys("standard_user");

        //Step3
        WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("secret_sauce");

        //Step 4
        WebElement loginEnter = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginEnter.click();

        //Step 5
        try {
            // Locate the "Add to cart" button, related to the product you want to add and click on it.
            WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
            addToCartButton.click();

            // Find the product counter element in the cart, and verify that its value has changed.
            WebElement cartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
            String badgeValue = cartBadge.getText();
            if (badgeValue.equals("1")) {
                System.out.println("El producto se agregó correctamente al carrito.");
            } else {
                System.out.println("No se logro agregar el producto al carrito.");
            }
        } catch (Exception messageError) {
            System.out.println("No se logro agregar el producto al carrito debido a una excepción: " + messageError.getMessage());
        }

        // Closed Step
        driver.quit();

    }
}
