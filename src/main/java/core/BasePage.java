package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWait(){
        return driverWait;
    }
}

