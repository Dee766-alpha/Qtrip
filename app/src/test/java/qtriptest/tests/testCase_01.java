package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;



//public class testCase_01 {
    /*@BeforeTest
    public static void createDriver() throws MalformedURLException {
        // Launch Browser using Zalenium
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
         driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
        System.out.println("createDriver()");
    }*/
    //public static RemoteWebDriver driver;
   /*  @Test(dataProvider = "data-provider",dataProviderClass = DP.class)
    public void TestCase_01(String username,String password) throws InterruptedException, MalformedURLException{
        boolean status;
     RemoteWebDriver driver=DriverSingleton.getDriver();
     RegisterPage register=new RegisterPage(driver);
    status=register.registerNewPage(username,password,true);

assertTrue(status,"Registrtion not successfull");
String lastgenrateduser=register.lastGenerateduser;
Thread.sleep(1000);
LoginPage login =new LoginPage(driver);
login.performLogin(lastgenrateduser,password);
HomePage homepage=new HomePage(driver);
status=homepage.isUserLoggedIn();
Thread.sleep(1000);
//assertTrue(status,"not login");
homepage.logOutUser();

    }
    
    
    
}*/

public class testCase_01 {
    /*@BeforeTest
    public static void createDriver() throws MalformedURLException {
        // Launch Browser using Zalenium
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
         driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
        System.out.println("createDriver()");
    }*/
    //public static RemoteWebDriver driver;
    @Test(description="Register the user and login with that",dataProvider = "data-provider",dataProviderClass = DP.class,priority = 1,groups = {"Login Flow"})
    
    public void TestCase_01(String username,String password) throws InterruptedException, MalformedURLException{
        boolean status;
     RemoteWebDriver driver=DriverSingleton.getDriver();
     RegisterPage register=new RegisterPage();
    status=register.registerNewPage(username,password,true);

assertTrue(status,"Registrtion not successfull");
String lastgenrateduser=register.lastGenerateduser;
Thread.sleep(1000);
LoginPage login =new LoginPage(driver);
login.performLogin(lastgenrateduser,password);
HomePage homepage=new HomePage(driver);
status=homepage.isUserLoggedIn();
Thread.sleep(1000);
assertTrue(status,"not login");
homepage.logOutUser();
    }    
    
    
}

