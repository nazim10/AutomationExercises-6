import com.github.dockerjava.api.model.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.time.Duration;

public class NegativeLogin {
    @Test
    public void Negative_Login(){

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 3. Verify that home page is visible successfully

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

        // 4. Click on 'Signup / Login' button

        driver.findElement(By.xpath("//*[text()=\" Signup / Login\"] ")).click();

        // 5. Verify 'Login to your account' is visible

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).isDisplayed();

        // 6. Enter incorrect email address and password

        Actions action =new Actions(driver);
        driver.findElement(By.xpath("(//input[@name=\"email\"])[1]")).click();
        action.sendKeys("abuzettin@abuzer.com")
                .sendKeys(Keys.TAB)
                .sendKeys("sifre123")
                .sendKeys(Keys.TAB)

                // 7. Click 'login' button

                .sendKeys(Keys.ENTER)
                .perform();

        // 8. Verify error 'Your email or password is incorrect!' is visible

        driver.findElement(By.xpath("//*[text() =\"Your email or password is incorrect!\"]")).isDisplayed();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();
    }
}