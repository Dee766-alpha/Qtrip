
package qtriptest.pages;

import qtriptest.DriverSingleton;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HistoryPage {
    
   
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/reservations/";
 WebDriver driver;
    
    public HistoryPage(WebDriver driver) throws MalformedURLException {
        this.driver=DriverSingleton.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/reservations/");
    }

    public int getReservation() throws InterruptedException{
        List<WebElement> list1=driver.findElements(By.xpath("//tbody[@id='reservation-table']/tr/th"));
        Thread.sleep(1000);
        //int size=list1.size();
        return list1.size();
    

    }
    public void  cancelReservation(String cancel) throws InterruptedException{
        //driver.findElement(By.xpath("//button[@onclick='cancelReservation(this)']")).se
        WebElement cancelbutton=driver.findElement(By.xpath("//button[@onclick='cancelReservation(this)']"));
        try{
            List<WebElement>list4 =driver.findElements(By.xpath("//tbody[@id='reservation-table']/tr/td[2]"));
        for(WebElement list5:list4){
            Thread.sleep(1000);
            if(list5.getText().equals(cancel)){
                Thread.sleep(1000);
                cancelbutton.click();
                Thread.sleep(1000);
                //driver.switchTo().alert().accept();
             break;

            }
        
        }
    }
    catch(Exception in){
        driver.switchTo().alert().accept();

    }


    }
}