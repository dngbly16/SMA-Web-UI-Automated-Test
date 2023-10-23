package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailModal extends BasePage {

    @FindBy(xpath = "//h4[@class='modal-title' and contains(text(), 'Lemon')]")
    private WebElement lemonModalTitle;
    @FindBy(xpath = "//img[@id='pr-image']")
    private WebElement productImage;
    @FindBy(xpath = "//td[text()='Barcode & QRcode']")
    private WebElement barAndQRCode;
    @FindBy(xpath = "//td[text()='Type']/following-sibling::td")
    private WebElement type;
    @FindBy(xpath = "//td[text()='Name']/following-sibling::td")
    private WebElement name;
    @FindBy(xpath = "//td[text()='Code']/following-sibling::td")
    private WebElement code;
    @FindBy(xpath = "//td[text()='Category']/following-sibling::td")
    private WebElement category;
    @FindBy(xpath = "//td[text()='Unit']/following-sibling::td")
    private WebElement unit;
    @FindBy(xpath = "//td[text()='Cost']/following-sibling::td")
    private WebElement cost;
    @FindBy(xpath = "//td[text()='Price']/following-sibling::td")
    private WebElement price;
    @FindBy(xpath = "//td[text()='Tax Rate']/following-sibling::td")
    private WebElement taxRate;
    @FindBy(xpath = "//td[text()='Tax Method']/following-sibling::td")
    private WebElement taxMethod;
    @FindBy(xpath = "//td[text()='Alert Quantity']/following-sibling::td")
    private WebElement alertQuantity;
    @FindBy(xpath = "//div[@class='panel panel-primary']")
    private WebElement productDetail;

    public ProductDetailModal(WebDriver driver) {
        super(driver);
    }

    public boolean verifyProductDetailModal() {
        return getWait().until(ExpectedConditions.visibilityOf(lemonModalTitle)).isDisplayed();
    }

    public boolean verifyProductImage() {
        return getWait().until(ExpectedConditions.visibilityOf(productImage)).isDisplayed();
    }

    public boolean verifyBarAndQRCode() {
        return getWait().until(ExpectedConditions.visibilityOf(barAndQRCode)).isDisplayed();
    }
    public boolean verifyProductDetail(){
        return getWait().until(ExpectedConditions.visibilityOf(productDetail)).isDisplayed();
    }
    public boolean verifyProductType(String value){
        return getWait().until(ExpectedConditions.visibilityOf(type)).isDisplayed() && type.getText().equals(value);
    }
    public boolean verifyProductName(String value){
        return getWait().until(ExpectedConditions.visibilityOf(name)).isDisplayed() && name.getText().equals(value);
    }
    public boolean verifyProductCode(String value){
        return getWait().until(ExpectedConditions.visibilityOf(code)).isDisplayed() && code.getText().equals(value);
    }
    public boolean verifyProductCategory(String value){
        return getWait().until(ExpectedConditions.visibilityOf(category)).isDisplayed() && category.getText().equals(value);
    }
    public boolean verifyProductUnit(String value){
        return getWait().until(ExpectedConditions.visibilityOf(unit)).isDisplayed() && unit.getText().equals(value);
    }
    public boolean verifyProductCost(String value){
        return getWait().until(ExpectedConditions.visibilityOf(cost)).isDisplayed() && cost.getText().equals(value);
    }
    public boolean verifyProductPrice(String value){
        return getWait().until(ExpectedConditions.visibilityOf(price)).isDisplayed() && price.getText().equals(value);
    }
    public boolean verifyProductTaxRate(String value) {
        return getWait().until(ExpectedConditions.visibilityOf(taxRate)).isDisplayed() && taxRate.getText()
                .equals(value);
    }
    public boolean verifyTaxMethod(String value){
        return getWait().until(ExpectedConditions.visibilityOf(taxMethod)).isDisplayed() && taxMethod.getText().equals(value);
    }
    public boolean verifyAlertQuantity(String value){
        return getWait().until(ExpectedConditions.visibilityOf(alertQuantity)).isDisplayed() && alertQuantity.getText().equals(value);
    }
}
