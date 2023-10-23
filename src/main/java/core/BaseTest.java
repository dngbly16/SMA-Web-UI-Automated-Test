package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    RemoteWebDriver driver;
    @BeforeMethod
    @Parameters({"browser"})
    public void beforeTest(String browser) throws MalformedURLException {
        if(browser.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", "Windows");
            //chromeOptions.addArguments("--headless=new");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),chromeOptions);
            //driver.manage().window().maximize();
        }

        if(browser.equals("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platformName","Windows");
            //firefoxOptions.setHeadless(true);
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),firefoxOptions);
            //driver.manage().window().maximize();
        }
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
    public WebDriver getDriver(){
        return driver;
    }
}
