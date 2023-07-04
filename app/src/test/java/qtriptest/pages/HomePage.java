package qtriptest.pages;

import qtriptest.DriverSingleton;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage {
    RemoteWebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/";

    public HomePage(RemoteWebDriver driver) throws MalformedURLException {
        this.driver=DriverSingleton.getDriver();
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        
    }
    public void navigatetohomepage(){
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
    }
   
    public void clickRegister(){
        driver.findElement(By.xpath("//*[text()='Register']")).click();
        
    }
    public boolean isUserLoggedIn(){
        if(driver.getCurrentUrl().equals("https://qtripdynamic-qa-frontend.vercel.app/")){
            return true;
        }
        else
        return false;
    }
    public void logOutUser() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Logout']")).click();
        Thread.sleep(1000);
    }
    public void searchCity(String city) throws InterruptedException{
        
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(city);
        Thread.sleep(2000);
    
       
    }
    public boolean assetAutoCompleteText(String completeText) throws InterruptedException{
        Thread.sleep(1000);
        if(driver.findElement(By.xpath("//*[@id='results']")).getText().equals(completeText)){
            
            return true;
        }
        else{
            return false;
        }
       
        
    }
    public void selectCity(String city) throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id='results']")).click();
        Thread.sleep(2000);

    }
}