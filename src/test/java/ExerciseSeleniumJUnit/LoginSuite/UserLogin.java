package ExerciseSeleniumJUnit.LoginSuite;

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
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class UserLogin {

    WebDriver driver;
    WebDriverWait wait;



    String url = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password = "secret_sauce";
    String expectedUrl = "https://www.saucedemo.com/inventory.html";
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
    public void validationLoginCorrect() {
        //Step 2
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);

        //Step 3
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);

        //Step 4
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        //Step 5
        try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals("Error: The requested page is not displayed " + actualUrl, expectedUrl, actualUrl);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error while waiting for URL: " + e.getMessage());
        }
    }

    @Test
    public void validationLoginError(){
        //Step 2
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);

        //Step 3

        WebElement pass = driver.findElement(By.xpath("//input[@data-test='password']"));
        pass.sendKeys("secrets_sauce");
        //Step 4
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        //Step 5
        WebElement errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']"));

        if(errorLogin.isDisplayed()){
            System.out.println("Show an error message, the username is failed" );
        } else {
            System.out.println("Does not show error message, repeat the test");
        }



    }

    @After
    public void TearDown(){

        driver.quit();


    }

}
