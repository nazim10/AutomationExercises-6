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

public class ActionClass {

    @Test
    public void ActionTest() {


/*Test Case 1: Register User
Setup */


// 1. Launch browser
        WebDriver driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//  2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        String url1 = driver.getCurrentUrl();


//  3. Verify that home page is visible successfully
        String homePage = driver.getCurrentUrl();
        System.out.println("Anasayfaya gidilmistir, sayfa url adresi :     " + homePage);

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
                .sendKeys("nazim_@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

//  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        WebElement enterAccount = driver.findElement(By.xpath("//b[text() = \"Enter Account Information\"]"));
        Assert.assertTrue(enterAccount.isDisplayed());

//  9. Fill details: Title, Name, Email, Password, Date of birth

        //  10. Select checkbox 'Sign up for our newsletter!'

//  11. Select checkbox 'Receive special offers from our partners!'

//  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

//  13. Click 'Create Account button'

        WebElement Gender = driver.findElement(By.xpath("//input[@value = \"Mr\"]"));
        Gender.click();
        action.sendKeys(Keys.TAB)
                .sendKeys("nazim")
                .sendKeys(Keys.TAB)
                .sendKeys("nazim@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("nazim123")
                .sendKeys(Keys.TAB)
                .sendKeys("7")
                .sendKeys(Keys.TAB)
                .sendKeys("F")
                .sendKeys(Keys.TAB)
                .sendKeys("19")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("abdi")
                .sendKeys(Keys.TAB)
                .sendKeys("ipekci")
                .sendKeys(Keys.TAB)
                .sendKeys("Tesla")
                .sendKeys(Keys.TAB)
                .sendKeys("KOLLEGE STRAßE")
                .sendKeys(Keys.TAB)
                .sendKeys("30")
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys("Ottowa")
                .sendKeys(Keys.TAB)
                .sendKeys("Edmonton")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("009911991199")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


//  14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//b[text()=\"Account Created!\"]"));
        Assert.assertTrue(accountCreated.isDisplayed());
//  15. Click 'Continue' button

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement continiou = driver.findElement(By.xpath("//a[@class =\"btn btn-primary\"]"));
        continiou.click();

        /*
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           WebElement reklam1 = driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]"));
           reklam1.click();
           /*

            WebElement reklam2 = driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]"));
            reklam2.click();

*/
//  16. Verify that 'Logged in as username' is visible

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Logged = driver.findElement(By.xpath("//i[@class =\"fa fa-user\" ]"));
        Assert.assertTrue(Logged.isDisplayed());

//  17. Click 'Delete Account' button
        WebElement delete = driver.findElement(By.xpath("//i[@class =\"fa fa-trash-o\" ]"));
        delete.click();

//  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/

        // WebElement malker = driver.findElement(By.xpath("//div[@id =\"dismiss-button\"]"));
        // malker.click();

        WebElement deleted = driver.findElement(By.xpath("//h2[@data-qa =\"account-deleted\"]"));
        Assert.assertTrue(deleted.isDisplayed());
    }
}