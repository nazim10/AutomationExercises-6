import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class PositiveLogin {

    @Test
    public void ActionTest() {

       // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://automationexercise.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       // 3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

       // 4. Click on 'Signup / Login' button

        driver.findElement(By.xpath("//a[@href =\"/login\"]")).click();

       // 5. Verify 'Login to your account' is visible

        driver.findElement(By.xpath("//*[text() =\"Login to your account\"]")).isDisplayed();

       // 6. Enter correct email address and password
        // 7. Click 'login' button
        driver.findElement(By.xpath("//input[@type =\"email\"]")).click();
        Actions action = new Actions(driver);
        action.sendKeys("north@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .perform();
        driver.findElement(By.xpath("//button[@type =\"submit\"]")).click();


       // 8. Verify that 'Logged in as username' is visible

        driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).isDisplayed();

       // 9. Click 'Delete Account' button

        driver.findElement(By.xpath("//i[@class=\"fa fa-trash-o\"]")).click();

       // 10. Verify that 'ACCOUNT DELETED!' is visible

        driver.findElement(By.xpath("//*[text() = \"Account Deleted!\"]")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();

    }
}