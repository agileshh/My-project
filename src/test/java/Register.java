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
import java.util.Properties;

public class Register extends Baseclass
{
     WebDriver driver;

    public Register()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        driver= initilizebrowserandURL("chrome");
    }

    @Test(priority = 1)
    public void Registrationwarningmessage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(3000);
        String Actual_firstname = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
        String Expected_Firstname = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(Actual_firstname,Expected_Firstname);
    }
    @Test (priority = 0)
    public void Invlaidlogin()
    {
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("adfg");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12214");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        WebElement Expe= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        //String Actu = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertTrue(Expe.isDisplayed(), "Test passed");
    }

    //@Test(priority = 2)
   public void registration()
   {
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Agileshh");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Sakthi");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Agileshsakthi@gmail.com");driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("7598243388");
       driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("qwerty");
       driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("qwerty");
       driver.findElement(By.xpath("//input[@value='0']")).click();
       driver.findElement(By.xpath("//input[@name='agree']")).click();
       driver.findElement(By.xpath("//input[@value='Continue']")).click();
   }
   @AfterMethod
   public void teardown()
   {
      driver.quit();
   }
}
