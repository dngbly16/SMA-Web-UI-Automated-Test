package tests;

import core.BaseTest;
import core.ExcelUtils;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PurchaseListPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC08 extends BaseTest {
    @Test(dataProvider = "testData")
    public void testMethod(String username, String password, String dateTimeFormat, String sortType, String totalEntries){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed(), "verify username display");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyDashboardPage(), "verify dashboard page");
        dashboardPage.moveToPurchaseList();
        PurchaseListPage purchaseListPage = new PurchaseListPage(getDriver());
        softAssert.assertTrue(purchaseListPage.verifyPurchaseListPage(), "verify list purchase page");
        softAssert.assertTrue(purchaseListPage.verifyDateTimeFormat(dateTimeFormat), "verify date time format");
        softAssert.assertTrue(purchaseListPage.verifyReferenceNoSortType(sortType), "verify reference sort type");
        softAssert.assertTrue(purchaseListPage.verifyPurchasesNumber(totalEntries), "verify entries display");
        softAssert.assertAll();
    }

    @DataProvider(name = "testData")
    public Object[][] getTestData(){
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "TC08", 0, 5);
    }
}
