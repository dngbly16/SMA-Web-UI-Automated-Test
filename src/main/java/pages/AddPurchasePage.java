package pages;

import java.util.List;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPurchasePage extends BasePage {
    @FindBy(xpath = "//div[@id='loading']")
    private WebElement loadingDiv;
    @FindBy(xpath = "//div[@id='s2id_powarehouse']")
    private WebElement warehouseLink;
    @FindBy(xpath = "//div[@class='select2-result-label']")
    private List<WebElement> selectOptions;
    @FindBy(xpath = "//div[@id='s2id_postatus']")
    private WebElement statusLink;
    @FindBy(xpath = "//div[@id='s2id_posupplier']")
    private WebElement supplierLink;
    @FindBy(xpath = "//input[@id='s2id_autogen8_search']")
    private WebElement supplierInput;
    @FindBy(xpath = "//span[@class='select2-match']")
    private WebElement supplierMatchedOption;
    @FindBy(xpath = "//input[@id='add_item']")
    private WebElement addItemInput;
    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
    private WebElement orderItemsResult;
    @FindBy(xpath = "//input[@id='add_pruchase']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement successfullyMessage;
    public AddPurchasePage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyAddPurchasePage(){
        return getWait().until(ExpectedConditions.visibilityOf(warehouseLink)).isDisplayed();
    }
    public void chooseWarehouse(String warehouse){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.visibilityOf(warehouseLink));
        warehouseLink.click();
        getWait().until(ExpectedConditions.visibilityOfAllElements(selectOptions));
        for(WebElement option : selectOptions) {
            if(option.getText().equalsIgnoreCase(warehouse)) {
                option.click();
                break;
            }
        }
    }
    public void chooseStatus(String status){
        getWait().until(ExpectedConditions.visibilityOf(statusLink));
        statusLink.click();
        getWait().until(ExpectedConditions.visibilityOfAllElements(selectOptions));
        for(WebElement option : selectOptions) {
            if(option.getText().equalsIgnoreCase(status)) {
                option.click();
                break;
            }
        }
    }
    public void chooseSupplier(String supplier){
        getWait().until(ExpectedConditions.visibilityOf(supplierLink));
        supplierLink.click();
        getWait().until(ExpectedConditions.visibilityOf(supplierInput));
        supplierInput.sendKeys(supplier);
        getWait().until(ExpectedConditions.visibilityOf(supplierMatchedOption));
        supplierMatchedOption.click();
    }
    public void inputProductToOrder(String productName){
        getWait().until(ExpectedConditions.visibilityOf(addItemInput));
        addItemInput.sendKeys(productName);
    }
    public void clickSubmit(){
        getWait().until(ExpectedConditions.visibilityOf(orderItemsResult));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        getWait().until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }
    public boolean verifyAddPurchaseSuccess(){
        return getWait().until(ExpectedConditions.visibilityOf(successfullyMessage)).isDisplayed();
    }
}
