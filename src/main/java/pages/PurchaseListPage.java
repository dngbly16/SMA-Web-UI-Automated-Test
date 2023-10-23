package pages;

import core.BasePage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PurchaseListPage extends BasePage {
    @FindBy(xpath = "//tr[@id='9']/td[2]")
    private WebElement dateCell;
    @FindBy(xpath = "//th[text()='Reference No']")
    private WebElement referenceNoTableHeader;
    @FindBy(xpath = "//tbody[@role='alert']/tr")
    List<WebElement> purchasesList;
    public PurchaseListPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyPurchaseListPage(){
        return getWait().until(ExpectedConditions.visibilityOf(referenceNoTableHeader)).isDisplayed();
    }
    public boolean verifyDateTimeFormat(String format){
        getWait().until(ExpectedConditions.visibilityOf(dateCell));
        String datetime = dateCell.getText();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            simpleDateFormat.parse(datetime);
            return true;
        } catch (ParseException e) {
            System.err.println("Parse datetime error: " + e.getMessage());
            return false;
        }
    }
    public boolean verifyPurchasesNumber(String number) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(purchasesList));
        return purchasesList.size() == Integer.parseInt(number);
    }
    public boolean verifyReferenceNoSortType(String expectSortType){
        getWait().until(ExpectedConditions.visibilityOf(referenceNoTableHeader));
        String sortType = referenceNoTableHeader.getAttribute("class").split("_")[1];
        return sortType.equalsIgnoreCase(expectSortType);
    }
}
