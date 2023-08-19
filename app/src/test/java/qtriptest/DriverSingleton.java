package qtriptest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class DriverSingleton {
    private static RemoteWebDriver  driver = null;

    //private static DriverSingleton singleton = null;

    @BeforeSuite
    private static RemoteWebDriver launchBrowser() throws MalformedURLException{
        if(driver == null){
            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(BrowserType.CHROME);
            driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"),capabilities);
            driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
            driver.manage().window().maximize();
            ReportSingleton.setExtentReport();
            
        }
        return driver;      
    }

    private DriverSingleton() throws MalformedURLException
    {
        DriverSingleton.driver = launchBrowser();
    }
    public static RemoteWebDriver getDriver() throws MalformedURLException{
        return driver;
    }
    @AfterTest
    public void quitDriver()
    {
        ReportSingleton.endExtentReport();
        driver.quit();
    }
    
}
