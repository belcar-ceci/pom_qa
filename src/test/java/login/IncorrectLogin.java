package login;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncorrectLogin {

    public static void main(String[] args) {
        /*
        * Validar Login incorrecto:
        1. Ir a la página https://www.saucedemo.com
        2. Escribir el username standard_use (Introducimos mal el usuario para forzar el error)
        3. Escribir el password secret_sauce
        4. Pulsar en el botón del Login
        5. Validar que aparece el mensaje de error
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
        username.sendKeys("standard_users");

        //Step3
        WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("secret_sauce");

        //Step 4
        WebElement loginEnter = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginEnter.click();

        //Step 5
        WebElement errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']"));



        if(errorLogin.isDisplayed()){
            System.out.println("Show an error message, the username is failed" );
        } else {
            System.out.println("Does not show error message, repeat the test");
        }

        driver.close();

    }

}
