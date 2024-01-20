import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmailAlreadyExist {


    @Test
    public void testLogout() {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 3. Verify that home page is visible successfully

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        // 4. Click on 'Signup / Login' button

        driver.findElement(By.xpath("//a[@href =\"/login\"]")).click();

        // 5. Verify 'Login to your account' is visible

        driver.findElement(By.xpath("//*[text() =\"Login to your account\"]")).isDisplayed();

        // 6. Enter correct email address and password
        // 7. Click 'login' button

        driver.findElement(By.xpath("//input[@type =\"email\"]")).click();

        action.sendKeys("north@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .perform();
        driver.findElement(By.xpath("//button[@type =\"submit\"]")).click();

        // 8. Verify that 'Logged in as username' is visible

        driver.findElement(By.xpath("//i[@class =\"fa fa-user\"]")).isDisplayed();
        driver.navigate().back();


        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        driver.quit();
        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://automationexercise.com/");
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver2.findElement(By.xpath("//a[@href =\"/login\"]")).click();
        driver2.findElement(By.xpath("//input[@name=\"name\"]")).click();
        Actions action2 = new Actions(driver2);
        action2.sendKeys("north")
                .sendKeys(Keys.TAB)
                .sendKeys("north@gmail.com")
                .sendKeys(Keys.TAB)
                .perform();
        driver2.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();


        //8. Verify error 'Email Address already exist!' is visible

        driver2.findElement(By.xpath("//*[text() = \"Email Address already exist!\"]")).isDisplayed();
        driver2.close();

    }
}
