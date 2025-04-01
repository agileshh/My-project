import Base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class Cart extends Baseclass
{
    WebDriver driver;
    public Cart()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        driver= initilizebrowserandURL("edge");
    }

    @Test
    public void checkcart()
    {
        driver.findElement(By.xpath("//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")).click();
        WebElement cartexp=driver.findElement(By.xpath("//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]"));
        Assert.assertTrue(cartexp.isDisplayed());
        WebElement carte=driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        Assert.assertTrue(carte.isDisplayed());
    }
    @Test
    public void checkout()
    {
        driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
        try
        {
            String actual=driver.findElement(By.xpath("//p[@class='text-center']")).getText();
            String exp= "Your shopping cart is empt";
            if(actual.equals(exp))
            {
                System.out.println("test pass");
            }else
            {
                System.out.println("test fail");
             }
        }
        catch( Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}