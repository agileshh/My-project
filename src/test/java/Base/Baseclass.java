package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Baseclass
{
    WebDriver driver;
    public Properties prop;

    public void Baseclass()
    {
        prop = new Properties();
        File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Conf\\Conffile.proprties");
        try
        {
            FileInputStream fileInput = new FileInputStream(propfile);
            prop.load(fileInput);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public WebDriver initilizebrowserandURL(String browser)
    {
        if(browser.equals("chrome"))
        {
            driver = new ChromeDriver();
        }else if (browser.equals("edge"))
        {
            driver = new EdgeDriver();
        }
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        return driver;
    }

}
