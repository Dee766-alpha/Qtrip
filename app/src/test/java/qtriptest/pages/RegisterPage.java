/*package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    public String lastGenerateduser="";
    public RemoteWebDriver driver;
   // String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";
    public RegisterPage(RemoteWebDriver driver) {
        this.driver = driver;
    }
    //public  boolean registerNewPage(String userName, String password, String confirmPassword,Boolean generateRandomUsername) throws InterruptedException{
        public  boolean registerNewPage(String userName, String password,Boolean generateRandomUsername) throws InterruptedException{

       /*  driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Register']")).click();*/
        /*driver.get("https://qtripdynamic-qa-frontend.vercel.app/pages/register/");
        driver.manage().window().maximize();
        
       
        
if (generateRandomUsername == true)
userName = userName+UUID.randomUUID().toString();
driver.findElement(By.xpath("//*[@name='email']")).sendKeys(userName);
driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
driver.findElement(By.xpath("//*[@name='confirmpassword']")).sendKeys(password);
driver.findElement(By.xpath("//*[text()='Register Now']")).click();
this.lastGenerateduser=userName;
WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://qtripdynamic-qa-frontend.vercel.app/pages/login"));

        return this.driver.getCurrentUrl().endsWith("/login");
//return true;

    }
    
}*/


package qtriptest.pages;

import qtriptest.DriverSingleton;
import qtriptest.SeleniumWrapper;
import java.net.MalformedURLException;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    
    @FindBy(xpath="//*[@name='email']")
    WebElement emaill;
    
    @FindBy(xpath="//*[@name='password']")
    WebElement passw;

    @FindBy(xpath="//*[@name='confirmpassword']")
    WebElement confirmpass;

    @FindBy(xpath="//*[text()='Register Now']")
    WebElement registered;
    

    public String lastGenerateduser="";
    //public RemoteWebDriver driver;
    WebDriver driver;
   String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";
    //public RegisterPage(RemoteWebDriver driver) {
       // this.driver = driver;
    //}
//


public RegisterPage() throws MalformedURLException
{
    this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

}
    public  boolean registerNewPage(String userName, String password,Boolean generateRandomUsername) throws InterruptedException, MalformedURLException{
       // this.driver=DriverSingleton.getDriver();
       // driver.get("https://qtripdynamic-qa-frontend.vercel.app/pages/register/");
       SeleniumWrapper.navigate(driver, this.url);
        driver.manage().window().maximize();
        
       
        
if (generateRandomUsername == true)
userName = userName+UUID.randomUUID().toString();
//driver.findElement(By.xpath("//*[@name='email']")).sendKeys(userName);
SeleniumWrapper.sendKeys(emaill, userName);
//driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
SeleniumWrapper.sendKeys(passw, password);
//driver.findElement(By.xpath("//*[@name='confirmpassword']")).sendKeys(password);
SeleniumWrapper.sendKeys(confirmpass, password);

//driver.findElement(By.xpath("//*[text()='Register Now']")).click();
SeleniumWrapper.click(registered, driver);
this.lastGenerateduser=userName;
WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://qtripdynamic-qa-frontend.vercel.app/pages/login"));

        return this.driver.getCurrentUrl().endsWith("/login");
//return true;

    
}

    
}