import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class ActionClass {

    public void ActionTest() {
/*Test Case 1: Register User
Setup */


// 1. Launch browser
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//  2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        String url1 = driver.getCurrentUrl();


//  3. Verify that home page is visible successfully
        String homePage = driver.getCurrentUrl();
        System.out.println("Anasayfaya gidilmistir, sayfa url'i :     " + homePage);

//  4. Click on 'Signup / Login' button
        WebElement signup = driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]"));
        signup.click();

//  5. Verify 'New User Signup!' is visible

        WebElement newUser = driver.findElement(By.xpath("//h2[text() =\"New User Signup!\"]"));
        Assert.assertTrue(newUser.isDisplayed());

        String url2 = driver.getCurrentUrl();
        Assert.assertNotSame(url2, url1);

//  6. Enter name and email address
//  7. Click 'Signup' button

        WebElement email = driver.findElement(By.xpath("//input[@name=\"name\"]"));
        email.sendKeys("nazim");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB)
                .sendKeys("nazim@gmail.com")
                .sendKeys(Keys.TAB)
                .click()
                .perform();

//  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        WebElement enterAccount = driver.findElement(By.xpath("//b[text() = \"Enter Account Information\"]"));
        Assert.assertTrue(enterAccount.isDisplayed());

//  9. Fill details: Title, Name, Email, Password, Date of birth


//  10. Select checkbox 'Sign up for our newsletter!'

//  11. Select checkbox 'Receive special offers from our partners!'

//  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

//  13. Click 'Create Account button'

//  14. Verify that 'ACCOUNT CREATED!' is visible

//  15. Click 'Continue' button

//  16. Verify that 'Logged in as username' is visible

//  17. Click 'Delete Account' button

//  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/


    }


}
