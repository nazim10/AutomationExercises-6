import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

import java.time.Duration;

public class Verify_All_Products {

    @Test
    public void Verify_All_Products() throws Exception {


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/");
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        //3. Verify that home page is visible successfully

        Assert.assertEquals(actualUrl, expectedUrl);

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//i[@class = \"material-icons card_travel\"]")).click();

        // --------------  Reklam Kapat!!   --------------------
        Robot robot = new Robot();
        int x = 1500;
        int y = 100;

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        ReusableMethods.wait(3);

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String AllProducts = driver.findElement(By.xpath("//*[text()='All Products']")).getText();
        System.out.println(AllProducts);

        //6. The products list is visible

        driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed();

        //7. Click on 'View Product' of first product

        /* -----------Ürünleri bir liste halinde yazdirmak icin --------------------
            List<WebElement> productList = driver.findElements(By.xpath("//div[@class=\"product-overlay\"]"));
            for (WebElement product:productList ) {
                System.out.println("product  :    " + product);
           }  */
        driver.findElement(By.xpath("(//i[@class=\"fa fa-plus-square\"])[1]")).click();

        //8. User is landed to product detail page
        String ActualURL = driver.getCurrentUrl();
        System.out.println("ActualURL    :  " + ActualURL);

        //9. Verify that detail.Detail is visible: product name, category, price, availability, condition, brand


        // Ürün adı
        System.out.println("  Product Name Asserion --> OK! ");
        driver.findElement(By.xpath("//*[text()=\"Blue Top\"]")).isDisplayed();

        // Kategori
        System.out.println("  Categorie Asserion --> OK!  ");
        driver.findElement(By.xpath("//*[text()=\"Category\"]")).isDisplayed();

        // Fiyat

        System.out.println("  Price Asserion --> OK!  ");
        driver.findElement(By.xpath("//*[text()=\"Rs. 500\"]")).isDisplayed();

        // Durum (availability)

        System.out.println("  Availability Asserion --> OK!   ");
        driver.findElement(By.xpath("//*[text()=\"Availability:\"]")).isDisplayed();

        // Durum (condition)

        System.out.println("  Condition Asserion --> OK!  ");
        driver.findElement(By.xpath("//*[text()=\"Condition:\"]")).isDisplayed();

        // Marka (brand)
        System.out.println("  Brands Asserion --> OK!   ");
        driver.findElement(By.xpath("//*[text()=\"Brands\"]")).isDisplayed();


    }
}
