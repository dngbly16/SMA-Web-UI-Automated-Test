package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//div[@id='loading']")
    private WebElement loadingDiv;
    @FindBy(xpath = "//div[@class = 'alert alert-success']/p")
    private WebElement loginSuccessMessage;
    @FindBy(xpath = "//h2[contains(text(), 'Overview Chart')]")
    private WebElement overviewChartTitle;
    @FindBy(xpath = "//h2[contains(text(), 'Quick Links')]")
    private WebElement quickLinksTitle;
    @FindBy(xpath = "//h2[contains(text(), 'Latest Five')]")
    private WebElement latestFiveTitle;
    @FindBy(xpath = "//h2[contains(text(), 'Best Sellers')]")
    private WebElement bestSellersTitle;
    @FindBy(xpath = "//li[@class='mm_products']/a")
    private WebElement productsLink;
    @FindBy(xpath = "//li[contains(@id,'products_index')]/a")
    private WebElement listProductsLink;
    @FindBy(xpath = "//li[@id='products_print_barcodes']/a")
    private WebElement printBarcodeLinks;
    @FindBy(xpath = "//li[contains(@class,'mm_sales')]/a")
    private WebElement salesLink;
    @FindBy(xpath = "//li[@id='sales_add']/a")
    private WebElement addSalesLink;
    @FindBy(xpath = "//li[@class='mm_purchases']/a")
    private WebElement purchasesLink;
    @FindBy(xpath = "//li[@id='purchases_index']/a")
    private WebElement purchaseListLink;
    @FindBy(xpath = "//li[@id='purchases_add']/a")
    private WebElement addPurchaseLink;
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyMessageWithTextDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(loginSuccessMessage)).isDisplayed()
                && loginSuccessMessage.getText().equals("You are successfully logged in.");
    }
    public boolean verifyOverviewChartDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(overviewChartTitle)).isDisplayed();
    }
    public boolean verifyQuickLinksDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(quickLinksTitle)).isDisplayed();
    }
    public boolean verifyLatestFiveDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(latestFiveTitle)).isDisplayed();
    }
    public boolean verifyBestSellersDisplayed(){
        return getWait().until(ExpectedConditions.visibilityOf(bestSellersTitle)).isDisplayed();
    }
    public boolean verifyDashboardPage(){
        return verifyMessageWithTextDisplayed() && verifyOverviewChartDisplayed() && verifyBestSellersDisplayed() && verifyLatestFiveDisplayed() && verifyQuickLinksDisplayed();
    }
    public void moveToListProductsPage(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.elementToBeClickable(productsLink));
        productsLink.click();
        getWait().until(ExpectedConditions.elementToBeClickable(listProductsLink));
        listProductsLink.click();
    }
    public void moveToPrintBarcodePage(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.elementToBeClickable(productsLink));
        productsLink.click();
        getWait().until(ExpectedConditions.elementToBeClickable(printBarcodeLinks));
        printBarcodeLinks.click();
    }
    public void moveToAddSale(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.elementToBeClickable(salesLink));
        salesLink.click();
        getWait().until(ExpectedConditions.elementToBeClickable(addSalesLink));
        addSalesLink.click();
    }
    public void moveToPurchaseList(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.elementToBeClickable(purchasesLink));
        purchasesLink.click();
        getWait().until(ExpectedConditions.elementToBeClickable(purchaseListLink));
        purchaseListLink.click();
    }
    public void moveToAddPurchase(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.elementToBeClickable(purchasesLink));
        purchasesLink.click();
        getWait().until(ExpectedConditions.elementToBeClickable(addPurchaseLink));
        addPurchaseLink.click();
    }
}
