
package qtriptest.pages;

import qtriptest.DriverSingleton;
import java.io.StringBufferInputStream;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AdventureDetailsPage {
    
    
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/detail/?adventure=0733501601";
    public RemoteWebDriver driver;
    public AdventureDetailsPage(RemoteWebDriver driver) throws MalformedURLException {
        this.driver=DriverSingleton.getDriver();
    }

    public void bookAdventure(String name,String date,String numberofperson) throws InterruptedException{
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

        driver.findElement(By.xpath("//input[@name='date']")).sendKeys(date);
        driver.findElement(By.xpath("//input[@name='person']")).clear();
        driver.findElement(By.xpath("//input[@name='person']")).sendKeys(numberofperson);
        driver.findElement(By.xpath("//*[text()='Reserve']")).click();
        Thread.sleep(1000);


    }
    public boolean isBookingSuccessful() throws InterruptedException{
        Thread.sleep(1000);
        if(driver.findElement(By.xpath("//div[@id='reserved-banner']")).getText().equals("Greetings! Reservation for this adventure is successful. (Click here to view your reservations)"))
        {
            return true;
        }
        return false;
        
        
    }
}