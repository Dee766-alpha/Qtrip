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
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class testCase_04 {
    @Test(description="verify booking for multiple adventures",dataProvider = "data-provider",dataProviderClass = DP.class,priority = 4,groups = {"Reliability Flow"})
    //copy code of testcase1 and paste
    public void TestCase_04(String username,String password,String dataset1,String dataset2,String dataset3) throws MalformedURLException, InterruptedException{
    //RemoteWebDriver driver=DriverSingleton.getDriver();
    boolean status;
     RemoteWebDriver driver=DriverSingleton.getDriver();
     List<String> datasetlist1=Arrays.asList(dataset1.split(";"));
     List<String> datasetlist2=Arrays.asList(dataset2.split(";"));
     List<String> datasetlist3=Arrays.asList(dataset3.split(";"));
     RegisterPage register=new RegisterPage();
    status=register.registerNewPage(username,password,true);

assertTrue(status,"Registrtion not successfull");
String lastgenrateduser=register.lastGenerateduser;
Thread.sleep(2000);
LoginPage login =new LoginPage(driver);
login.performLogin(lastgenrateduser,password);
assertTrue(status,"not login");
HomePage page2=new HomePage(driver);
//status=homepage.isUserLoggedIn();
Thread.sleep(2000);
page2.navigatetohomepage();

//homepage.logOutUser();
//create object for homepage
//HomePage page2 =new HomePage(driver);
//call method searchcity with homepage object
page2.searchCity(datasetlist1.get(0));
//call selectcity method with homepage object
page2.selectCity(datasetlist1.get(0));
//create object for adventure  page
AdventurePage ap=new AdventurePage(driver);

//call selectadventure method with adventure page object
ap.selectAdventure(datasetlist1.get(1));
//create object for adventuredetails page 
AdventureDetailsPage advpagedetails =new AdventureDetailsPage(driver);
//call bookadventuredetails method with adventuredetailspage object
advpagedetails.bookAdventure(datasetlist1.get(2), datasetlist1.get(3), datasetlist1.get(4));
page2.navigatetohomepage();
//call method searchcity with homepage object
page2.searchCity(datasetlist2.get(0));
//call selectcity method with homepage object
page2.selectCity(datasetlist2.get(0));
//create object for adventure  page

//call selectadventure method with adventure page object
ap.selectAdventure(datasetlist2.get(1));
//create object for adventuredetails page 

//call bookadventuredetails method with adventuredetailspage object
advpagedetails.bookAdventure(datasetlist2.get(2), datasetlist2.get(3), datasetlist2.get(4));
page2.navigatetohomepage();

//call method searchcity with homepage object
page2.searchCity(datasetlist3.get(0));
//call selectcity method with homepage object
page2.selectCity(datasetlist3.get(0));
//create object for adventure  page


//call selectadventure method with adventure page object
ap.selectAdventure(datasetlist3.get(1));
//create object for adventuredetails page 

//call bookadventuredetails method with adventuredetailspage object
advpagedetails.bookAdventure(datasetlist3.get(2), datasetlist3.get(3), datasetlist3.get(4));
//create object for history page
HistoryPage hp = new HistoryPage(driver);
Thread.sleep(2000);
//call method getReservations  with history page object -->store it in int variable
int count =hp.getReservation();
assertEquals(count,3,"actual count and expected count not matched");
//call method cancelReservations with historypage object
//hp.cancelReservation(ad);
driver. navigate().refresh();
//int getreserve=hp.getReservation();
//page2.logOutUser();
//driver. Navigate().refresh();
//call getReservations method with history object --> Store it in int variable
//call loggedoutuser method with homepage object
}
}
