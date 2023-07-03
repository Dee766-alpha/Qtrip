package qtriptest.pages;

import qtriptest.DriverSingleton;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;

public class AdventurePage {
    //String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/?city=goa";
    public RemoteWebDriver driver;
    public AdventurePage(RemoteWebDriver driver) throws MalformedURLException {
        this.driver=DriverSingleton.getDriver();
    }

    public void setFilterValue(String filterValue) throws InterruptedException{
        ////select[@id='duration-select']/option
        driver.findElement(By.xpath("//select[@id='duration-select']")).click();
        Thread.sleep(1000);
        List<WebElement> FilterValueList = driver.findElements(By.xpath("//select[@id='duration-select']/option"));
        for(WebElement val : FilterValueList)
        {
            if(val.getText().equals(filterValue))
            {
                Thread.sleep(1000);
                val.click();
                Thread.sleep(2000);
                break;
            }
        }
        // Thread.sleep(2000);
        // //Filtervalue.click();
        // Select val = new Select(FilterValueList);
        // val.selectByVisibleText(filterValue);
    }

    public void categoryValue(String category) throws InterruptedException{
        driver.findElement(By.xpath("//select[@id='category-select']")).click();
        Thread.sleep(1000);
        List<WebElement> categoryOption = driver.findElements(By.xpath("//select[@id='category-select']/option"));
        for(WebElement cat : categoryOption)
        {
            if(cat.getText().equals(category))
            {
                Thread.sleep(2000);
                cat.click();
                Thread.sleep(2000);
                break;
            }
        }
            
    //    // categoryOption.click();
    //     Select option1 = new Select(categoryOption);
    //     option1.selectByVisibleText(category);
    //     Thread.sleep(1000);
    }
    public int getResultCount() throws InterruptedException{
        Thread.sleep(2000);
        List<WebElement> list2=driver.findElements(By.xpath("//div[@id='data']/div"));
        Thread.sleep(2000);
        return list2.size();
        
        
    }

    public  void selectAdventure(String adventurename) throws InterruptedException{
         driver.findElement(By.xpath("//input[@id='search-adventures']")).sendKeys(adventurename);
         Thread.sleep(1000);
        // categoryOption.click();
        List<WebElement> list3=driver.findElements(By.xpath("//div[@class='activity-card']/div/div[1]/h5"));

        for(WebElement value1:list3){
            if(value1.getText().equals(adventurename)){
                value1.click();
                Thread.sleep(1000);
                break;
            }
        }
         

        
    }
}