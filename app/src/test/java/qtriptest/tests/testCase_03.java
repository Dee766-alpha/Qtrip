package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class testCase_03 {
    @Test(description="verify booking and cancelation working ",dataProvider = "data-provider",dataProviderClass = DP.class,priority = 3,groups = {"Booking and Cancellation Flow"})
    //copy code of testcase1 and paste
    public void TestCase_03(String username,String password,String city,String ad,String advname,String date,String numberofperson) throws MalformedURLException, InterruptedException{
    //RemoteWebDriver driver=DriverSingleton.getDriver();
    boolean status;
     RemoteWebDriver driver=DriverSingleton.getDriver();
     RegisterPage register=new RegisterPage();
    status=register.registerNewPage(username,password,true);

assertTrue(status,"Registrtion not successfull");
String lastgenrateduser=register.lastGenerateduser;
Thread.sleep(2000);
LoginPage login =new LoginPage(driver);
login.performLogin(lastgenrateduser,password);
HomePage homepage=new HomePage(driver);
//status=homepage.isUserLoggedIn();
Thread.sleep(2000);
//assertTrue(status,"not login");
//homepage.logOutUser();
//create object for homepage
HomePage page2 =new HomePage(driver);
//call method searchcity with homepage object
page2.searchCity(city);
//call selectcity method with homepage object
page2.selectCity(city);
//create object for adventure  page
AdventurePage ap=new AdventurePage(driver);

//call selectadventure method with adventure page object
ap.selectAdventure(ad);
//create object for adventuredetails page 
AdventureDetailsPage advpagedetails =new AdventureDetailsPage(driver);
//call bookadventuredetails method with adventuredetailspage object
advpagedetails.bookAdventure(advname, date, numberofperson);
//create object for history page
HistoryPage hp = new HistoryPage(driver);
Thread.sleep(2000);
//call method getReservations  with history page object -->store it in int variable
int count =hp.getReservation();
//call method cancelReservations with historypage object
assertEquals(count,1,"not matched");
hp.cancelReservation(ad);
driver. navigate().refresh();
int getreserve=hp.getReservation();
assertEquals(getreserve,0,"not matched");
page2.logOutUser();
//driver. Navigate().refresh();
//call getReservations method with history object --> Store it in int variable
//call loggedoutuser method with homepage object
}
}
