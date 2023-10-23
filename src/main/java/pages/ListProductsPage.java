package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListProductsPage extends BasePage {
    @FindBy(xpath = "//div[@id='loading']")
    private WebElement loadingDiv;
    @FindBy(xpath = "//h2[contains(text(), 'roducts (All Warehouses)')]")
    private WebElement listProductLabel;
    @FindBy(xpath = "//td[text()='Lemon']")
    private WebElement lemonTableCell;
    public ListProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyListProductPage(){
        return getWait().until(ExpectedConditions.visibilityOf(listProductLabel)).isDisplayed();
    }
    public boolean verifyTableColumnWithGivenName(String name){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='" + name + "']"))).isDisplayed();
    }
    public void openLemonProductDetail(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingDiv));
        getWait().until(ExpectedConditions.visibilityOf(lemonTableCell));
        lemonTableCell.click();
    }
}
