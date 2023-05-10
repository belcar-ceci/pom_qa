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

    @After
    public void TearDown(){
        //step closure
        driver.quit();

    }

}
