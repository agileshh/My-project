import Base.Baseclass;
import Pages.Registerpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Register extends Baseclass
{
    WebDriver driver;
    Registerpage reg;

    @BeforeMethod
    public void setup()
    {
        driver= initilizebrowserandURL("chrome");
    }

    @Test
    public void Registrationwarningmessage() throws InterruptedException
    {
        reg = new Registerpage(driver);
        reg.myaccount();
        reg.registerdropdownbutton();
        reg.continuebutton();
        Thread.sleep(3000);
        String Actual_Firstname=reg.firstnamemsg();
        String Expected_Firstname = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(Actual_Firstname,Expected_Firstname);
    }

  //  @Test (priority = 0, dataProvider = "supplydata")
    public void Invlaidlogin(String email,String pwd)
    {
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        WebElement Actu= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        //String Exp = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertTrue(Actu.isDisplayed(), "Test passed");
    }

    //@DataProvider
    public Object [][] supplydata()
    {
        Object [][] data = {{"agilesh", "Vksdognas"},
                            {"dad@gmail.com", "wfdw"}};
        return data;
    }

    @Test
   public void registration()
   {
       reg = new Registerpage(driver);
       reg.myaccount();
       reg.registerdropdownbutton();
       reg.firstname("Agileshh");
       reg.lastname("Sakthi");
       reg.email("agileshsakthi@gmail.com");
       reg.password("Qwerty");
       reg.confirmpassword("Qwerty");
       reg.subscribe_no_click();
       reg.agreebox();
       reg.continuebutton();
   }
   //@AfterMethod
   public void teardown()
   {
      driver.quit();
   }
}
