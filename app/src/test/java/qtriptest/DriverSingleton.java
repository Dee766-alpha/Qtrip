package qtriptest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSingleton {
    private static WebDriver  driver = null;

    //private static DriverSingleton singleton = null;

    @BeforeSuite
    private static WebDriver launchBrowser() throws MalformedURLException{
        if(driver == null){
            // final DesiredCapabilities capabilities = new DesiredCapabilities();
            // capabilities.setBrowserName(BrowserType.CHROME);
            // driver = new WebDriver(new URL("http://localhost:8082/wd/hub"),capabilities);
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver","E:\\seleniumdrivers\\chromedriver.exe");
            ChromeOptions obj = new ChromeOptions();
            obj.setBinary("E:\\seleniumdrivers\\chromedriver.exe");
         driver  = new ChromeDriver();
            //driver = new ChromeDriver();
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
    public static WebDriver getDriver() throws MalformedURLException{
        return driver;
    }
    @AfterTest
    public void quitDriver()
    {
        ReportSingleton.endExtentReport();
    driver.quit();
    }
    
}
