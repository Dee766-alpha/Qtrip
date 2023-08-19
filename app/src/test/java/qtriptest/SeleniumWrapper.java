package qtriptest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumWrapper {
    public static boolean click(WebElement elementoclick,WebDriver driver){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
            //js.executeScript("arguments[0].scrollIntoView();", elementToBeClickable);
            if(elementoclick.isDisplayed()){
                JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", elementoclick);
            elementoclick.click();
            return true;
            }
            else
                return false;
            
    }
    public  static boolean sendKeys(WebElement inputbox,String city){
        inputbox.clear();
        inputbox.sendKeys(city);
        return true;
        
    }
    public static  boolean navigate(WebDriver driver,String url){
        if(url.equals(url)){
            driver.get(url);
            return true;
        }
        else
        return false;
    }
    //public static WebElement findelementretry(WebDriver driver,By by,int retrycount){}

}
