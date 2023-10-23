package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='identity']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@class='checkbox pull-left']/following-sibling::button")
    private WebElement loginButton;
    @FindBy(xpath = "//label[@for='remember']")
    private WebElement rememberMeLabel;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage(){
        getDriver().get("https://sma.tecdiary.net/admin/login/");
    }
    public boolean verifyUserNameTextBoxDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(userNameInput)).isDisplayed();
    }
    public boolean verifyPasswordTextBoxDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(passwordInput)).isDisplayed();
    }
    public boolean verifyLoginButtonDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
    }
    public boolean verifyRememberMeCheckboxDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(rememberMeLabel)).isDisplayed();
    }

    private void clearInputField(){
        userNameInput.clear();
        passwordInput.clear();
    }
    public void login(String username, String password){
        getWait().until(ExpectedConditions.visibilityOf(userNameInput));
        clearInputField();
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
