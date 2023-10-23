package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddSalesPage extends BasePage {
    @FindBy(xpath = "//div[@id='loading']")
    private WebElement loadingDiv;
    @FindBy(xpath = "//div[@id='s2id_slwarehouse']")
    private WebElement warehouseLink;
    @FindBy(xpath = "//ul[@id='select2-results-3']//div[text()='Warehouse 2']")
    private WebElement optionWarehouse2;
    @FindBy(xpath = "//span[@id='select2-chosen-12']/parent::a")
    private WebElement customerLink;
    @FindBy(xpath = "//input[@id='s2id_autogen12_search']")
    private WebElement customerInput;
    @FindBy(xpath = "//div[@id='select2-result-label-15']")
    private WebElement customerSearchResult;
    @FindBy(xpath = "//input[@name='add_item']")
    private WebElement orderItemInput;
    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
    private WebElement orderItemsResult;
    @FindBy(xpath = "//div[@id='s2id_slpayment_status']")
    private WebElement paymentStatusLink;
    @FindBy(xpath = "//div[contains(text(), 'Paid')]")
    private WebElement paidStatusOption;
    @FindBy(xpath = "//input[@id='add_sale']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement successfullyMessage;
    public AddSalesPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyAddSalesPage(){
        return getWait().until(ExpectedConditions.visibilityOf(warehouseLink)).isDisplayed();
    }
    public void chooseCustomer(){
        getWait().until(ExpectedConditions.elementToBeClickable(customerLink));
        customerLink.click();
        getWait().until(ExpectedConditions.visibilityOf(customerInput));
        customerInput.sendKeys("Walk");
        getWait().until(ExpectedConditions.elementToBeClickable(customerSearchResult));
        customerSearchResult.click();
    }
    public void chooseWarehouse(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.elementToBeClickable(warehouseLink));
        warehouseLink.click();
        getWait().until(ExpectedConditions.elementToBeClickable(optionWarehouse2));
        optionWarehouse2.click();
    }
    public void addOrderItem(String itemName){
        getWait().until(ExpectedConditions.visibilityOf(orderItemInput));
        orderItemInput.sendKeys(itemName);
    }
    public void choosePaymentStatus(){
        getWait().until(ExpectedConditions.visibilityOf(orderItemsResult));
        getWait().until(ExpectedConditions.elementToBeClickable(paymentStatusLink));
        paymentStatusLink.click();
        getWait().until(ExpectedConditions.elementToBeClickable(paidStatusOption));
        paidStatusOption.click();
    }
    public void submitAddSale(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        getWait().until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }
    public boolean verifyAddSaleSuccess(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        return getWait().until(ExpectedConditions.visibilityOf(successfullyMessage)).isDisplayed();
    }
}
