package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage
{
    WebDriver driver;

    //@Finby annotation
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myaccountpage;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    private WebElement logindropdownpage;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailpage;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordpage;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginbuttonpage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningmsgpage;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement registerdropdownbuttonpage;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continuebuttonpage;

    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    private WebElement firstnamemsgpage;

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstnamepage;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastnamepage;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement confirmpasswordpage;

    @FindBy(xpath = "//input[@value='0']")
    private WebElement subscribe_no_clickpage;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreeboxpage;

    //Constructor
    public Registerpage(WebDriver driver)
    {
        this.driver = this.driver;
        PageFactory.initElements(driver, this);
    }

    //Page action
    public void myaccount()
    {
        myaccountpage.click();
    }

    public void logindropdown()
    {
        logindropdownpage.click();
    }

    public void email(String mail)
    {
        emailpage.sendKeys(mail);
    }

    public void password(String pwd)
    {
        passwordpage.sendKeys(pwd);
    }

    public void loginbutton()
    {
        loginbuttonpage.click();
    }

    public String warningmsglogin()
    {
        String warningmsgtext=warningmsgpage.getText();
        return warningmsgtext;
    }

    public void registerdropdownbutton()
    {
        registerdropdownbuttonpage.click();
    }

    public void continuebutton()
    {
        continuebuttonpage.click();
    }

    public String firstnamemsg()
    {
        String nametext=firstnamemsgpage.getText();
        return nametext;
    }

    public void firstname(String fname)
    {
        firstnamepage.sendKeys(fname);
    }

    public void lastname(String lname)
    {
        lastnamepage.sendKeys(lname);
    }

    public void confirmpassword(String pwd)
    {
        confirmpasswordpage.sendKeys(pwd);
    }

    public void subscribe_no_click()
    {
        subscribe_no_clickpage.click();
    }

    public void agreebox()
    {
        agreeboxpage.click();
    }
}
