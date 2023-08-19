package qtriptest.pages;

import qtriptest.DriverSingleton;
import qtriptest.SeleniumWrapper;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    public RemoteWebDriver driver;

    @FindBy(xpath="//*[@name='email']")
    WebElement email;

    @FindBy(xpath="//*[@name='password']")
    WebElement passw;

    @FindBy(xpath="//*[text()='Login to QTrip']")
    WebElement login;



    //String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/login/";
    public LoginPage(RemoteWebDriver driver) throws MalformedURLException {
        this.driver=DriverSingleton.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }


    public void performLogin(String userName,String password) throws InterruptedException{
       // driver.get("https://qtripdynamic-qa-frontend.vercel.app/pages/login/");
        //driver.findElement(By.xpath("//*[@name='email']")).sendKeys(userName);
        SeleniumWrapper.sendKeys(email, userName);
       // driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
       SeleniumWrapper.sendKeys(passw, password);
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[text()='Login to QTrip']")).click();
        SeleniumWrapper.click(login, driver);
        Thread.sleep(2000);
        //driver.switchTo().alert().accept();
        
     
        
   
}
}
