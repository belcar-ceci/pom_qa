package Inventory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ValidateNumberResults {

    public static void main(String[] args) {
        /*
        * 1. Ir a la página https://www.saucedemo.com
        2. Escribir el username standard_user
        3. Escribir el password secret_sauce
        4. Pulsar en el botón del Login.
        5. Validar que el número de productos mostrados es igual a 6.
        * */

        //Initial Step
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
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
        int numProduct = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        System.out.println("The number of products displayed is: " + numProduct);
        if (numProduct == 6) {
            System.out.println("6 products are displayed.");
        } else {
            System.out.println("ERROR: 6 products have not been displayed..");
        }

        //step closure
        driver.quit();




    }




}
