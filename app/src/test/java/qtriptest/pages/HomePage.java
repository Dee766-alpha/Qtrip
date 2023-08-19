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

public class HomePage {
    @FindBy(xpath="//*[text()='Logout']")
    WebElement loggout;

    @FindBy(xpath="//input[@id='autocomplete']")
    WebElement searchcity;

    @FindBy(xpath="//ul[@id='results']")
    WebElement selecityElement;

    RemoteWebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/";

    public HomePage(RemoteWebDriver driver) throws MalformedURLException {
        this.driver=DriverSingleton.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        //driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        
        
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
        //driver.findElement(By.xpath("//*[text()='Logout']")).click();
        SeleniumWrapper.click(loggout, driver);
        Thread.sleep(1000);
    }
    public void searchCity(String city) throws InterruptedException{
        
        //driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(city);
        //driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        SeleniumWrapper.sendKeys(searchcity, city);
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
        //driver.findElement(By.xpath("//ul[@id='results']")).click();
        SeleniumWrapper.click(selecityElement, driver);
        Thread.sleep(2000);

    }
}