package login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginInit {

    //String url = "https://www.saucedemo.com/";
    public static void main(String[] args) {
        /*
        * Realizar Login:
        1. Ir a la página https://www.saucedemo.com/
        2. Escribir el username standard_user
        3. Escribir el password secret_sauce
        4. Pulsar en el botón del Login.
        5. Validar que hemos accedido correctamente a la página, comprobando que se muestra
la URL
        * */

        //Initial Step
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

        //Step3
        WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("secret_sauce");

        //Step 4
        WebElement loginEnter = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginEnter.click();

        //Step 5
        String pageActual = driver.getCurrentUrl();

        if("https://www.saucedemo.com/inventory.html".equals(pageActual)){
            System.out.println("The URL is correct and it displays correctly" + pageActual );
        } else {
            System.out.println("The URL is not correct. The does not correspond to what was expected: " + pageActual);
        }

        driver.close();
    }
}
