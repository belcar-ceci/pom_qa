package ExerciseSeleniumJUnit.InventorySuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class InventoryTest {

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password = "secret_sauce";
    //String expectedUrl = "https://www.saucedemo.com/inventory.html";


    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,5);
        // Step 1
        driver.get(url);
    }

    @Test
    public void ValidateNumberProducts(){

        //Step 2
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);

        //Step 3
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);

        //Step 4
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        //Step 5
        int numProduct = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        System.out.println("The number of products displayed is: " + numProduct);
        if (numProduct == 6) {
            System.out.println("6 products are displayed.");
        } else {
            System.out.println("ERROR: 6 products have not been displayed..");
        }

    }

    @Test
    public void ProductInInventory(){
        /*
        * 1. Ir a la página https://www.saucedemo.com
        2. Escribir el username standard_user
        3. Escribir el password secret_sauce
        4. Pulsar en el botón del Login.
        5  . Validar que el producto Sauce Labs Bolt T-Shirt aparece en el inventario.
        */

        //Step 2
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);

        //Step 3
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);

        //Step 4
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        //Step 5
        try{
            WebElement inventoryProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")));
            // Validar que el producto está visible en el inventario
            Assert.assertTrue(inventoryProduct.isDisplayed());
            System.out.println("The product " + inventoryProduct + " has been found in inventory.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: product has not been validated in inventory");
        }
    }

    @Test
    public void AddProductInCart(){
        /*
        * 1. Ir a la página https://www.saucedemo.com
        2. Escribir el username standard_user
        3. Escribir el password secret_sauce
        4. Pulsar en el botón del Login.
        5. Agregar al carrito el producto Sauce Labs Bolt T-Shirt
        6. Validar que, en el icono del carrito, se ha agregado 1 producto
        * */

        //Step 2
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);

        //Step 3
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);

        //Step 4
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        //Step 5
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        addToCartButton.click();

        // Paso 6: Validar que, en el icono del carrito, se ha agregado 1 producto
        WebElement cartIcon = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        String cartItemCount = cartIcon.getText();
        if (cartItemCount.equals("1")) {
            System.out.println("1 product has been successfully added to the cart.");
        } else {
            System.out.println("No products have been added to the cart.");
        }

    }

    @Test
    public void RemoveProductCartInventory(){

        //Step 2
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);

        //Step 3
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);

        //Step 4
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        //Step 5
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        addToCartButton.click();

        //Step 6
        WebElement showRemoveButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']"));
        showRemoveButton.click();

        //Step 7
        try {
            WebElement cartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
            String cartItemCount = cartIcon.getText();
            if (cartItemCount.isEmpty()) {
                System.out.println("The product has been removed from the cart.");
            } else {
                System.out.println("Error: The product has not been removed from the cart.");
            }
        } catch (Exception e) {
            System.out.println("The product is not removed from the cart, there is an exception: " + e.getMessage());

        }

    }

    @After
    public void TearDown(){
        //step closure
        //driver.quit();

    }

}
