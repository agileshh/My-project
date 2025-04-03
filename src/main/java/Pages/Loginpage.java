package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
    WebDriver driver;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginbuttonpage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningmsgpage;

    public Loginpage(WebDriver driver)
    {
        this.driver = this.driver;
        PageFactory.initElements(driver, this);
    }

    public void loginbutton()
    {
        loginbuttonpage.click();
    }

    public String warningmsg()
    {
        String check=warningmsgpage.getText();
        return check;
    }
}
