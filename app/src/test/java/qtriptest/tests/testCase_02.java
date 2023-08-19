package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.ReportSingleton;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HomePage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.List;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class testCase_02 {
    @Test(description="Select the adventure(search and filter is working fine)",dataProvider = "data-provider",dataProviderClass = DP.class,priority = 2,groups = {"Search and Filter flow"})
    public void TestCase02(String city,String categoryvalue,String filtervalue ,String expectedfilterresult,String expectedunfilterresult) throws InterruptedException, IOException{
        ReportSingleton.test = ReportSingleton.reports.startTest("verify thesearch and filter working fine");
        RemoteWebDriver driver=DriverSingleton.getDriver();
        //create object for homepage
        HomePage page1=new HomePage(driver);
        //call method searchcity with homepage object
        page1.navigatetohomepage();
        page1.searchCity(city);
        Thread.sleep(1000);
        page1.assetAutoCompleteText(city);
        Thread.sleep(1000);
        // if(!status){
        //     System.out.print("not city found");
        // }
        // else{
        //call method selectcity with homepage object
        page1.selectCity(city);

        //create object for adventure page
        AdventurePage page2 = new AdventurePage(driver);
        //call method setfiltervalues with adventure page object
        page2.setFilterValue(filtervalue);
        Thread.sleep(2000);
        //call method setCategoryValue with adventure page object
        page2.categoryValue(categoryvalue);
        Thread.sleep(2000);
        //call method getResultCount with adventure page object 
        int actualcount =page2.getResultCount();
        Thread.sleep(2000);
        assertEquals(String.valueOf(actualcount), expectedfilterresult,"actual and expected not matched");
        List <WebElement> list2=driver.findElements(By.xpath("//div[@class='filter-bar-tile d-flex align-items-center']/div"));
        for(WebElement list3:list2){
            list3.click();
        }
        Thread.sleep(2000);
        actualcount=page2.getResultCount();

        assertEquals(String.valueOf(actualcount), expectedunfilterresult,"actual and expected not matched");
        ReportSingleton.test.log(LogStatus.PASS,ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver)) ,"Successfully verify that the search and filters are working fine");
        }
    }