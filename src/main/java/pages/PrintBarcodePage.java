package pages;

import core.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrintBarcodePage extends BasePage {
    @FindBy(xpath = "//h2[contains(text(), 'Print Barcode/Label')]")
    private WebElement printBarcodeTitle;
    @FindBy(xpath = "//input[@name='add_item']")
    private WebElement addProductInput;
    @FindBy(xpath = "//div[@id='s2id_style']/a")
    private WebElement styleLinkToOpenDropdownMenu;
    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    private WebElement styleInput;
    @FindBy(xpath = "//div[contains(@class,'icheckbox_square-blue')]")
    private List<WebElement> printCheckboxes;
    @FindBy(xpath = "//input[@name='print']")
    private WebElement updateButton;
    @FindBy(xpath = "//div[contains(@class, 'barcode')]/div")
    private WebElement barcodeItem;
    @FindBy(xpath = "//span[@class='product_image']/img")
    private WebElement printProductImage;
    @FindBy(xpath = "//span[@class='barcode_site']")
    private WebElement printBarcodeSite;
    @FindBy(xpath = "//span[@class='barcode_name']")
    private WebElement printBarcodeName;
    @FindBy(xpath = "//span[@class='barcode_price']")
    private WebElement printBarcodePrice;
    @FindBy(xpath = "//span[@class='barcode_unit']")
    private WebElement printBarcodeUnit;
    @FindBy(xpath = "//span[@class='barcode_category']")
    private WebElement printBarcodeCategory;
    @FindBy(xpath = "//span[@class='barcode_image']")
    private WebElement printBarcodeImage;
    public PrintBarcodePage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyPrintBarcodePage(){
        return getWait().until(ExpectedConditions.visibilityOf(printBarcodeTitle)).isDisplayed();
    }
    public void clickUpdate(){
        getWait().until(ExpectedConditions.visibilityOf(updateButton)).click();
    }
    public void inputProduct(String name){
        getWait().until(ExpectedConditions.visibilityOf(addProductInput)).sendKeys(name);
    }
    public void chooseStyle(String style) {
        getWait().until(ExpectedConditions.visibilityOf(styleLinkToOpenDropdownMenu)).click();
        getWait().until(ExpectedConditions.visibilityOf(styleInput)).sendKeys(Keys.chord(style, Keys.ENTER));
    }
    public void checkAllPrintCheckboxes(){
        for(WebElement checkboxContainer : printCheckboxes){
            if(!checkboxContainer.getAttribute("class").contains("checked")) {
                WebElement checkbox = checkboxContainer.findElement(By.tagName("input"));
                String checkboxID = checkbox.getAttribute("id");
                getWait().until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[@for='" + checkboxID + "']"))).click();
            }
        }
    }
    public boolean verifyAddProductDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(addProductInput)).isDisplayed();
    }
    public boolean verifyStyleDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(styleLinkToOpenDropdownMenu)).isDisplayed();
    }
    public boolean verifyPrintCheckboxesDisplayed(){
        for(WebElement checkbox : printCheckboxes){
            if(!getWait().until(ExpectedConditions.visibilityOf(checkbox)).isDisplayed()) return false;
        }
        return true;
    }
    public boolean verifyBarcodeProductImage(){
        return getWait().until(ExpectedConditions.visibilityOf(printProductImage)).isDisplayed();
    }
    public boolean verifyBarcodeSite(){
        return getWait().until(ExpectedConditions.visibilityOf(printBarcodeSite)).isDisplayed();
    }
    public boolean verifyBarcodeName(){
        return getWait().until(ExpectedConditions.visibilityOf(printBarcodeName)).isDisplayed();
    }
    public boolean verifyBarcodePrice(){
        return getWait().until(ExpectedConditions.visibilityOf(printBarcodePrice)).isDisplayed();
    }
    public boolean verifyBarcodeUnit(){
        return getWait().until(ExpectedConditions.visibilityOf(printBarcodeUnit)).isDisplayed();
    }
    public boolean verifyBarcodeCategory(){
        return getWait().until(ExpectedConditions.visibilityOf(printBarcodeCategory)).isDisplayed();
    }
    public boolean verifyBarcodeImage(){
        return getWait().until(ExpectedConditions.visibilityOf(printBarcodeImage)).isDisplayed();
    }

    public String getPrintBarcodeSiteText() {
        return printBarcodeSite.getText();
    }

    public String getPrintBarcodeNameText() {
        return printBarcodeName.getText();
    }

    public String getPrintBarcodePriceText() {
        return printBarcodePrice.getText();
    }

    public String getPrintBarcodeUnitText() {
        return printBarcodeUnit.getText();
    }

    public String getPrintBarcodeCategoryText() {
        return printBarcodeCategory.getText();
    }
}
