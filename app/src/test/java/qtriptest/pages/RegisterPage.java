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
import java.net.MalformedURLException;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    public String lastGenerateduser="";
    //public RemoteWebDriver driver;
    WebDriver driver;
   // String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";
    //public RegisterPage(RemoteWebDriver driver) {
       // this.driver = driver;
    //}
//

public RegisterPage() throws MalformedURLException
{
    this.driver=DriverSingleton.getDriver();

}
    public  boolean registerNewPage(String userName, String password,Boolean generateRandomUsername) throws InterruptedException, MalformedURLException{
       // this.driver=DriverSingleton.getDriver();
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/pages/register/");
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
    
}