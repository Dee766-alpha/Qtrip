
package qtriptest.pages;

import qtriptest.DriverSingleton;
import qtriptest.SeleniumWrapper;
import java.io.StringBufferInputStream;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AdventureDetailsPage {
    @FindBy(xpath="//input[@name='name']")
    WebElement nameTextBox;

    @FindBy(xpath="//input[@name='date']")
    WebElement dateTextBox;

    @FindBy(xpath="//input[@name='person']")
    WebElement numofperson;
    @FindBy(xpath="//*[text()='Reserve']")
    WebElement reserve;


    
    
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/detail/?adventure=0733501601";
 WebDriver driver;
    public AdventureDetailsPage(WebDriver driver) throws MalformedURLException {

        this.driver=DriverSingleton.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void bookAdventure(String name,String date,String numberofperson) throws InterruptedException{
        //driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        SeleniumWrapper.sendKeys(nameTextBox, name);

        //driver.findElement(By.xpath("//input[@name='date']")).sendKeys(date);
        SeleniumWrapper.sendKeys(dateTextBox, date);
        //driver.findElement(By.xpath("//input[@name='person']")).clear();
        //driver.findElement(By.xpath("//input[@name='person']")).sendKeys(numberofperson);
        SeleniumWrapper.sendKeys(numofperson, numberofperson);
        //driver.findElement(By.xpath("//*[text()='Reserve']")).click();
        SeleniumWrapper.click(reserve, driver);
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