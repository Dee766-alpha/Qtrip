package qtriptest.pages;

import qtriptest.DriverSingleton;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage {
    public RemoteWebDriver driver;
    //String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/login/";
    public LoginPage(RemoteWebDriver driver) throws MalformedURLException {
        this.driver=DriverSingleton.getDriver();
    }


    public void performLogin(String userName,String password) throws InterruptedException{
       // driver.get("https://qtripdynamic-qa-frontend.vercel.app/pages/login/");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Login to QTrip']")).click();
        Thread.sleep(2000);
        //driver.switchTo().alert().accept();
        
     
        
   
}
}
